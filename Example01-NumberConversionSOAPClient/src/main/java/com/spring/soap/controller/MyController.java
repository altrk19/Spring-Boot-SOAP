package com.spring.soap.controller;

import com.spring.soap.server.NumberConversion;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import java.math.BigInteger;

@RestController
public class MyController {
    private final NumberConversion numberConversion;

    public MyController(NumberConversion numberConversion) {
        this.numberConversion = numberConversion;
    }

    @GetMapping("/convert/{number}")
    public String test1(@PathVariable("number") @NotNull final String number){
        return numberConversion.getNumberConversionSoap().numberToWords(BigInteger.valueOf(Long.parseLong(number)));
    }
}
