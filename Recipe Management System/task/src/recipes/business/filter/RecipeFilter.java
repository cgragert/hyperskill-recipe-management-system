package recipes.business.filter;

import recipes.util.RecipeField;

public record RecipeFilter(RecipeField field, String value) {
}
