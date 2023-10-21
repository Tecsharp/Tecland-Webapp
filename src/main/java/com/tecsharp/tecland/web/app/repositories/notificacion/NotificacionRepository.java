package com.tecsharp.tecland.web.app.repositories.notificacion;

import com.tecsharp.tecland.web.app.models.Notificacion;

import java.util.List;

public interface NotificacionRepository {

    Boolean mandaNotificacionAUsuarioAgregado(String username, Integer usernameId, Integer amigoId);

    List<Notificacion> obtenerNotificacionesUsuario(Integer usuarioId);

    Boolean eliminarNotificacionAgregarAmigo(Integer usuarioId, Integer amigoId);

    Boolean deshabilitarNotificacionSolicitudAmistad(Integer usuarioId, Integer amigoId);
}
