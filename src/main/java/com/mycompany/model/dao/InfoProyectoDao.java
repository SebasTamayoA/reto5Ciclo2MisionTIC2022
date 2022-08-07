package com.mycompany.model.dao;

import com.mycompany.model.util.JDBCUtilities;
import com.mycompany.model.vo.InfoProyectoVo;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class InfoProyectoDao {

    public DefaultTableModel listar() throws SQLException {
    /* Realizar un informe basándose en la información de los proyectos cuya clasificación sea
    “Casa Campestre” y que estén ubicados en las ciudades de “Santa Marta”, “Cartagena” y
    “Barranquilla”. Este informe debe contener: el ID_Proyecto, la Constructora, el
    Nùmero_Habitaciones y la respectiva Ciudad.*/

        String sql = "SELECT Proyecto.ID_Proyecto, Proyecto.Constructora,"
                + " Proyecto.Numero_Habitaciones, Proyecto.Ciudad FROM Proyecto"
                + " WHERE Proyecto.Clasificacion = 'Casa Campestre' AND Proyecto.Ciudad IN ('Santa Marta', 'Cartagena', 'Barranquilla')"
                + " ORDER BY Proyecto.Ciudad";
        try {
            Connection connection = JDBCUtilities.getConnection();
            assert connection != null;
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<InfoProyectoVo> lista = new ArrayList<>();
            while (resultSet.next()) {
                InfoProyectoVo infoProyectoVo = new InfoProyectoVo();
                infoProyectoVo.setIdProyecto(resultSet.getInt("ID_Proyecto"));
                infoProyectoVo.setConstructora(resultSet.getString("Constructora"));
                infoProyectoVo.setNumeroHabitaciones(resultSet.getInt("Numero_Habitaciones"));
                infoProyectoVo.setCiudad(resultSet.getString("Ciudad"));
                lista.add(infoProyectoVo);
            }
            DefaultTableModel resultado = new DefaultTableModel();
            resultado.addColumn("ID_Proyecto");
            resultado.addColumn("Constructora");
            resultado.addColumn("Numero_Habitaciones");
            resultado.addColumn("Ciudad");
            for (InfoProyectoVo infoProyectoVo : lista) {
                Object[] fila = {infoProyectoVo.getIdProyecto(), infoProyectoVo.getConstructora(), infoProyectoVo.getNumeroHabitaciones(), infoProyectoVo.getCiudad()};
                resultado.addRow(fila);
            }
            connection.close();
            return resultado;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al listar");
            e.printStackTrace();
            return null;
        }


    }
}
