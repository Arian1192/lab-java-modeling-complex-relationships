package com.ironhack.labjavamodelingcomplexrelationships.exercise1.repository;

import com.ironhack.labjavamodelingcomplexrelationships.exercise1.model.Association;
import com.ironhack.labjavamodelingcomplexrelationships.exercise1.model.Chapter;
import com.ironhack.labjavamodelingcomplexrelationships.exercise1.repository.AssociationRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AssociationRepositoryTest {

    @Autowired
    private AssociationRepository as;

    private Association association;
    private Set<Chapter> chapterSet;
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