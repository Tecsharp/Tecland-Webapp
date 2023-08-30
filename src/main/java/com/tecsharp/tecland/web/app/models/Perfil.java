package com.tecsharp.tecland.web.app.models;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class Perfil {
	
	private Integer id;
	private Usuario usuario;
	private String imageUrl;
	private ArrayList<Trabajo> trabajosActivos;
	private ArrayList<Trabajo> trabajosNoActivos;
	private String ultimaCon;
	private List<Logro> logros; //SELECCIONAR DESDE BASE DE DATOS EL NOMBRE DE LOS LOGROS
	private List<Estadistica> listEst1;
	private List<Estadistica> listEst2;
}
