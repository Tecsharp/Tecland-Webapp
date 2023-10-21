package com.tecsharp.tecland.web.app.services.estadistica;

import java.util.List;

import com.tecsharp.tecland.web.app.models.Estadistica;

public interface EstadisticaService {

	List<Estadistica> obtieneListEst1(String UUID);

	List<Estadistica> obtieneListEst2(String UUID);

	Estadistica ObtieneUserDeaths(String UUID);

	Estadistica ObtieneUserKill(String UUID);

	Estadistica ObtieneUserPlayedtime(String UUID);

	Estadistica ObtieneUserBreaks(String UUID);

}
