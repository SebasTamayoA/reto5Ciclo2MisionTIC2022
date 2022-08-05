package com.mycompany.view;

import com.mycompany.controller.ReportesController;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class ReportesView extends JFrame {
    private final ReportesController reportesController;
    private JPanel panel1;
    private JTable tblResultados;
    private JButton btnInforme3;
    private JButton btnInforme1;
    private JButton btnInforme2;
    private JButton btnSalir;
    private JLabel lblTitulo;

    public ReportesView() {
        super("Reportes proyectos de vivenda");
        this.reportesController = new ReportesController();
        setContentPane(panel1);


        btnInforme1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // ocultar jLabel lblTitulo
                    lblTitulo.setVisible(false);
                    // mostrar el informe 1 en el jTable tblResultados y agregar un scrollPanel al jFrame
                    DefaultTableModel model = reportesController.listarInfoLider();
                    tblResultados.setModel(model);
                    JScrollPane scrollPane = new JScrollPane(tblResultados);
                    panel1.setLayout(new BorderLayout());
                    panel1.add(scrollPane, BorderLayout.CENTER);
                    // poner botones al final del jFrame para volver a la ventana principal y salir
                    JPanel panel2 = new JPanel();
                    panel2.add(btnInforme1);
                    panel2.add(btnInforme2);
                    panel2.add(btnInforme3);
                    panel2.add(btnSalir);
                    panel1.add(panel2, BorderLayout.SOUTH);
                    pack(); // ajustar el tamaño del jFrame a los componentes que contiene

                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Error al listar los líderes");
                }

            }
        });
    }
}
