package EsameFinale.ProgettoCinema.service.impl;

import EsameFinale.ProgettoCinema.data.dto.SpettatoreDto;
import EsameFinale.ProgettoCinema.data.model.Cinema;
import EsameFinale.ProgettoCinema.data.model.Spettatore;
import EsameFinale.ProgettoCinema.repository.SpettatoreRepository;
import EsameFinale.ProgettoCinema.service.SpettatoreService;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class SpettatoreServiceImpl implements SpettatoreService {

  private SpettatoreRepository spettatoreRepository;

  public SpettatoreServiceImpl(SpettatoreRepository spettatoreRepository) {
    this.spettatoreRepository = spettatoreRepository;
  }

  @Override
  public Optional<Spettatore> getById(String id) {
    return spettatoreRepository.findById(id);
  }

  @Override
  public boolean deleteById(String id) {
    Optional<Spettatore> spettatore = spettatoreRepository.findById(id);
    if (spettatore.isPresent()) {
      spettatoreRepository.deleteById(id);
      return true;
    } else {
      return false;
    }
  }

  @Override
  public List<SpettatoreDto> getAll() {
    List<SpettatoreDto> spettatoreDtoList = new ArrayList<>();
    for (Spettatore spettatore : spettatoreRepository.findAll()) {
      spettatoreDtoList.add(spettatore.toDto());
    }
    return spettatoreDtoList;
  }

  @Override
  public Spettatore save(Spettatore spettatore) {
    Spettatore spettatoreToSave = Spettatore.builder()
        .id(spettatore.getId())
        .name(spettatore.getName())
        .surname(spettatore.getSurname())
        .birthdate(spettatore.getBirthdate())
        .biglietto(spettatore.getBiglietto())
        .build();
    return spettatoreRepository.save(spettatoreToSave);
  }

}
