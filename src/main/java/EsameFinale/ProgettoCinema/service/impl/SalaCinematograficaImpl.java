package EsameFinale.ProgettoCinema.service.impl;

import EsameFinale.ProgettoCinema.data.dto.SalaCinematograficaDto;
import EsameFinale.ProgettoCinema.data.model.Biglietto;
import EsameFinale.ProgettoCinema.data.model.SalaCinematografica;
import EsameFinale.ProgettoCinema.data.model.Spettatore;
import EsameFinale.ProgettoCinema.repository.SalaCinematograficaRepository;
import EsameFinale.ProgettoCinema.service.SalaCinematograficaService;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class SalaCinematograficaImpl implements SalaCinematograficaService {

  private SalaCinematograficaRepository salaCinematograficaRepository;

  public SalaCinematograficaImpl(SalaCinematograficaRepository salaCinematograficaRepository) {
    this.salaCinematograficaRepository = salaCinematograficaRepository;
  }

  @Override
  public Optional<SalaCinematografica> getById(String id) {
    return salaCinematograficaRepository.findById(id);
  }

  @Override
  public boolean deleteById(String id) {
    Optional<SalaCinematografica> salaCinematografica = salaCinematograficaRepository.findById(id);
    if (salaCinematografica.isPresent()) {
      salaCinematograficaRepository.deleteById(id);
      return true;
    } else {
      return false;
    }
  }

  @Override
  public List<SalaCinematograficaDto> getAll() {
    List<SalaCinematograficaDto> salaCinematograficaDtoList = new ArrayList<>();
    for (SalaCinematografica salaCinematografica : salaCinematograficaRepository.findAll()) {
      salaCinematograficaDtoList.add(salaCinematografica.toDto());
    }
    return salaCinematograficaDtoList;
  }

  @Override
  public boolean emptyRoom(String id) {
    Optional<SalaCinematografica> salaCinematografica = salaCinematograficaRepository.findById(id);
    if (salaCinematografica.isPresent()) {
      salaCinematografica.get().setNumSpectator(0);
      return true;
    } else {
      return false;
    }
  }

  @Override
  public boolean fullRoom(String id) {
    Optional<SalaCinematografica> salaCinematografica = salaCinematograficaRepository.findById(id);
    if (salaCinematografica.isPresent()) {
      if (salaCinematografica.get().getNumSpectator() >= salaCinematografica.get()
          .getMaxNumSpectator()) {
        return true;
      } else {
        return false;
      }
    } else {
      return false;
    }
  }

  @Override
  public void accessSala(String idSala, Biglietto biglietto) {
    Optional<SalaCinematografica> salaCinematografica = salaCinematograficaRepository.findById(
        idSala);
    Spettatore spettatore = new Spettatore();
    if (salaCinematografica.isPresent()) {
      if (salaCinematografica.get().getFilm().getMinAge() == 18 && (!spettatore.adult(
          biglietto.getSpettatore()))) {
        throw new RuntimeException("Film vietato ai minori");
      } else if (salaCinematografica.get().getFilm().getMinAge() > biglietto.getSpettatore()
          .age(biglietto.getSpettatore())) {
        throw new RuntimeException("Età non valida per questo genere di film");
      }
    }
  }

}
