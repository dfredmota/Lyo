package com.lyo;


import com.lyo.document.Beer;
import com.lyo.services.BeerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.BodyInserters.fromPublisher;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

/**
 * @author Fred Mota
 * Dfredmota@gmail.com
 */

//@Component
public class BeerHandler {
	
	@Autowired
	BeerService beerService;
	
	public Mono<ServerResponse> findAll(ServerRequest request){
		return ok()
				.contentType(MediaType.APPLICATION_JSON)
				.body(beerService.findAll(), Beer.class);
	}
	
	public Mono<ServerResponse> findById(ServerRequest request){
		String id = request.pathVariable("id");
		return ok()
				.contentType(MediaType.APPLICATION_JSON)
				.body(beerService.findById(id), Beer.class);
	}
	
	public Mono<ServerResponse> save(ServerRequest request){
		final Mono<Beer> beer = request.bodyToMono(Beer.class);
		return ok()
				.contentType(MediaType.APPLICATION_JSON)
				.body(BodyInserters.fromPublisher(beer.flatMap(beerService::save), Beer.class));
	}
	
	
}
