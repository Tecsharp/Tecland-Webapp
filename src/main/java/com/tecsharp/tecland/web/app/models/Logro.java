package com.tecsharp.tecland.web.app.models;

import java.io.Serializable;

import lombok.Data;

@Data
public class Logro implements Serializable{
	
	private static final long serialVersionUID = -3286921961908984521L;
	private String uuid;
	private String username;
	private String achievement;
	private String dbname;
	private String date;
	private String url;
	private String descripcion;
	private String estado;

}
