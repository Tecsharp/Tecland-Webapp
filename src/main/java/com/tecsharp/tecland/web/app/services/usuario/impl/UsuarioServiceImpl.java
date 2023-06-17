package com.tecsharp.tecland.web.app.services.usuario.impl;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.tecsharp.tecland.web.app.models.Usuario;
import com.tecsharp.tecland.web.app.repositories.usuario.impl.UsuarioRepositoryImpl;
import com.tecsharp.tecland.web.app.services.usuario.UsuarioService;


@Service
@Primary
public class UsuarioServiceImpl implements UsuarioService {
    @Override
    public Usuario login(String username, String password) {
        UsuarioRepositoryImpl repository = new UsuarioRepositoryImpl();

        Usuario usuario = repository.findByUsername(username);
        if (!islogged(usuario)) {
            return usuario;
        }

//        if (!isActive(usuario)) {
//            return null;
//        }

        return usuario;
    }

    private boolean islogged(Usuario usuario) {

        if (usuario != null) {
            return true;
        } else {
            System.out.println("No se encontro el usuario");
            return false;
        }


    }


}
