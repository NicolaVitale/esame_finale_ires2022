package EsameFinale.ProgettoCinema.data.model;

import EsameFinale.ProgettoCinema.data.archetype.Model;
import EsameFinale.ProgettoCinema.data.dto.CinemaDto;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
@Table(name = "cinema")
public class Cinema implements Model {

  @Id
  private String id;

  @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "cinema")
  @JsonManagedReference(value = "sala_cinematografica")
  @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
  private List<SalaCinematografica> salaCinematograficasList;

  @Override
  public CinemaDto toDto() {
    return CinemaDto.builder()
        .id(id)
        .salaCinematograficasList(salaCinematograficasList)
        .build();
  }
}
