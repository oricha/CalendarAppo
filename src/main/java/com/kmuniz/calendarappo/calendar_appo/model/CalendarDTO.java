package com.kmuniz.calendarappo.calendar_appo.model;

import lombok.Data;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
public class CalendarDTO {
    private List<List<DayDTO>> weeks = new ArrayList<>();

    public Object weeks() {
        //TODO implement
        return null;
    }

    @Data
    public static class DayDTO {
        private LocalDate date;
        private boolean isCurrentMonth;
        private boolean isAvailable;
        private boolean hasAppointments;
    }
} 