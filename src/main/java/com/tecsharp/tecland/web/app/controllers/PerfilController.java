package com.tecsharp.tecland.web.app.controllers;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tecsharp.tecland.web.app.models.Amigo;
import com.tecsharp.tecland.web.app.models.Logro;
import com.tecsharp.tecland.web.app.models.Notificacion;
import com.tecsharp.tecland.web.app.models.Perfil;
import com.tecsharp.tecland.web.app.services.amigo.AmigoService;
import com.tecsharp.tecland.web.app.services.estadistica.EstadisticaService;
import com.tecsharp.tecland.web.app.services.login.LoginService;
import com.tecsharp.tecland.web.app.services.notificacion.NotificacionService;
import com.tecsharp.tecland.web.app.services.perfil.PerfilService;
import com.tecsharp.tecland.web.app.services.usuario.UsuarioService;

@Controller
@RequestMapping("/")
public class PerfilController implements Serializable {


	private static final long serialVersionUID = 6966533466813479613L;

	@Autowired
	@Qualifier("loginServiceSession")
	private LoginService loginService;

	@Autowired
	@Qualifier("perfilServicePrincipal")
	private PerfilService perfilService;

	@Autowired
	private UsuarioService usuarioService;

	@Autowired
	private AmigoService amigoService;

	@Autowired
	private NotificacionService notificacionService;
	
	@Autowired
	private EstadisticaService estService;

	@GetMapping({ "/perfil" })
	public String toPerfil(HttpServletRequest req, Model model) throws ServletException, IOException {

		
		String usernameLogged = (String) req.getSession().getAttribute("USERNAME");
		
		if (usernameLogged != null) {

			try {

				Perfil perfil = perfilService
						.obtenerPerfilDeUsuario((String) req.getSession().getAttribute("USERNAME"));
				
				
				/* 
				 * Se recoge la lista de logros en el perfil y se recorre para saber si el usuario tiene 2 logros
				 * Si el usuario tiene el logro "place_5_chest" unicamente, se muestra.
				 * Si el usuario tiene el logro "place_5_chest" y "place_50_chest" se elimina el primero y se muestra el segundo
				 * */
				List<Logro> listaLogros = perfil.getLogros();
				for (Logro lista : listaLogros) {

					if (lista.getDbname().equals("place_50_chest")) {
						listaLogros.removeIf(Logro -> Logro.getDbname().equals("place_5_chest"));

					}

				}
				
				//SE MANDA PERFIL
				model.addAttribute("perfil", perfil);
	
				//lISTA DE AMIGOS EN PERFIL
				List<Amigo> amigosLista = amigoService.obtenerListaAmigos(perfil.getUsuario().getId());
				model.addAttribute("amigosLista", amigosLista);
				
				//LISTA DE NOTIFICACIONES DEL PERFIL
				List<Notificacion> notificacionesLista = notificacionService
						.obtenerNotificacionesUsuario((Integer) req.getSession().getAttribute("ID"));
				req.setAttribute("notificacionesLista", notificacionesLista);

				//TITULO DE LA PAGINA
				model.addAttribute("titulo", "Perfil | Tecland");
				
				// ESTADISTICAS DEL NAVBAR // 
				model.addAttribute("userDeaths", estService.ObtieneUserDeaths(perfil.getUsuario().getUUID()));
				model.addAttribute("userKill", estService.ObtieneUserKill(perfil.getUsuario().getUUID()));
				model.addAttribute("userBreaks", estService.ObtieneUserBreaks(perfil.getUsuario().getUUID()));
				model.addAttribute("userPlayedTime", estService.ObtieneUserPlayedtime(perfil.getUsuario().getUUID()));
				

			} catch (Exception e) {
				return "redirect:/login";
			}
			return "perfil";

		} else {
			return "redirect:/login";
		}
	}

	@PostMapping("/destroy")
	public String destroySession(HttpServletRequest request) {
		request.getSession().invalidate();
		return "redirect:/";
	}

	@PostMapping("/info/actualizar")
	public String actualizarInformacionPerfil(HttpServletRequest req, @RequestParam String biografia) {

		Integer id = (Integer) req.getSession().getAttribute("ID");
		usuarioService.actualizarBiografia(biografia, id);

		return "redirect:/perfil";
	}

//	
//	@GetMapping("/{perfil}")
//	public String buscaPerfil(@PathVariable String perfil, Model model) {
//		
//		
//		
//		return "presentacion";
//	}

}
