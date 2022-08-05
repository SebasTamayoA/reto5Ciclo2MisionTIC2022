package com.mycompany.model.dao;

import com.mycompany.model.util.JDBCUtilities;
import com.mycompany.model.vo.ComprasProyectoVo;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ComprasProyectoDao {
    /*public List<ComprasProyectoVo> listar() throws SQLException {
        ArrayList<ComprasProyectoVo> resultado = new ArrayList<>();
        *//*Realizar un informe basándose en las compras realizadas por los proyectos con el proveedor
        “Homecenter” y para la ciudad “Salento”. Este informe debe incluir: ID_Compra,
         Constructora y Banco_Vinculado*//*
        String sql = "SELECT Compra.ID_Compra AS ID, Proyecto.Constructora AS CONSTRUCTORA, Proyecto.Banco_Vinculado AS BANCO FROM Compra"
                + " INNER JOIN Proyecto ON Compra.ID_Proyecto = Proyecto.ID_Proyecto"
                + " WHERE Compra.Proveedor = 'Homecenter' AND Proyecto.Ciudad = 'Salento'";
        try {
            Connection connection = JDBCUtilities.getConnection();
            assert connection != null;
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                ComprasProyectoVo comprasProyectoVo = new ComprasProyectoVo();
                comprasProyectoVo.setIdProyecto(resultSet.getInt("ID"));
                comprasProyectoVo.setConstructora(resultSet.getString("CONSTRUCTORA"));
                comprasProyectoVo.setBancoVinculado(resultSet.getString("BANCO"));
                resultado.add(comprasProyectoVo);
            }
            return resultado;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }*/

    public DefaultTableModel listar() throws SQLException {
        /*Realizar un informe basándose en las compras realizadas por los proyectos con el proveedor
        “Homecenter” y para la ciudad “Salento”. Este informe debe incluir: ID_Compra,
         Constructora y Banco_Vinculado*/
        String sql = "SELECT Compra.ID_Compra, Proyecto.Constructora, Proyecto.Banco_Vinculado FROM Compra"
                + " INNER JOIN Proyecto ON Compra.ID_Proyecto = Proyecto.ID_Proyecto"
                + " WHERE Compra.Proveedor = 'Homecenter' AND Proyecto.Ciudad = 'Salento'";
        try {
            Connection connection = JDBCUtilities.getConnection();
            assert connection != null;
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            DefaultTableModel resultado = new DefaultTableModel();
            resultado.addColumn("ID_Compra");
            resultado.addColumn("Constructora");
            resultado.addColumn("Banco_Vinculado");
            while (resultSet.next()) {
                resultado.addRow(new Object[]{
                        resultSet.getInt("ID_Compra"),
                        resultSet.getString("Constructora"),
                        resultSet.getString("Banco_Vinculado")
                });
            }
            return resultado;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al listar");
            e.printStackTrace();
            return null;
        }
    }

}
