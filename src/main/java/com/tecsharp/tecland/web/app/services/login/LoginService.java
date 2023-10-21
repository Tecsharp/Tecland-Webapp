package com.tecsharp.tecland.web.app.services.login;

import javax.servlet.http.HttpServletRequest;
import com.tecsharp.tecland.web.app.models.Usuario;

import java.util.Optional;


//import javax.servlet.http.HttpServletRequest;


public interface LoginService {
	
    Optional<String> getUsername(HttpServletRequest request);

    Optional<Integer> getId(HttpServletRequest request);

    Optional<String> getUser(HttpServletRequest username);

    Optional<Integer> getUserType(HttpServletRequest request);

    boolean registrarUsuario(String nombre, String apellido, String email, String username, String password);

    Usuario obtenerUsuario(String password, String username);

    boolean obtenerAutorizacionComparandoPass(String password, String username);


}
