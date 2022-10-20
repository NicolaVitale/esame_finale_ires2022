package EsameFinale.ProgettoCinema.controller;

import EsameFinale.ProgettoCinema.data.dto.CinemaDto;
import EsameFinale.ProgettoCinema.data.model.Cinema;
import EsameFinale.ProgettoCinema.service.impl.CinemaServiceImpl;
import java.util.List;
import java.util.Optional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cinema")
public class CinemaController {

  private CinemaServiceImpl cinemaService;

  public CinemaController(CinemaServiceImpl cinemaService) {
    this.cinemaService = cinemaService;
  }

  @GetMapping
  public List<CinemaDto> getAll() {
    return cinemaService.getAll();
  }

  @GetMapping("/{idCinema}")
  public Optional<Cinema> getById(@PathVariable String idCinema) {
    return cinemaService.getById(idCinema);
  }

  @DeleteMapping("/{idCinema}")
  public boolean delete(@PathVariable String idCinema) {
    return cinemaService.deleteById(idCinema);
  }

  @PostMapping
  public Cinema insert(@RequestBody CinemaDto cinemaDto) {
    return cinemaService.save(cinemaDto.toModel());
  }

  @GetMapping("/incasso")
  public double getById() {
    return cinemaService.totaleIncasso();
  }

}
