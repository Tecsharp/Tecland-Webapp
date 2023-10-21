package com.tecsharp.tecland.web.app.controllers;

import java.io.IOException;
import java.io.Serializable;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;


@Controller
@RequestMapping({"/", "/index"})
public class IndexController implements Serializable {
	
	private static final long serialVersionUID = -2105642709837992463L;

	@GetMapping({"/index", "/"})
	public String index(HttpServletRequest req, Model model) throws ServletException, IOException{
        		

        return "index";

    }

	

}
