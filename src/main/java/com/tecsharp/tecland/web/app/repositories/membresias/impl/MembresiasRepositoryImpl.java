package com.tecsharp.tecland.web.app.repositories.membresias.impl;

import com.tecsharp.tecland.web.app.models.Membresia;
import com.tecsharp.tecland.web.app.repositories.membresias.MembresiasRepository;
import com.tecsharp.tecland.web.app.utils.Constantes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MembresiasRepositoryImpl implements MembresiasRepository {

    @Override
    public List<Membresia> obtenerTodasLasMembresias() {

        ArrayList<Membresia> membresias = new ArrayList<>();

        Membresia membresia = null;
        String query = "SELECT * FROM membresias";


        try (Connection connection = DriverManager.getConnection(Constantes.DB_PROPERTIES);
             PreparedStatement statement = connection.prepareStatement(query)) {

            ResultSet result = statement.executeQuery();

            while (result.next()) {
                membresia = new Membresia();
                membresia.setId(result.getInt("id"));
                membresia.setNombre(result.getString("nombre"));
                membresia.setInformacion(result.getString("informacion"));
                membresia.setCosto(result.getInt("costo"));
                membresia.setNumObjetos(result.getInt("numObjetos"));
                membresia.setImgLink(result.getString("imgLink"));
                membresias.add(membresia);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        return membresias;
    }
}
