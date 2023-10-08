package com.mtbp.movies.web;

import com.mtbp.commons.dto.theaters.*;
import com.mtbp.movies.services.TheaterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/theaters")
public class TheaterController {

    private final TheaterService theaterService;

    @PostMapping
    public ResponseEntity<TheaterDto> addTheater(@RequestBody AddTheaterRequest addTheaterRequest) {
        TheaterDto theater = theaterService.addTheater(addTheaterRequest);
        return ResponseEntity.ok(theater);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TheaterDto> updateTheater(@PathVariable("id") String id, @RequestBody UpdateTheaterRequest updateTheaterRequest) {
        TheaterDto theater = theaterService.updateTheater(id, updateTheaterRequest);
        return ResponseEntity.ok(theater);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TheaterDto> findTheater(@PathVariable String id) {
        TheaterDto theater = theaterService.findTheater(id);
        return ResponseEntity.ok(theater);
    }

    @PostMapping("/{theaterId}/screens")
    public ResponseEntity<TheaterDto> addScreens(@PathVariable String theaterId, @RequestBody List<AddScreenRequest> addScreenRequest) {
        TheaterDto theater = theaterService.addScreens(theaterId, addScreenRequest);
        return ResponseEntity.ok(theater);
    }

    @GetMapping("/{theaterId}/screens")
    public ResponseEntity<List<ScreenDto>> findScreens(@PathVariable String theaterId) {
        List<ScreenDto> screens = theaterService.findScreens(theaterId);
        return ResponseEntity.ok(screens);
    }

    @DeleteMapping("/{theaterId}/screens/{screenId}")
    public ResponseEntity removeScreen(@PathVariable String theaterId, @PathVariable String screenId) {
        theaterService.removeScreen(theaterId, screenId);
        return ResponseEntity.noContent().build();
    }
}
