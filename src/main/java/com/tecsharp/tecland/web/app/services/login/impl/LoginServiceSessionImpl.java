package com.tecsharp.tecland.web.app.services.login.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession; 
import com.tecsharp.tecland.web.app.models.Usuario;
import com.tecsharp.tecland.web.app.services.login.LoginService;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


@Component
@Qualifier("loginServiceSession")
public class LoginServiceSessionImpl implements LoginService {
    @Override
    public Optional<String> getUsername(HttpServletRequest request) {
        try {
        	
    	HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        if (username != null) {
            return Optional.of(username);
        }
        } catch (Exception e){
        	return Optional.empty();
        }
        return Optional.empty();
    }

    public Optional<Integer> getId(HttpServletRequest request) {
    	try {
        HttpSession session = request.getSession();
        Integer idUser = (Integer) session.getAttribute("idUser");
        if (idUser != null) {
            return Optional.of(idUser);
        }
        return Optional.empty();
    	} catch (Exception e) {
        	return Optional.empty();
        	
        }
    }

    public Optional<Integer> getUserType(HttpServletRequest request) {
        try {
    	HttpSession session = request.getSession();
        Integer userType = (Integer) session.getAttribute("userType");
        if (userType != null) {
            return Optional.of(userType);
        }
        return Optional.empty();
        } catch (Exception e) {
        	return Optional.empty();
        	
        }
    }

    @Override
    public boolean registrarUsuario(String name, String apellido, String email, String username, String password) {
        return false;
    }

    @Override
    public Usuario obtenerUsuario(String password, String username) {
        return null;
    }

    @Override
    public boolean obtenerAutorizacionComparandoPass(String password, String username) {
        return false;
    }

    @Override
    public Optional<String> getUser(HttpServletRequest request) {
        return Optional.empty();
    }


}
