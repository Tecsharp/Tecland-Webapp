package com.tecsharp.tecland.web.app.controllers;

import java.io.IOException;
import java.io.Serializable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tecsharp.tecland.web.app.models.Usuario;
import com.tecsharp.tecland.web.app.services.login.LoginService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/")
public class LoginController implements Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	@Qualifier("loginService")
	private LoginService loginService;

	@GetMapping({ "/login" })
	public String login(HttpServletRequest req, Model model, HttpSession session) throws ServletException, IOException {

		String user = (String) req.getSession().getAttribute("USERNAME"); // SE OBTIENE EL USUARIO DE LA SESION
		if (user != null) {
			model.addAttribute("user", user); // SE MANDA A LA VISTA HTML
			return "redirect:/perfil";
		} else {
			return "login";
		}

	}

	@PostMapping({ "/login-auth" })
	public String loginAuth(HttpServletRequest req, @RequestParam String username, String password)
			throws ServletException, IOException {
		String user = (String) req.getSession().getAttribute("USERNAME");
		if (user == null) {
			try {

				Usuario usuario = loginService.obtenerUsuario(password, username);
				if (usuario != null) {

					req.getSession().setAttribute("ID", usuario.getId());
					req.getSession().setAttribute("USERNAME", usuario.getUsername());
					return "redirect:/perfil";

				} else {
					return "redirect:/login";
				}
			} catch (Exception e) {

			}
			return "redirect:/login";

		} else {
			return "redirect:/perfil";
		}

	}

}
