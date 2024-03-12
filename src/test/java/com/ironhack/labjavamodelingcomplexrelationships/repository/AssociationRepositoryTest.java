package com.ironhack.labjavamodelingcomplexrelationships.repository;

import com.ironhack.labjavamodelingcomplexrelationships.model.Association;
import com.ironhack.labjavamodelingcomplexrelationships.repository.AssociationRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AssociationRepositoryTest {

    @Autowired
    private AssociationRepository as;

    private Association association;
    @BeforeEach
    //given
    void setUp() {
        association = new Association();

    }

    @AfterEach
    void tearDown() {
        as.deleteAll();
    }

    @Test
    @DisplayName("Association should be created succesfully")
    void createAssociation(){
        //when
        as.save(association);
        Optional<Association> maybeAssociation = as.findById(association.getId());
        assertTrue(maybeAssociation.isPresent());
        assertEquals(association.getId(), maybeAssociation.get().getId());
    }
}