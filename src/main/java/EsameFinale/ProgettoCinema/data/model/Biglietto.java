package EsameFinale.ProgettoCinema.data.model;

import EsameFinale.ProgettoCinema.data.archetype.Model;
import EsameFinale.ProgettoCinema.data.dto.BigliettoDto;
import com.fasterxml.jackson.annotation.JsonBackReference;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "biglietto")
public class Biglietto implements Model {

  @Id
  private String id;

  @Column
  private String seating;

  @Column
  private double price;

  @OneToOne
  @JoinColumn(name = "id_spettatore")
  @JsonBackReference(value = "spettatore")
  private Spettatore spettatore;

  @ManyToOne
  @JoinColumn(name = "id_sala_cinematografica")
  @JsonBackReference(value = "sala_cinematografica")
  private SalaCinematografica salaCinematografica;

  @Override
  public BigliettoDto toDto() {
    return BigliettoDto.builder()
        .id(id)
        .seating(seating)
        .price(price)
        .spettatore(spettatore)
        .salaCinematografica(salaCinematografica)
        .build();
  }
}
