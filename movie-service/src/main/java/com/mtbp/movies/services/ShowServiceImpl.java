package com.mtbp.movies.services;

import com.mtbp.commons.dto.movies.AddShowRequest;
import com.mtbp.commons.dto.movies.ShowDto;
import com.mtbp.commons.dto.movies.UpdateShowRequest;
import com.mtbp.commons.utils.DocKeyUtils;
import com.mtbp.db.exceptions.DocumentNotFoundException;
import com.mtbp.db.theaters.Screen;
import com.mtbp.db.theaters.Show;
import com.mtbp.db.theaters.Theater;
import com.mtbp.db.theaters.services.ScreenDbService;
import com.mtbp.db.theaters.services.ShowDbService;
import com.mtbp.db.theaters.services.TheaterDbService;
import com.mtbp.movies.mappers.ShowMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class ShowServiceImpl implements ShowService {
    private final ShowMapper showMapper;
    private final ShowDbService showDbService;
    private final TheaterDbService theaterDbService;
    private final ScreenDbService screenDbService;

    @Override
    public ShowDto addShow(AddShowRequest addShowRequest) {
        Theater theater = findTheater(addShowRequest.getTheaterId());
        Screen screen = findScreen(addShowRequest.getScreenId());
        Show show = showMapper.map(addShowRequest, theater.findCity(), screen.getSeats());
        return showMapper.map(showDbService.save(show));
    }

    @Override
    public ShowDto findShow(String id) {
        final String showId = DocKeyUtils.createShowDocKey(id);
        return showDbService.findById(showId).map(showMapper::map).orElseThrow(
            () -> new DocumentNotFoundException(showId)
        );
    }

    @Override
    public ShowDto updateShow(String id, UpdateShowRequest updateShowRequest) {
        final String showId = DocKeyUtils.createShowDocKey(id);
        return showDbService.findById(showId).map(
            show -> {
                // validate the request to make sure there no ticket bookings present.
                show = showMapper.map(show, updateShowRequest);
                return showMapper.map(showDbService.save(show));
            }
        ).orElseThrow(
            () -> new DocumentNotFoundException(showId)
        );
    }

    @Override
    public List<ShowDto> findShows(ShowSearchFilters filters) {
        return showDbService.findBy(filters.getMovieId(), filters.getCity(), filters.getDate())
            .stream()
            .map(showMapper::map)
            .collect(Collectors.toList());
    }

    private Theater findTheater(String id) {
        final String theaterId = DocKeyUtils.createTheaterDocKey(id);
        return theaterDbService.findById(theaterId).orElseThrow(
            () -> new DocumentNotFoundException(theaterId)
        );
    }

    private Screen findScreen(String id) {
        final String screenId = DocKeyUtils.createScreenDocKey(id);
        return screenDbService.findById(screenId).orElseThrow(
            () -> new DocumentNotFoundException(screenId)
        );
    }
}