package recipes.repository;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
public class Recipe {

    private int id;

    private String name;

    private String description;

    private List<String> ingredients;

    private List<String> directions;
}
