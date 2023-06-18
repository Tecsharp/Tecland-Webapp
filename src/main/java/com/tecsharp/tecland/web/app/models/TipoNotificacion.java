package com.tecsharp.tecland.web.app.models;

import java.io.Serializable;

import lombok.Data;

@Data
public class TipoNotificacion implements Serializable{

    private Integer id;
    private String tipoNotificacion;

}
