package com.example.calculadora1902;

import java.math.BigInteger;

public class Fibonoacci {
    private BigInteger numero1;
    private BigInteger numero2;

    public Fibonoacci() {
        this.numero1 = BigInteger.ONE;
        this.numero2 = BigInteger.ONE;
    }

    public BigInteger calcularSiguiente() {
        BigInteger resultado = numero1.add(numero2);
        numero1 = numero2;
        numero2 = resultado;
        return resultado;
    }

    public BigInteger getNumero1() {
        return numero1;
    }
}
