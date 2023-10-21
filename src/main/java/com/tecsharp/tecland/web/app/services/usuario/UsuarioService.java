package com.tecsharp.tecland.web.app.services.usuario;

import java.util.List;

import com.tecsharp.tecland.web.app.models.Usuario;

public interface UsuarioService {

	Usuario login(String username, String password);

	Usuario findByUsername(String username);

	String findById(Integer id);

	void actualizarBiografia(String biografia, Integer id);

	Usuario checkUserExist(String username);

	List<Usuario> getAllUsers();
	
	void ActualizaPerfilUsuario(Usuario usuario);

}
