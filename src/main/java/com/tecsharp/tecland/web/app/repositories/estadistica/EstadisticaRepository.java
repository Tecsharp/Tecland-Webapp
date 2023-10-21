package com.tecsharp.tecland.web.app.repositories.estadistica;

import com.tecsharp.tecland.web.app.models.Estadistica;

public interface EstadisticaRepository {

	Estadistica obtieneDeaths(String UUID);

	Estadistica obtieneBeds(String UUID);

	Estadistica obtieneBreaks(String UUID);

	Estadistica obtieneArrows(String UUID);

	Estadistica obtieneDistanceHorse(String UUID);

	Estadistica obtieneDistanceBoat(String UUID);

	Estadistica obtieneDistanceFoot(String UUID);

	Estadistica obtieneKills(String UUID);

	Estadistica obtieneItemDrops(String UUID);

	Estadistica obtieneEatenItems(String UUID);

	Estadistica obtieneConsumedpotions(String UUID);

	Estadistica obtieneTrades(String UUID);

	Estadistica obtienePickups(String UUID);

	Estadistica obtienePlaytime(String UUID);

}
