package com.tecsharp.tecland.web.app.repositories.notificacion.impl;

import com.tecsharp.tecland.web.app.models.Notificacion;
import com.tecsharp.tecland.web.app.repositories.notificacion.NotificacionRepository;
import com.tecsharp.tecland.web.app.utils.Constantes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class NotificacionRepositoryImpl implements NotificacionRepository {
    @Override
    public Boolean mandaNotificacionAUsuarioAgregado(String username, Integer usernameiD, Integer amigoId) {
        String query = "insert into notificaciones values (0, ?, ?, 'Agregar', '" + username + "' ' te ha enviado una solicitud de amistad', 1, 'test');";

        try (Connection connection = DriverManager.getConnection(Constantes.DB_PROPERTIES);
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, amigoId);
            statement.setInt(2, usernameiD);
            statement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            return false;

        }

        return true;
    }

    @Override
    public ArrayList<Notificacion> obtenerNotificacionesUsuario(Integer usuarioId) {

        ArrayList<Notificacion> listaNotificaciones = new ArrayList<>();
        String query3 = "select * from notificaciones where usuarioId = ?;";

        try (Connection connection = DriverManager.getConnection(Constantes.DB_PROPERTIES);
             PreparedStatement statement = connection.prepareStatement(query3)) {

            statement.setInt(1, usuarioId);
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                Notificacion notificacion = new Notificacion();
                notificacion.setId(result.getInt("id"));
                notificacion.setUsuarioId(result.getInt("usuarioIdSender"));
                notificacion.setNotificacionMensaje(result.getString("notificacionMensaje"));
                notificacion.setEstado(result.getInt("estado"));
                notificacion.setUrl(result.getString("url"));
                listaNotificaciones.add(notificacion);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listaNotificaciones;
    }

    @Override
    public Boolean eliminarNotificacionAgregarAmigo(Integer usuarioId, Integer amigoId) {
        String query = "DELETE FROM notificaciones WHERE usuarioIdSender = ? and usuarioId = ?;";

        try (Connection connection = DriverManager.getConnection(Constantes.DB_PROPERTIES);
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, usuarioId);
            statement.setInt(2, amigoId);
            statement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    @Override
    public Boolean deshabilitarNotificacionSolicitudAmistad(Integer usuarioId, Integer amigoId) {

        String query = "UPDATE notificaciones SET estado = 0 WHERE usuarioId = ?";

        try (Connection connection = DriverManager.getConnection(Constantes.DB_PROPERTIES);
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, usuarioId);
            statement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }
}
