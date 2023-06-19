package com.tecsharp.tecland.web.app.models;

import java.io.Serializable;

import lombok.Data;

@Data
public class Amigo implements Serializable{

    private Integer id;
    private String nombre;
    private Integer usernameId;
    private Integer amigoId;
    private Integer estado;
    private Boolean isFriend;
    private Boolean solicitudPendiente;
    private Boolean solicitudEnviada;
    private String imageUrl;
    
}
