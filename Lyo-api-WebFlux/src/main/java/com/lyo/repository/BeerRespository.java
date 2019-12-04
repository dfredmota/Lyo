package com.lyo.repository;

import com.lyo.document.Beer;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

/**
 * @author Fred Mota
 * Dfredmota@gmail.com
 */

public interface BeerRespository extends ReactiveMongoRepository<Beer, String>{
    @Override
    Flux<Beer> findAll(Sort sort);
    Flux<Beer> findByName(String name);
    Flux<Beer> findByStar(String star);
    Flux<Beer> findByProbar(String probar);
    Flux<Beer> findByBrewery(String brewery);
    Flux<Beer> findByCoutry(String coutry);
}
