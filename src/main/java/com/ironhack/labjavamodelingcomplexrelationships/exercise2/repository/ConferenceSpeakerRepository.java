package com.ironhack.labjavamodelingcomplexrelationships.exercise2.repository;

import com.ironhack.labjavamodelingcomplexrelationships.exercise2.model.ConferenceSpeaker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConferenceSpeakerRepository extends JpaRepository<ConferenceSpeaker, Long> {
}
