package com.kmuniz.calendarappo.calendar_appo.service;


import com.kmuniz.calendarappo.calendar_appo.model.*;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.List;

@Service
public class AppointmentService {


    public CalendarDTO generateCalendarData(YearMonth month){
        return null;
    }


    public TimeSlotDTO getAvailableTimeSlots(LocalDate date, Long clinicId, Long serviceId) {
        return null;
    }

    public List<ClinicDTO> getAvailableClinics() {
        return null;
    }

    public List<MedicalServiceDTO> getAvailableServices(Long clinicId) {
        return null;
    }

    public AppointmentDTO bookAppointment(AppointmentBookingDTO booking) {
        return null;
    }

    public List<AppointmentDTO> getCurrentUserAppointments() {
        return null;
    }

}
