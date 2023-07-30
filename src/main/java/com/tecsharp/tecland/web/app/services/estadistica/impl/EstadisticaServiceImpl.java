package com.tecsharp.tecland.web.app.services.estadistica.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tecsharp.tecland.web.app.models.Estadistica;
import com.tecsharp.tecland.web.app.repositories.estadistica.EstadisticaRepository;
import com.tecsharp.tecland.web.app.services.estadistica.EstadisticaService;

@Service
public class EstadisticaServiceImpl implements EstadisticaService{
	
	@Autowired
	private EstadisticaRepository estRepo;
	


	@Override
	public List<Estadistica> obtieneListEst1(String UUID) {
		List<Estadistica> lista = new ArrayList<>();
		lista.add(estRepo.obtieneBeds(UUID));
		lista.add(estRepo.obtieneBreaks(UUID));
		lista.add(estRepo.obtieneDeaths(UUID));
		lista.add(estRepo.obtieneArrows(UUID));
		lista.add(estRepo.obtieneDistanceHorse(UUID));
		lista.add(estRepo.obtieneDistanceBoat(UUID));
		lista.add(estRepo.obtieneDistanceFoot(UUID));
		
		return lista;
	}

	@Override
	public List<Estadistica> obtieneListEst2(String UUID) {
		List<Estadistica> lista = new ArrayList<>();
		
		lista.add(estRepo.obtieneKills(UUID));
		lista.add(estRepo.obtieneItemDrops(UUID));
		lista.add(estRepo.obtieneEatenItems(UUID));
		lista.add(estRepo.obtieneConsumedpotions(UUID));
		lista.add(estRepo.obtieneTrades(UUID));
		lista.add(estRepo.obtienePickups(UUID));
		lista.add(estRepo.obtienePlaytime(UUID));
		
		return lista;
	}

}
