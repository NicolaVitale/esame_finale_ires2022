package EsameFinale.ProgettoCinema.data.model;

import EsameFinale.ProgettoCinema.data.archetype.Model;
import EsameFinale.ProgettoCinema.data.dto.SalaCinematograficaDto;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.dom4j.rule.Mode;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "sala_cinematografica")
public class SalaCinematografica implements Model {

  @Id
  private String id;

  @Column
  private int numSpectator;

  @ManyToOne
  @JoinColumn(name = "id_cinema")
  @JsonBackReference(value = "cinema")
  private Cinema cinema;


  @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "sala_cinematografica")
  @JsonManagedReference(value = "film")
  @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
  private Film film;


  @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "sala_cinematografica")
  @JsonManagedReference(value = "biglietto")
  @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
  private List<Biglietto> bigliettoList;

  @Override
  public SalaCinematograficaDto toDto() {
    return SalaCinematograficaDto.builder()
        .id(id)
        .numSpectator(numSpectator)
        .cinema(cinema)
        .film(film)
        .bigliettoList(bigliettoList)
        .build();
  }
}
