package com.mycompany.model.dao;

import com.mycompany.model.util.JDBCUtilities;
import com.mycompany.model.vo.InfoLiderVo;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class InfoLiderDao {

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
            List<InfoLiderVo> lista = new ArrayList<>();
            while (resultSet.next()) {
                InfoLiderVo infoLiderVo = new InfoLiderVo();
                infoLiderVo.setIdLider(resultSet.getInt("ID_Lider"));
                infoLiderVo.setNombre(resultSet.getString("Nombre"));
                infoLiderVo.setPrimerApellido(resultSet.getString("Primer_Apellido"));
                infoLiderVo.setCiudadResidencia(resultSet.getString("Ciudad_Residencia"));
                lista.add(infoLiderVo);
            }
            DefaultTableModel resultado = new DefaultTableModel();
            resultado.addColumn("ID_Lider");
            resultado.addColumn("Nombre");
            resultado.addColumn("Primer_Apellido");
            resultado.addColumn("Ciudad_Residencia");
            for (InfoLiderVo infoLiderVo : lista) {
                resultado.addRow(new Object[]{
                        infoLiderVo.getIdLider(),
                        infoLiderVo.getNombre(),
                        infoLiderVo.getPrimerApellido(),
                        infoLiderVo.getCiudadResidencia()
                });
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

