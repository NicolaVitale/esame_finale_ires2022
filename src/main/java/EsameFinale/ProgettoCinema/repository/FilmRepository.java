package EsameFinale.ProgettoCinema.repository;

import EsameFinale.ProgettoCinema.data.model.Film;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmRepository extends JpaRepository<Film, String> {

}
