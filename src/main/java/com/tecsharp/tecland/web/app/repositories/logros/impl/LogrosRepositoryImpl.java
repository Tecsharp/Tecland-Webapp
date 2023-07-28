package com.tecsharp.tecland.web.app.repositories.logros.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.Date;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.tecsharp.tecland.web.app.models.Logro;
import com.tecsharp.tecland.web.app.models.Usuario;
import com.tecsharp.tecland.web.app.repositories.logros.LogrosRepository;
import com.tecsharp.tecland.web.app.services.perfil.PerfilService;
import com.tecsharp.tecland.web.app.services.perfil.impl.PerfilServiceImpl;
import com.tecsharp.tecland.web.app.utils.Constantes;


@Component
public class LogrosRepositoryImpl implements LogrosRepository{
	
	PerfilService perfilService = new PerfilServiceImpl();

	@Override
	public List<Logro> obtenerListaLogros(String username) {
		
        String query = "select * from achievements where username = ?";

        List<Logro> listaLogros = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(Constantes.DB_PROPERTIES);
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, username);
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                Logro logro = new Logro();
               
                String achievement = result.getString("achievement");
                logro.setUsername(result.getString("username"));
                Date date = result.getDate("date");
                
                if(achievement.equals("distancefoot_1000") || achievement.equals("connect_1") || 
                		achievement.equals("maxlevel_10") || achievement.equals("kills_1_zombie")) {
                
                	if(achievement.equals("distancefoot_1000")){
                		logro.setUrl("https://rol4.fenixzone.com/imagenes/logros/10.png");
                		logro.setAchievement("El caminante");
                		logro.setDate(perfilService.convertirDateToString(date));
                		logro.setDescripcion("Recorrer 1000 bloques");
                		
                	} else if(achievement.equals("connect_1")){
                		logro.setUrl("https://rol4.fenixzone.com/imagenes/logros/11.png");
                		logro.setAchievement("La Bienvenida");
                		logro.setDate(perfilService.convertirDateToString(date));
                		logro.setDescripcion("Conexión por primera vez");
                		
                	} else if(achievement.equals("maxlevel_10")){
                		logro.setUrl("https://rol4.fenixzone.com/imagenes/logros/11.png");
                		logro.setAchievement("Nivel 10");
                		logro.setDate(perfilService.convertirDateToString(date));
                		logro.setDescripcion("Llega al nivel 10");
                		
                	} else if(achievement.equals("kills_1_zombie")){
                		logro.setUrl("https://rol4.fenixzone.com/imagenes/logros/11.png");
                		logro.setAchievement("Mata Podridos");
                		logro.setDate(perfilService.convertirDateToString(date));
                		logro.setDescripcion("Mata tu primer zombie");
                	}
                	
                	listaLogros.add(logro);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
		return listaLogros;
	}

}
