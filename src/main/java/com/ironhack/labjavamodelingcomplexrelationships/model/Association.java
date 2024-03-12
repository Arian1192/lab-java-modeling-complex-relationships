package com.ironhack.labjavamodelingcomplexrelationships.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "association")
@EqualsAndHashCode
public class Association {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
}

/*
* La asocciación se hace desde los Chapters.
* */

