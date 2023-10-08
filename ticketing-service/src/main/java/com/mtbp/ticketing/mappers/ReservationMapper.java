package com.mtbp.ticketing.mappers;

import com.mtbp.commons.dto.reservations.CreateReservationRequest;
import com.mtbp.commons.dto.reservations.ReservationDto;
import com.mtbp.commons.utils.DocKeyUtils;
import com.mtbp.db.ticketing.Reservation;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(
    componentModel = "spring",
    imports = {DocKeyUtils.class},
    unmappedTargetPolicy = ReportingPolicy.IGNORE,
    nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT
)
public interface ReservationMapper {
    @Mapping(target = "id", expression = "java(DocKeyUtils.createReservationDocKey())")
    @Mapping(target = "showDate", source = "createReservationRequest.date")
    @Mapping(target = "showTime", source = "createReservationRequest.time")
    Reservation map(CreateReservationRequest createReservationRequest, long lockPeriod);

    @Mapping(target = "id", expression = "java(DocKeyUtils.removeDocPrefix(reservation.getId()))")
    @Mapping(target = "reservationLockPeriod", source = "lockPeriod")
    ReservationDto map(Reservation reservation);
}
