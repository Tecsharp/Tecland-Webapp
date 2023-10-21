package com.tecsharp.tecland.web.app.models;

import java.io.Serializable;

import lombok.Data;

@Data
public class Trabajo implements Serializable{

    private static final long serialVersionUID = -4516437053759583018L;
	private String nombre;
    private Integer nivel;
    private String img;

}
