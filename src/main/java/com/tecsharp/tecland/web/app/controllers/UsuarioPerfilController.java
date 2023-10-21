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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tecsharp.tecland.web.app.models.Amigo;
import com.tecsharp.tecland.web.app.models.Logro;
import com.tecsharp.tecland.web.app.models.Notificacion;
import com.tecsharp.tecland.web.app.models.Perfil;
import com.tecsharp.tecland.web.app.models.Usuario;
import com.tecsharp.tecland.web.app.services.amigo.AmigoService;
import com.tecsharp.tecland.web.app.services.login.LoginService;
import com.tecsharp.tecland.web.app.services.notificacion.NotificacionService;
import com.tecsharp.tecland.web.app.services.perfil.PerfilService;
import com.tecsharp.tecland.web.app.services.usuario.UsuarioService;
import com.tecsharp.tecland.web.app.utils.Constantes;

@Controller
@RequestMapping("/")
public class UsuarioPerfilController implements Serializable {

	private static final long serialVersionUID = 1L;

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

	@GetMapping({ "/{username}" })
	public String presentacionPerfil(HttpServletRequest req, Model model, @PathVariable String username)
			throws ServletException, IOException {

		if (username.equals("perfil") || username.equals("Perfil") || username.equals("favicon.ico")
				|| username.equals("login") || username.equals("Login")) {
			return "redirect:/login";
		}

		Usuario user = usuarioService.checkUserExist(username);
		if (user.getUsername() == null) {
			return "redirect:/error";
		}

		Integer id = (Integer) req.getSession().getAttribute("ID");
		String usernameLogged = (String) req.getSession().getAttribute("USERNAME");

		try {
			if (id != null) {
				
				/*
				 * ENVIO DE LISTA DE AMIGOS, NOTIFICACIONES
				 * */
				List<Amigo> amigosLista = amigoService.obtenerListaAmigos(id);
				model.addAttribute("amigosLista", amigosLista);

				List<Notificacion> notificacionesLista = notificacionService.obtenerNotificacionesUsuario(id);

				model.addAttribute("notificacionesLista", notificacionesLista);

				List<Amigo> listaBusquedaAmigos = amigoService.obtenerListaDeAmigos(username, id);

				model.addAttribute("listaBusquedaAmigos", listaBusquedaAmigos);

			} else {
				// SE MANDA UN MENSAJE AL NO TENER LA SESION INICIADA
				model.addAttribute("mensaje", Constantes.NO_USER_LOGGED);
				return "forward:/error";
			}
			if (username != null) {

				// COMPROBAR SI EL USUARIO EXISTE, SI EXISTE IRÁ A BUSCARLO A LA BASE DE DATOS
				Perfil perfilBusqueda = perfilService.obtenerPerfilDeUsuario(username);
				
				// SI EL PERFIL QUE BUSCÓ NO EXISTE, REDIRIGE A ERROR CON UN MENSAJE.
				if (perfilBusqueda == null) {
					model.addAttribute("mensaje", Constantes.PROFILE_NOT_FOUND);
					return "forward:/error";
				}

				/* 
				 * Se recoge la lista de logros en el perfil y se recorre para saber si el usuario tiene 2 logros
				 * Si el usuario tiene el logro "place_5_chest" unicamente, se muestra.
				 * Si el usuario tiene el logro "place_5_chest" y "place_50_chest" se elimina el primero y se muestra el segundo
				 * */
				List<Logro> listaLogros = perfilBusqueda.getLogros();
				for (Logro lista : listaLogros) {

					if (lista.getDbname().equals(Constantes.PLACE_50_CHEST)) {
						listaLogros.removeIf(Logro -> Logro.getDbname().equals(Constantes.PLACE_5_CHEST));

					}

				}
				
				//PERFIL DE USUARIO BUSCADO
				model.addAttribute("perfilBusqueda", perfilBusqueda);
				
				//PERFIL DEL USUARIO LOGUEADO
				model.addAttribute("perfil", perfilService.obtenerPerfilDeUsuario(usernameLogged));

			}

		} catch (Exception e) {
			return "redirect:/error";
		}

		return "usuariop";
	}

}
