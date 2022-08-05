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
                    // limpiar el Jpanel
                    panel1.removeAll();
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
                    // agregar nuevo label en la parte superior y centrarlo
                    JLabel lblTitulo2 = new JLabel(" Información respectiva al “Líder”.");
                    panel1.add(lblTitulo2, BorderLayout.NORTH);
                    lblTitulo2.setHorizontalAlignment(lblTitulo2.CENTER);
                    // agregar margenes al label
                    lblTitulo2.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
                    pack(); // ajustar el tamaño del jFrame a los componentes que contiene

                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Error al listar los líderes");
                }
            }
        });
        btnInforme2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // limpiar el Jpanel
                    panel1.removeAll();
                    // mostrar el informe 2 en el jTable tblResultados y agregar un scrollPanel al jFrame
                    DefaultTableModel model = reportesController.listarInfoProyecto();
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
                    // agregar nuevo label en la parte superior y centrarlo
                    JLabel lblTitulo2 = new JLabel("información de los proyectos cuya clasificación sea \n" +
                            "“Casa Campestre” y que estén ubicados en las ciudades de “Santa Marta”, “Cartagena” y\n" +
                            "“Barranquilla”");
                    panel1.add(lblTitulo2, BorderLayout.NORTH);
                    lblTitulo2.setHorizontalAlignment(lblTitulo2.CENTER);
                    // agregar margenes al label
                    lblTitulo2.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
                    pack(); // ajustar el tamaño del jFrame a los componentes que contiene

                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Error al listar los proyectos");
                }
            }
        });
        btnInforme3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // limpiar el Jpanel
                    panel1.removeAll();
                    // mostrar el informe 3 en el jTable tblResultados y agregar un scrollPanel al jFrame
                    DefaultTableModel model = reportesController.listarComprasProyecto();
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
                    // agregar nuevo label en la parte superior y centrarlo
                    JLabel lblTitulo2 = new JLabel(" compras realizadas por los proyectos con el proveedor “Homecenter” y para la ciudad “Salento”");
                    panel1.add(lblTitulo2, BorderLayout.NORTH);
                    lblTitulo2.setHorizontalAlignment(lblTitulo2.CENTER);
                    // agregar margenes al label
                    lblTitulo2.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
                    pack(); // ajustar el tamaño del jFrame a los componentes que contiene

                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Error al listar las compras");
                }
            }
        });
        btnSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // salir de la ventana
                dispose();
            }
        });
    }
}
