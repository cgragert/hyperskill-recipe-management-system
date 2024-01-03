package recipes.repository.cache;

import org.springframework.stereotype.Component;
import recipes.repository.Recipe;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

@Component
public class RecipeCache {

    private final Map<Integer, Recipe> recipes = new HashMap<>();

    public void addRecipe(final Recipe recipe) {
        recipes.put(recipe.getId(), recipe);
    }

    public Recipe getRecipe(final int id) throws NoSuchElementException {
        final Recipe recipe = recipes.get(id);
        if (recipe == null) {
            throw new NoSuchElementException();
        }
        return recipe;
    }

}
