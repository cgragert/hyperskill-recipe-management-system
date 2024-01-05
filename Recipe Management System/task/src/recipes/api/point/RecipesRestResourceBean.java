package recipes.api.point;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RestController;
import recipes.api.RecipesRestResource;
import recipes.api.dto.RecipeDto;
import recipes.business.RecipeService;
import recipes.business.entity.User;
import recipes.business.filter.RecipeFilterFactory;

import java.util.Collection;

@RestController
@RequiredArgsConstructor
public class RecipesRestResourceBean implements RecipesRestResource {

    private final RecipeService recipeService;
    private final RecipeFilterFactory filterFactory;

    @Override
    public ResponseEntity<RecipeDto> addRecipe(final RecipeDto recipeDto, final UserDetails userDetails) {
        return ResponseEntity.ok(recipeService.addRecipe(recipeDto, new User(userDetails)));
    }

    @Override
    public ResponseEntity<RecipeDto> getRecipe(final int id) {
        return ResponseEntity.ok(recipeService.getRecipe(id));
    }

    @Override
    public ResponseEntity<Void> deleteRecipe(final int id, final UserDetails userDetails) {
        recipeService.deleteRecipe(id, new User(userDetails));
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<Void> updateRecipe(final int id, final RecipeDto recipeDto, final UserDetails userDetails) {
        recipeService.updateRecipe(id, recipeDto, new User(userDetails));
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<Collection<RecipeDto>> searchRecipe(final String category, final String name) {
        return ResponseEntity.ok(recipeService.searchRecipe(filterFactory.createFilter(category, name)));
    }
}
