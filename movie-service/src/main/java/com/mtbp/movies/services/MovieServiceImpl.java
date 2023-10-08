package com.mtbp.movies.services;

import com.mtbp.commons.dto.movies.AddMovieRequest;
import com.mtbp.commons.dto.movies.MovieDto;
import com.mtbp.commons.dto.movies.UpdateMovieRequest;
import com.mtbp.commons.utils.DocKeyUtils;
import com.mtbp.db.movies.Movie;
import com.mtbp.db.movies.services.MovieDbService;
import com.mtbp.movies.mappers.MovieMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {

    private final MovieDbService movieDbService;
    private final MovieMapper movieMapper;

    @Override
    public MovieDto addMovie(AddMovieRequest addMovieRequest) {
        Movie movie = movieMapper.map(addMovieRequest);
        movie = movieDbService.save(movie);
        return movieMapper.map(movie);
    }

    @Override
    public MovieDto updateMovie(String id, UpdateMovieRequest updateMovieRequest) {
        String movieId = DocKeyUtils.createMovieDocKey(id);
        return movieDbService.findById(movieId).map(
            movie -> {
                movie = movieMapper.map(movie, updateMovieRequest);
                return movieMapper.map(movieDbService.save(movie));
            }
        ).orElseThrow(
            () -> new RuntimeException(String.format("Document with the id %s not found!", movieId))
        );
    }

    @Override
    public MovieDto findMovie(String id) {
        String movieId = DocKeyUtils.createMovieDocKey(id);
        return movieDbService.findById(movieId).map(movieMapper::map).orElseThrow(
            () -> new RuntimeException(String.format("Document with the id %s not found!", movieId))
        );
    }
}
