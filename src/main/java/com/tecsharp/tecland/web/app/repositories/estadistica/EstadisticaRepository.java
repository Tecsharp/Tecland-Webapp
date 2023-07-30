package com.tecsharp.tecland.web.app.repositories.estadistica;

import java.util.List;

import com.tecsharp.tecland.web.app.models.Estadistica;

public interface EstadisticaRepository {
	
	
	
	public Estadistica obtieneDeaths(String UUID);
	
	public Estadistica obtieneBeds(String UUID);
	
	public Estadistica obtieneBreaks(String UUID);
	
	public Estadistica obtieneArrows(String UUID);
	
	public Estadistica obtieneDistanceHorse(String UUID);
	
	public Estadistica obtieneDistanceBoat(String UUID);
	
	public Estadistica obtieneDistanceFoot(String UUID);
	
	public Estadistica obtieneKills(String UUID);
	
	public Estadistica obtieneItemDrops(String UUID);
	
	public Estadistica obtieneEatenItems(String UUID);
	
	public Estadistica obtieneConsumedpotions(String UUID);
	
	public Estadistica obtieneTrades(String UUID);
	
	public Estadistica obtienePickups(String UUID);
	
	public Estadistica obtienePlaytime(String UUID);
	

}
