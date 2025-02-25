package com.kmuniz.calendarappo.calendar_appo.repos;

import com.kmuniz.calendarappo.calendar_appo.domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UsersRepository extends JpaRepository<Users, Long> {
}
