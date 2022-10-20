package EsameFinale.ProgettoCinema.service.impl;

import EsameFinale.ProgettoCinema.data.dto.BigliettoDto;
import EsameFinale.ProgettoCinema.data.model.Biglietto;
import EsameFinale.ProgettoCinema.data.model.Spettatore;
import EsameFinale.ProgettoCinema.repository.BigliettoRepository;
import EsameFinale.ProgettoCinema.repository.SpettatoreRepository;
import EsameFinale.ProgettoCinema.service.BigliettoService;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class BigliettoServiceImpl implements BigliettoService {

  private BigliettoRepository bigliettoRepository;
  private SpettatoreRepository spettatoreRepository;

  public BigliettoServiceImpl(BigliettoRepository bigliettoRepository,
      SpettatoreRepository spettatoreRepository) {
    this.bigliettoRepository = bigliettoRepository;
    this.spettatoreRepository = spettatoreRepository;
  }

  @Override
  public Optional<Biglietto> getById(String id) {
    return bigliettoRepository.findById(id);
  }

  @Override
  public boolean deleteById(String id) {
    Optional<Biglietto> biglietto = bigliettoRepository.findById(id);
    if (biglietto.isPresent()) {
      bigliettoRepository.deleteById(id);
      return true;
    } else {
      return false;
    }
  }

  @Override
  public List<BigliettoDto> getAll() {
    List<BigliettoDto> bigliettoDtoList = new ArrayList<>();
    for (Biglietto biglietto : bigliettoRepository.findAll()) {
      bigliettoDtoList.add(biglietto.toDto());
    }
    return bigliettoDtoList;
  }

  @Override
  public boolean priceReduction(Spettatore spettatore, Biglietto biglietto) {
    int age = Period.between(spettatore.getBirthdate(), LocalDate.now()).getYears();
    if (age <= 5) {
      biglietto.setPrice(biglietto.getPrice() / 2);
      spettatore.setBiglietto(biglietto);
      return true;
    } else if (age >= 70) {
      biglietto.setPrice(biglietto.getPrice() - ((biglietto.getPrice() * 10) / 100));
      spettatore.setBiglietto(biglietto);
      return true;
    } else {
      spettatore.setBiglietto(biglietto);
      return false;
    }
  }

}
