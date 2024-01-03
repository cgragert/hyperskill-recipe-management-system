package recipes.api;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import recipes.api.dto.RecipeDto;


@RequestMapping(path = "/api/recipe")
public interface RecipesRestResource {

    @PostMapping(path = "new")
    ResponseEntity<RecipeDto> addRecipe(@RequestBody RecipeDto recipeDto);

    @GetMapping(path = "{id}")
    ResponseEntity<RecipeDto> getRecipe(@PathVariable("id") final int id);
}
