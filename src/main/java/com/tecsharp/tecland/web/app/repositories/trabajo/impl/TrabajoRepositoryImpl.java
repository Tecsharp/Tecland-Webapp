package com.tecsharp.tecland.web.app.repositories.trabajo.impl;

import com.tecsharp.tecland.web.app.models.Trabajo;
import com.tecsharp.tecland.web.app.repositories.trabajo.TrabajoRepository;
import com.tecsharp.tecland.web.app.utils.Constantes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class TrabajoRepositoryImpl implements TrabajoRepository {
    @Override
    public ArrayList<Trabajo> obtenerTrabajosActivos(Integer idUser) {

        //OBTIENE LOS TRABAJOS ACTIVOS DEL USUARIO
        ArrayList<Trabajo> listaTrabajosActivos = new ArrayList<>();
        String query3 = "SELECT job, level FROM jobs_jobs WHERE userid = ?";

        try (Connection connection = DriverManager.getConnection(Constantes.DB_PROPERTIES);
             PreparedStatement statement = connection.prepareStatement(query3)) {

            statement.setInt(1, idUser);
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                Trabajo trabajo = new Trabajo();
                trabajo.setNombre(result.getString("job"));
                trabajo.setNivel(result.getInt("level"));
                listaTrabajosActivos.add(trabajo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listaTrabajosActivos;
    }

    @Override
    public ArrayList<Trabajo> obtenerTrabajosNoActivos(Integer idUser) {
        //OBTIENE LOS TRABAJOS ACTIVOS DEL USUARIO
        ArrayList<Trabajo> listaTrabajosNoActivos = new ArrayList<>();
        String query3 = "SELECT job, level FROM jobs_archive WHERE userid = ?";

        try (Connection connection = DriverManager.getConnection(Constantes.DB_PROPERTIES);
             PreparedStatement statement = connection.prepareStatement(query3)) {

            statement.setInt(1, idUser);
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                Trabajo trabajo = new Trabajo();
                trabajo.setNombre(result.getString("job"));
                trabajo.setNivel(result.getInt("level"));
                listaTrabajosNoActivos.add(trabajo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listaTrabajosNoActivos;
    }
}
