package com.mtbp.movies.mappers;

import com.mtbp.commons.dto.theaters.AddTheaterRequest;
import com.mtbp.commons.dto.theaters.TheaterDto;
import com.mtbp.commons.utils.DocKeyUtils;
import com.mtbp.db.theaters.Theater;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueMappingStrategy;
import org.mapstruct.ReportingPolicy;

import java.util.Set;
import java.util.stream.Collectors;

@Mapper(
    componentModel = "spring",
    imports = {DocKeyUtils.class},
    unmappedTargetPolicy = ReportingPolicy.IGNORE,
    nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT
)
public interface TheaterMapper {

    @Mapping(target = "id", expression = "java(DocKeyUtils.createTheaterDocKey())")
    @Mapping(target = "screens", ignore = true)
    Theater map(AddTheaterRequest addTheaterRequest);

    @Mapping(target = "id", expression = "java(DocKeyUtils.removeDocPrefix(theater.getId()))")
    @Mapping(target = "screens", expression = "java(map(theater.getScreens()))")
    TheaterDto map(Theater theater);

    default Set<String> map(Set<String> screenIds) {
        return screenIds.stream()
            .map(DocKeyUtils::removeDocPrefix)
            .collect(Collectors.toSet());
    }
}