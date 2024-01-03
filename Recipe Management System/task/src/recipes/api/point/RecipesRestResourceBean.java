package recipes.api.point;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import recipes.api.RecipesRestResource;
import recipes.api.dto.RecipeDto;
import recipes.business.RecipeService;

@RestController
@RequiredArgsConstructor
public class RecipesRestResourceBean implements RecipesRestResource {

    private final RecipeService recipeService;

    @Override
    public ResponseEntity<RecipeDto> addRecipe(final RecipeDto recipeDto) {
        return ResponseEntity.ok(recipeService.addRecipe(recipeDto));
    }

    @Override
    public ResponseEntity<RecipeDto> getRecipe(final int id) {
        return ResponseEntity.ok(recipeService.getRecipe(id));
    }
}
