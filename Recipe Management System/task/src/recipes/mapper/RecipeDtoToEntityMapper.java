package recipes.mapper;

import org.springframework.stereotype.Component;
import recipes.api.dto.RecipeDto;
import recipes.repository.Recipe;

import java.util.Collection;

@Component
public class RecipeDtoToEntityMapper implements Mapper<Recipe, RecipeDto> {

    @Override
    public Recipe mapToEntity(final RecipeDto from) {
        return new Recipe()
                .setName(from.getName())
                .setDescription(from.getDescription())
                .setIngredients(from.getIngredients())
                .setDirections(from.getDirections());
    }

    @Override
    public Collection<Recipe> mapToEntities(final Collection<RecipeDto> from) {
        return null;
    }

    @Override
    public RecipeDto mapToDto(final Recipe from) {
        return new RecipeDto()
                .setName(from.getName())
                .setDescription(from.getDescription())
                .setIngredients(from.getIngredients())
                .setDirections(from.getDirections());
    }

    @Override
    public Collection<RecipeDto> mapToDtos(final Collection<Recipe> from) {
        return null;
    }
}
