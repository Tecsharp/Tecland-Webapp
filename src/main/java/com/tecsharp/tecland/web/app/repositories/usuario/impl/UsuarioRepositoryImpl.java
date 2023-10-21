package com.tecsharp.tecland.web.app.repositories.usuario.impl;

import com.tecsharp.tecland.web.app.models.Usuario;
import com.tecsharp.tecland.web.app.repositories.usuario.UsuarioRepository;
import com.tecsharp.tecland.web.app.utils.Constantes;
import com.tecsharp.tecland.web.app.utils.Utilidades;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("usuarioRepository")
public class UsuarioRepositoryImpl implements UsuarioRepository {

	@Override
	public Usuario findByUsername(String username) {
		Usuario usuario = null;
		// usuario.setUsername(username);

		// USUARIO
		String query = "SELECT * FROM authme WHERE username = ?";

		try (Connection connection = DriverManager.getConnection(Constantes.DB_PROPERTIES);
				PreparedStatement statement = connection.prepareStatement(query)) {

			statement.setString(1, username);
			ResultSet result = statement.executeQuery();

			while (result.next()) {
				usuario = new Usuario();
				usuario.setId(result.getInt("id"));
				usuario.setUsername(result.getString("realname"));
				// usuario.setVip(result.getInt("vip"));
				// usuario.setDinero(result.getInt("dinero"));
				// usuario.setPassword(result.getString("password"));
				usuario.setCorreo(result.getString("email"));
				usuario.setUltimaIp(result.getString("ip"));
				usuario.setIsAdmin(result.getInt("admin"));
				usuario.setEstadoConexion(result.getInt("isLogged"));
				usuario.setUltimaConexion(result.getLong("lastlogin"));
				usuario.setBiografia(result.getString("biografia"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		// OBTIENE EL UUID

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

		// OBTIENE LOS PUNTOS ACUTLAES DE JOBS
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

		// OBTIENE EL DINERO DEL USUARIO
		String query5 = "select money from essentials_userdata where player_name = ?";

		try (Connection connection = DriverManager.getConnection(Constantes.DB_PROPERTIES);
				PreparedStatement statement = connection.prepareStatement(query5)) {

			statement.setString(1, usuario.getUsername());
			ResultSet result = statement.executeQuery();

			while (result.next()) {
				usuario.setDinero(result.getDouble("money"));
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
			statement.setInt(6, 1); // USERTYPE
			statement.setString(7, "usuario cliente"); // DESCRIPTION
			statement.setInt(8, 0); // USER CREATE
			statement.setInt(9, 0); // USER UPDATE
			statement.setString(10, fecha); // DATE CREATE
			statement.setString(11, fecha); // DATE UPDATE
			statement.setInt(12, 1); // ID STATUS
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

			statement.setString(1, biografia); // Biografia
			statement.setInt(2, id); // Biografia

			statement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();

		}

	}

	@Override
	public String getUserById(Integer id) {
		String query = "SELECT username FROM authme WHERE id = ?";

		String name = null;

		try (Connection connection = DriverManager.getConnection(Constantes.DB_PROPERTIES);
				PreparedStatement statement = connection.prepareStatement(query)) {

			statement.setInt(1, id);
			ResultSet result = statement.executeQuery();

			while (result.next()) {

				name = result.getString("username");

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return name;
	}

	@Override
	public Usuario checkUserExist(String username) {

		Usuario user = new Usuario();

		String query = "SELECT username FROM authme WHERE username = ?";

		try (Connection connection = DriverManager.getConnection(Constantes.DB_PROPERTIES);
				PreparedStatement statement = connection.prepareStatement(query)) {

			statement.setString(1, username);
			ResultSet result = statement.executeQuery();

			while (result.next()) {

				user.setUsername(result.getString("username"));

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return user;
	}

	@Override
	public List<Usuario> getAllUsers() {
		Usuario usuario = null;

		List<Usuario> usuarios = new ArrayList<Usuario>();
		String query = "SELECT * FROM authme";

		try (Connection connection = DriverManager.getConnection(Constantes.DB_PROPERTIES);
				PreparedStatement statement = connection.prepareStatement(query)) {

			ResultSet result = statement.executeQuery();

			while (result.next()) {
				usuario = new Usuario();
				usuario.setId(result.getInt("id"));
				usuario.setUsername(result.getString("realname"));
				// usuario.setVip(result.getInt("vip"));
				// usuario.setDinero(result.getDouble("money"));
				// usuario.setPassword(result.getString("password"));
				usuario.setCorreo(result.getString("email"));
				usuario.setUltimaIp(result.getString("ip"));
				usuario.setEstadoConexion(result.getInt("isLogged"));
				usuario.setUltimaConString(Utilidades.convertirLongToDate(result.getLong("regdate")));
				usuario.setBiografia(result.getString("biografia"));
				usuario.setIsAdmin(result.getInt("admin"));
				usuario.setDinero(UsuarioRepositoryImpl.obtenerDinero(usuario.getUsername()));
				usuario.setPuntosTrabajoActual(UsuarioRepositoryImpl.getCurrentPoints(usuario.getId()));

				usuario.setImgAvatar(Utilidades.recuperarLinkAvatarURL(usuario.getUsername()));
				usuarios.add(usuario);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return usuarios;
	}

	public static Double getCurrentPoints(Integer userId) {
		// OBTIENE LOS PUNTOS ACUTLAES DE JOBS

		Double newInput = null;
		String query4 = "SELECT currentpoints FROM jobs_points WHERE userid = ?";

		try (Connection connection = DriverManager.getConnection(Constantes.DB_PROPERTIES);
				PreparedStatement statement = connection.prepareStatement(query4)) {

			statement.setInt(1, userId);
			ResultSet result = statement.executeQuery();

			while (result.next()) {

				Double input = result.getDouble("currentpoints");
				BigDecimal bd = new BigDecimal(input).setScale(2, RoundingMode.HALF_UP);
				newInput = bd.doubleValue();

			}
		} catch (Exception e) {
			e.printStackTrace();

		}
		return newInput;

	}

	@Override
	public void actualizarDineroUsuario(Usuario usuario) {
		String query = "UPDATE essentials_userdata SET money = ? WHERE player_uuid = ?";

		try (Connection connection = DriverManager.getConnection(Constantes.DB_PROPERTIES);
				PreparedStatement statement = connection.prepareStatement(query)) {

			statement.setDouble(1, usuario.getDinero()); // Biografia
			statement.setString(2, usuario.getUUID()); // Biografia

			statement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();

		}

	}

	@Override
	public void actualizarPuntosDeTrabajoUsuario(Usuario usuario) {
		String query = "UPDATE jobs_points SET currentpoints = ? WHERE userid = ?";

		try (Connection connection = DriverManager.getConnection(Constantes.DB_PROPERTIES);
				PreparedStatement statement = connection.prepareStatement(query)) {

			statement.setDouble(1, usuario.getPuntosTrabajoActual());
			statement.setInt(2, usuario.getId());

			statement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();

		}

	}

	@Override
	public void actualizarInfoAuthme(Usuario usuario) {
		String query = "UPDATE authme SET email = ?, biografia = ? WHERE id = ?";

		try (Connection connection = DriverManager.getConnection(Constantes.DB_PROPERTIES);
				PreparedStatement statement = connection.prepareStatement(query)) {

			statement.setString(1, usuario.getCorreo());
			statement.setString(2, usuario.getBiografia());
			statement.setInt(3, usuario.getId());

			statement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();

		}

	}

	@Override
	public String obtieneUUID(Usuario usuario) {
		// OBTIENE EL UUID
		String UUID = null;
		String query6 = "select player_uuid from jobs_users where username = ?";

		try (Connection connection = DriverManager.getConnection(Constantes.DB_PROPERTIES);
				PreparedStatement statement = connection.prepareStatement(query6)) {

			statement.setString(1, usuario.getUsername());
			ResultSet result = statement.executeQuery();

			while (result.next()) {
				UUID = result.getString("player_uuid");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return UUID;
	}

	public static Double obtenerDinero(String username) {
		Double money = null;
		
		// OBTIENE EL DINERO DEL USUARIO
				String query = "select money from essentials_userdata where player_name = ?";

				try (Connection connection = DriverManager.getConnection(Constantes.DB_PROPERTIES);
						PreparedStatement statement = connection.prepareStatement(query)) {

					statement.setString(1, username);
					ResultSet result = statement.executeQuery();

					while (result.next()) {
						money = result.getDouble("money");
					}
				} catch (Exception e) {
					e.printStackTrace();

				}
		 
		return money;
	}

}
