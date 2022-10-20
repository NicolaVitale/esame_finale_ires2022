package EsameFinale.ProgettoCinema.controller;

import EsameFinale.ProgettoCinema.data.dto.BigliettoDto;
import EsameFinale.ProgettoCinema.data.dto.CinemaDto;
import EsameFinale.ProgettoCinema.data.model.Biglietto;
import EsameFinale.ProgettoCinema.data.model.Cinema;
import EsameFinale.ProgettoCinema.service.impl.BigliettoServiceImpl;
import java.util.List;
import java.util.Optional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/biglietto")
public class BigliettoController {

  BigliettoServiceImpl bigliettoService;

  public BigliettoController(BigliettoServiceImpl bigliettoService) {
    this.bigliettoService = bigliettoService;
  }

  @GetMapping
  public List<BigliettoDto> getAll() {
    return bigliettoService.getAll();
  }

  @GetMapping("/{idCinema}")
  public Optional<Biglietto> getById(@PathVariable String idBiglietto) {
    return bigliettoService.getById(idBiglietto);
  }

  @DeleteMapping("/{idCinema}")
  public boolean delete(@PathVariable String idBiglietto) {
    return bigliettoService.deleteById(idBiglietto);
  }

  @PostMapping
  public Biglietto insert(@RequestBody BigliettoDto bigliettoDto) {
    return bigliettoService.save(bigliettoDto.toModel());
  }
}
