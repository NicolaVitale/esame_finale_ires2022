package EsameFinale.ProgettoCinema.service;

import EsameFinale.ProgettoCinema.data.dto.SalaCinematograficaDto;
import EsameFinale.ProgettoCinema.data.model.Biglietto;
import EsameFinale.ProgettoCinema.data.model.SalaCinematografica;
import java.util.List;
import java.util.Optional;

public interface SalaCinematograficaService {

  Optional<SalaCinematografica> getById(String id);

  boolean deleteById(String id);

  List<SalaCinematograficaDto> getAll();

  SalaCinematografica save(SalaCinematografica salaCinematografica);

  boolean emptyRoom(String id);

  boolean fullRoom(String id);

  void accessSala(String idSala, Biglietto biglietto);

}
