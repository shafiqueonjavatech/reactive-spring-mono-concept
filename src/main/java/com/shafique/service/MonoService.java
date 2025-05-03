package com.shafique.service;

import reactor.core.publisher.Mono;

public class MonoService {
    
    public Mono<String> legendMono(){
        return Mono.just ( "Mahatma Gandhi" );
    }
}
