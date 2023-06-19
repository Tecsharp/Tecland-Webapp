package com.tecsharp.tecland.web.app.services.trabajo.impl;

import com.tecsharp.tecland.web.app.models.Trabajo;

import com.tecsharp.tecland.web.app.repositories.trabajo.TrabajoRepository;
import com.tecsharp.tecland.web.app.repositories.trabajo.impl.TrabajoRepositoryImpl;
import com.tecsharp.tecland.web.app.services.trabajo.TrabajoService;

import java.util.ArrayList;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class TrabajoServiceImpl implements TrabajoService {

    @Override
    public ArrayList<Trabajo> obtenerTrabajosActivos(Integer idUser) {
        TrabajoRepository trabajoRepo = new TrabajoRepositoryImpl();
        return trabajoRepo.obtenerTrabajosActivos(idUser);
    }

    @Override
    public ArrayList<Trabajo> obtenerTrabajosNoActivos(Integer idUser) {
        TrabajoRepository trabajoRepo = new TrabajoRepositoryImpl();
        return trabajoRepo.obtenerTrabajosNoActivos(idUser);
    }
}
