package com.tecsharp.tecland.web.app.utils;

import java.text.DecimalFormat;

public class Utilidades {

    public static String formatearPrecio(Integer precio) {
        DecimalFormat formatea = new DecimalFormat("###,###,###");
        return formatea.format(precio);
    }

}
