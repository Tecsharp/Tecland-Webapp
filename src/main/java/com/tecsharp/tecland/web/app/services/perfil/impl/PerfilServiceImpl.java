package com.tecsharp.tecland.web.app.services.perfil.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.tecsharp.tecland.web.app.models.Perfil;
import com.tecsharp.tecland.web.app.repositories.logros.LogrosRepository;
import com.tecsharp.tecland.web.app.services.perfil.PerfilService;
import com.tecsharp.tecland.web.app.services.trabajo.TrabajoService;
import com.tecsharp.tecland.web.app.services.usuario.UsuarioService;

@Service
@Qualifier("perfilServicePrincipal")
public class PerfilServiceImpl implements PerfilService{
	
	
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private TrabajoService trabajoService;
	
	@Autowired
	private LogrosRepository logrosRepo;

	@Override
	public String recuperarLinkAvatarURL(String username) {
		
		return "https://minotar.net/armor/bust/" + username + ".png";
	}

	@Override
	public String recuperarNombreRealDeUsuarioMinecraft(String username) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	public String convertirLongToDate(Long fecha) {
		
		//long fecha = 1346524199000l;
        Date date = new Date(fecha);
        SimpleDateFormat df2 = new SimpleDateFormat("EEEE dd 'de' MMMM 'del' YYYY");
        String dateText = df2.format(date);
		
		return dateText;
	}
	
	public String convertirDateToString(Date fecha) {
		
		//long fecha = 1346524199000l;
        
        SimpleDateFormat df2 = new SimpleDateFormat("EEEE dd 'de' MMMM 'del' YYYY");
        String dateText = df2.format(fecha);
		
		return dateText;
	}
	
  
	@Override
	public Perfil obtenerPerfilDeUsuario(String username) {
		
		Perfil perfil = new Perfil();
		if(username != null) {
		perfil.setId(usuarioService.findByUsername(username).getId());
		perfil.setUsuario(usuarioService.findByUsername(username)); //SE BUSCA Y SETEA EL USUARIO
		
		/*
		 * Se envia la fecha de lastlogin para convertirla a String
		 */
		
		perfil.setUltimaCon(convertirLongToDate(perfil.getUsuario().getUltimaConexion()));
		
		perfil.setImageUrl(recuperarLinkAvatarURL(username)); // SE RECUPERA LA URL DE LA IMAGEN DE USUARIO
		perfil.setTrabajosActivos(trabajoService.obtenerTrabajosActivos(perfil.getUsuario().getId())); // SE OBTIENEN LOS TRABAJOS ACTIVOS
		perfil.setTrabajosNoActivos(trabajoService.obtenerTrabajosActivos(perfil.getUsuario().getId())); // SE OBTIENEN LOS TRABAJOS NO ACTIVOS
		perfil.setLogros(logrosRepo.obtenerListaLogros(username));
		
		} else {
			return null;
		}
		
		return perfil;
	}

	@Override
	public String actualizarBiografia(String biografia) {
		
		
		
		return null;
	}
	
	

}
