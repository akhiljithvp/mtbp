package com.mtbp.movies.mappers;

import com.mtbp.commons.dto.theaters.AddScreenRequest;
import com.mtbp.commons.dto.theaters.AddSeatsRequest;
import com.mtbp.commons.dto.theaters.ScreenDto;
import com.mtbp.commons.utils.DocKeyUtils;
import com.mtbp.db.theaters.Screen;
import com.mtbp.db.theaters.SeatsInfo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(
    componentModel = "spring",
    imports = {DocKeyUtils.class},
    unmappedTargetPolicy = ReportingPolicy.IGNORE,
    nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT
)
public interface ScreenMapper {

    @Mapping(target = "id", expression = "java(DocKeyUtils.createScreenDocKey())")
    Screen map(AddScreenRequest addScreenRequest);

    SeatsInfo map(AddSeatsRequest addSeatsRequest);

    @Mapping(target = "id", expression = "java(DocKeyUtils.removeDocPrefix(screen.getId()))")
    ScreenDto map(Screen screen);
}
