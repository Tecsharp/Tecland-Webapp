package com.tecsharp.tecland.web.app.models;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Data
@Component
public class Usuario implements Serializable {

    private Integer id;
    private String username;
    private String correo;
    private String password;
    private Integer dinero;
    private Integer vip;
    private Date dateCreate;
    private Date dateUpdate;

    // JOBS PLUGIN //
    private Double puntosTrabajoActual;
    private Trabajo trabajo; // crear model trabajo

    //AUTHME PLUGIN //
    private String ultimaIp;
    private Long ultimaConexion;
    private Integer estadoConexion;
    private String biografia;


}
