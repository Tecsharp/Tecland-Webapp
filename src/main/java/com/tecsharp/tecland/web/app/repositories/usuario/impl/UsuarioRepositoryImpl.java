package com.tecsharp.tecland.web.app.repositories.usuario.impl;

import com.tecsharp.tecland.web.app.models.Usuario;
import com.tecsharp.tecland.web.app.repositories.usuario.UsuarioRepository;
import com.tecsharp.tecland.web.app.utils.Constantes;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;


@Component
@Qualifier("usuarioRepository")
public class UsuarioRepositoryImpl implements UsuarioRepository {


    @Override
    public Usuario findByUsername(String username) {
        Usuario usuario = null;

        //USUARIO
        String query = "SELECT * FROM authme WHERE username = ?";


        try (Connection connection = DriverManager.getConnection(Constantes.DB_PROPERTIES);
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, username);
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                usuario = new Usuario();
                usuario.setId(result.getInt("id"));
                usuario.setUsername(result.getString("realname"));
                //usuario.setVip(result.getInt("vip"));
                //usuario.setDinero(result.getInt("dinero"));
                //usuario.setPassword(result.getString("password"));
                usuario.setCorreo(result.getString("email"));
                usuario.setUltimaIp(result.getString("ip"));
                usuario.setEstadoConexion(result.getInt("isLogged"));
                usuario.setUltimaConexion(result.getLong("lastlogin"));
                usuario.setBiografia(result.getString("biografia"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        //OBTIENE EL UUID
        
        String query6 = "select player_uuid from jobs_users where username = ?";


        try (Connection connection = DriverManager.getConnection(Constantes.DB_PROPERTIES);
             PreparedStatement statement = connection.prepareStatement(query6)) {

            statement.setString(1, username);
            ResultSet result = statement.executeQuery();

            while (result.next()) {
            	usuario.setUUID(result.getString("player_uuid"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        



        //OBTIENE LOS PUNTOS ACUTLAES DE JOBS
        String query4 = "SELECT currentpoints FROM jobs_points WHERE userid = ?";

        try (Connection connection = DriverManager.getConnection(Constantes.DB_PROPERTIES);
             PreparedStatement statement = connection.prepareStatement(query4)) {

            statement.setInt(1, usuario.getId());
            ResultSet result = statement.executeQuery();

            while (result.next()) {

                Double input = result.getDouble("currentpoints");
                BigDecimal bd = new BigDecimal(input).setScale(2, RoundingMode.HALF_UP);
                double newInput = bd.doubleValue();

                usuario.setPuntosTrabajoActual(newInput);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        return usuario;
    }

    @Override
    public Integer obtenerNumeroDeUsuariosRegistrados() {
        Integer numUsuariosRegistrados = null;

        String query = "SELECT COUNT(id_user) AS numUsers FROM users";
        try (Connection connection = DriverManager.getConnection(Constantes.DB_PROPERTIES);
             PreparedStatement statement = connection.prepareStatement(query)) {

            ResultSet result = statement.executeQuery();

            while (result.next()) {
                numUsuariosRegistrados = result.getInt("numUsers");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return numUsuariosRegistrados;
    }

    @Override
    public boolean registrarUsuario(String nombre, String apellido, String email, String username, String password) {

        DateTimeFormatter FOMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
        LocalDateTime localDateTime = LocalDateTime.now();
        String fecha = FOMATTER.format(localDateTime);

        String query = "INSERT INTO users VALUES (0,?,?,?,?,?,?,?,?,?,?,?,?);";

        try (Connection connection = DriverManager.getConnection(Constantes.DB_PROPERTIES);
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, nombre);
            statement.setString(2, apellido);
            statement.setString(3, email);
            statement.setString(4, username);
            statement.setString(5, password);
            statement.setInt(6, 1); //USERTYPE
            statement.setString(7, "usuario cliente"); //DESCRIPTION
            statement.setInt(8, 0); //USER CREATE
            statement.setInt(9, 0); //USER UPDATE
            statement.setString(10, fecha); //DATE CREATE
            statement.setString(11, fecha); //DATE UPDATE
            statement.setInt(12, 1); //ID STATUS
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    @Override
    public String obtenerPasswordHashed(String username) {
        String hashedPassword = null;

        String query = "SELECT password FROM authme WHERE username = ?;";
        try (Connection connection = DriverManager.getConnection(Constantes.DB_PROPERTIES);
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, username);
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                hashedPassword = result.getString("password");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return hashedPassword;


    }

	@Override
	public void actualizarBiografia(String biografia, Integer id) {

        String query = "UPDATE authme SET biografia = ? WHERE id = ?";

        try (Connection connection = DriverManager.getConnection(Constantes.DB_PROPERTIES);
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, biografia); //Biografia
            statement.setInt(2, id); //Biografia

            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            
        }
		
	}


}
