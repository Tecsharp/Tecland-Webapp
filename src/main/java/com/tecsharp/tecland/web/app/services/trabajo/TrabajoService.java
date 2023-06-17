package com.tecsharp.tecland.web.app.services.trabajo;

import com.tecsharp.tecland.web.app.models.Trabajo;

import java.util.ArrayList;

public interface TrabajoService {

    ArrayList<Trabajo> obtenerTrabajosActivos(Integer idUser);

    ArrayList<Trabajo> obtenerTrabajosNoActivos(Integer idUser);


}
