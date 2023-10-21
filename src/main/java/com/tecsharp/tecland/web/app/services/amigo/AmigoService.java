package com.tecsharp.tecland.web.app.services.amigo;

import com.tecsharp.tecland.web.app.models.Amigo;
import com.tecsharp.tecland.web.app.models.Notificacion;

import java.util.List;

public interface AmigoService {

    List<Amigo> obtenerListaDeAmigos(String busqueda, Integer userId);

    List<Amigo> obtenerListaAmigos(Integer usernameId);

    List<Amigo> compruebaAmigoAgregado(Integer usernameId);

    Boolean agregarAmigoLista(Integer usuarioEmisor, Integer usuarioReceptor);

    List<Notificacion> comprobacionDeSolicitud(Integer usuarioReceptor, Integer usuarioEmisor);

    Boolean registrarSolicitudDeAmistad(Integer usuarioEmisor, Integer usuarioReceptor);

    Boolean eliminarSolicitudDeAmistad(Integer usuarioEmisor, Integer usuarioReceptor);

    Boolean aceptarSolicitudDeAmistad(Integer usuarioEmisor, Integer usuarioReceptor);

    Boolean eliminarAmigo(Integer usuario, Integer usuarioAmigo);

    String recuperarLinkAvatarURL(String username);
}
