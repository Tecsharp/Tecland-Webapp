package com.tecsharp.tecland.web.app.repositories.usuario;


import java.util.List;

import com.tecsharp.tecland.web.app.models.Usuario;

public interface UsuarioRepository {

    public Usuario findByUsername(String username);

    public Integer obtenerNumeroDeUsuariosRegistrados();

    boolean registrarUsuario(String nombre, String apellido, String email, String username, String password);

    public String obtenerPasswordHashed(String username);
    
    public void actualizarBiografia(String biografia, Integer id);
    
    public String getUserById(Integer id);
    
    public Usuario checkUserExist(String username);
    
    public List<Usuario> getAllUsers();
    

}
