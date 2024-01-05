package recipes.mapper;

import javax.validation.constraints.NotNull;
import java.util.Collection;

@SuppressWarnings("java:S119")
public interface Mapper<ENTITY, DTO> {

    default ENTITY mapToEntity(@NotNull DTO from) {
        return mapToEntity(from, createEntity());
    }

    default DTO mapToDto(@NotNull ENTITY from) {
        return mapToDto(from, createDto());
    }

    ENTITY mapToEntity(@NotNull DTO from, @NotNull ENTITY to);

    Collection<ENTITY> mapToEntities(Collection<DTO> from);

    DTO mapToDto(@NotNull ENTITY from, @NotNull DTO to);

    Collection<DTO> mapToDtos(Collection<ENTITY> from);

    DTO createDto();

    ENTITY createEntity();
}
