package com.tecsharp.tecland.web.app.models;

import java.io.Serializable;

import lombok.Data;

@Data
public class Membresia implements Serializable{

    private static final long serialVersionUID = -7969015317413670403L;
	private Integer id;
    private String nombre;
    private String informacion;
    private Integer costo;
    private Integer numObjetos;
    private String imgLink;


}
