package com.mtbp.movies.web;

import com.mtbp.commons.dto.movies.AddMovieRequest;
import com.mtbp.commons.dto.movies.MovieDto;
import com.mtbp.commons.dto.movies.UpdateMovieRequest;
import com.mtbp.movies.services.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/movies")
public class MovieController {
    private final MovieService movieService;

    @PostMapping
    public ResponseEntity<MovieDto> addMovie(@RequestBody AddMovieRequest addMovieRequest) {
        MovieDto movie = movieService.addMovie(addMovieRequest);
        return ResponseEntity.ok(movie);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MovieDto> updateMovie(@PathVariable String id, @RequestBody UpdateMovieRequest updateMovieRequest) {
        MovieDto movie = movieService.updateMovie(id, updateMovieRequest);
        return ResponseEntity.ok(movie);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<MovieDto> findMovie(@PathVariable("id") String id) {
        MovieDto movie = movieService.findMovie(id);
        return ResponseEntity.ok(movie);
    }


}
