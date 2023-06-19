package com.tecsharp.tecland.web.app.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tecsharp.tecland.web.app.models.Amigo;
import com.tecsharp.tecland.web.app.models.Notificacion;
import com.tecsharp.tecland.web.app.models.Usuario;
import com.tecsharp.tecland.web.app.services.amigo.AmigoService;
import com.tecsharp.tecland.web.app.services.login.LoginService;
import com.tecsharp.tecland.web.app.services.login.impl.LoginServiceSessionImpl;
import com.tecsharp.tecland.web.app.services.notificacion.NotificacionService;
import com.tecsharp.tecland.web.app.services.usuario.UsuarioService;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping({ "/" })
public class AmigoController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Autowired
	private AmigoService amigoService;

	@Autowired
	private NotificacionService notificacionService;
	
	

	@PostMapping({ "/buscar" })
	public String buscarAmigo(@RequestParam String busqueda, HttpServletRequest req, Model model)
			throws ServletException, IOException {

		if (req.getSession().getAttribute("USERNAME") != null) {

			
			ArrayList<Amigo> listaBusquedaAmigos = amigoService.obtenerListaDeAmigos(busqueda, (Integer)req.getSession().getAttribute("ID"));
			req.setAttribute("listaBusquedaAmigos", listaBusquedaAmigos); // SE ENVIA AL REQUEST

			
			ArrayList<Notificacion> notificacionesLista = notificacionService.obtenerNotificacionesUsuario((Integer)req.getSession().getAttribute("ID"));
			req.setAttribute("notificacionesLista", notificacionesLista);

		} else {
			return "/";
		}

		return "buscar";

	}
	
	@GetMapping({"/aceptar"})
	public String aceptarAmigo(@RequestParam String userId, HttpServletRequest req, Model model) {
		
		String id = userId;
		
		return "/";
	}

}
