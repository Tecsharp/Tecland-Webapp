package com.tecsharp.tecland.web.app.models;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;

import jakarta.annotation.Resource;
import lombok.Data;

@Data
public class Perfil {
	
	private Integer id;
	private Usuario usuario;
	private String imageUrl;
	private ArrayList<Trabajo> trabajosActivos;
	private ArrayList<Trabajo> trabajosNoActivos;
	private String ultimaCon;
	
}
