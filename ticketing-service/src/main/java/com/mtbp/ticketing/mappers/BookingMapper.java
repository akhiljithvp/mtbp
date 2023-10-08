package com.mtbp.ticketing.mappers;

import com.mtbp.commons.dto.payments.CreateBookingRequest;
import com.mtbp.commons.utils.DocKeyUtils;
import com.mtbp.db.ticketing.Booking;
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
public interface BookingMapper {
    @Mapping(target = "id", expression = "java(DocKeyUtils.createBookingDocKey())")
    Booking map(CreateBookingRequest createBookingRequest);
}
