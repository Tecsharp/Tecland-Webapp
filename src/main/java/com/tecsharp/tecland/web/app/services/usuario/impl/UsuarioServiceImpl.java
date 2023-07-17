package com.tecsharp.tecland.web.app.services.usuario.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.tecsharp.tecland.web.app.models.Usuario;
import com.tecsharp.tecland.web.app.repositories.usuario.UsuarioRepository;
import com.tecsharp.tecland.web.app.repositories.usuario.impl.UsuarioRepositoryImpl;
import com.tecsharp.tecland.web.app.services.usuario.UsuarioService;


@Service
@Primary
public class UsuarioServiceImpl implements UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
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

	@Override
	public Usuario findByUsername(String username) {
		
		Usuario usuario = usuarioRepository.findByUsername(username);
		
		return usuario;
	}

	@Override
	public void actualizarBiografia(String biografia, Integer id) {
		usuarioRepository.actualizarBiografia(biografia, id);
		
	}


}
