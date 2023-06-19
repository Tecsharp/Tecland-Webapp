package com.tecsharp.tecland.web.app.models;

import java.io.Serializable;

import lombok.Data;

@Data
public class Notificacion implements Serializable{

    private Integer id;
    private Integer usuarioId;
    private Integer usuarioIdSender;
    private TipoNotificacion notificacion;
    private String notificacionMensaje;
    private Integer estado;
    private String url;
    
    private String urlAceptar;
    private String urlRechazar;

}
