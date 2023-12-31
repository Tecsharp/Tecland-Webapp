package com.tecsharp.tecland.web.app.services.amigo.impl;

import com.tecsharp.tecland.web.app.models.Amigo;
import com.tecsharp.tecland.web.app.models.Notificacion;
import com.tecsharp.tecland.web.app.repositories.amigo.AmigoRepository;
import com.tecsharp.tecland.web.app.repositories.amigo.impl.AmigoRepositoryImpl;
import com.tecsharp.tecland.web.app.repositories.notificacion.NotificacionRepository;
import com.tecsharp.tecland.web.app.repositories.notificacion.impl.NotificacionRepositoryImpl;
import com.tecsharp.tecland.web.app.services.amigo.AmigoService;
import com.tecsharp.tecland.web.app.services.notificacion.NotificacionService;
import com.tecsharp.tecland.web.app.services.notificacion.impl.NotificacionServiceImpl;
import com.tecsharp.tecland.web.app.utils.Constantes;

import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;


@Service
@Primary
public class AmigoServiceImpl implements AmigoService {
    AmigoRepository amigoRepository = new AmigoRepositoryImpl();

    @Override
    public List<Amigo> obtenerListaDeAmigos(String busqueda, Integer userId) {


        List<Amigo> amigos = amigoRepository.obtenerListaDeAmigosEnBusqueda(busqueda);
        for (Amigo a : amigos) {
            a.setIsFriend(amigoRepository.obtieneIsFriend(userId, a.getId()));
            a.setSolicitudPendiente(amigoRepository.obtieneSolicitudPendiente(userId, a.getId()));
            a.setSolicitudEnviada(amigoRepository.obtieneSolicitudEnviada(userId, a.getId()));
            a.setImageUrl(recuperarLinkAvatarURL(a.getNombre()));
        }
 
        return amigos;
    }

    @Override
    public List<Amigo> obtenerListaAmigos(Integer usernameId) {
    	List <Amigo> lista = amigoRepository.obtenerAmigos(usernameId);
    	for (Amigo a : lista) {
            a.setImageUrl(recuperarLinkAvatarURL(a.getNombre()));
        }
        return lista;
    }

    @Override
    public List<Amigo> compruebaAmigoAgregado(Integer usernameId) {


        return null;
    }

    @Override
    public Boolean agregarAmigoLista(Integer usuarioId, Integer amigoId) {

        if (amigoRepository.agregarAmigoLista(usuarioId, amigoId)) {
            return true;
        }

        return null;
    }

    @Override
    public List<Notificacion> comprobacionDeSolicitud(Integer userId, Integer usuarioId) {
        NotificacionRepository notificacionRepository = new NotificacionRepositoryImpl();
        List<Notificacion> listaNotificaciones = notificacionRepository.obtenerNotificacionesUsuario(usuarioId);

        return listaNotificaciones;
    }

    @Override
    public Boolean registrarSolicitudDeAmistad(Integer usuarioEmisor, Integer usuarioReceptor) {
        return amigoRepository.registrarSolicitudDeAmistad(usuarioEmisor, usuarioReceptor);
    }

    @Override
    public Boolean eliminarSolicitudDeAmistad(Integer usuarioEmisor, Integer usuarioReceptor) {
        NotificacionService notificacionService = new NotificacionServiceImpl();
        try {
            //ELIMINA LA SOLICITUD DE AMISTAD
            if (amigoRepository.eliminarSolicitudDeAmistad(usuarioEmisor, usuarioReceptor)) {
                //ELIMINA LA NOTIFICACION
                if (notificacionService.eliminarNotificacionAgregarAmigo(usuarioEmisor, usuarioReceptor)) {
                    return true;
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return false;
    }

    @Override
    public Boolean aceptarSolicitudDeAmistad(Integer usuarioEmisor, Integer usuarioReceptor) {
        //REGISTRAR AMIGO EN EL USUARIO RECEPTOR
        //REGISTRA USUARIO EMISOR PRIMERO

        try {
            amigoRepository.aceptarSolicitudDeAmistad(usuarioEmisor, usuarioReceptor);
            //REGISTRA USUARIO RECEPTOR SEGUNDO
            amigoRepository.aceptarSolicitudDeAmistad(usuarioReceptor, usuarioEmisor);

            //ELIMINAR LA SOLICITUD DE AMISTAD INICIAL
            amigoRepository.eliminarSolicitudDeAmistad(usuarioEmisor, usuarioReceptor);

            //DESHABILITAR LA NOTIFICACION
            NotificacionService notificacionService = new NotificacionServiceImpl();
            notificacionService.deshabilitarNotificacionSolicitudAmistad(usuarioReceptor, usuarioEmisor);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }



        return true;
    }

    @Override
    public Boolean eliminarAmigo(Integer usuario, Integer usuarioAmigo) {
        if(amigoRepository.eliminarAmigo(usuario, usuarioAmigo)){
            if (amigoRepository.eliminarAmigo(usuarioAmigo, usuario)){
                return true;
            }
        }

        return false;
    }

    @Override
	public String recuperarLinkAvatarURL(String username) {
		
		return Constantes.URL_IMG_AVATAR + username + ".png";
	}
    

}
