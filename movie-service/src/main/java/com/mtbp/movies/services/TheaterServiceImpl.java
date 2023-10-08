package com.mtbp.movies.services;

import com.mtbp.commons.dto.theaters.*;
import com.mtbp.commons.utils.DocKeyUtils;
import com.mtbp.db.exceptions.DocumentNotFoundException;
import com.mtbp.db.theaters.Screen;
import com.mtbp.db.theaters.Theater;
import com.mtbp.db.theaters.services.ScreenDbService;
import com.mtbp.db.theaters.services.TheaterDbService;
import com.mtbp.movies.mappers.ScreenMapper;
import com.mtbp.movies.mappers.TheaterMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class TheaterServiceImpl implements TheaterService {
    private final TheaterMapper theaterMapper;
    private final ScreenMapper screenMapper;
    private final TheaterDbService theaterDbService;
    private final ScreenDbService screenDbService;

    @Override
    public TheaterDto addTheater(AddTheaterRequest addTheaterRequest) {
        Theater theater = theaterMapper.map(addTheaterRequest);
        saveScreens(theater, addTheaterRequest.getScreens());
        return theaterMapper.map(theaterDbService.save(theater));
    }

    @Override
    public TheaterDto updateTheater(String id, UpdateTheaterRequest updateTheaterRequest) {
        return null;
    }

    @Override
    public TheaterDto findTheater(String id) {
        final String theaterId = DocKeyUtils.createTheaterDocKey(id);
        return theaterDbService.findById(theaterId).map(theaterMapper::map).orElseThrow(
            () -> new DocumentNotFoundException(theaterId)
        );
    }

    @Override
    public TheaterDto addScreens(String id, List<AddScreenRequest> addScreenRequests) {
        final String theaterId = DocKeyUtils.createTheaterDocKey(id);
        return theaterDbService.findById(theaterId).map(
            theater -> {
                saveScreens(theater, addScreenRequests);
                return theaterMapper.map(theaterDbService.save(theater));
            }
        ).orElseThrow(
            () -> new DocumentNotFoundException(theaterId)
        );
    }

    @Override
    public List<ScreenDto> findScreens(String id) {
        final String theaterId = DocKeyUtils.createTheaterDocKey(id);
        return theaterDbService.findById(theaterId).map(
            theater -> screenDbService.findAll(theater.getScreens())
                .stream()
                .map(screenMapper::map)
                .collect(Collectors.toList())
        ).orElseThrow(
            () -> new DocumentNotFoundException(theaterId)
        );
    }

    @Override
    public void removeScreen(String theaterId, String screenId) {
        screenDbService.deleteById(DocKeyUtils.createScreenDocKey(screenId));
    }

    private void saveScreens(Theater theater, List<AddScreenRequest> addScreenRequests) {
        if (!CollectionUtils.isEmpty(addScreenRequests)) {
            screenDbService.saveAll(
                addScreenRequests.stream().map(
                    addScreenRequest -> {
                        Screen screen = screenMapper.map(addScreenRequest);
                        theater.addScreen(screen.getId());
                        return screen;
                    }
                ).collect(Collectors.toList())
            );
        }
    }
}
