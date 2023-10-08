package com.mtbp.movies.services;


import com.mtbp.commons.dto.movies.AddShowRequest;
import com.mtbp.commons.dto.movies.ShowDto;
import com.mtbp.commons.dto.movies.UpdateShowRequest;

import java.util.List;

public interface ShowService {

    ShowDto addShow(AddShowRequest addShowRequest);

    ShowDto findShow(String id);

    ShowDto updateShow(String id, UpdateShowRequest updateShowRequest);

    List<ShowDto> findShows(ShowSearchFilters filters);
}