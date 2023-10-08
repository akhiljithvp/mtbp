package com.mtbp.movies.services;

import com.mtbp.commons.dto.theaters.*;

import java.util.List;

public interface TheaterService {
    TheaterDto addTheater(AddTheaterRequest addTheaterRequest);

    TheaterDto updateTheater(String id, UpdateTheaterRequest updateTheaterRequest);

    TheaterDto findTheater(String id);

    TheaterDto addScreens(String theaterId, List<AddScreenRequest> addScreenRequest);

    List<ScreenDto> findScreens(String id);

    void removeScreen(String theaterId, String screenId);
}
