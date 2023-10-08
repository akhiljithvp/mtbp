package com.mtbp.movies.web;

import com.mtbp.commons.dto.theaters.SeatsDto;
import com.mtbp.movies.services.SeatsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/seats")
public class SeatsController {

    private final SeatsService seatsService;

    @GetMapping
    public ResponseEntity<SeatsDto> findSeats(
        @RequestParam("showId") String showId,
        @RequestParam("date") Optional<LocalDate> date
    ) {
        SeatsDto seats = seatsService.findSeats(showId, date.orElse(LocalDate.now()));
        return ResponseEntity.ok(seats);
    }
}
