package com.kmuniz.calendarappo.calendar_appo.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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

    public Long getId() { 
        return id; 
    }

    public void setId(Long id) { 
        this.id = id; 
    }

    public List<AppointmentDTO> getCurrentUserAppointments() {
        // TODO: Replace with actual database query to fetch current user's appointments
        List<AppointmentDTO> appointments = new ArrayList<>();
        
        // Mock data for demonstration
        AppointmentDTO appointment = new AppointmentDTO();
        appointment.setId(1L);
        appointment.setAppointmentDate(LocalDateTime.now().plusDays(1));
        appointment.setStatus("SCHEDULED");
        appointment.setClinicName("Central Medical Clinic");
        appointment.setServiceName("General Consultation");
        appointment.setDoctorName("Dr. Smith");
        appointment.setPatientName("John Doe");
        
        appointments.add(appointment);
        
        return appointments;
    }
}