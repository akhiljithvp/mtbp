package com.mtbp.movies.mappers;

import com.mtbp.commons.dto.movies.AddShowRequest;
import com.mtbp.commons.dto.movies.ShowDto;
import com.mtbp.commons.dto.movies.UpdateShowRequest;
import com.mtbp.commons.utils.DocKeyUtils;
import com.mtbp.db.theaters.SeatsInfo;
import com.mtbp.db.theaters.Show;
import org.mapstruct.*;

@Mapper(
    componentModel = "spring",
    imports = {DocKeyUtils.class},
    unmappedTargetPolicy = ReportingPolicy.IGNORE,
    nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT
)
public interface ShowMapper {
    @Mapping(target = "id", expression = "java(DocKeyUtils.createShowDocKey())")
    @Mapping(target = "movieId", expression = "java(DocKeyUtils.createMovieDocKey(addShowRequest.getMovieId()))")
    @Mapping(target = "screenId", expression = "java(DocKeyUtils.createScreenDocKey(addShowRequest.getScreenId()))")
    @Mapping(target = "theaterId", expression = "java(DocKeyUtils.createTheaterDocKey(addShowRequest.getTheaterId()))")
    Show map(AddShowRequest addShowRequest, String city, SeatsInfo seats);

    Show map(@MappingTarget Show show, UpdateShowRequest updateShowRequest);

    @Mapping(target = "id", expression = "java(DocKeyUtils.removeDocPrefix(show.getId()))")
    @Mapping(target = "movieId", expression = "java(DocKeyUtils.removeDocPrefix(show.getMovieId()))")
    @Mapping(target = "screenId", expression = "java(DocKeyUtils.removeDocPrefix(show.getScreenId()))")
    @Mapping(target = "theaterId", expression = "java(DocKeyUtils.removeDocPrefix(show.getTheaterId()))")
    ShowDto map(Show show);
}