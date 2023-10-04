package com.tecsharp.tecland.web.app.services.perfil;

import java.util.Date;

import com.tecsharp.tecland.web.app.models.Perfil;

public interface PerfilService {
	
	public String recuperarLinkAvatarURL(String username);
	
	public String recuperarNombreRealDeUsuarioMinecraft(String username);
	
	public Perfil obtenerPerfilDeUsuario(String username);
	
	public String actualizarBiografia(String biografia);
	
	public String convertirDateToString(Date fecha);
	
	public String obtenerNombrePorID(Integer id);

}
