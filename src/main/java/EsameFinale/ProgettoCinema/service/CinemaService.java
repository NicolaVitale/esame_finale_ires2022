package EsameFinale.ProgettoCinema.service;

import EsameFinale.ProgettoCinema.data.dto.CinemaDto;
import EsameFinale.ProgettoCinema.data.model.Cinema;
import java.util.List;
import java.util.Optional;

public interface CinemaService {

  Optional<Cinema> getById(String id);

  boolean deleteById(String id);

  List<CinemaDto> getAll();

  double totaleIncasso();

}
