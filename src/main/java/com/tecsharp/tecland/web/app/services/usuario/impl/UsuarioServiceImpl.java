package com.tecsharp.tecland.web.app.services.usuario.impl;

import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.tecsharp.tecland.web.app.models.Usuario;
import com.tecsharp.tecland.web.app.repositories.usuario.UsuarioRepository;
import com.tecsharp.tecland.web.app.repositories.usuario.impl.UsuarioRepositoryImpl;
import com.tecsharp.tecland.web.app.services.usuario.UsuarioService;


@Service
@Primary
public class UsuarioServiceImpl implements UsuarioService {
	
	UsuarioRepository usuarioRepository = new UsuarioRepositoryImpl();
	
    @Override
    public Usuario login(String username, String password) {
        UsuarioRepositoryImpl repository = new UsuarioRepositoryImpl();

        Usuario usuario = repository.findByUsername(username);
        if (!islogged(usuario)) {
            return usuario;
        }


        return usuario;
    }

    private boolean islogged(Usuario usuario) {

        if (usuario != null) {
            return true;
        } else {
            
            return false;
        }


    }

	@Override
	public Usuario findByUsername(String username) {
		
		Usuario usuario = usuarioRepository.findByUsername(username);
		
		return usuario;
	}
	
	@Override
	public String findById(Integer id) {
		
		String name = usuarioRepository.getUserById(id);
		
		return name;
	}

	@Override
	public void actualizarBiografia(String biografia, Integer id) {
		usuarioRepository.actualizarBiografia(biografia, id);
		
	}

	@Override
	public Usuario checkUserExist(String username) {
		
		return usuarioRepository.checkUserExist(username);
	}

	@Override
	public List<Usuario> getAllUsers() {
		List<Usuario> ListUsers = usuarioRepository.getAllUsers();
		
		
		
		return ListUsers;
	}

	@Override
	public void ActualizaPerfilUsuario(Usuario usuario) {
		usuario.setUUID(usuarioRepository.obtieneUUID(usuario));
		usuarioRepository.actualizarDineroUsuario(usuario);
		usuarioRepository.actualizarInfoAuthme(usuario);
		usuarioRepository.actualizarPuntosDeTrabajoUsuario(usuario);
		
	}


}
