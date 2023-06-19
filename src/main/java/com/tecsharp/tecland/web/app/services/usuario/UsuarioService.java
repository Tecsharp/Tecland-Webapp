package com.tecsharp.tecland.web.app.services.usuario;

import com.tecsharp.tecland.web.app.models.Usuario;



public interface UsuarioService {

    Usuario login(String username, String password);
    
    Usuario findByUsername(String username);


}
