package com.tecsharp.tecland.web.app.models;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class Perfil implements Serializable{
	
	private static final long serialVersionUID = 1081943433415809627L;
	private Integer id;
	private Usuario usuario;
	private String imageUrl;
	private List<Trabajo> trabajosActivos;
	private List<Trabajo> trabajosNoActivos;
	private String ultimaCon;
	private List<Logro> logros; //SELECCIONAR DESDE BASE DE DATOS EL NOMBRE DE LOS LOGROS
	private List<Estadistica> listEst1;
	private List<Estadistica> listEst2;
}
