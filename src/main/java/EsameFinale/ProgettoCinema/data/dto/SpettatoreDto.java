package EsameFinale.ProgettoCinema.data.dto;

import EsameFinale.ProgettoCinema.data.archetype.Dto;
import EsameFinale.ProgettoCinema.data.model.Biglietto;
import EsameFinale.ProgettoCinema.data.model.Spettatore;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SpettatoreDto implements Dto {

  private String id;

  private String name;

  private String surname;

  private LocalDate birthdate;

  private Biglietto biglietto;

  @Override
  public Spettatore toModel() {
    return Spettatore.builder()
        .id(id)
        .name(name)
        .surname(surname)
        .birthdate(birthdate)
        .biglietto(biglietto)
        .build();
  }
}
