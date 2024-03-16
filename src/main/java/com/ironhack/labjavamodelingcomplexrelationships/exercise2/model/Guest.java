package com.ironhack.labjavamodelingcomplexrelationships.exercise2.model;

import com.ironhack.labjavamodelingcomplexrelationships.exercise2.enums.GuestStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "guest")
public class Guest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Enumerated(EnumType.STRING)
    private GuestStatus status;

    @ManyToOne
    private Event event;

}