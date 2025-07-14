package tuti.desi.entidades;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("CONDIMENTO")
public class Condimento extends Ingrediente{

}
