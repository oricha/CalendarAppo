package com.kmuniz.calendarappo.calendar_appo.model;



public class MedicalServiceDTO {
    private Long id;
    private String name;
    private String description;
    private double price;
    private int durationMinutes;
    private Long clinicId;
    private String clinicName;

    public MedicalServiceDTO(long l, String generalConsultation, String s) {

        this.id = l;
        this.name = generalConsultation;
        this.description = s;
    }

    // Getters and Setters
}