package com.tecsharp.tecland.web.app.repositories.logros;

import java.util.List;

import com.tecsharp.tecland.web.app.models.Logro;

public interface LogrosRepository {
	
	public List<Logro> obtenerListaLogros(String username);

}
