package com.shafique;

import com.shafique.service.MonoService;

public class Main {
    public static void main ( String[] args ) {
        MonoService monoService = new MonoService ();
        monoService.legendMono ().doOnNext ( System.out::print ).subscribe ();
    }
}