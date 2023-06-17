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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.tecsharp.tecland.web.app.models.Notificacion;
import com.tecsharp.tecland.web.app.models.Usuario;
import com.tecsharp.tecland.web.app.services.login.LoginService;
import com.tecsharp.tecland.web.app.services.login.impl.LoginServiceImpl;
import com.tecsharp.tecland.web.app.services.login.impl.LoginServiceSessionImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@Controller
@RequestMapping("/")
public class LoginController extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	
	@Autowired
	@Qualifier("loginService")
	private LoginService loginService;
	
	@GetMapping({"/login"})
	public String login(HttpServletRequest req, HttpServletResponse resp, Model model) throws ServletException, IOException{
		
		 LoginService auth = new LoginServiceSessionImpl();
	     Optional<String> usernameOptional = auth.getUsername(req);
	     Optional<Integer> userAdminOptional = auth.getUserType(req);
	     model.addAttribute("username", usernameOptional);
	     model.addAttribute("userAdminOptional", userAdminOptional);
		
		Usuario usuario = new Usuario();
		
		model.addAttribute("usuario", usuario);
		
        
		return "login";
		
    }
	
	@PostMapping({"/login-auth"})
	public String login2(HttpServletRequest req, HttpServletResponse resp, @RequestParam String username, String password, Model model) throws ServletException, IOException{

		HttpSession session = req.getSession();


            LoginService usr = new LoginServiceImpl();
            Usuario usuario = usr.obtenerUsuario(password, username);

            
            if (usuario != null) {
            	
                try {
                session.setAttribute("username", username);
                req.setAttribute("usuario", usuario); // add to request
                req.getSession().setAttribute("usuario", usuario); // add to session
                
                } catch (Exception e) {
                	return "redirect:/login";
                }
            	
                System.out.println("ALGO PASO");
                return "redirect:/perfil";

            } else {
            	return "redirect:/login";
            }
        

    }


}
