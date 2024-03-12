package com.ironhack.labjavamodelingcomplexrelationships.model;

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

    @OneToMany(mappedBy = "association")
    private Set<Chapter> chapters;
}

/*
* La asocciación se hace desde los Chapters.
* */

