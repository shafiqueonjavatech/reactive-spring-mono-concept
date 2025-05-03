package com.shafique.service;

import reactor.core.publisher.Mono;

public class MonoService {
    
    public Mono<String> emptyMono(){
        return Mono.empty();
    }
    
    public Mono<String> legendMono(){
        return Mono.just( "Mahatma Gandhi" );
    }
    
    public Mono<String> monoFromCallable(){
        return Mono.fromCallable( ()-> {
            return "i am returning inline";
        } );
    }
    
    
}
