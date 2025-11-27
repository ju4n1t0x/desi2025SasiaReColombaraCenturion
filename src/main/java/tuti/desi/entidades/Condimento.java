package tuti.desi.entidades;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@DiscriminatorValue("condimento")
public class Condimento extends Ingrediente{
    @OneToMany(mappedBy = "ingrediente")
    private List<ItemReceta> itemReceta;

    public List<ItemReceta> getItemReceta() {
        return itemReceta;
    }

    public void setItemReceta(List<ItemReceta> itemReceta) {
        this.itemReceta = itemReceta;
    }


}
