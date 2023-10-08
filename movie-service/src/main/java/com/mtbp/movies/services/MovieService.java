package com.mtbp.movies.services;

import com.mtbp.commons.dto.movies.AddMovieRequest;
import com.mtbp.commons.dto.movies.MovieDto;
import com.mtbp.commons.dto.movies.UpdateMovieRequest;

public interface MovieService {
    MovieDto addMovie(AddMovieRequest addMovieRequest);

    MovieDto updateMovie(String id, UpdateMovieRequest updateMovieRequest);

    MovieDto findMovie(String id);
}