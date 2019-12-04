package com.lyo.controller;

import com.lyo.document.Beer;
import com.lyo.services.BeerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

import java.time.Duration;

/**
 * @author Fred Mota
 * Dfredmota@gmail.com
 */

@CrossOrigin(origins = "*")
@RestController
public class BeerController {
	
	@Autowired
	BeerService beerService;

	@GetMapping(value="/beers/v1/todos")
	public Flux<Beer> getBeer(){
		return beerService.findAll();
	}

	@GetMapping(value="/beers/v1/id/{id}")
	public Mono<Beer> getBeerId(@PathVariable String id){
		return beerService.findById(id);
	}

	@GetMapping(value="/beers/v1/name/{name}")
	public Flux<Beer> getBeerName(@PathVariable String name){
		return beerService.findByName(name);
	}

	@GetMapping(value="/beers/v1/brewery/{brewery}")
	public Flux<Beer> getBeerBrewery(@PathVariable String brewery){
		return beerService.findByBrewery(brewery);
	}

	@GetMapping(value="/beers/v1/probar/{probar}")
	public Flux<Beer> getBeerProbar(@PathVariable String probar){
		return beerService.findByProbar(probar);
	}

	@GetMapping(value="/beers/v1/star/{star}")
	public Flux<Beer> getBeerStar(@PathVariable String star){
		return beerService.findByStar(star);
	}

	@GetMapping(value="/beers/v1/coutry/{coutry}")
	public Flux<Beer> getBeerCoutry(@PathVariable String coutry){
		return beerService.findByCoutry(coutry);
	}

	@GetMapping(value="/beers/v1/{id}/boxprice")
	public Mono<Beer> getBeerIdboxprice(@PathVariable String id){
		return beerService.findById(id);
	}

	@PostMapping(value="/beers/v1/nuevo")
	public Mono<Beer> save(@RequestBody Beer beer){
		return beerService.save(beer);
	}

	@GetMapping(value="/beers/events", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<Tuple2<Long, Beer>> getBeerByEvents(){
	    Flux<Long> interval = Flux.interval(Duration.ofSeconds(10));
        Flux<Beer> events = beerService.findAll();
        System.out.print("Passou aqui events");
        return Flux.zip(interval, events);
	}
}
