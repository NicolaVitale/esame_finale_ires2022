package EsameFinale.ProgettoCinema.data.model;

import EsameFinale.ProgettoCinema.data.archetype.Model;
import EsameFinale.ProgettoCinema.data.dto.FilmDto;
import com.fasterxml.jackson.annotation.JsonBackReference;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
@Table(name = "film")
public class Film implements Model {

  @Id
  private String id;

  @Column
  private String title;

  @Column
  private String author;

  @Column
  private String producer;

  @Column
  private String gender;

  @Column
  private int minAge;

  @Column
  private int duration;

  @OneToOne
  @JoinColumn(name = "id_sala_cinematografica")
  @JsonBackReference(value = "sala_cinematografica")
  private SalaCinematografica salaCinematografica;

  @Override
  public FilmDto toDto() {
    return FilmDto.builder()
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
