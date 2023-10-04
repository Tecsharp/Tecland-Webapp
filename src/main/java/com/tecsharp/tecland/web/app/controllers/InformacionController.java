package com.tecsharp.tecland.web.app.controllers;

import java.io.IOException;
import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tecsharp.tecland.web.app.services.informacion.InformacionService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping({ "" })
public class InformacionController implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private InformacionService infoService;
	
	@GetMapping({ "/informacion" })
	public String buscarAmigo(HttpServletRequest req, Model model)
			throws ServletException, IOException {
		
		String info = infoService.recuperarInformacion(1);
		model.addAttribute(info, info);

		return "informacion";

	}

}
