package com.kmuniz.calendarappo.calendar_appo.model;

import java.time.LocalDate;
import java.time.LocalTime;

public record AppointmentBookingDTO(
    LocalDate date,
    LocalTime time,
    Long clinicId,
    Long serviceId,
    String notes
) {} 