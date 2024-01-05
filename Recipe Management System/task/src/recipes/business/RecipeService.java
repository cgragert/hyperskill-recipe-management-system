package recipes.business;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import recipes.api.dto.RecipeDto;
import recipes.business.entity.Recipe;
import recipes.business.entity.User;
import recipes.business.filter.RecipeFilter;
import recipes.mapper.RecipeDtoToEntityMapper;
import recipes.repository.RecipeRepository;

import javax.validation.constraints.NotNull;
import java.util.Collection;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RecipeService {

    private final RecipeRepository repository;
    private final RecipeDtoToEntityMapper dtoToEntityMapper;

    public RecipeDto addRecipe(@NotNull final RecipeDto recipeDto, @NotNull final User user) {
        Recipe recipe = dtoToEntityMapper.mapToEntity(recipeDto);
        recipe.setUser(user);
        recipe = repository.save(recipe);
        return new RecipeDto().setId(recipe.getId());
    }

    public RecipeDto getRecipe(final int id) {
        final Recipe recipe = repository.findById(id).orElseThrow();
        return dtoToEntityMapper.mapToDto(recipe);
    }

    public void deleteRecipe(final int id, @NotNull final User user) {
        final Recipe recipe = repository.findById(id).orElseThrow();
        validateUser(user, recipe);
        repository.delete(recipe);
    }

    public void updateRecipe(final int id, @NotNull final RecipeDto recipeDto, @NotNull final User user) {
        final Optional<Recipe> optionalRecipe = repository.findById(id);
        if (optionalRecipe.isEmpty()) {
            throw new NoSuchElementException();
        }
        final Recipe recipe = dtoToEntityMapper.mapToEntity(recipeDto, optionalRecipe.get());
        validateUser(user, recipe);
        recipe.setId(id).setUser(user);
        repository.save(recipe);
    }

    public Collection<RecipeDto> searchRecipe(@NotNull final RecipeFilter filter) {
        Collection<Recipe> recipes = switch (filter.field()) {
            case NAME -> repository.findByNameContainsIgnoreCaseOrderByDateDesc(filter.value());
            case CATEGORY -> repository.findByCategoryIgnoreCaseOrderByDateDesc(filter.value());
        };
        return dtoToEntityMapper.mapToDtos(recipes);
    }

    private void validateUser(@NotNull final User user, @NotNull final Recipe recipe)
            throws UnauthorizedOperationException {
        if (!user.equals(recipe.getUser())) {
            throw new UnauthorizedOperationException();
        }
    }
}
