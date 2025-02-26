package com.kmuniz.calendarappo.calendar_appo.model;

import lombok.Data;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

@Data
public class TimeSlotDTO {
    private Map<LocalTime, TimeSlotInfo> timeSlots = new HashMap<>();

    @Data
    public static class TimeSlotInfo {
        private boolean available;
        private String doctorName;
        private Long doctorId;
        private String status; // "AVAILABLE", "BOOKED", "UNAVAILABLE"
    }

    public boolean isAvailable(int hour, int minute) {
        LocalTime time = LocalTime.of(hour, minute);
        TimeSlotInfo info = timeSlots.get(time);
        return info != null && info.isAvailable();
    }
} 