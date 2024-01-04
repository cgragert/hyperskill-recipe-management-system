package recipes.business;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import recipes.api.dto.RecipeDto;
import recipes.business.entity.Recipe;
import recipes.business.filter.RecipeFilter;
import recipes.mapper.RecipeDtoToEntityMapper;
import recipes.repository.RecipeRepository;

import java.util.Collection;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class RecipeService {

    private final RecipeRepository repository;
    private final RecipeDtoToEntityMapper dtoToEntityMapper;

    public RecipeDto addRecipe(final RecipeDto recipeDto) {
        Recipe recipe = dtoToEntityMapper.mapToEntity(recipeDto);
        recipe = repository.save(recipe);
        return new RecipeDto().setId(recipe.getId());
    }

    public RecipeDto getRecipe(final int id) {
        final Recipe recipe = repository.findById(id).orElseThrow();
        return dtoToEntityMapper.mapToDto(recipe);
    }

    public void deleteRecipe(final int id) {
        final Recipe recipe = repository.findById(id).orElseThrow();
        repository.delete(recipe);
    }

    public void updateRecipe(final int id, final RecipeDto recipeDto) {
        if (!repository.existsById(id)) {
            throw new NoSuchElementException();
        }
        final Recipe recipe = dtoToEntityMapper.mapToEntity(recipeDto);
        recipe.setId(id);
        repository.save(recipe);
    }

    public Collection<RecipeDto> searchRecipe(final RecipeFilter filter) {
        Collection<Recipe> recipes = switch (filter.field()) {
            case NAME -> repository.findByNameContainsIgnoreCaseOrderByDateDesc(filter.value());
            case CATEGORY -> repository.findByCategoryIgnoreCaseOrderByDateDesc(filter.value());
        };
        return dtoToEntityMapper.mapToDtos(recipes);
    }
}
