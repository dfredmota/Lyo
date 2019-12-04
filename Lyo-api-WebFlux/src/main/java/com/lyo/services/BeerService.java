package com.lyo.services;

import com.lyo.document.Beer;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author Fred Mota
 * Dfredmota@gmail.com
 */

public interface BeerService {
	
	Flux<Beer> findAll();
	Mono<Beer> findById(String id);
	Mono<Beer> save(Beer beer);
	Flux<Beer> findByName(String name);
	Flux<Beer> findByBrewery(String brewery);
	Flux<Beer> findByProbar(String probar);
	Flux<Beer> findByStar(String star);
	Flux<Beer> findByCoutry(String coutry);
}
