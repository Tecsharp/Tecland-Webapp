package com.tecsharp.tecland.web.app.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
@RequestMapping("/")
public class IndexController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	//@Autowired
	//private Usuario usuario;
	
	@Autowired
	private NotificacionService notificacionService;
	
	
	@GetMapping({"/index", "/"})
	public String index(Model model) throws ServletException, IOException{
        
      
		Usuario user = (Usuario) model.getAttribute("usuario");
		

        return "index";

    }

	

}
