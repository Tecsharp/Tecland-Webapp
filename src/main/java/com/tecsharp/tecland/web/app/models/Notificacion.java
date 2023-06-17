package com.tecsharp.tecland.web.app.models;

import lombok.Data;

@Data
public class Notificacion {

    private Integer id;
    private Integer usuarioId;
    private Integer usuarioIdSender;
    private TipoNotificacion notificacion;
    private String notificacionMensaje;
    private Integer estado;
    private String url;

}
