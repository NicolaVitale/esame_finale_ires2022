package EsameFinale.ProgettoCinema.service;

import EsameFinale.ProgettoCinema.data.dto.SpettatoreDto;
import EsameFinale.ProgettoCinema.data.model.Spettatore;
import java.util.List;
import java.util.Optional;

public interface SpettatoreService {

  Optional<Spettatore> getById(String id);

  boolean deleteById(String id);

  List<SpettatoreDto> getAll();

  Spettatore save(Spettatore spettatore);

}
