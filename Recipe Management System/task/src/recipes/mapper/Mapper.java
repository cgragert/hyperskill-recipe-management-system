package recipes.mapper;

import java.util.Collection;

@SuppressWarnings("java:S119")
public interface Mapper<ENTITY, DTO> {

    ENTITY mapToEntity(DTO from);

    Collection<ENTITY> mapToEntities(Collection<DTO> from);

    DTO mapToDto(ENTITY from);

    Collection<DTO> mapToDtos(Collection<ENTITY> from);
}
