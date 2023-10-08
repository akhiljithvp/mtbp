package com.mtbp.movies.services;

import com.mtbp.commons.dto.theaters.SeatsDto;
import com.mtbp.commons.utils.DocKeyUtils;
import com.mtbp.db.exceptions.DocumentNotFoundException;
import com.mtbp.db.theaters.Seats;
import com.mtbp.db.theaters.Show;
import com.mtbp.db.theaters.services.SeatsDbService;
import com.mtbp.db.theaters.services.ShowDbService;
import com.mtbp.movies.mappers.SeatsMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Slf4j
@Service
@RequiredArgsConstructor
public class SeatsServiceImpl implements SeatsService {
    private final SeatsMapper seatsMapper;
    private final SeatsDbService seatsDbService;
    private final ShowDbService showDbService;

    @Override
    public SeatsDto findSeats(String showId, LocalDate date) {
        final String seatsId = DocKeyUtils.createSeatsDocKey(showId, date);
        return seatsDbService.findById(seatsId)
            .map(seatsMapper::map)
            .orElseGet(
                () -> {
                    final String showDocId = DocKeyUtils.createShowDocKey(showId);
                    Show show = showDbService.findById(showDocId).orElseThrow(
                        () -> new DocumentNotFoundException(showDocId)
                    );
                    Seats seats = seatsMapper.map(seatsId, show.getSeats(), show.getDailyShowTimings());
                    return seatsMapper.map(seatsDbService.save(seats));
                }
            );
    }
}
