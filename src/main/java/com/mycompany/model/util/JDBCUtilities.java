package com.mycompany.model.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCUtilities {
    // Atributos de clase para gestión de conexión con la base de datos SQLite
    private static final String UBICACION_BD = "D:\\Users\\sebas\\Documents\\Education\\MisionTic2022\\Ciclo2\\Programacion\\Retos\\Reto5\\reto5\\ProyectosConstruccion.db";
    public static Connection getConnection() throws SQLException {
        String url = "jdbc:sqlite:" + UBICACION_BD;
        try{return DriverManager.getConnection(url);}
        catch(SQLException e){
            e.printStackTrace();
            return null;
        }
    }
}
