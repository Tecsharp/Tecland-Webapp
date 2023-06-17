package com.tecsharp.tecland.web.app.services.membresias.impl;

import com.tecsharp.tecland.web.app.models.Membresia;
import com.tecsharp.tecland.web.app.repositories.membresias.MembresiasRepository;
import com.tecsharp.tecland.web.app.repositories.membresias.impl.MembresiasRepositoryImpl;
import com.tecsharp.tecland.web.app.services.membresias.MembresiasService;

import java.util.ArrayList;

public class MembresiasServiceImpl implements MembresiasService {
    @Override
    public ArrayList<Membresia> obtenerMembresias() {

        MembresiasRepository membresias = new MembresiasRepositoryImpl();


        return (ArrayList<Membresia>) membresias.obtenerTodasLasMembresias();
    }
}
