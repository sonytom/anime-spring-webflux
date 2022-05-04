package tom.company.animespringwebflux.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;
import tom.company.animespringwebflux.domain.AnimeModel;

@Repository
public interface AnimeRepository extends ReactiveCrudRepository<AnimeModel, Long> {
    Mono <AnimeModel> findById (Long id);

}
