package com.tecsharp.tecland.web.app.controllers;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.tecsharp.tecland.web.app.models.Usuario;
import com.tecsharp.tecland.web.app.services.login.LoginService;
import com.tecsharp.tecland.web.app.services.login.impl.LoginServiceImpl;

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
	public String login(HttpServletRequest req, Model model) throws ServletException, IOException {
		Usuario usuario = null;
		try {
			HttpSession session = req.getSession();
			usuario = (Usuario) session.getAttribute("usuario"); // SE RECUPERA EL USUARIO
			req.getSession().setAttribute("usuario", usuario); // SE ENVIA AL REQUEST
		} catch (Exception e) {

		}

		usuario = new Usuario(); // NECESITA UN USUARIO VACIO
		model.addAttribute("usuario", usuario);// ENVIA EL USUARIO VACIO A L

		return "login";

	}

	@PostMapping({ "/login-auth" })
	public String loginAuth(HttpServletRequest req, @RequestParam String username, String password, Model model) throws ServletException, IOException {

		Usuario usuario = loginService.obtenerUsuario(password, username);
		req.getSession().setAttribute("usuario", usuario);

		if (usuario != null) {
			
			return "forward:/cuenta";

		} else {
			return "redirect:/login";
		}

	}

	

}
