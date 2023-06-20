package com.tecsharp.tecland.web.app.repositories.amigo.impl;

import com.tecsharp.tecland.web.app.models.Amigo;
import com.tecsharp.tecland.web.app.repositories.amigo.AmigoRepository;
import com.tecsharp.tecland.web.app.utils.Constantes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class AmigoRepositoryImpl implements AmigoRepository {
    @Override
    public ArrayList<Amigo> obtenerAmigos(Integer usernameId) {
        Integer estado = null;

        ArrayList<Amigo> amigosLista = new ArrayList<>();
        String query = "SELECT realname, authme.id FROM authme JOIN amigos ON amigos.amigoid = authme.id WHERE amigos.usuarioid = ?";

        try (Connection connection = DriverManager.getConnection(Constantes.DB_PROPERTIES);
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, usernameId);
            ResultSet result = statement.executeQuery();
////////////
            while (result.next()) {
                Amigo amigos = new Amigo();
                amigos.setId(result.getInt("id"));
                amigos.setNombre(result.getString("realname"));
                estado = obtenerEstadoConexionDeAmigo(amigos.getNombre());

                amigos.setEstado(estado);
                amigosLista.add(amigos);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        return amigosLista;
    }

    @Override
    public Integer obtenerEstadoConexionDeAmigo(String username) {
        Integer estadoConexion = null;
        //OBTIENE INFORMACION DE AUTHME
        String query = "SELECT ip, isLogged  FROM authme WHERE realname = ?";

        try (Connection connection = DriverManager.getConnection(Constantes.DB_PROPERTIES);
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, username);
            ResultSet result = statement.executeQuery();

            while (result.next()) {

                estadoConexion = result.getInt("isLogged");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return estadoConexion;
    }

    @Override
    public ArrayList<Amigo> obtenerListaDeAmigosEnBusqueda(String username) {

        //OBTIENE INFORMACION DE AMIGOS
        ArrayList<Amigo> amigos = new ArrayList<>();
        String query = "SELECT * FROM authme WHERE realname like ? ";

        try (Connection connection = DriverManager.getConnection(Constantes.DB_PROPERTIES);
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, username);
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                Amigo amigo = new Amigo();
                amigo.setId(result.getInt("id"));
                amigo.setNombre(result.getString("realname"));
                amigo.setEstado(result.getInt("isLogged"));
                amigos.add(amigo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return amigos;
    }

    @Override
    public Boolean obtieneIsFriend(Integer userId, Integer amigoId) {

        Integer dbAmigoId = null;
        String query2 = "SELECT amigoid FROM amigos JOIN authme ON amigos.amigoid = authme.id WHERE amigos.usuarioid = ?";

        try (Connection connection = DriverManager.getConnection(Constantes.DB_PROPERTIES);
             PreparedStatement statement = connection.prepareStatement(query2)) {

            statement.setInt(1, userId);
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                dbAmigoId = result.getInt("amigoid");
                if (dbAmigoId == amigoId) {
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        return false;
    }

    @Override
    public Boolean obtieneSolicitudPendiente(Integer usuarioId, Integer usuarioIdSender) {
        Integer dbUsuarioSender = null;
        Integer dbUsuarioId = null;
        Integer dbEstado = null;
        String query2 = "select * from notificaciones where usuarioId = ? and usuarioIdSender = ? and estado = ?;";

        try (Connection connection = DriverManager.getConnection(Constantes.DB_PROPERTIES);
             PreparedStatement statement = connection.prepareStatement(query2)) {

            statement.setInt(1, usuarioId);
            statement.setInt(2, usuarioIdSender);
            statement.setInt(3, 1); //1 ES ESTADO ACTIVO
            ResultSet result = statement.executeQuery();

            while (result.next()) {

                dbUsuarioId = result.getInt("usuarioId");
                dbUsuarioSender = result.getInt("usuarioIdSender");
                dbEstado = result.getInt("estado");

                if (usuarioId.equals(dbUsuarioId) && dbUsuarioSender.equals(usuarioIdSender) && dbEstado == 1) {
                    return true;
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        return false;
    }

    @Override
    public Boolean obtieneSolicitudEnviada(Integer usuarioEmisor, Integer usuarioReceptor) {
        Integer dbUsuarioReceptor = null;
        Integer dbUsuarioEmisor = null;
        Boolean solicitudEnviada = false;
        String query2 = "SELECT * FROM solicitudesAmistad where usuarioEmisor = ? and usuarioReceptor = ?;";

        try (Connection connection = DriverManager.getConnection(Constantes.DB_PROPERTIES);
             PreparedStatement statement = connection.prepareStatement(query2)) {

            statement.setInt(1, usuarioEmisor);
            statement.setInt(2, usuarioReceptor);
            ResultSet result = statement.executeQuery();

            while (result.next()) {

                dbUsuarioReceptor = result.getInt("usuarioReceptor");
                dbUsuarioEmisor = result.getInt("usuarioEmisor");
                
                if (dbUsuarioReceptor.equals(usuarioReceptor) && dbUsuarioEmisor.equals(usuarioEmisor)) { 
                	solicitudEnviada = true;
                } 

            }
            
        } catch (Exception e) {
            e.printStackTrace();
            return solicitudEnviada;
        }

        return solicitudEnviada;
    }

    @Override
    public Boolean agregarAmigoLista(Integer usuarioId, Integer amigoId) {
        String query = "INSERT INTO amigos VAlUE (0,?,?);";

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
    public Boolean registrarSolicitudDeAmistad(Integer usuarioEmisor, Integer usuarioReceptor) {

        String query = "INSERT INTO solicitudesAmistad VALUES (0, ?, ?);";

        try (Connection connection = DriverManager.getConnection(Constantes.DB_PROPERTIES);
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, usuarioEmisor);
            statement.setInt(2, usuarioReceptor);
            statement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    @Override
    public Boolean eliminarSolicitudDeAmistad(Integer usuarioEmisor, Integer usuarioReceptor) {

        String query = "DELETE FROM solicitudesAmistad WHERE usuarioEmisor = ? and usuarioReceptor = ?;";

        try (Connection connection = DriverManager.getConnection(Constantes.DB_PROPERTIES);
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, usuarioEmisor);
            statement.setInt(2, usuarioReceptor);
            statement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    @Override
    public Boolean aceptarSolicitudDeAmistad(Integer usuarioEmisor, Integer usuarioReceptor) {

        String query = "INSERT INTO amigos VALUES (0, ?, ?);";

        try (Connection connection = DriverManager.getConnection(Constantes.DB_PROPERTIES);
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, usuarioEmisor);
            statement.setInt(2, usuarioReceptor);
            statement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    @Override
    public Boolean eliminarAmigo(Integer usuario, Integer usuarioAmigo) {

        String query = "DELETE FROM amigos WHERE usuarioid = ? and amigoid = ?";

        try (Connection connection = DriverManager.getConnection(Constantes.DB_PROPERTIES);
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, usuario);
            statement.setInt(2, usuarioAmigo);
            statement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        return true;

    }


}
