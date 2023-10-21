package com.tecsharp.tecland.web.app.controllers;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tecsharp.tecland.web.app.models.Amigo;
import com.tecsharp.tecland.web.app.models.Notificacion;
import com.tecsharp.tecland.web.app.models.Perfil;
import com.tecsharp.tecland.web.app.services.amigo.AmigoService;
import com.tecsharp.tecland.web.app.services.notificacion.NotificacionService;
import com.tecsharp.tecland.web.app.services.perfil.PerfilService;
import com.tecsharp.tecland.web.app.utils.Constantes;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping({ "/" })
public class AmigoController implements Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	private AmigoService amigoService;

	@Autowired
	private NotificacionService notificacionService;

	@Autowired
	private PerfilService perfilService;

	@PostMapping({ "/perfil/buscar" })
	public String buscarAmigo(HttpServletRequest req, @RequestParam String busqueda, Model model)
			throws ServletException, IOException {

		String username = (String) req.getSession().getAttribute("USERNAME");
		Integer userId = (Integer) req.getSession().getAttribute("ID");
		if (username != null) {
			if (busqueda != null) {

				Perfil perfil = perfilService
						.obtenerPerfilDeUsuario((String) req.getSession().getAttribute("USERNAME"));
				model.addAttribute("perfil", perfil);
				model.addAttribute("perfilUsuarioLogged", perfilService.obtenerPerfilDeUsuario((String) req.getSession().getAttribute("USERNAME")));

				List<Amigo> listaBusquedaAmigos = amigoService.obtenerListaDeAmigos(busqueda, userId); //BUSCA AL USUARIO
				req.setAttribute("listaBusquedaAmigos", listaBusquedaAmigos); // SE ENVIA AL REQUEST

				List<Notificacion> notificacionesLista = notificacionService
						.obtenerNotificacionesUsuario((Integer) req.getSession().getAttribute("ID"));
				req.setAttribute("notificacionesLista", notificacionesLista);
				
				if(listaBusquedaAmigos.isEmpty()) {
					
					
					model.addAttribute("noUsuario", Constantes.NO_USER_FOUND + busqueda);
					return "busqueda";
				}

			}
		} else {
			return "redirect:/login";
		}

		return "busqueda";

	}

	@PostMapping({ "/aceptar-amigo" })
	public String aceptarAmigo(@RequestParam Integer idUsuarioSolicitud, HttpServletRequest req, Model model) {
		String usuario = (String) req.getSession().getAttribute("USERNAME");

		if (usuario != null) {
			amigoService.aceptarSolicitudDeAmistad(idUsuarioSolicitud, (Integer) req.getSession().getAttribute("ID"));

			return "redirect:/perfil";
		} else {
			return "redirect:/login";
		}
	}

	@PostMapping({ "/agregar-amigo" })
	public String agregarAmigo(@RequestParam String username, Integer userId, HttpServletRequest req, Model model) {
		String usuario = (String) req.getSession().getAttribute("USERNAME");
		if (notificacionService.mandaNotificacionAUsuarioAgregado(username,
				(Integer) req.getSession().getAttribute("ID"), userId)) {
			// REGISTRA A LA TABLA DE SOLICITUDES DE AMISTAD

			amigoService.registrarSolicitudDeAmistad((Integer) req.getSession().getAttribute("ID"), userId);
		} else {
			return "redirect:/perfil";
		}

		if (usuario != null) {
			return "redirect:/perfil";
		} else {
			return "redirect:/login";
		}
	}

	@PostMapping({ "/cancelar-solicitud" })
	public String cancelarsolicitudAmigo(@RequestParam Integer idUsuarioSolicitud, HttpServletRequest req,
			Model model) {

		String usuario = (String) req.getSession().getAttribute("USERNAME");
		if (usuario != null) {

			// CANCELA LA SOLICITUD DE AMISTAD
			amigoService.eliminarSolicitudDeAmistad((Integer) req.getSession().getAttribute("ID"), idUsuarioSolicitud);

			return "redirect:/perfil";
		} else {
			return "redirect:/login";
		}
	}

	@PostMapping({ "/eliminar-amigo" })
	public String eliminarAmigo(@RequestParam Integer idUsuarioSolicitud, HttpServletRequest req, Model model) {

		String usuario = (String) req.getSession().getAttribute("USERNAME");
		if (usuario != null) {

			amigoService.eliminarAmigo((Integer) req.getSession().getAttribute("ID"), idUsuarioSolicitud);

			return "redirect:/perfil";
		} else {
			return "redirect:/login";
		}
	}

}
