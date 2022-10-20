package EsameFinale.ProgettoCinema.repository;

import EsameFinale.ProgettoCinema.data.model.Cinema;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CinemaRepository extends JpaRepository<Cinema, String> {

}
