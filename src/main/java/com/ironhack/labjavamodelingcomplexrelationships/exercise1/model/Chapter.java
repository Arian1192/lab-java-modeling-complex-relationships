package com.ironhack.labjavamodelingcomplexrelationships.exercise1.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldNameConstants;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "chapter")
@EqualsAndHashCode
public class Chapter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String district;

    @OneToOne
    private Member president;


    @OneToMany(mappedBy = "chapter", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Member> members;

    @ManyToOne
    private Association association;

    public Chapter(String name, String district, Member president, List<Member> members, Association association) {
        this.name = name;
        this.district = district;
        this.president = president;
        this.members = members;
        this.association = association;
    }
}
