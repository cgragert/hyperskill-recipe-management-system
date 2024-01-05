package recipes.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
public class UserDto {

    @NotBlank
    @Email(regexp = ".+@.+\\.[a-zA-Z]+")
    @JsonProperty("email")
    private String email;

    @NotBlank
    @Size(min = 8)
    @JsonProperty("password")
    private String password;
}
