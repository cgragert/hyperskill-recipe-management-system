package recipes.business;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import recipes.api.dto.UserDto;
import recipes.business.entity.User;
import recipes.mapper.UserDtoToEntityMapper;
import recipes.repository.UserRepository;

import javax.validation.constraints.NotNull;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;
    private final UserDtoToEntityMapper dtoToEntityMapper;

    public void registerUser(@NotNull final UserDto userDto) {
        final User user = dtoToEntityMapper.mapToEntity(userDto);
        if (repository.existsById(user.getEmail())) {
            throw new IllegalStateException();
        }
        repository.save(user);
    }
}
