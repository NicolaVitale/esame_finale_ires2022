package EsameFinale.ProgettoCinema.service.impl;

import EsameFinale.ProgettoCinema.data.dto.CinemaDto;
import EsameFinale.ProgettoCinema.data.model.Biglietto;
import EsameFinale.ProgettoCinema.data.model.Cinema;
import EsameFinale.ProgettoCinema.data.model.SalaCinematografica;
import EsameFinale.ProgettoCinema.repository.CinemaRepository;
import EsameFinale.ProgettoCinema.repository.SalaCinematograficaRepository;
import EsameFinale.ProgettoCinema.service.CinemaService;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class CinemaServiceImpl implements CinemaService {

  private CinemaRepository cinemaRepository;
  private SalaCinematograficaRepository salaCinematograficaRepository;

  public CinemaServiceImpl(CinemaRepository cinemaRepository,
      SalaCinematograficaRepository salaCinematograficaRepository) {
    this.cinemaRepository = cinemaRepository;
    this.salaCinematograficaRepository = salaCinematograficaRepository;
  }

  @Override
  public Optional<Cinema> getById(String id) {
    return cinemaRepository.findById(id);
  }

  @Override
  public boolean deleteById(String id) {
    Optional<Cinema> cinema = cinemaRepository.findById(id);
    if (cinema.isPresent()) {
      cinemaRepository.deleteById(id);
      return true;
    } else {
      return false;
    }
  }

  @Override
  public List<CinemaDto> getAll() {
    List<CinemaDto> cinemaDtoList = new ArrayList<>();
    for (Cinema cinema : cinemaRepository.findAll()) {
      cinemaDtoList.add(cinema.toDto());
    }
    return cinemaDtoList;
  }

  @Override
  public Cinema save(Cinema cinema) {
    Cinema cinemaToSave = Cinema.builder()
        .id(cinema.getId())
        .salaCinematograficasList(cinema.getSalaCinematograficasList())
        .build();
    return cinemaRepository.save(cinemaToSave);
  }

  @Override
  public double totaleIncasso() {
    double total = 0;
    for(SalaCinematografica salaCinematografica : salaCinematograficaRepository.findAll()) {
      total = total + salaCinematografica.getIncasso();
    }
    return total;
  }
}
