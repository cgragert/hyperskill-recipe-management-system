package recipes.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import recipes.business.entity.Recipe;

import javax.validation.constraints.NotNull;
import java.util.List;

@Repository
public interface RecipeRepository extends CrudRepository<Recipe, Integer> {

    List<Recipe> findByCategoryIgnoreCaseOrderByDateDesc(@NotNull final String category);

    List<Recipe> findByNameContainsIgnoreCaseOrderByDateDesc(@NotNull final String name);
}
