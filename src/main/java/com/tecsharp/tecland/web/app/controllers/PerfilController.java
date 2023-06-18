package com.tecsharp.tecland.web.app.controllers;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.tecsharp.tecland.web.app.models.Notificacion;
import com.tecsharp.tecland.web.app.models.Usuario;
import com.tecsharp.tecland.web.app.services.login.LoginService;
import com.tecsharp.tecland.web.app.services.login.impl.LoginServiceSessionImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/")
public class PerfilController implements Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	@Qualifier("loginServiceSession")
	private LoginService loginService;

	@GetMapping({ "/perfil" })
	public String login(HttpServletRequest req, HttpSession session, RedirectAttributes redirectAttributes, Model model) throws ServletException, IOException {
		Usuario user = (Usuario) model.getAttribute("usuario");

		try {
			Optional<String> usernameOptional = loginService.getUsername(req);
			if (usernameOptional.isPresent()) {

				return "perfil";

			} else {
				return "redirect:/";
			}
		} catch (Exception e) {
			return "redirect:/";
		}

	}

}
