package com.shafique;

import com.shafique.service.MonoCreationService;
import com.shafique.service.MonoTransformationService;
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
        
        //Mono transformation operator
        
        MonoTransformationService monoTransformationService =
                new MonoTransformationService ();
        
        /**
         * you should understand the difference between map and flatmap, map only
         * trasform the value present in stream, as shown here converting from lower case
         * to upper case.
         */
        monoTransformationService.mapToUpper().doOnNext( System.out::println ).subscribe();
        
        /**
         * here you can see i am changing the type from string to integer using flatmap
         */
        monoTransformationService.convertToLength().doOnNext( System.out::println ).subscribe();
        
        /**
         * here i am applying filter on element and if filter condition is not met,
         * stream will empty , which i am replacing with Integer.MIN_VAL
         */
        monoTransformationService.filterMono ().doOnNext ( System.out::println ).subscribe ();
        
        monoTransformationService.monoEmplty()
                .defaultIfEmpty ( "No Value " +"in" +" stream" )
                .doOnNext (System.out::println).subscribe ();
        
        monoTransformationService.monoEmplty().switchIfEmpty(
                Mono.just( "get data " +"from alt source, when stream is emplty" )
        ).doOnNext (  System.out::println  ).subscribe ();
        
        monoTransformationService.getBillNumber()
                .doOnNext(s -> {
                    System.out.println ( "element type is "+s.getClass().toString ());
                    } )
                .map ( Integer::parseInt )
                .cast(Integer.class)
                .doOnNext (v -> {
                    System.out.println ( "element type is "+v.getClass().toString ());
                    } )
                .subscribe ();
    }
}