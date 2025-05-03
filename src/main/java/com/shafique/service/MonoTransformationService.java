package com.shafique.service;

import reactor.core.publisher.Mono;

import java.util.Map;

public class MonoTransformationService {
    
    //Mono  transformation Operator
    public Mono<String> mapToUpper(){
        return Mono.just ( "hello" ).map ( String::toUpperCase );
    }
    
    
    public Mono<Integer> convertToLength(){
        return Mono.just ( "Banana" ).flatMap ( element -> Mono.just ( element.length () ) );
    }
    
    public Mono<Integer> filterMono(){
        return Mono.just ( 734 ).filter (  i -> i < 300 ).defaultIfEmpty ( Integer.MIN_VALUE );
    }
    
    public Mono<String> monoEmplty(){
        return Mono.empty ();
    }
    
    public Mono<String> getBillNumber(){
        return Mono.just( "345" );
    }
    
    public Mono<String> zipWithP1(){
        return Mono.just ( "A" );
    }
    
    public Mono<Integer> zipWithP2(){
        return Mono.just ( 1 );
    }
    
    public Mono<String> getUserId(){
        return Mono.just ( "user123" );
    }
    
    public Mono<String> getUserDepartment(String userId){
        Map<String, String> userMap = Map.of ( "user123", "EMS" );
        return Mono.justOrEmpty ( userMap.get ( userId ) );
    }
    
}
