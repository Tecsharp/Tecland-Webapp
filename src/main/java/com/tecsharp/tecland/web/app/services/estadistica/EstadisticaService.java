package com.tecsharp.tecland.web.app.services.estadistica;

import java.util.List;

import com.tecsharp.tecland.web.app.models.Estadistica;

public interface EstadisticaService {
	
	public List<Estadistica>obtieneListEst1(String UUID);
	public List<Estadistica>obtieneListEst2(String UUID);

}
