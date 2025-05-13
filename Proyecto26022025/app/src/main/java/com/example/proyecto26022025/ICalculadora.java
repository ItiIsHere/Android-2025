package com.example.proyecto26022025;

import android.icu.math.BigDecimal;

public interface ICalculadora {

    BigDecimal calcular(Operacion operacion, BigDecimal x, BigDecimal y);

}
