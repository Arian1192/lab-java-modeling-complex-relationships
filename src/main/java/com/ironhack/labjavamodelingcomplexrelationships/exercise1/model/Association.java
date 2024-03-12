package com.ironhack.labjavamodelingcomplexrelationships.exercise1.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

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

    @OneToMany(mappedBy = "association", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Chapter> chapters;
}

/*
* La asocciación se hace desde los Chapters.
* */

