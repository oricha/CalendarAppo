package com.kmuniz.calendarappo.calendar_appo.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class ScheduleDTO {
    private Long id;
    private LocalDate availableDate;
    private LocalTime startTime;
    private LocalTime endTime;
    private Long doctorId;
    private String doctorName;
    private Long clinicId;
    private String clinicName;

    // Getters and Setters
}