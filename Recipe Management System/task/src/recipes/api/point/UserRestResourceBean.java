package recipes.api.point;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import recipes.api.UserRestResource;
import recipes.api.dto.UserDto;
import recipes.business.UserService;

@RestController
@RequiredArgsConstructor
public class UserRestResourceBean implements UserRestResource {

    private final UserService userService;

    @Override
    public ResponseEntity<Void> register(final UserDto userDto) {
        userService.registerUser(userDto);
        return ResponseEntity.ok().build();
    }
}
