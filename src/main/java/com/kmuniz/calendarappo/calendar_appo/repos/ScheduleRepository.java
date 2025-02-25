package com.kmuniz.calendarappo.calendar_appo.repos;

import com.kmuniz.calendarappo.calendar_appo.domain.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
}
