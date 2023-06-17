package com.tecsharp.tecland.web.app.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Constantes {

    public static final String DB_PROPERTIES = "jdbc:mysql://localhost:3306/tecland?user=root&password=";
    private static final String url = "jdbc:mysql://localhost:3306/tecland?serverTimeZone=UTC";
    private static final String username = "root";
    private static final String password = "";

    public static Connection getConnection() throws SQLException {

        return DriverManager.getConnection(url, username, password);

    }
}
