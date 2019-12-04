package com.lyo;

import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;

/**
 * @author Fred Mota
 * Dfredmota@gmail.com
 */

//@Configuration
public class BeerRouter {
	
	//@Bean
	public RouterFunction<ServerResponse> route(BeerHandler handler){
		return RouterFunctions
				.route(GET("/beers").and(accept(MediaType.APPLICATION_JSON)), handler::findAll)
				.andRoute(GET("/beers/{id}").and(accept(MediaType.APPLICATION_JSON)), handler::findById)
				.andRoute(POST("/beers").and(accept(MediaType.APPLICATION_JSON)), handler::save);
			
	}
	

}
