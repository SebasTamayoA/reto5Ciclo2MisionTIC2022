package com.mycompany.model.dao;

import com.mycompany.model.util.JDBCUtilities;
import com.mycompany.model.vo.InfoLiderVo;

import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class InfoLiderDao {

/*    public List<InfoLiderVo> listar() throws SQLException {
        List<InfoLiderVo> resultado = new ArrayList<>();
        *//*Generar un informe basándose en la tabla con la información respectiva al “Líder”. El
        listado debe contener: el ID_Lider, el Nombre, el Primer_Apellido y la Ciudad_Residencia.
        Este informe debe estar ordenado por la “Ciudad_Residencia” de forma alfabética.*//*
        String sql = "SELECT Lider.ID_Lider, Lider.Nombre, Lider.Primer_Apellido" +
                ", Lider.Ciudad_Residencia FROM Lider ORDER BY Lider.Ciudad_Residencia";
        try {
            Connection connection = JDBCUtilities.getConnection();
            assert connection != null;
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                InfoLiderVo infoLiderVo = new InfoLiderVo();
                infoLiderVo.setIdLider(resultSet.getInt("ID_Lider"));
                infoLiderVo.setNombre(resultSet.getString("Nombre"));
                infoLiderVo.setPrimerApellido(resultSet.getString("Primer_Apellido"));
                infoLiderVo.setCiudadResidencia(resultSet.getString("Ciudad_Residencia"));
                resultado.add(infoLiderVo);
            }
            return resultado;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }*/

    // metodo para convertir resultado de listar() en DefaultTableModel
    public DefaultTableModel listar() throws SQLException {
             /*Generar un informe basándose en la tabla con la información respectiva al “Líder”. El
            listado debe contener: el ID_Lider, el Nombre, el Primer_Apellido y la Ciudad_Residencia.
            Este informe debe estar ordenado por la “Ciudad_Residencia” de forma alfabética.*/
        String sql = "SELECT Lider.ID_Lider, Lider.Nombre, Lider.Primer_Apellido" +
                ", Lider.Ciudad_Residencia FROM Lider ORDER BY Lider.Ciudad_Residencia";
        try {
            Connection connection = JDBCUtilities.getConnection();
            assert connection != null;
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            DefaultTableModel modelo = new DefaultTableModel();
            modelo.addColumn("ID_Lider", new Object[]{"ID_Lider"});
            modelo.addColumn("Nombre", new Object[]{"Nombre"});
            modelo.addColumn("Primer_Apellido", new Object[]{"Primer_Apellido"});
            modelo.addColumn("Ciudad_Residencia", new Object[]{"Ciudad_Residencia"});
            while (resultSet.next()) {
                Object[] fila = new Object[4];
                fila[0] = resultSet.getInt("ID_Lider");
                fila[1] = resultSet.getString("Nombre");
                fila[2] = resultSet.getString("Primer_Apellido");
                fila[3] = resultSet.getString("Ciudad_Residencia");
                modelo.addRow(fila);
            }
            return modelo;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }


}

