package com.example.proyecto26022025;

public enum Operacion {

    SUMA, RESTA, MULT, DIV, PORC, NONE;

    public static String conver(Operacion operacion){

        switch (operacion){
            case SUMA:
                return "+";
            case RESTA:
                return "-";
            case MULT:
                return "*";
            case DIV:
                return "/";
            case PORC:
                return "%";
            case NONE:
                return "Error";
        }

        return "";

    }

}
