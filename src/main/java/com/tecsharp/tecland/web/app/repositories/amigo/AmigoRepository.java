package com.tecsharp.tecland.web.app.repositories.amigo;

import com.tecsharp.tecland.web.app.models.Amigo;

import java.util.List;

public interface AmigoRepository {

    List<Amigo> obtenerAmigos(Integer usernameId);

    Integer obtenerEstadoConexionDeAmigo(String username);

    List<Amigo> obtenerListaDeAmigosEnBusqueda(String username);

    Boolean obtieneIsFriend(Integer usuarioEmisor, Integer usuarioReceptor);

    Boolean obtieneSolicitudPendiente(Integer usuarioEmisor, Integer usuarioReceptor);

    Boolean obtieneSolicitudEnviada(Integer usuarioEmisor, Integer usuarioReceptor);

    Boolean agregarAmigoLista(Integer usuarioEmisor, Integer usuarioReceptor);

    Boolean registrarSolicitudDeAmistad(Integer usuarioEmisor, Integer usuarioReceptor);

    Boolean eliminarSolicitudDeAmistad(Integer usuarioEmisor, Integer usuarioReceptor);

    Boolean aceptarSolicitudDeAmistad(Integer usuarioEmisor, Integer usuarioReceptor);

    Boolean eliminarAmigo(Integer usuario, Integer usuarioAmigo);

}
