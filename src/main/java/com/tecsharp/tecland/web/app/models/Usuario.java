package com.tecsharp.tecland.web.app.models;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

import org.springframework.stereotype.Component;

@Data
@Component
public class Usuario implements Serializable {

    private static final long serialVersionUID = -326943953747230173L;
	private Integer id;
    private String UUID;
    private String username;
    private String correo;
    private String password;
    private Double dinero;
    private Integer vip;
    private Date dateCreate;
    private Date dateUpdate;
    private Integer isAdmin;

    // JOBS PLUGIN //
    private Double puntosTrabajoActual;
    private Trabajo trabajo; // crear model trabajo

    //AUTHME PLUGIN //
    private String ultimaIp;
    private Long ultimaConexion;
    private String ultimaConString;
    private Integer estadoConexion;
    private String biografia;
    private String imgAvatar;


}
