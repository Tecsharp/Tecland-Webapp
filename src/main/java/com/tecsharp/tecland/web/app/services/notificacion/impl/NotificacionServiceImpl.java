package com.tecsharp.tecland.web.app.services.notificacion.impl;

import com.tecsharp.tecland.web.app.models.Notificacion;
import com.tecsharp.tecland.web.app.repositories.notificacion.NotificacionRepository;
import com.tecsharp.tecland.web.app.repositories.notificacion.impl.NotificacionRepositoryImpl;
import com.tecsharp.tecland.web.app.services.notificacion.NotificacionService;

import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class NotificacionServiceImpl implements NotificacionService {

	NotificacionRepository notificacionRepository = new NotificacionRepositoryImpl();

	@Override
	public Boolean mandaNotificacionAUsuarioAgregado(String username, Integer usernameId, Integer amigoId) {

		return notificacionRepository.mandaNotificacionAUsuarioAgregado(username, usernameId, amigoId);
	}

	@Override
	public List<Notificacion> obtenerNotificacionesUsuario(Integer usuarioId) {
		List<Notificacion> listaNotificaciones = notificacionRepository.obtenerNotificacionesUsuario(usuarioId);

		return listaNotificaciones;
	}

	@Override
	public Boolean eliminarNotificacionAgregarAmigo(Integer usuarioId, Integer amigoId) {
		return notificacionRepository.eliminarNotificacionAgregarAmigo(usuarioId, amigoId);
	}

	@Override
	public Boolean deshabilitarNotificacionSolicitudAmistad(Integer usuarioId, Integer amigoId) {

		return notificacionRepository.deshabilitarNotificacionSolicitudAmistad(usuarioId, amigoId);
	}
}
