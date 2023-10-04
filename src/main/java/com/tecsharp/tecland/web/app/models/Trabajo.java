package com.tecsharp.tecland.web.app.models;

import java.io.Serializable;

import lombok.Data;

@Data
public class Trabajo implements Serializable{

    private String nombre;
    private Integer nivel;
    private String img;

}
