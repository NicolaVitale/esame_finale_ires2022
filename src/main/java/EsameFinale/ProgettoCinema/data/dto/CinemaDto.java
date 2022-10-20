package EsameFinale.ProgettoCinema.data.dto;

import EsameFinale.ProgettoCinema.data.archetype.Dto;
import EsameFinale.ProgettoCinema.data.model.Cinema;
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
public class CinemaDto implements Dto {

  private String id;

  private List<SalaCinematografica> salaCinematograficasList;

  @Override
  public Cinema toModel() {
    return Cinema.builder()
        .id(id)
        .salaCinematograficasList(salaCinematograficasList)
        .build();
  }
}
