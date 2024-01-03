package recipes.business;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import recipes.api.dto.RecipeDto;
import recipes.mapper.RecipeDtoToEntityMapper;
import recipes.repository.Recipe;
import recipes.repository.RecipeRepository;

@Service
@RequiredArgsConstructor
public class RecipeService {

    private final RecipeRepository repository;
    private final RecipeDtoToEntityMapper dtoToEntityMapper;
    private final IdGenerator idGenerator;

    public RecipeDto addRecipe(RecipeDto recipeDto) {
        final Recipe recipe = dtoToEntityMapper.mapToEntity(recipeDto);
        recipe.setId(idGenerator.getNextId());
        repository.addRecipe(recipe);
        return new RecipeDto().setId(recipe.getId());
    }

    public RecipeDto getRecipe(final int id) {
        final Recipe recipe = repository.getRecipe(id);
        return dtoToEntityMapper.mapToDto(recipe);
    }
}
