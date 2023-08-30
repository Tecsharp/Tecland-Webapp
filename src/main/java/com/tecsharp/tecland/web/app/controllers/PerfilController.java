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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tecsharp.tecland.web.app.models.Amigo;
import com.tecsharp.tecland.web.app.models.Logro;
import com.tecsharp.tecland.web.app.models.Notificacion;
import com.tecsharp.tecland.web.app.models.Perfil;
import com.tecsharp.tecland.web.app.services.amigo.AmigoService;
import com.tecsharp.tecland.web.app.services.login.LoginService;
import com.tecsharp.tecland.web.app.services.notificacion.NotificacionService;
import com.tecsharp.tecland.web.app.services.perfil.PerfilService;
import com.tecsharp.tecland.web.app.services.trabajo.TrabajoService;
import com.tecsharp.tecland.web.app.services.usuario.UsuarioService;

@Controller
@RequestMapping("")
public class PerfilController implements Serializable {

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

	@GetMapping({ "/perfil" })
	public String toPerfil(HttpServletRequest req, Model model) throws ServletException, IOException {

		String username = (String) req.getSession().getAttribute("USERNAME");
		req.getSession().setAttribute("USERNAME", username);
		if (username != null) {

			try {

				Perfil perfil = perfilService
						.obtenerPerfilDeUsuario((String) req.getSession().getAttribute("USERNAME"));

				List<Logro> listaLogros = perfil.getLogros();
				for (Logro lista : listaLogros) {

					if (lista.getDbname().equals("place_50_chest")) {
						listaLogros.removeIf(Logro -> Logro.getDbname().equals("place_5_chest"));

					}

				}

				model.addAttribute("perfil", perfil);
				model.addAttribute("logrosListaUser", perfil.getLogros());

				model.addAttribute("trabajosActivos",
						trabajoService.obtenerTrabajosActivos(perfil.getUsuario().getId()));
				model.addAttribute("trabajosNoActivos",
						trabajoService.obtenerTrabajosNoActivos(perfil.getUsuario().getId()));

				ArrayList<Amigo> amigosLista = amigoService.obtenerListaAmigos(perfil.getUsuario().getId());
				model.addAttribute("amigosLista", amigosLista);

				ArrayList<Notificacion> notificacionesLista = notificacionService
						.obtenerNotificacionesUsuario((Integer) req.getSession().getAttribute("ID"));
				req.setAttribute("notificacionesLista", notificacionesLista);

				model.addAttribute("perfilUsuarioUsername", perfil.getUsuario().getUsername());
				model.addAttribute("perfilImageUrl", perfil.getImageUrl());

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
