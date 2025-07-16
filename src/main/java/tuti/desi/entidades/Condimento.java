package tuti.desi.entidades;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("condimento")
public class Condimento extends Ingrediente{

}
