package com.lyo.services;

import com.lyo.document.Beer;
import com.lyo.repository.BeerRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author Fred Mota
 * Dfredmota@gmail.com
 */

@Service
public class BeerServiceImpl implements BeerService{
	
	@Autowired
	BeerRespository beerRespository;

	@Override
	public Flux<Beer> findAll() {
		return beerRespository.findAll();
	}

	@Override
	public Mono<Beer> findById(String id) {
		return beerRespository.findById(id);
	}

	@Override
	public Mono<Beer> save(Beer Beer) {
		return beerRespository.save(Beer);
	}

	@Override
	public Flux<Beer> findByName(String name) {	return beerRespository.findByName(name);}

	@Override
	public Flux<Beer> findByBrewery(String brewery) {
		return beerRespository.findByBrewery(brewery);
	}

	@Override
	public Flux<Beer> findByProbar(String probar) {
		return beerRespository.findByProbar(probar);
	}

	@Override
	public Flux<Beer> findByStar(String star) {
		return beerRespository.findByStar(star);
	}

	@Override
	public Flux<Beer> findByCoutry(String coutry) {
		return beerRespository.findByCoutry(coutry);
	}

}
