package EsameFinale.ProgettoCinema.service;

import EsameFinale.ProgettoCinema.data.dto.FilmDto;
import EsameFinale.ProgettoCinema.data.model.Film;
import java.util.List;
import java.util.Optional;

public interface FilmService {

  Optional<Film> getById(String id);

  boolean deleteById(String id);

  Film save(Film film);

  List<FilmDto> getAll();

}
