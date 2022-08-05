package com.mycompany.model.dao;

import com.mycompany.model.util.JDBCUtilities;

import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class InfoProyectoDao {

    public DefaultTableModel listar() throws SQLException {
    /* Realizar un informe basándose en la información de los proyectos cuya clasificación sea
    “Casa Campestre” y que estén ubicados en las ciudades de “Santa Marta”, “Cartagena” y
    “Barranquilla”. Este informe debe contener: el ID_Proyecto, la Constructora, el
    Nùmero_Habitaciones y la respectiva Ciudad.*/
        String sql = "SELECT Proyecto.ID_Proyecto, Proyecto.Constructora,"
                + "Proyecto.Numero_Habitaciones, Proyecto.Ciudad FROM Proyecto"
                + " WHERE Proyecto.Clasificacion = 'Casa Campestre' AND Proyecto.Ciudad IN ('Santa Marta', 'Cartagena', 'Barranquilla')";
        try {
            Connection connection = JDBCUtilities.getConnection();
            assert connection != null;
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            DefaultTableModel resultado = new DefaultTableModel();
            resultado.addColumn("ID_Proyecto");
            resultado.addColumn("Constructora");
            resultado.addColumn("Numero_Habitaciones");
            resultado.addColumn("Ciudad");
            while (resultSet.next()) {
                resultado.addRow(new Object[]{
                        resultSet.getInt("ID_Proyecto"),
                        resultSet.getString("Constructora"),
                        resultSet.getInt("Numero_Habitaciones"),
                        resultSet.getString("Ciudad")
                });
            }
            return resultado;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }


    }
}
