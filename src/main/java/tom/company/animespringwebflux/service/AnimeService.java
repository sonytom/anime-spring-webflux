package tom.company.animespringwebflux.service;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import tom.company.animespringwebflux.domain.AnimeModel;
import tom.company.animespringwebflux.repository.AnimeRepository;

@Service
@AllArgsConstructor
public class AnimeService {

    AnimeRepository animeRepository;

    public Flux<AnimeModel> getAllAnimes() {
        return animeRepository.findAll();
    }


    public Mono<AnimeModel> findAnimeById(Long id) {
        return animeRepository.findById(id).switchIfEmpty(monoResponseStatusNotFoundException())
                .log();
    }

    public <T> Mono<T> monoResponseStatusNotFoundException() {
        return Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND, "Anime not found"));
    }


    public Mono<AnimeModel> createAnime(AnimeModel animeModel) {
        return animeRepository.save(animeModel);
    }

    public Mono<Void> updateAnime(AnimeModel anime) {
        return findAnimeById(anime.getId())
                .map(animeDb -> anime.withId(animeDb.getId()))
                .flatMap(animeRepository::save).then();
    }


    public Mono<Void> deleteAnime(Long id) {
        return findAnimeById(id).flatMap(animeRepository::delete).then();
    }


}
