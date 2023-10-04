package com.tecsharp.tecland.web.app.services.notificacion;

import com.tecsharp.tecland.web.app.models.Notificacion;

import java.util.ArrayList;

public interface NotificacionService {

	public Boolean mandaNotificacionAUsuarioAgregado(String username, Integer usernameId, Integer amigoId);

	public ArrayList<Notificacion> obtenerNotificacionesUsuario(Integer usuarioId);

	public Boolean eliminarNotificacionAgregarAmigo(Integer usuarioId, Integer amigoId);

	public Boolean deshabilitarNotificacionSolicitudAmistad(Integer usuarioId, Integer amigoId);
}
