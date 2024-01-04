package recipes.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import recipes.api.dto.RecipeDto;

import javax.validation.Valid;
import javax.websocket.server.PathParam;
import java.util.Collection;


@RequestMapping(path = "/api/recipe")
public interface RecipesRestResource {

    @PostMapping(path = "new")
    ResponseEntity<RecipeDto> addRecipe(@RequestBody @Valid final RecipeDto recipeDto);

    @GetMapping(path = "{id}")
    ResponseEntity<RecipeDto> getRecipe(@PathVariable("id") final int id);

    @DeleteMapping(path = "{id}")
    ResponseEntity<Void> deleteRecipe(@PathVariable("id") final int id);

    @PutMapping(path = "{id}")
    ResponseEntity<Void> updateRecipe(@PathVariable("id") final int id, @RequestBody @Valid final RecipeDto recipeDto);

    @GetMapping(path = "search")
    ResponseEntity<Collection<RecipeDto>> searchRecipe(
            @PathParam("category") final String category,
            @PathParam("name") final String name);
}
