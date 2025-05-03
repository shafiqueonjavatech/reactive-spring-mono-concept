package com.shafique.service;

import reactor.core.publisher.Mono;

public class MonoCreationService {
    
    // Mono Creational operator
    
    public Mono<String> emptyMono(){
        return Mono.empty();
    }
    
    public Mono<String> legendMono(){
        return Mono.just( "Mahatma Gandhi" );
    }
    
    public Mono<String> monoFromCallable(){
        return Mono.fromCallable( ()-> "i am returning inline" );
    }
    
    public Mono<String> monoFromSupplier(){
        return Mono.fromSupplier ( ()-> returnSomeValue () );
    }
    
    public Mono<String> monoJustEager(){
        Mono<String> test =  Mono.just( returnSomeValue () );
        return Mono.empty ();
    }
    
    
    private String returnSomeValue(){
        return "i was executed eagerly";
    }
    
    
    public Mono<Long> monoDefer(){
        return Mono.defer( () -> Mono.just ( System.currentTimeMillis () ));
    }
    
    public Mono<Long> monoDeferCompareJust(){
        return Mono.just ( System.currentTimeMillis () );
    }
    
    //Mono  transformation Operator
    
    
}
