package EsameFinale.ProgettoCinema.data.model;

import EsameFinale.ProgettoCinema.data.archetype.Model;
import EsameFinale.ProgettoCinema.data.dto.SpettatoreDto;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
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
@Table(name = "spettatore")
public class Spettatore implements Model {

  @Id
  private String id;

  @Column
  private String name;

  @Column
  private String surname;

  @Column
  private Date birthdate;

  @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "spettatore")
  @JsonManagedReference(value = "biglietto")
  @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
  private Biglietto biglietto;

  @Override
  public SpettatoreDto toDto() {
    return SpettatoreDto.builder()
        .id(id)
        .name(name)
        .surname(surname)
        .birthdate(birthdate)
        .biglietto(biglietto)
        .build();
  }
}
