package com.ironhack.labjavamodelingcomplexrelationships.exercise1.repository;

import com.ironhack.labjavamodelingcomplexrelationships.exercise1.model.Association;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssociationRepository extends JpaRepository<Association, Long> {

}
