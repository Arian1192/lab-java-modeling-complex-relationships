package com.ironhack.labjavamodelingcomplexrelationships.exercise2;

import jakarta.persistence.CascadeType;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.List;


@Entity
@DiscriminatorValue("conference")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Data
public class Conference extends Event{
    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL)
    private List<ConferenceSpeaker> speakers;
}
