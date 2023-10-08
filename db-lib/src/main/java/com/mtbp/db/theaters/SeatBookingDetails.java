package com.mtbp.db.theaters;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SeatBookingDetails {
    private LocalTime time;
    private int total;
    @Builder.Default
    private Set<Integer> booked = new HashSet<>();
    @Builder.Default
    private Set<Integer> reserved = new HashSet<>();

    public SeatAvailability getAvailability() {
        return total > booked.size() + reserved.size() ? SeatAvailability.available : SeatAvailability.house_full;
    }

    public int findAvailableSeatCount() {
        return total - booked.size() + reserved.size();
    }
}