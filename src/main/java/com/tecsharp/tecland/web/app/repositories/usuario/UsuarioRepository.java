package com.tecsharp.tecland.web.app.repositories.usuario;

import java.util.List;

import com.tecsharp.tecland.web.app.models.Usuario;

public interface UsuarioRepository {

	Usuario findByUsername(String username);

	Integer obtenerNumeroDeUsuariosRegistrados();

	boolean registrarUsuario(String nombre, String apellido, String email, String username, String password);

	String obtenerPasswordHashed(String username);

	void actualizarBiografia(String biografia, Integer id);

	String getUserById(Integer id);

	Usuario checkUserExist(String username);

	List<Usuario> getAllUsers();
	
	void actualizarDineroUsuario(Usuario usuario);
	void actualizarPuntosDeTrabajoUsuario(Usuario usuario);
	void actualizarInfoAuthme(Usuario usuario);

	String obtieneUUID(Usuario usuario);
	
	

}
