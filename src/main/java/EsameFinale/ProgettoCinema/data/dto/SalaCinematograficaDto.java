package EsameFinale.ProgettoCinema.data.dto;

import EsameFinale.ProgettoCinema.data.archetype.Dto;
import EsameFinale.ProgettoCinema.data.model.Biglietto;
import EsameFinale.ProgettoCinema.data.model.Cinema;
import EsameFinale.ProgettoCinema.data.model.Film;
import EsameFinale.ProgettoCinema.data.model.SalaCinematografica;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SalaCinematograficaDto implements Dto {

  private String id;

  private int numSpectator;

  private Cinema cinema;

  private Film film;

  private List<Biglietto> bigliettoList;

  @Override
  public SalaCinematografica toModel() {
    return SalaCinematografica.builder()
        .id(id)
        .numSpectator(numSpectator)
        .cinema(cinema)
        .film(film)
        .bigliettoList(bigliettoList)
        .build();
  }
}
