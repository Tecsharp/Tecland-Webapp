package com.tecsharp.tecland.web.app.services.perfil.impl;


import java.util.Date;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.tecsharp.tecland.web.app.models.Perfil;
import com.tecsharp.tecland.web.app.models.Usuario;
import com.tecsharp.tecland.web.app.repositories.logros.LogrosRepository;
import com.tecsharp.tecland.web.app.services.estadistica.EstadisticaService;
import com.tecsharp.tecland.web.app.services.perfil.PerfilService;
import com.tecsharp.tecland.web.app.services.trabajo.TrabajoService;
import com.tecsharp.tecland.web.app.services.usuario.UsuarioService;
import com.tecsharp.tecland.web.app.utils.Constantes;
import com.tecsharp.tecland.web.app.utils.Utilidades;

@Service
@Qualifier("perfilServicePrincipal")
public class PerfilServiceImpl implements PerfilService{
	
	
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private TrabajoService trabajoService;
	
	@Autowired
	private LogrosRepository logrosRepo;
	
	@Autowired
	private EstadisticaService estadisticaService;

	@Override
	public String recuperarLinkAvatarURL(String username) {
		
		return Constantes.URL_IMG_AVATAR + username + ".png";
	}

	@Override
	public String recuperarNombreRealDeUsuarioMinecraft(String username) {
		// TODO Auto-generated method stub
		return null;
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
		Usuario usuario = usuarioService.findByUsername(username);
		perfil.setUsuario(usuario); //SE BUSCA Y SETEA EL USUARIO
		perfil.setId(usuario.getId());
		
		/*
		 * Se envia la fecha de lastlogin para convertirla a String
		 */
		
		perfil.setUltimaCon(Utilidades.convertirLongToDate(perfil.getUsuario().getUltimaConexion()));
		
		perfil.setImageUrl(recuperarLinkAvatarURL(username)); // SE RECUPERA LA URL DE LA IMAGEN DE USUARIO
		perfil.setTrabajosActivos(trabajoService.obtenerTrabajosActivos(perfil.getUsuario().getId())); // SE OBTIENEN LOS TRABAJOS ACTIVOS
		perfil.setTrabajosNoActivos(trabajoService.obtenerTrabajosActivos(perfil.getUsuario().getId())); // SE OBTIENEN LOS TRABAJOS NO ACTIVOS
		perfil.setLogros(logrosRepo.obtenerListaLogros(username));
		perfil.setListEst1(estadisticaService.obtieneListEst1(perfil.getUsuario().getUUID()));
		perfil.setListEst2(estadisticaService.obtieneListEst2(perfil.getUsuario().getUUID()));

		} else {
			return null;
		}
		
		return perfil;
	}

	@Override
	public String actualizarBiografia(String biografia) {
		
		
		
		return null;
	}

	@Override
	public String obtenerNombrePorID(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
