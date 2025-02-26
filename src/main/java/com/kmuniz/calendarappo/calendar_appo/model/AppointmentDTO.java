package com.kmuniz.calendarappo.calendar_appo.model;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class AppointmentDTO {
    private Long id;
    private LocalDateTime appointmentDate;
    private String status;    // SCHEDULED, COMPLETED, CANCELED
    private String notes;

    private Long patientId;
    private String patientName;

    private Long doctorId;
    private String doctorName;

    private Long clinicId;
    private String clinicName;

    private Long serviceId;
    private String serviceName;
}
