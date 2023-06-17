package com.tecsharp.tecland.web.app.services.login;

import jakarta.servlet.http.HttpServletRequest;
import com.tecsharp.tecland.web.app.models.Usuario;

import java.util.Optional;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

//import javax.servlet.http.HttpServletRequest;


public interface LoginService {
	
    Optional<String> getUsername(HttpServletRequest request);

    Optional<Integer> getId(HttpServletRequest request);

    Optional<String> getUser(HttpServletRequest request);

    Optional<Integer> getUserType(HttpServletRequest request);

    boolean registrarUsuario(String nombre, String apellido, String email, String username, String password);

    Usuario obtenerUsuario(String password, String username);

    boolean obtenerAutorizacionComparandoPass(String password, String username);


}
