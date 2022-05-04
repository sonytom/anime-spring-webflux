package tom.company.animespringwebflux.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import tom.company.animespringwebflux.domain.AnimeModel;
import tom.company.animespringwebflux.service.AnimeService;

@AllArgsConstructor
//@RequiredArgsConstructor
@RestController
@RequestMapping("animes")
public class AnimeController {
    private final AnimeService animeService;

    @GetMapping
    public Flux<AnimeModel> getAllAnimes() {
        return animeService.getAllAnimes();
    }

    @GetMapping("/{id}")
    public Mono<AnimeModel> findById(@Valid @NotNull @PathVariable(value = "id") Long id) {
        return animeService.findAnimeById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<AnimeModel> createAnime(@Valid @NotNull @RequestBody AnimeModel animeModel) {
        return animeService.createAnime(animeModel);
    }

    @PutMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> updateAnime(@PathVariable Long id, @RequestBody AnimeModel animeModel) {
        return animeService.updateAnime(animeModel.withId(id));
    }

    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> deleteAnime(@PathVariable int id) {
        return animeService.deleteAnime((long) id);
    }


}
