package com.tecsharp.tecland.web.app.controllers;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
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
import com.tecsharp.tecland.web.app.services.trabajo.TrabajoService;
import com.tecsharp.tecland.web.app.services.usuario.UsuarioService;

@Controller
@RequestMapping("")
public class UsuarioPerfilController implements Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	@Qualifier("loginServiceSession")
	private LoginService loginService;

	@Autowired
	@Qualifier("perfilServicePrincipal")
	private PerfilService perfilService;

	@Autowired
	private TrabajoService trabajoService;

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
		if(user.getUsername() == null) {
			return "redirect:/error";
		}

		Integer id = (Integer) req.getSession().getAttribute("ID");
		String usernameLogged = (String) req.getSession().getAttribute("USERNAME");

		model.addAttribute("usernameLogged", usernameLogged);
		model.addAttribute("userLoggedId", id);

		if (id != null) {
			ArrayList<Amigo> amigosLista = amigoService.obtenerListaAmigos(id);
			model.addAttribute("amigosLista", amigosLista);

			ArrayList<Notificacion> notificacionesLista = notificacionService.obtenerNotificacionesUsuario(id);
			
			model.addAttribute("notificacionesLista", notificacionesLista);

			ArrayList<Amigo> listaBusquedaAmigos = amigoService.obtenerListaDeAmigos(username, id);
			
			model.addAttribute("listaBusquedaAmigos", listaBusquedaAmigos);

		} if (username != null) {
			try {
				
				//COMPROBAR SI EL USUARIO EXISTE, SI EXISTE IR A BUSCARLO A LA BASE DE DATOS
				Perfil perfil = perfilService.obtenerPerfilDeUsuario(username);

				if (perfil == null) {
					return "redirect:/error";
				}

				List<Logro> listaLogros = perfil.getLogros();
				for (Logro lista : listaLogros) {

					if (lista.getDbname().equals("place_50_chest")) {
						listaLogros.removeIf(Logro -> Logro.getDbname().equals("place_5_chest"));

					}

				}

				model.addAttribute("perfil", perfil);
				model.addAttribute("perfilUsuarioLogged", perfilService.obtenerPerfilDeUsuario(usernameLogged));

				model.addAttribute("logrosListaUser", perfil.getLogros());
				model.addAttribute("trabajosActivos",
						trabajoService.obtenerTrabajosActivos(perfil.getUsuario().getId()));
				model.addAttribute("trabajosNoActivos",
						trabajoService.obtenerTrabajosNoActivos(perfil.getUsuario().getId()));
			} catch (Exception e) {
				return "redirect:/error";
			}

		} 

		return "usuariop";
	}

}
