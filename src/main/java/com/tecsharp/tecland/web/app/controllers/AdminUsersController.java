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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tecsharp.tecland.web.app.models.Amigo;
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
public class AdminUsersController implements Serializable {

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

	@GetMapping({ "/admin/users" })
	public String adminUserPage(HttpServletRequest req, Model model) throws ServletException, IOException {

		String username = (String) req.getSession().getAttribute("USERNAME");
		req.getSession().setAttribute("USERNAME", username);
		if (username != null) {

			try {

				Perfil perfil = perfilService.obtenerPerfilDeUsuario((String) req.getSession().getAttribute("USERNAME"));
				model.addAttribute("perfil", perfil);

				List<Amigo> amigosLista = amigoService.obtenerListaAmigos(perfil.getUsuario().getId());
				model.addAttribute("amigosLista", amigosLista);

				List<Notificacion> notificacionesLista = notificacionService
						.obtenerNotificacionesUsuario((Integer) req.getSession().getAttribute("ID"));
				req.setAttribute("notificacionesLista", notificacionesLista);

				
				model.addAttribute("listaUsuarios", usuarioService.getAllUsers());
				model.addAttribute("perfilUsuarioLogged", perfilService.obtenerPerfilDeUsuario(username));
				
				
			} catch (Exception e) {
				return "redirect:/login";
			}
			return "admin-usuarios";

		} else {
			return "redirect:/login";
		}
	}
	
//	@PostMapping({ "/admin/users/update/info" })
//	public String updateInfoUsers(HttpServletRequest req, @RequestParam String username) throws ServletException, IOException {
//		
//		Usuario user = usuarioService.findByUsername(username);
//		
//		
//		return "user";
//		
//	}
	
	
	@GetMapping({ "/admin/users/update/info" })
	public String getUpdateInfoUser(HttpServletRequest req, Model model, @RequestParam String usernameUpdate) throws ServletException, IOException {

		String username = (String) req.getSession().getAttribute("USERNAME");
		req.getSession().setAttribute("USERNAME", username);
		if (username != null) {

			try {

				Perfil perfil = perfilService.obtenerPerfilDeUsuario((String) req.getSession().getAttribute("USERNAME"));
				model.addAttribute("perfil", perfil);
				
				if(perfil.getUsuario().getIsAdmin() == 0) {
					
					model.addAttribute("mensaje", Constantes.NO_ADMIN_USER);
					return "redirect:/error";
				}


				List<Notificacion> notificacionesLista = notificacionService
						.obtenerNotificacionesUsuario((Integer) req.getSession().getAttribute("ID"));
				req.setAttribute("notificacionesLista", notificacionesLista);
				
				model.addAttribute("perfilUsuarioLogged", perfilService.obtenerPerfilDeUsuario(username));
				
				model.addAttribute("userInfoObj", new Usuario());
				
				
				if(usernameUpdate != null) {
					
					Perfil perfilUsuario = perfilService.obtenerPerfilDeUsuario(usernameUpdate);
					
					model.addAttribute("userInfo", perfilUsuario);
					model.addAttribute("textHead" , "Modificar información de usuario");
					model.addAttribute("textInterhead", "Infomación de " + perfilUsuario.getUsuario().getUsername());
				} else {
					return "redirect:/admin/users/update/info";
				}
				
				
				
				
				
			} catch (Exception e) {
				return "redirect:/login";
			}
			return "infouser-form";

		} else {
			return "redirect:/login";
		}
	}

	@PostMapping({ "/admin/users/update/info" })
	public String getUpdateInfoUser(HttpServletRequest req, @ModelAttribute Usuario userInfoObj) throws ServletException, IOException {
		
		usuarioService.ActualizaPerfilUsuario(userInfoObj);
		
		return "redirect:/admin/users/update/info" + "?usernameUpdate=" + userInfoObj.getUsername();
	
	}

}
