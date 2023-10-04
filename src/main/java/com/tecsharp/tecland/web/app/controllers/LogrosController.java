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
import org.springframework.web.bind.annotation.RequestMapping;
import com.tecsharp.tecland.web.app.models.Logro;
import com.tecsharp.tecland.web.app.models.Notificacion;
import com.tecsharp.tecland.web.app.models.Perfil;
import com.tecsharp.tecland.web.app.services.login.LoginService;
import com.tecsharp.tecland.web.app.services.notificacion.NotificacionService;
import com.tecsharp.tecland.web.app.services.perfil.PerfilService;
import com.tecsharp.tecland.web.app.services.trabajo.TrabajoService;

@Controller
@RequestMapping("")
public class LogrosController implements Serializable {

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
	private NotificacionService notificacionService;

	@GetMapping({ "/logros" })
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


				ArrayList<Notificacion> notificacionesLista = notificacionService
						.obtenerNotificacionesUsuario((Integer) req.getSession().getAttribute("ID"));
				req.setAttribute("notificacionesLista", notificacionesLista);

				model.addAttribute("perfilUsuarioUsername", perfil.getUsuario().getUsername());
				model.addAttribute("perfilUsuarioLogged", perfilService.obtenerPerfilDeUsuario(username));
				model.addAttribute("perfilImageUrl", perfil.getImageUrl());
				

			} catch (Exception e) {
				return "redirect:/login";
			}
			return "logros";

		} else {
			return "redirect:/login";
		}
	}



}
