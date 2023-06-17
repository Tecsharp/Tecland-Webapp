package com.tecsharp.tecland.web.app.repositories.trabajo;

import com.tecsharp.tecland.web.app.models.Trabajo;

import java.util.ArrayList;

public interface TrabajoRepository {

    ArrayList<Trabajo> obtenerTrabajosActivos(Integer idUser);

    ArrayList<Trabajo> obtenerTrabajosNoActivos(Integer idUser);


}
