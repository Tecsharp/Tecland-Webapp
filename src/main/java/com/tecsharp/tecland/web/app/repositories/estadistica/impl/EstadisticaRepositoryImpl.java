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
				est.setDescripcion(Constantes.ACHIEV_DES_DEATHS);
				est.setValor(result.getString(Constantes.ACHIEV_DEATHS));
				est.setImg(Constantes.ACHIEV_IMG_URL_DEATHS);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		if (est.getValor() == null) {
			Estadistica est2 = new Estadistica();
			est2.setDescripcion(Constantes.ACHIEV_DES_DEATHS);
			est2.setValor("0");
			est2.setImg(Constantes.ACHIEV_IMG_URL_DEATHS);
			return est2;
		}
		return est;
	}

	@Override
	public Estadistica obtieneBeds(String UUID) {

		Estadistica est = new Estadistica();

		String query = "Select * from beds WHERE playername = ?";

		try (Connection connection = DriverManager.getConnection(Constantes.DB_PROPERTIES);
				PreparedStatement statement = connection.prepareStatement(query)) {

			statement.setString(1, UUID);
			ResultSet result = statement.executeQuery();

			while (result.next()) {
				est.setDescripcion(Constantes.ACHIEV_DES_BEDS);
				est.setValor(result.getString(Constantes.ACHIEV_BEDS));
				est.setImg(Constantes.ACHIEV_IMG_URL_BEDS);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		if (est.getValor() == null) {
			Estadistica est2 = new Estadistica();
			est2.setDescripcion(Constantes.ACHIEV_DES_BEDS);
			est2.setValor("0");
			est2.setImg(Constantes.ACHIEV_IMG_URL_BEDS);
			return est2;
		}
		return est;
	}

	@Override
	public Estadistica obtieneBreaks(String UUID) {
		Estadistica est = new Estadistica();

		String query = "Select breaks from breaks WHERE playername = ? and blockid = ?";

		try (Connection connection = DriverManager.getConnection(Constantes.DB_PROPERTIES);
				PreparedStatement statement = connection.prepareStatement(query)) {

			statement.setString(1, UUID);
			statement.setString(2, "stone");
			ResultSet result = statement.executeQuery();

			while (result.next()) {
				est.setDescripcion(Constantes.ACHIEV_DES_BREAKS);
				est.setValor(result.getString(Constantes.ACHIEV_BREAKS));
				est.setImg(Constantes.ACHIEV_IMG_URL_BREAKS);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		if (est.getValor() == null) {
			Estadistica est2 = new Estadistica();
			est2.setDescripcion(Constantes.ACHIEV_BREAKS);
			est2.setValor("0");
			est2.setImg(Constantes.ACHIEV_IMG_URL_BREAKS);
			return est2;
		}
		return est;
	}

	@Override
	public Estadistica obtieneArrows(String UUID) {
		Estadistica est = new Estadistica();

		String query = "Select * from arrows WHERE playername = ?";

		try (Connection connection = DriverManager.getConnection(Constantes.DB_PROPERTIES);
				PreparedStatement statement = connection.prepareStatement(query)) {

			statement.setString(1, UUID);
			ResultSet result = statement.executeQuery();

			while (result.next()) {
				est.setDescripcion(Constantes.ACHIEV_DES_ARROWS);
				est.setValor(result.getString(Constantes.ACHIEV_ARROWS));
				est.setImg(Constantes.ACHIEV_IMG_URL_ARROWS);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		if (est.getValor() == null) {
			Estadistica est2 = new Estadistica();
			est2.setDescripcion(Constantes.ACHIEV_DES_ARROWS);
			est2.setValor("0");
			est2.setImg(Constantes.ACHIEV_IMG_URL_ARROWS);
			return est2;
		}
		return est;
	}

	@Override
	public Estadistica obtieneDistanceHorse(String UUID) {
		Estadistica est = new Estadistica();
		
		String query = "Select * from distancehorse WHERE playername = ?";

		try (Connection connection = DriverManager.getConnection(Constantes.DB_PROPERTIES);
				PreparedStatement statement = connection.prepareStatement(query)) {

			statement.setString(1, UUID);
			ResultSet result = statement.executeQuery();

			while (result.next()) {

				est.setDescripcion(Constantes.ACHIEV_DES_DISTANCEHORSE);
				est.setValor(result.getString(Constantes.ACHIEV_DISTANCEHORSE));
				est.setImg(Constantes.ACHIEV_IMG_URL_DISTANCEHORSE);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		if (est.getValor() == null) {
			Estadistica est2 = new Estadistica();
			est2.setDescripcion(Constantes.ACHIEV_DES_DISTANCEHORSE);
			est2.setValor("0");
			est2.setImg(Constantes.ACHIEV_IMG_URL_DISTANCEHORSE);
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

				est.setDescripcion(Constantes.ACHIEV_DES_DISTANCEBOAT);
				est.setValor(result.getString(Constantes.ACHIEV_DISTANCEBOAT));
				est.setImg(Constantes.ACHIEV_IMG_URL_DISTANCEBOAT);
				

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		if (est.getValor() == null) {
			Estadistica est2 = new Estadistica();
			est2.setDescripcion(Constantes.ACHIEV_DES_DISTANCEBOAT);
			est2.setValor("0");
			est2.setImg(Constantes.ACHIEV_IMG_URL_DISTANCEBOAT);
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
				est.setDescripcion(Constantes.ACHIEV_DES_DISTANCEFOOT);
				est.setValor(result.getString(Constantes.ACHIEV_DISTANCEFOOT));
				est.setImg(Constantes.ACHIEV_IMG_URL_DISTANCEFOOT);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		if (est.getValor() == null) {
			Estadistica est2 = new Estadistica();
			est2.setDescripcion(Constantes.ACHIEV_DES_DISTANCEFOOT);
			est2.setValor("0");
			est2.setImg(Constantes.ACHIEV_IMG_URL_DISTANCEFOOT);
			return est2;
		}
		return est;
	}

	@Override
	public Estadistica obtieneKills(String UUID) {
		Estadistica est = new Estadistica();
		// OBTIENE LAS CAMAS
		String query = "Select sum(kills) from kills WHERE playername = ?";

		try (Connection connection = DriverManager.getConnection(Constantes.DB_PROPERTIES);
				PreparedStatement statement = connection.prepareStatement(query)) {

			statement.setString(1, UUID);
			ResultSet result = statement.executeQuery();

			while (result.next()) {
				est.setDescripcion(Constantes.ACHIEV_DES_KILLS);
				est.setValor(result.getString(Constantes.ACHIEV_KILLS));
				est.setImg(Constantes.ACHIEV_IMG_URL_KILLS);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		if (est.getValor() == null) {
			Estadistica est2 = new Estadistica();
			est2.setDescripcion(Constantes.ACHIEV_DES_KILLS);
			est2.setValor("0");
			est2.setImg(Constantes.ACHIEV_IMG_URL_KILLS);
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
				est.setDescripcion(Constantes.ACHIEV_DES_DROPS);
				est.setValor(result.getString(Constantes.ACHIEV_DROPS));
				est.setImg(Constantes.ACHIEV_IMG_URL_DROPS);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		if (est.getValor() == null) {
			Estadistica est2 = new Estadistica();
			est2.setDescripcion(Constantes.ACHIEV_DES_DROPS);
			est2.setValor("0");
			est2.setImg(Constantes.ACHIEV_IMG_URL_DROPS);
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
				est.setDescripcion(Constantes.ACHIEV_DES_EATENITEMS);
				est.setValor(result.getString(Constantes.ACHIEV_EATENITEMS));
				est.setImg(Constantes.ACHIEV_IMG_URL_EATENITEMS);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		if (est.getValor() == null) {
			Estadistica est2 = new Estadistica();
			est2.setDescripcion(Constantes.ACHIEV_DES_EATENITEMS);
			est2.setValor("0");
			est2.setImg(Constantes.ACHIEV_IMG_URL_EATENITEMS);
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
				est.setDescripcion(Constantes.ACHIEV_DES_CONSUMEDPOTIONS);
				est.setValor(result.getString(Constantes.ACHIEV_CONSUMEDPOTIONS));
				est.setImg(Constantes.ACHIEV_IMG_URL_CONSUMEDPOTIONS);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		if (est.getValor() == null) {
			Estadistica est2 = new Estadistica();
			est2.setDescripcion(Constantes.ACHIEV_DES_CONSUMEDPOTIONS);
			est2.setValor("0");
			est2.setImg(Constantes.ACHIEV_IMG_URL_CONSUMEDPOTIONS);
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
				est.setDescripcion(Constantes.ACHIEV_DES_TRADES);
				est.setValor(result.getString(Constantes.ACHIEV_TRADES));
				est.setImg(Constantes.ACHIEV_IMG_URL_TRADES);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		if (est.getValor() == null) {
			Estadistica est2 = new Estadistica();
			est2.setDescripcion(Constantes.ACHIEV_DES_TRADES);
			est2.setValor("0");
			est2.setImg(Constantes.ACHIEV_IMG_URL_TRADES);
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
				est.setDescripcion(Constantes.ACHIEV_DES_PICKUPS);
				est.setValor(result.getString(Constantes.ACHIEV_PICKUPS));
				est.setImg(Constantes.ACHIEV_IMG_URL_PICKUPS);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		if (est.getValor() == null) {
			Estadistica est2 = new Estadistica();
			est2.setDescripcion(Constantes.ACHIEV_DES_PICKUPS);
			est2.setValor("0");
			est2.setImg(Constantes.ACHIEV_IMG_URL_PICKUPS);
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
				est.setDescripcion(Constantes.ACHIEV_DES_PLAYEDTIME);
				
				Integer tiempoJugado = result.getInt("playedtime");
				Double tj = (double) ((tiempoJugado / 60000) / 60);
				
				est.setValor(tj.toString() + " horas");
				est.setImg(Constantes.ACHIEV_IMG_URL_PLAYEDTIME);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		if (est.getValor() == null) {
			Estadistica est2 = new Estadistica();
			est2.setDescripcion(Constantes.ACHIEV_DES_PLAYEDTIME);
			est2.setValor("0 horas");
			est2.setImg(Constantes.ACHIEV_IMG_URL_PLAYEDTIME);
			return est2;
		}
		return est;
	}

}
