package EsameFinale.ProgettoCinema.service.impl;

import EsameFinale.ProgettoCinema.data.dto.FilmDto;
import EsameFinale.ProgettoCinema.data.model.Film;
import EsameFinale.ProgettoCinema.repository.FilmRepository;
import EsameFinale.ProgettoCinema.service.FilmService;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class FilmServiceImpl implements FilmService {

  private FilmRepository filmRepository;

  public FilmServiceImpl(FilmRepository filmRepository) {
    this.filmRepository = filmRepository;
  }

  @Override
  public Optional<Film> getById(String id) {
    return filmRepository.findById(id);
  }

  @Override
  public boolean deleteById(String id) {
    Optional<Film> film = filmRepository.findById(id);
    if (film.isPresent()) {
      filmRepository.deleteById(id);
      return true;
    } else {
      return false;
    }
  }

  @Override
  public Film save(Film film) {
    Film filmToSave = Film.builder()
        .id(film.getId())
        .title(film.getTitle())
        .author(film.getAuthor())
        .producer(film.getProducer())
        .gender(film.getGender())
        .minAge(film.getMinAge())
        .duration(film.getDuration())
        .salaCinematografica(film.getSalaCinematografica())
        .build();
    return filmRepository.save(filmToSave);
  }

  @Override
  public List<FilmDto> getAll() {
    List<FilmDto> filmDtoList = new ArrayList<>();
    for (Film film : filmRepository.findAll()) {
      filmDtoList.add(film.toDto());
    }
    return filmDtoList;
  }

}
