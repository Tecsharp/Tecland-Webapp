package com.tecsharp.tecland.web.app.repositories.informacion.impl;

import com.tecsharp.tecland.web.app.repositories.informacion.InformacionRepository;
import com.tecsharp.tecland.web.app.utils.Constantes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class InformacionRepositoryImpl implements InformacionRepository {
    @Override
    public String infoRecuperada(Integer id) {

        String descripcion = null;

        String query = "SELECT * FROM info_tecland WHERE id = 1";

        try (Connection connection = DriverManager.getConnection(Constantes.DB_PROPERTIES);
             PreparedStatement statement = connection.prepareStatement(query)) {

            ResultSet result = statement.executeQuery();

            while (result.next()) {
                descripcion = result.getString("descripcion");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return descripcion;
    }
}
