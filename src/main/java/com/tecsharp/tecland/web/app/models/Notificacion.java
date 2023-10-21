package com.tecsharp.tecland.web.app.models;

import java.io.Serializable;

import lombok.Data;

@Data
public class Notificacion implements Serializable{

    private static final long serialVersionUID = -284090883317831060L;
	private Integer id;
    private Integer usuarioId;
    private Integer usuarioIdSender;
    private String imgUsuarioSender;
    private TipoNotificacion notificacion;
    private String notificacionMensaje;
    private Integer estado;
    private String url;
    
    private String urlAceptar;
    private String urlRechazar;

}
