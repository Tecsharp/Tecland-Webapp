package com.tecsharp.tecland.web.app.utils;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tecsharp.tecland.web.app.models.Usuario;
import com.tecsharp.tecland.web.app.repositories.usuario.UsuarioRepository;

@Component
public class Utilidades {

	public static String formatearPrecio(Integer precio) {
		DecimalFormat formatea = new DecimalFormat("###,###,###");
		return formatea.format(precio);
	}

	public static String recuperarLinkAvatarURL(String username) {

		return Constantes.URL_IMG_AVATAR + username + ".png";
	}

	public static String convertirLongToDate(Long fecha) {

		// long fecha = 1346524199000l;
		Date date = new Date(fecha);
		SimpleDateFormat df2 = new SimpleDateFormat("EEEE dd 'de' MMMM 'del' YYYY");
		String dateText = df2.format(date);

		return dateText;
	}

}
