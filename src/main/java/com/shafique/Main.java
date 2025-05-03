package com.shafique;

import com.shafique.service.MonoCreationService;
import reactor.core.publisher.Mono;

public class Main {
    public static void main ( String[] args ) throws InterruptedException {
        MonoCreationService monoCreationService = new MonoCreationService ();
        
        // creating an empty mono and setting default text to verify
        monoCreationService.emptyMono().defaultIfEmpty ( "Nothing emitted" )
                .doOnNext( element ->System.out.println ( "values is :"+element )).subscribe ();
        
        // creating legend mono
        monoCreationService.legendMono().doOnNext( System.out::println ).subscribe();
        
        // test mono trigger based on operator
        monoCreationService.monoJustEager();
        
        // creating mono from callable
        monoCreationService.monoFromCallable().doOnNext( System.out::println ).subscribe();
        
        // creating mono from supplier
        monoCreationService.monoFromSupplier();
        
        // compare defer with just, intentionally added this to make it clear the usage
        // of defer during code review, i saw few of you people used it incorrectly.
        Mono<Long> mono1 = monoCreationService.monoDeferCompareJust ();
        mono1.doOnNext ( System.out::println ).subscribe ();
        Thread.sleep(1000);
        mono1.doOnNext ( System.out::println ).subscribe ();
        
        Mono<Long> mono2 = monoCreationService.monoDefer ();
        mono2.doOnNext ( System.out::println ).subscribe ();
        Thread.sleep(1000);
        mono2.doOnNext ( System.out::println ).subscribe ();
    }
}