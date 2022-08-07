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
            List<ComprasProyectoVo> lista = new ArrayList<>();
            while (resultSet.next()) {
                ComprasProyectoVo comprasProyectoVo = new ComprasProyectoVo();
                comprasProyectoVo.setIdCompra(resultSet.getInt("ID_Compra"));
                comprasProyectoVo.setConstructora(resultSet.getString("Constructora"));
                comprasProyectoVo.setBancoVinculado(resultSet.getString("Banco_Vinculado"));
                lista.add(comprasProyectoVo);
            }
            DefaultTableModel resultado = new DefaultTableModel();
            resultado.addColumn("ID_Compra");
            resultado.addColumn("Constructora");
            resultado.addColumn("Banco_Vinculado");
            for (ComprasProyectoVo comprasProyectoVo : lista) {
                resultado.addRow(new Object[]{
                        comprasProyectoVo.getIdCompra(),
                        comprasProyectoVo.getConstructora(),
                        comprasProyectoVo.getBancoVinculado()
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
