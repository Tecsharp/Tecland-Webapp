package com.tecsharp.tecland.web.app.controllers;

import java.io.IOException;
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

import com.tecsharp.tecland.web.app.models.Notificacion;
import com.tecsharp.tecland.web.app.models.Usuario;
import com.tecsharp.tecland.web.app.services.login.LoginService;
import com.tecsharp.tecland.web.app.services.login.impl.LoginServiceSessionImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@Controller
@RequestMapping("/")
public class PerfilController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Autowired
	@Qualifier("loginServiceSession")
	private LoginService loginService;
	
	
	@GetMapping({"/perfil"})
	public String login(HttpServletRequest req, HttpServletResponse resp, Model model) throws ServletException, IOException{
		LoginService auth = new LoginServiceSessionImpl();
		Optional<String> usernameOptional = auth.getUsername(req);
        Optional<Integer> userAdminOptional = auth.getUserType(req);
		Usuario user = (Usuario)model.getAttribute("usuario");
		
		
		if(user != null) {
			
			return "perfil";
			
		}
		
		return "redirect:/";
    }

}
