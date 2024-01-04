package recipes.business;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import recipes.api.dto.RecipeDto;
import recipes.mapper.RecipeDtoToEntityMapper;
import recipes.business.entity.Recipe;
import recipes.repository.RecipeRepository;

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
}
