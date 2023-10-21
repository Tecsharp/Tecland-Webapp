package com.tecsharp.tecland.web.app.models;

import java.io.Serializable;

import lombok.Data;

@Data
public class Informacion implements Serializable{

    private static final long serialVersionUID = 1162055351081913565L;
	private Integer id;
    private String informacion;

}
