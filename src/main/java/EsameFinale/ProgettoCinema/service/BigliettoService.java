package EsameFinale.ProgettoCinema.service;

import EsameFinale.ProgettoCinema.data.dto.BigliettoDto;
import EsameFinale.ProgettoCinema.data.model.Biglietto;
import EsameFinale.ProgettoCinema.data.model.Spettatore;
import java.util.List;
import java.util.Optional;

public interface BigliettoService {

  Optional<Biglietto> getById(String id);

  boolean deleteById(String id);

  List<BigliettoDto> getAll();

  Biglietto save(Biglietto biglietto);

  boolean priceReduction(Spettatore spettatore, Biglietto biglietto);

}
