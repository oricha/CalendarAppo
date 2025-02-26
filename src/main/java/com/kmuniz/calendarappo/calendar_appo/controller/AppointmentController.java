package com.kmuniz.calendarappo.calendar_appo.controller;

import com.kmuniz.calendarappo.calendar_appo.model.*;
import com.kmuniz.calendarappo.calendar_appo.service.AppointmentService;
import com.kmuniz.calendarappo.calendar_appo.util.ApiResponse;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.List;

@Controller
@RequestMapping("/appointments")
public class AppointmentController {

    private final AppointmentService appointmentService;

    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @GetMapping("/calendar")
    public String showCalendar(
            @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM") YearMonth month,
            Model model) {
        try {
            YearMonth selectedMonth = month != null ? month : YearMonth.now();
            CalendarDTO calendar = appointmentService.generateCalendarData(selectedMonth);
            
            model.addAttribute("currentDate", selectedMonth.atDay(1));
            model.addAttribute("previousMonth", selectedMonth.minusMonths(1));
            model.addAttribute("nextMonth", selectedMonth.plusMonths(1));
            model.addAttribute("calendar", calendar.getWeeks());
            
            return "appointments/calendar";
        } catch (Exception e) {
            model.addAttribute("error", "Error loading calendar: " + e.getMessage());
            return "error";
        }
    }

    @GetMapping("/timeslots")
    public String showTimeSlots(
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
            @RequestParam(required = false) Long clinicId,
            @RequestParam(required = false) Long serviceId,
            Model model) {
        try {
            TimeSlotDTO timeSlots = appointmentService.getAvailableTimeSlots(date, clinicId, serviceId);
            List<ClinicDTO> clinics = appointmentService.getAvailableClinics();
            List<MedicalServiceDTO> medicalServices = appointmentService.getAvailableServices(clinicId);

            model.addAttribute("selectedDate", date);
            model.addAttribute("previousDate", date.minusDays(1));
            model.addAttribute("nextDate", date.plusDays(1));
            model.addAttribute("timeSlots", timeSlots);
            model.addAttribute("clinics", clinics);
            model.addAttribute("services", medicalServices);
            model.addAttribute("selectedClinicId", clinicId);
            model.addAttribute("selectedServiceId", serviceId);

            return "appointments/timeslots";
        } catch (Exception e) {
            model.addAttribute("error", "Error loading time slots: " + e.getMessage());
            return "error";
        }
    }

    @PostMapping("/book")
  //  @PreAuthorize("hasRole('PATIENT')")
    public ResponseEntity<ApiResponse<AppointmentDTO>> bookAppointment(
            @RequestBody AppointmentBookingDTO booking) {
        try {
            AppointmentDTO appointment = appointmentService.bookAppointment(booking);
            return ResponseEntity.ok(new ApiResponse<>("SUCCESS", "Appointment booked successfully", appointment));
        } catch (Exception e) {
            return ResponseEntity.badRequest()
                    .body(new ApiResponse<>("ERROR", e.getMessage(), null));
        }
    }

    @GetMapping("/my-appointments")
  //  @PreAuthorize("isAuthenticated()")
    public String showMyAppointments(Model model) {
        try {
            List<AppointmentDTO> appointments = appointmentService.getCurrentUserAppointments();
            model.addAttribute("appointments", appointments);
            return "appointments/my-appointments";
        } catch (Exception e) {
            model.addAttribute("error", "Error loading appointments: " + e.getMessage());
            return "error";
        }
    }
} 