package com.mtbp.movies.mappers;

import com.mtbp.commons.dto.theaters.AddSeatsRequest;
import com.mtbp.commons.dto.theaters.SeatBookingDetailsDto;
import com.mtbp.commons.dto.theaters.SeatTypeDto;
import com.mtbp.commons.dto.theaters.SeatsDto;
import com.mtbp.commons.utils.DocKeyUtils;
import com.mtbp.db.theaters.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueMappingStrategy;
import org.mapstruct.ReportingPolicy;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Mapper(
    componentModel = "spring",
    imports = {DocKeyUtils.class},
    unmappedTargetPolicy = ReportingPolicy.IGNORE,
    nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT
)
public interface SeatsMapper {

    @Mapping(target = "total", source = "addSeatsRequest.total")
    @Mapping(target = "types", source = "addSeatsRequest.types")
    Seats map(String id, AddSeatsRequest addSeatsRequest);

    SeatType map(SeatTypeDto seatTypeDto);

    @Mapping(target = "currentBookings", expression = "java(map(dailyShowTimings, seats.getTotal()))")
    Seats map(String id, SeatsInfo seats, List<LocalTime> dailyShowTimings);

    SeatsDto map(Seats seats);

    SeatBookingDetailsDto map(SeatBookingDetails seatBookingDetails);

    String map(SeatAvailability seatAvailability);

    default List<SeatBookingDetails> map(List<LocalTime> dailyShowTimings, int total) {
        List<SeatBookingDetails> bookings = new ArrayList<>();
        for (LocalTime time : dailyShowTimings) {
            bookings.add(SeatBookingDetails.builder()
                .time(time)
                .total(total)
                .build()
            );
        }
        return bookings;
    }
}