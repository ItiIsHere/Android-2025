package com.example.proyecto26022025;

import android.widget.Switch;

import java.math.BigDecimal;
import java.util.function.LongFunction;

public class CalculadoraMemoria implements ICalculadoraMemoria {

    private String display = "0.0";

    private Operacion operacion;

    private BigDecimal x;

    private BigDecimal y;
    @Override
    String concat(String numero){
        display += numero;
        return display;
    }

    @Override
    public String concat(String operacion){
        this.operacion = operacion;
        this.x = BigDecimal.valueOf(Long.parseLong(display));
        return Operacion.convert(operacion);
    }

    @Override
    public  void clear(){
        display = "";
        operacion = operacion.NONE;
        x = BigDecimal.ZERO;
        y = BigDecimal.ZERO
    }

    private void igual(){

        this.y = BigDecimal.valueOf((Long.parseLong(display)));

    }


}
