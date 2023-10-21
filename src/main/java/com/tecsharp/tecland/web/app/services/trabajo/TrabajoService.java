package com.tecsharp.tecland.web.app.services.trabajo;

import com.tecsharp.tecland.web.app.models.Trabajo;

import java.util.List;

public interface TrabajoService {

    List<Trabajo> obtenerTrabajosActivos(Integer idUser);

    List<Trabajo> obtenerTrabajosNoActivos(Integer idUser);


}
