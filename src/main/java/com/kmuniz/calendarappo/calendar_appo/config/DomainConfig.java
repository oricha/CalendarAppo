package com.kmuniz.calendarappo.calendar_appo.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@EntityScan("com.kmuniz.calendarappo.calendar_appo.domain")
@EnableJpaRepositories("com.kmuniz.calendarappo.calendar_appo.repos")
@EnableTransactionManagement
public class DomainConfig {
}
