package recipes.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import recipes.api.dto.UserDto;

import javax.validation.Valid;

@RequestMapping(path = "api")
public interface UserRestResource {

    @PostMapping("register")
    ResponseEntity<Void> register(@RequestBody @Valid UserDto userDto);
}
