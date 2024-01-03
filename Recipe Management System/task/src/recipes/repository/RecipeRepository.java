package recipes.repository;

public interface RecipeRepository {

    Recipe getRecipe(final int id);

    void addRecipe(final Recipe recipe);
}
