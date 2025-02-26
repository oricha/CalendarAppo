package com.kmuniz.calendarappo.calendar_appo.model;

import lombok.Data;

@Data
public class ClinicDTO {
    private Long id;
    private String name;
    private String address;
    private String phone;
    private String email;
    private String openingHours;
}