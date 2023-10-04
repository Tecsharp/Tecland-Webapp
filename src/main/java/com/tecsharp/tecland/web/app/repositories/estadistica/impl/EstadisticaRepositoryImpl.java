package com.tecsharp.tecland.web.app.repositories.estadistica.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.stereotype.Repository;

import com.tecsharp.tecland.web.app.models.Estadistica;
import com.tecsharp.tecland.web.app.repositories.estadistica.EstadisticaRepository;
import com.tecsharp.tecland.web.app.utils.Constantes;

@Repository
public class EstadisticaRepositoryImpl implements EstadisticaRepository {

	@Override
	public Estadistica obtieneDeaths(String UUID) {
		Estadistica est = new Estadistica();
		// OBTIENE LAS CAMAS
		String query = "Select * from deaths WHERE playername = ?";

		try (Connection connection = DriverManager.getConnection(Constantes.DB_PROPERTIES);
				PreparedStatement statement = connection.prepareStatement(query)) {

			statement.setString(1, UUID);
			ResultSet result = statement.executeQuery();

			while (result.next()) {
				est.setDescripcion("Veces muerto");
				est.setValor(result.getString("deaths"));
				est.setImg("/icons/totem.png");

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		if (est.getValor() == null) {
			Estadistica est2 = new Estadistica();
			est2.setDescripcion("Veces muerto");
			est2.setValor("0");
			est2.setImg("/icons/totem.png");
			return est2;
		}
		return est;
	}

	@Override
	public Estadistica obtieneBeds(String UUID) {

		Estadistica est = new Estadistica();
		// OBTIENE LAS CAMAS
		String query = "Select * from beds WHERE playername = ?";

		try (Connection connection = DriverManager.getConnection(Constantes.DB_PROPERTIES);
				PreparedStatement statement = connection.prepareStatement(query)) {

			statement.setString(1, UUID);
			ResultSet result = statement.executeQuery();

			while (result.next()) {
				est.setDescripcion("Camas usadas");
				est.setValor(result.getString("beds"));
				est.setImg("/icons/bed.png");

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		if (est.getValor() == null) {
			Estadistica est2 = new Estadistica();
			est2.setDescripcion("Camas usadas");
			est2.setValor("0");
			est2.setImg("/icons/bed.png");
			return est2;
		}
		return est;
	}

	@Override
	public Estadistica obtieneBreaks(String UUID) {
		Estadistica est = new Estadistica();
		// OBTIENE LAS CAMAS
		String query = "Select breaks from breaks WHERE playername = ? and blockid = ?";

		try (Connection connection = DriverManager.getConnection(Constantes.DB_PROPERTIES);
				PreparedStatement statement = connection.prepareStatement(query)) {

			statement.setString(1, UUID);
			statement.setString(2, "stone");
			ResultSet result = statement.executeQuery();

			while (result.next()) {
				est.setDescripcion("Bloques rotos");
				est.setValor(result.getString("breaks"));
				est.setImg("/icons/block1.png");

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		if (est.getValor() == null) {
			Estadistica est2 = new Estadistica();
			est2.setDescripcion("Bloques rotos");
			est2.setValor("0");
			est2.setImg("/icons/block1.png");
			return est2;
		}
		return est;
	}

	@Override
	public Estadistica obtieneArrows(String UUID) {
		Estadistica est = new Estadistica();
		// OBTIENE LAS CAMAS
		String query = "Select * from arrows WHERE playername = ?";

		try (Connection connection = DriverManager.getConnection(Constantes.DB_PROPERTIES);
				PreparedStatement statement = connection.prepareStatement(query)) {

			statement.setString(1, UUID);
			ResultSet result = statement.executeQuery();

			while (result.next()) {
				est.setDescripcion("Flechas lanzadas");
				est.setValor(result.getString("arrows"));
				est.setImg("/icons/arrow.png");

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		if (est.getValor() == null) {
			Estadistica est2 = new Estadistica();
			est2.setDescripcion("Flechas lanzadas");
			est2.setValor("0");
			est2.setImg("/icons/arrow.png");
			return est2;
		}
		return est;
	}

	@Override
	public Estadistica obtieneDistanceHorse(String UUID) {
		Estadistica est = new Estadistica();
		// OBTIENE LAS CAMAS
		String query = "Select * from distancehorse WHERE playername = ?";

		try (Connection connection = DriverManager.getConnection(Constantes.DB_PROPERTIES);
				PreparedStatement statement = connection.prepareStatement(query)) {

			statement.setString(1, UUID);
			ResultSet result = statement.executeQuery();

			while (result.next()) {

				est.setDescripcion("Bloques recorridos en caballo");
				est.setValor(result.getString("distancehorse"));
				est.setImg("/icons/HorseDiamond.png");

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		if (est.getValor() == null) {
			Estadistica est2 = new Estadistica();
			est2.setDescripcion("Bloques recorridos en caballo");
			est2.setValor("0");
			est2.setImg("/icons/HorseDiamond.png");
			return est2;
		}
		return est;
	}

	@Override
	public Estadistica obtieneDistanceBoat(String UUID) {
		Estadistica est = new Estadistica();
		// OBTIENE LAS CAMAS
		String query = "Select * from distanceboat WHERE playername = ?";

		try (Connection connection = DriverManager.getConnection(Constantes.DB_PROPERTIES);
				PreparedStatement statement = connection.prepareStatement(query)) {

			statement.setString(1, UUID);
			ResultSet result = statement.executeQuery();

			while (result.next()) {

				est.setDescripcion("Bloques recorridos en bote");
				est.setValor(result.getString("distanceboat"));
				est.setImg("/icons/Boat.png");
				

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		if (est.getValor() == null) {
			Estadistica est2 = new Estadistica();
			est2.setDescripcion("Bloques recorridos en bote");
			est2.setValor("0");
			est2.setImg("/icons/Boat.png");
			return est2;
		}
		return est;
	}

	@Override
	public Estadistica obtieneDistanceFoot(String UUID) {
		Estadistica est = new Estadistica();
		// OBTIENE LAS CAMAS
		String query = "Select * from distancefoot WHERE playername = ?";

		try (Connection connection = DriverManager.getConnection(Constantes.DB_PROPERTIES);
				PreparedStatement statement = connection.prepareStatement(query)) {

			statement.setString(1, UUID);
			ResultSet result = statement.executeQuery();

			while (result.next()) {
				est.setDescripcion("Bloques recorridos a pie");
				est.setValor(result.getString("distancefoot"));
				est.setImg("/icons/goldfeet.png");

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		if (est.getValor() == null) {
			Estadistica est2 = new Estadistica();
			est2.setDescripcion("Bloques recorridos a pie");
			est2.setValor("0");
			est2.setImg("/icons/goldfeet.png");
			return est2;
		}
		return est;
	}

	@Override
	public Estadistica obtieneKills(String UUID) {
		Estadistica est = new Estadistica();
		// OBTIENE LAS CAMAS
		String query = "Select * from kills WHERE playername = ? and mobname = ?";

		try (Connection connection = DriverManager.getConnection(Constantes.DB_PROPERTIES);
				PreparedStatement statement = connection.prepareStatement(query)) {

			statement.setString(1, UUID);
			statement.setString(2, "zombie");
			ResultSet result = statement.executeQuery();

			while (result.next()) {
				est.setDescripcion("Mobs asesinados");
				est.setValor(result.getString("kills"));
				est.setImg("/icons/diamond_sword.png");

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		if (est.getValor() == null) {
			Estadistica est2 = new Estadistica();
			est2.setDescripcion("Mobs asesinados");
			est2.setValor("0");
			est2.setImg("/icons/diamond_sword.png");
			return est2;
		}
		return est;
	}

	@Override
	public Estadistica obtieneItemDrops(String UUID) {
		Estadistica est = new Estadistica();
		// OBTIENE LAS CAMAS
		String query = "Select * from drops WHERE playername = ?";

		try (Connection connection = DriverManager.getConnection(Constantes.DB_PROPERTIES);
				PreparedStatement statement = connection.prepareStatement(query)) {

			statement.setString(1, UUID);
			ResultSet result = statement.executeQuery();

			while (result.next()) {
				est.setDescripcion("Objetos tirados al suelo");
				est.setValor(result.getString("drops"));
				est.setImg("/icons/rottenmeat.png");

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		if (est.getValor() == null) {
			Estadistica est2 = new Estadistica();
			est2.setDescripcion("Objetos tirados al suelo");
			est2.setValor("0");
			est2.setImg("/icons/rottenmeat.png");
			return est2;
		}
		return est;
	}

	@Override
	public Estadistica obtieneEatenItems(String UUID) {
		Estadistica est = new Estadistica();
		// OBTIENE LAS CAMAS
		String query = "Select * from eatenitems WHERE playername = ?";

		try (Connection connection = DriverManager.getConnection(Constantes.DB_PROPERTIES);
				PreparedStatement statement = connection.prepareStatement(query)) {

			statement.setString(1, UUID);
			ResultSet result = statement.executeQuery();

			while (result.next()) {
				est.setDescripcion("Objetos comidos");
				est.setValor(result.getString("eatenitems"));
				est.setImg("/icons/meat.png");

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		if (est.getValor() == null) {
			Estadistica est2 = new Estadistica();
			est2.setDescripcion("Objetos comidos");
			est2.setValor("0");
			est2.setImg("/icons/meat.png");
			return est2;
		}
		return est;
	}

	@Override
	public Estadistica obtieneConsumedpotions(String UUID) {
		Estadistica est = new Estadistica();
		// OBTIENE LAS CAMAS
		String query = "Select * from consumedpotions WHERE playername = ?";

		try (Connection connection = DriverManager.getConnection(Constantes.DB_PROPERTIES);
				PreparedStatement statement = connection.prepareStatement(query)) {

			statement.setString(1, UUID);
			ResultSet result = statement.executeQuery();

			while (result.next()) {
				est.setDescripcion("Pociones bebidas");
				est.setValor(result.getString("consumedpotions"));
				est.setImg("/icons/posion.png");

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		if (est.getValor() == null) {
			Estadistica est2 = new Estadistica();
			est2.setDescripcion("Pociones bebidas");
			est2.setValor("0");
			est2.setImg("/icons/posion.png");
			return est2;
		}
		return est;
	}

	@Override
	public Estadistica obtieneTrades(String UUID) {
		Estadistica est = new Estadistica();
		// OBTIENE LAS CAMAS
		String query = "Select * from trades WHERE playername = ?";

		try (Connection connection = DriverManager.getConnection(Constantes.DB_PROPERTIES);
				PreparedStatement statement = connection.prepareStatement(query)) {

			statement.setString(1, UUID);
			ResultSet result = statement.executeQuery();

			while (result.next()) {
				est.setDescripcion("Tradeos");
				est.setValor(result.getString("trades"));
				est.setImg("/icons/gold.png");

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		if (est.getValor() == null) {
			Estadistica est2 = new Estadistica();
			est2.setDescripcion("Tradeos");
			est2.setValor("0");
			est2.setImg("/icons/gold.png");
			return est2;
		}
		return est;
	}

	@Override
	public Estadistica obtienePickups(String UUID) {
		Estadistica est = new Estadistica();
		// OBTIENE LAS CAMAS
		String query = "Select * from pickups WHERE playername = ?";

		try (Connection connection = DriverManager.getConnection(Constantes.DB_PROPERTIES);
				PreparedStatement statement = connection.prepareStatement(query)) {

			statement.setString(1, UUID);
			ResultSet result = statement.executeQuery();

			while (result.next()) {
				est.setDescripcion("Objetos recogidos");
				est.setValor(result.getString("pickups"));
				est.setImg("/icons/orange_shulker.png");

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		if (est.getValor() == null) {
			Estadistica est2 = new Estadistica();
			est2.setDescripcion("Objetos recogidos");
			est2.setValor("0");
			est2.setImg("/icons/orange_shulker.png");
			return est2;
		}
		return est;
	}

	@Override
	public Estadistica obtienePlaytime(String UUID) {
		Estadistica est = new Estadistica();
		// OBTIENE LAS CAMAS
		String query = "Select * from playedtime WHERE playername = ?";

		try (Connection connection = DriverManager.getConnection(Constantes.DB_PROPERTIES);
				PreparedStatement statement = connection.prepareStatement(query)) {

			statement.setString(1, UUID);
			ResultSet result = statement.executeQuery();

			while (result.next()) {
				est.setDescripcion("Tiempo jugado");
				
				Integer tiempoJugado = result.getInt("playedtime");
				Double tj = (double) ((tiempoJugado / 60000) / 60);
				
				est.setValor(tj.toString() + " horas");
				est.setImg("/icons/brujula.png");

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		if (est.getValor() == null) {
			Estadistica est2 = new Estadistica();
			est2.setDescripcion("Tiempo jugado");
			est2.setValor("0 horas");
			est2.setImg("/icons/brujula.png");
			return est2;
		}
		return est;
	}

}
