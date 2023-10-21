package com.tecsharp.tecland.web.app.repositories.trabajo;

import com.tecsharp.tecland.web.app.models.Trabajo;

import java.util.List;

public interface TrabajoRepository {

    List<Trabajo> obtenerTrabajosActivos(Integer idUser);

    List<Trabajo> obtenerTrabajosNoActivos(Integer idUser);


}
