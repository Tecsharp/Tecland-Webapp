package com.tecsharp.tecland.web.app.models;

import lombok.Data;

@Data
public class Amigo {

    private Integer id;
    private String nombre;
    private Integer usernameId;
    private Integer amigoId;
    private Integer estado;
    private Boolean isFriend;
    private Boolean solicitudPendiente;
    private Boolean solicitudEnviada;
}
