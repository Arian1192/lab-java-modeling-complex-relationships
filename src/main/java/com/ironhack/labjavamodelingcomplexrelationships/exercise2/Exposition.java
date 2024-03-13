package com.ironhack.labjavamodelingcomplexrelationships.exercise2;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Entity
@DiscriminatorValue("exposition")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Exposition extends Event {
    // Otros campos y relaciones específicos de la exposición...

    // Getters y setters...
}
