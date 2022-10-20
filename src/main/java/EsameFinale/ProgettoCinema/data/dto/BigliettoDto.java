package EsameFinale.ProgettoCinema.data.dto;

import EsameFinale.ProgettoCinema.data.archetype.Dto;
import EsameFinale.ProgettoCinema.data.model.Biglietto;
import EsameFinale.ProgettoCinema.data.model.SalaCinematografica;
import EsameFinale.ProgettoCinema.data.model.Spettatore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BigliettoDto implements Dto {

  private String id;

  private String seating;

  private double price;

  private Spettatore spettatore;

  private SalaCinematografica salaCinematografica;

  @Override
  public Biglietto toModel() {
    return Biglietto.builder()
        .id(id)
        .seating(seating)
        .price(price)
        .spettatore(spettatore)
        .salaCinematografica(salaCinematografica)
        .build();
  }
}
