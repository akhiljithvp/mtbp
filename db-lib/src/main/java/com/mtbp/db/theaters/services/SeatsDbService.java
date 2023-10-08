package com.mtbp.db.theaters.services;

import com.mtbp.db.BaseDbService;
import com.mtbp.db.theaters.Seats;

import java.util.List;

public interface SeatsDbService extends BaseDbService<Seats, String> {
    List<Seats> saveAll(List<Seats> seatsList);
}
