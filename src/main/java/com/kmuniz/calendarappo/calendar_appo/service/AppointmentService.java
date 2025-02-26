package com.kmuniz.calendarappo.calendar_appo.service;


import com.kmuniz.calendarappo.calendar_appo.model.*;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;

@Service
public class AppointmentService {


    public CalendarDTO generateCalendarData(YearMonth month) {
        CalendarDTO calendar = new CalendarDTO();
        LocalDate firstOfMonth = month.atDay(1);
        LocalDate lastOfMonth = month.atEndOfMonth();

        // Find the first day of the week containing the 1st of the month
        LocalDate firstDayOfCalendar = firstOfMonth.minusDays(firstOfMonth.getDayOfWeek().getValue() - 1);

        // Generate 6 weeks to ensure we cover the whole month
        List<CalendarDTO.DayDTO> currentWeek = new ArrayList<>();
        LocalDate currentDate = firstDayOfCalendar;

        for (int i = 0; i < 42; i++) { // 6 weeks * 7 days
            CalendarDTO.DayDTO day = new CalendarDTO.DayDTO();
            day.setDate(currentDate);
            day.setCurrentMonth(currentDate.getMonth() == month.getMonth());
            day.setAvailable(isDateAvailable(currentDate));
            day.setHasAppointments(hasAppointmentsOnDate(currentDate));
            
            currentWeek.add(day);

            if (currentWeek.size() == 7) {
                calendar.getWeeks().add(currentWeek);
                currentWeek = new ArrayList<>();
            }

            currentDate = currentDate.plusDays(1);
        }

        return calendar;
    }

    private boolean isDateAvailable(LocalDate date) {
        // TODO: Implement actual availability check
        return !date.isBefore(LocalDate.now());
    }

    private boolean hasAppointmentsOnDate(LocalDate date) {
        // TODO: Implement actual appointments check
        return false;
    }

    public TimeSlotDTO getAvailableTimeSlots(LocalDate date, Long clinicId, Long serviceId) {
        // TODO: Replace with actual database query for availability
        TimeSlotDTO timeSlots = new TimeSlotDTO();
        
        // Get clinic opening hours (mock data)
        LocalTime startTime = LocalTime.of(6, 0); // 6:00 AM
        LocalTime endTime = LocalTime.of(22, 0);  // 10:00 PM
        
        // Generate time slots in 15-minute intervals
        LocalTime currentTime = startTime;
        while (currentTime.isBefore(endTime)) {
            TimeSlotDTO.TimeSlotInfo slotInfo = new TimeSlotDTO.TimeSlotInfo();
            
            // Mock availability logic
            boolean isPastTime = date.equals(LocalDate.now()) && currentTime.isBefore(LocalTime.now());
            boolean isWeekend = date.getDayOfWeek().getValue() >= 6;
            boolean isDuringLunch = currentTime.getHour() == 12;
            
            slotInfo.setAvailable(!isPastTime && !isWeekend && !isDuringLunch);
            slotInfo.setStatus(slotInfo.isAvailable() ? "AVAILABLE" : "UNAVAILABLE");
            
            // Mock doctor assignment
            if (slotInfo.isAvailable()) {
                slotInfo.setDoctorId(1L);
                slotInfo.setDoctorName("Dr. Smith");
            }
            
            timeSlots.getTimeSlots().put(currentTime, slotInfo);
            currentTime = currentTime.plusMinutes(15);
        }
        
        return timeSlots;
    }

    public List<ClinicDTO> getAvailableClinics() {
        // TODO: Replace with actual database query
        List<ClinicDTO> clinics = new ArrayList<>();
        
        ClinicDTO clinic1 = new ClinicDTO();
        clinic1.setId(1L);
        clinic1.setName("Central Medical Clinic");
        clinic1.setAddress("123 Main St, Downtown");
        clinic1.setPhone("555-0123");
        clinic1.setEmail("contact@centralclinic.com");
        clinic1.setOpeningHours("Mon-Fri: 8:00-18:00");
        
        ClinicDTO clinic2 = new ClinicDTO();
        clinic2.setId(2L);
        clinic2.setName("Family Health Center");
        clinic2.setAddress("456 Oak Ave, Uptown");
        clinic2.setPhone("555-0456");
        clinic2.setEmail("info@familyhealth.com");
        clinic2.setOpeningHours("Mon-Sat: 9:00-20:00");
        
        clinics.add(clinic1);
        clinics.add(clinic2);
        
        return clinics;
    }

    public List<MedicalServiceDTO> getAvailableServices(Long clinicId) {
        return null;
    }

    public AppointmentDTO bookAppointment(AppointmentBookingDTO booking) {
        // TODO: Replace with actual database operations
        if (booking == null) {
            throw new IllegalArgumentException("Booking details cannot be null");
        }
        
        if (booking.date() == null || booking.time() == null) {
            throw new IllegalArgumentException("Appointment date and time must be specified");
        }
        
        if (booking.clinicId() == null || booking.serviceId() == null) {
            throw new IllegalArgumentException("Clinic and service must be specified");
        }

        // Create a sample appointment
        AppointmentDTO appointment = new AppointmentDTO();
        appointment.setId(1L); // In real app, this would be generated by the database
        appointment.setAppointmentDate(LocalDateTime.of(booking.date(), booking.time()));
        appointment.setStatus("SCHEDULED");
        appointment.setNotes(booking.notes());
        
        // Set clinic details (in real app, these would be fetched from the database)
        appointment.setClinicId(booking.clinicId());
        appointment.setClinicName("Central Medical Clinic");
        
        // Set service details (in real app, these would be fetched from the database)
        appointment.setServiceId(booking.serviceId());
        appointment.setServiceName("General Consultation");
        
        // Set mock patient details (in real app, these would come from authenticated user)
        appointment.setPatientId(1L);
        appointment.setPatientName("John Doe");
        
        // Set mock doctor details (in real app, these would be assigned based on availability)
        appointment.setDoctorId(1L);
        appointment.setDoctorName("Dr. Smith");
        
        return appointment;
    }

    public List<AppointmentDTO> getCurrentUserAppointments() {
        return null;
    }

}
