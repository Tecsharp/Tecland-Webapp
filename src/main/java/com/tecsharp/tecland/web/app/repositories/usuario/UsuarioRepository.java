package com.tecsharp.tecland.web.app.repositories.usuario;


import com.tecsharp.tecland.web.app.models.Usuario;

public interface UsuarioRepository {

    Usuario findByUsername(String username);

    Integer obtenerNumeroDeUsuariosRegistrados();

    boolean registrarUsuario(String nombre, String apellido, String email, String username, String password);

    String obtenerPasswordHashed(String username);
}
