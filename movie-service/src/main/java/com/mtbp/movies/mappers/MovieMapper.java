package com.mtbp.movies.mappers;

import com.mtbp.commons.dto.movies.AddMovieRequest;
import com.mtbp.commons.dto.movies.MovieDto;
import com.mtbp.commons.dto.movies.UpdateMovieRequest;
import com.mtbp.commons.utils.DocKeyUtils;
import com.mtbp.db.movies.Movie;
import org.mapstruct.*;

@Mapper(
    componentModel = "spring",
    imports = {DocKeyUtils.class},
    unmappedTargetPolicy = ReportingPolicy.IGNORE,
    nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT
)
public interface MovieMapper {

    @Mapping(target = "id", expression = "java(DocKeyUtils.createMovieDocKey())")
    @Mapping(target = "releaseDate", source = "releaseDate", dateFormat = "dd-MM-yyyy")
    Movie map(AddMovieRequest addMovieRequest);

    @Mapping(target = "id", expression = "java(DocKeyUtils.removeDocPrefix(movie.getId()))")
    MovieDto map(Movie movie);

    Movie map(@MappingTarget Movie movie, UpdateMovieRequest updateMovieRequest);
}