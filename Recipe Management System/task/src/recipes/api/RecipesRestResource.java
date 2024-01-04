package recipes.api;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import recipes.api.dto.RecipeDto;

import javax.validation.Valid;


@RequestMapping(path = "/api/recipe")
public interface RecipesRestResource {

    @PostMapping(path = "new")
    ResponseEntity<RecipeDto> addRecipe(@RequestBody @Valid final RecipeDto recipeDto);

    @GetMapping(path = "{id}")
    ResponseEntity<RecipeDto> getRecipe(@PathVariable("id") final int id);

    @DeleteMapping(path = "{id}")
    ResponseEntity<Void> deleteRecipe(@PathVariable("id") final int id);
}
