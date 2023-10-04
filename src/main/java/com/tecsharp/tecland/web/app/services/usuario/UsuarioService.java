package com.tecsharp.tecland.web.app.services.usuario;

import java.util.List;

import com.tecsharp.tecland.web.app.models.Usuario;



public interface UsuarioService {

	public Usuario login(String username, String password);
    
    public Usuario findByUsername(String username);
    
    public String findById(Integer id);
    
    public void actualizarBiografia(String biografia, Integer id);
    
    public Usuario checkUserExist(String username);
    
    public List<Usuario> getAllUsers();
    

}
