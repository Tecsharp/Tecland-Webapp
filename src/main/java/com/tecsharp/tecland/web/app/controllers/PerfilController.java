package com.tecsharp.tecland.web.app.controllers;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.tecsharp.tecland.web.app.models.Amigo;
import com.tecsharp.tecland.web.app.models.Notificacion;
import com.tecsharp.tecland.web.app.models.Perfil;
import com.tecsharp.tecland.web.app.models.Usuario;
import com.tecsharp.tecland.web.app.services.amigo.AmigoService;
import com.tecsharp.tecland.web.app.services.login.LoginService;
import com.tecsharp.tecland.web.app.services.login.impl.LoginServiceSessionImpl;
import com.tecsharp.tecland.web.app.services.notificacion.NotificacionService;
import com.tecsharp.tecland.web.app.services.perfil.PerfilService;
import com.tecsharp.tecland.web.app.services.trabajo.TrabajoService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

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
	private AmigoService amigoService;
	
	@Autowired
	private NotificacionService notificacionService;

	@GetMapping({ "/perfil" })
	public String toPerfil(HttpServletRequest req, Model model) throws ServletException, IOException {

		
		String username = (String) req.getSession().getAttribute("USERNAME");
		req.getSession().setAttribute("USERNAME", username);
		if (username != null) {
			

			try {
				
				Perfil perfil = perfilService.obtenerPerfilDeUsuario((String) req.getSession().getAttribute("USERNAME"));
				model.addAttribute("perfil", perfil);
				model.addAttribute("trabajosActivos", trabajoService.obtenerTrabajosActivos(perfil.getUsuario().getId()));
				model.addAttribute("trabajosNoActivos", trabajoService.obtenerTrabajosNoActivos(perfil.getUsuario().getId()));
				
				ArrayList<Amigo> amigosLista = amigoService.obtenerListaAmigos(perfil.getUsuario().getId());
				model.addAttribute("amigosLista", amigosLista);
				
				ArrayList<Notificacion> notificacionesLista = notificacionService.obtenerNotificacionesUsuario((Integer)req.getSession().getAttribute("ID"));
				req.setAttribute("notificacionesLista", notificacionesLista);
				
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
	
	
	
	@GetMapping("/{perfil}")
	public String buscaPerfil(@PathVariable String perfil, Model model) {
		
		
		
		return "presentacion";
	}
	

}
