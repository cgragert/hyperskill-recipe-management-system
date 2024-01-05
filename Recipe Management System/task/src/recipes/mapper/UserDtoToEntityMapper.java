package recipes.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import recipes.api.dto.UserDto;
import recipes.business.entity.User;

import javax.validation.constraints.NotNull;
import java.util.Collection;

@Component
@RequiredArgsConstructor
public class UserDtoToEntityMapper implements Mapper<User, UserDto> {

    private final PasswordEncoder passwordEncoder;

    @Override
    public User mapToEntity(@NotNull final UserDto from, final User to) {
        return to.setEmail(from.getEmail()).setPassword(passwordEncoder.encode(from.getPassword()));
    }

    @Override
    public Collection<User> mapToEntities(final Collection<UserDto> from) {
        return null;
    }

    @Override
    public UserDto mapToDto(final User from, final UserDto to) {
        return null;
    }

    @Override
    public Collection<UserDto> mapToDtos(final Collection<User> from) {
        return null;
    }

    @Override
    public UserDto createDto() {
        return new UserDto();
    }

    @Override
    public User createEntity() {
        return new User();
    }
}
