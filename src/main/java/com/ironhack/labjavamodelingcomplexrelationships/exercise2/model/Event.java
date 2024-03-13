package com.ironhack.labjavamodelingcomplexrelationships.exercise2.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "event_type")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public abstract class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date date;
    private int duration;
    private String location;
    private String title;

    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL)
    private List<Guest> guests;

}