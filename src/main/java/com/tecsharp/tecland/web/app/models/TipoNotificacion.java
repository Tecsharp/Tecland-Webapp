package com.tecsharp.tecland.web.app.models;

import java.io.Serializable;

import lombok.Data;

@Data
public class TipoNotificacion implements Serializable{

    private static final long serialVersionUID = -2857021815983053700L;
	private Integer id;
    private String tipoNotificacion;

}
