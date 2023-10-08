package com.mtbp.movies.web;

import com.mtbp.commons.dto.movies.AddShowRequest;
import com.mtbp.commons.dto.movies.ShowDto;
import com.mtbp.commons.dto.movies.UpdateShowRequest;
import com.mtbp.commons.utils.DocKeyUtils;
import com.mtbp.movies.services.ShowSearchFilters;
import com.mtbp.movies.services.ShowService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/shows")
public class ShowController {

    private final ShowService showService;

    @PostMapping
    public ResponseEntity<ShowDto> addShow(@RequestBody AddShowRequest addShowRequest) {
        ShowDto show = showService.addShow(addShowRequest);
        return ResponseEntity.ok(show);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ShowDto> updateShow(@PathVariable String id, @RequestBody UpdateShowRequest updateShowRequest) {
        ShowDto show = showService.updateShow(id, updateShowRequest);
        return ResponseEntity.ok(show);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<ShowDto> findShow(@PathVariable String id) {
        ShowDto show = showService.findShow(id);
        return ResponseEntity.ok(show);
    }

    @GetMapping
    public ResponseEntity<List<ShowDto>> findShows(
        @RequestParam("city") String city,
        @RequestParam("date") Optional<LocalDate> date,
        @RequestParam("movieId") Optional<String> movieId
    ) {
        ShowSearchFilters filters = ShowSearchFilters.builder()
            .city(city)
            .date(date.orElse(LocalDate.now()))
            .movieId(movieId.map(DocKeyUtils::createMovieDocKey).orElse(null))
            .build();
        List<ShowDto> shows = showService.findShows(filters);
        return ResponseEntity.ok(shows);
    }
}