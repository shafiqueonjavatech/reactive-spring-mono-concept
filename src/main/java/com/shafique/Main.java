package com.shafique;

import com.shafique.service.MonoService;

public class Main {
    public static void main ( String[] args ) {
        MonoService monoService = new MonoService ();
        
        // creating an empty mono and setting default text to verify
        monoService.emptyMono().defaultIfEmpty ( "Nothing emitted" )
                .doOnNext( element ->System.out.println ( "values is :"+element )).subscribe ();
        
        // creating legend mono
        monoService.legendMono().doOnNext( System.out::println ).subscribe();
        
        // creating mono from callable
        monoService.monoFromCallable().doOnNext( System.out::println ).subscribe();
    }
}