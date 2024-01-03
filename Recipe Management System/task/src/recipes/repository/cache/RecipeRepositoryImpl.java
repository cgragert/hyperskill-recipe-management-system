package recipes.repository.cache;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import recipes.repository.Recipe;
import recipes.repository.RecipeRepository;

@Repository
@RequiredArgsConstructor
public class RecipeRepositoryImpl implements RecipeRepository {

    private final RecipeCache cache;

    @Override
    public Recipe getRecipe(final int id) {
        return cache.getRecipe(id);
    }

    @Override
    public void addRecipe(Recipe recipe) {
        cache.addRecipe(recipe);
    }
}
