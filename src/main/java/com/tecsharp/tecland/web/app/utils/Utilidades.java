package com.tecsharp.tecland.web.app.utils;

import java.text.DecimalFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Utilidades {
	
    public static String formatearPrecio(Integer precio) {
        DecimalFormat formatea = new DecimalFormat("###,###,###");
        return formatea.format(precio);
    }
    

}
