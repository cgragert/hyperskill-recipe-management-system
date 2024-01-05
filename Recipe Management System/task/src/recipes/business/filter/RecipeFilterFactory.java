package recipes.business.filter;

import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import recipes.util.RecipeField;

@Component
public class RecipeFilterFactory {

    public RecipeFilter createFilter(@Nullable final String category, @Nullable final String name) {
        if (category == null && name != null) {
            return new RecipeFilter(RecipeField.NAME, name);
        } else if (category != null && name == null) {
            return new RecipeFilter(RecipeField.CATEGORY, category);
        }
        throw new IllegalStateException();
    }

}
