package com.tecsharp.tecland.web.app.models;

import java.io.Serializable;

import lombok.Data;

@Data
public class Session implements Serializable{
	
	private static final long serialVersionUID = -6499754242491335142L;
	private Usuario usuario;

}
