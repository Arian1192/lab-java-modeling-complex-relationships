package com.ironhack.labjavamodelingcomplexrelationships.exercise2.repository;

import com.ironhack.labjavamodelingcomplexrelationships.exercise2.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {
}
