package com.tecsharp.tecland.web.app.services.perfil;

import com.tecsharp.tecland.web.app.models.Perfil;

public interface PerfilService {
	
	String recuperarLinkAvatarURL(String username);
	
	String recuperarNombreRealDeUsuarioMinecraft(String username);
	
	Perfil obtenerPerfilDeUsuario(String username);
	


}
