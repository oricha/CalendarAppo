package com.kmuniz.calendarappo.calendar_appo.repos;

import com.kmuniz.calendarappo.calendar_appo.domain.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
}
