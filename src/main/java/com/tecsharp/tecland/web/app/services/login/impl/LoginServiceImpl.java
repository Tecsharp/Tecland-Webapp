package com.tecsharp.tecland.web.app.services.login.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.tecsharp.tecland.web.app.models.Usuario;
import com.tecsharp.tecland.web.app.repositories.usuario.UsuarioRepository;
import com.tecsharp.tecland.web.app.repositories.usuario.impl.UsuarioRepositoryImpl;
import com.tecsharp.tecland.web.app.security.Sha256;
import com.tecsharp.tecland.web.app.services.login.LoginService;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;



@Component
@Qualifier("loginService")
public class LoginServiceImpl implements LoginService {
    @Override
    public Optional<String> getUsername(HttpServletRequest request) {
        return Optional.empty();
    }

    @Override
    public Optional<Integer> getId(HttpServletRequest request) {
        return Optional.empty();
    }

    @Override
    public Optional<String> getUser(HttpServletRequest request) {

        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        String password = (String) session.getAttribute("password");

        UsuarioRepository user = new UsuarioRepositoryImpl();
        if (obtenerAutorizacionComparandoPass(password, username)) {
            if (user.findByUsername(username) != null) {
                return Optional.of(username);
            }
            return Optional.empty();
        }
        return Optional.empty();
    }

    @Override
    public Optional<Integer> getUserType(HttpServletRequest request) {
        return Optional.empty();
    }

    @Override
    public boolean registrarUsuario(String name, String apellido, String email, String username, String password) {
        UsuarioRepository usuarioRepository = new UsuarioRepositoryImpl();
        return usuarioRepository.registrarUsuario(name, apellido, email, username, password);
    }

    @Override
    public Usuario obtenerUsuario(String password, String username) {

        UsuarioRepository user = new UsuarioRepositoryImpl();
        if (obtenerAutorizacionComparandoPass(password, username)) {
            Usuario usuario = user.findByUsername(username);
            return usuario;
        }


        return null;
    }

    @Override
    public boolean obtenerAutorizacionComparandoPass(String password, String username) {
        UsuarioRepository usuarioRepository = new UsuarioRepositoryImpl();
        String hashedPassword = usuarioRepository.obtenerPasswordHashed(username);
        Sha256 sha = new Sha256();
        return sha.comparePassword(password, hashedPassword, username);
    }


}
