package com.tecsharp.tecland.web.app.controllers;



import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class ErroresControllers implements ErrorController {

	

	@GetMapping({ "/error" })
	public String getErrorPath() {
		

		
		return "error-404";
	}
	

}
