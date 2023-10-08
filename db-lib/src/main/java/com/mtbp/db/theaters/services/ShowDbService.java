package com.mtbp.db.theaters.services;

import com.mtbp.db.BaseDbService;
import com.mtbp.db.theaters.Show;

import java.time.LocalDate;
import java.util.List;

public interface ShowDbService extends BaseDbService<Show, String> {
    List<Show> findBy(String movieId, String city, LocalDate date);
}