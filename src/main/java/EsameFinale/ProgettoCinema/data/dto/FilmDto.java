package EsameFinale.ProgettoCinema.data.dto;

import EsameFinale.ProgettoCinema.data.archetype.Dto;
import EsameFinale.ProgettoCinema.data.model.Film;
import EsameFinale.ProgettoCinema.data.model.SalaCinematografica;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FilmDto implements Dto {

  private String id;

  private String title;

  private String author;

  private String producer;

  private String gender;

  private int minAge;

  private int duration;

  private SalaCinematografica salaCinematografica;

  @Override
  public Film toModel() {
    return Film.builder()
        .id(id)
        .title(title)
        .author(author)
        .producer(producer)
        .gender(gender)
        .minAge(minAge)
        .duration(duration)
        .salaCinematografica(salaCinematografica)
        .build();
  }
}
