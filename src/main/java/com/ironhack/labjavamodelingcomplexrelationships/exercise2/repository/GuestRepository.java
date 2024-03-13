package com.ironhack.labjavamodelingcomplexrelationships.exercise2.repository;

import com.ironhack.labjavamodelingcomplexrelationships.exercise2.model.Guest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GuestRepository extends JpaRepository<Guest, Long> {
}

