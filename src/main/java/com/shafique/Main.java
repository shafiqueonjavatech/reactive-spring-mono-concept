package com.shafique;

import com.shafique.service.MonoService;
import reactor.core.publisher.Mono;

public class Main {
    public static void main ( String[] args ) throws InterruptedException {
        MonoService monoService = new MonoService ();
        
        // creating an empty mono and setting default text to verify
        monoService.emptyMono().defaultIfEmpty ( "Nothing emitted" )
                .doOnNext( element ->System.out.println ( "values is :"+element )).subscribe ();
        
        // creating legend mono
        monoService.legendMono().doOnNext( System.out::println ).subscribe();
        
        // test mono trigger based on operator
        monoService.monoJustEager();
        
        // creating mono from callable
        monoService.monoFromCallable().doOnNext( System.out::println ).subscribe();
        
        // creating mono from supplier
        monoService.monoFromSupplier();
        
        // compare defer with just, intentionally added this to make it clear the usage
        // of defer during code review, i saw few of you people used it incorrectly.
        Mono<Long> mono1 = monoService.monoDeferCompareJust ();
        mono1.doOnNext ( System.out::println ).subscribe ();
        Thread.sleep(1000);
        mono1.doOnNext ( System.out::println ).subscribe ();
        
        Mono<Long> mono2 = monoService.monoDefer ();
        mono2.doOnNext ( System.out::println ).subscribe ();
        Thread.sleep(1000);
        mono2.doOnNext ( System.out::println ).subscribe ();
    }
}