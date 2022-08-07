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
    private JLabel lblIcon;

    public ReportesView() {
        super("Reportes proyectos de vivienda"); // titulo de la ventana
        this.reportesController = new ReportesController();
        setContentPane(panel1);
        // agragar icono lblIcon
        ImageIcon icon = new ImageIcon("src/main/java/com/mycompany/view/icon.png");
        lblIcon.setIcon(icon);

        btnInforme1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String titulo = " Información respectiva al “Líder”.";
                panelResultados(titulo);
            }
            });
        btnInforme2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String titulo = "Información de los proyectos cuya clasificación sea \n" +
                        "“Casa Campestre” y que estén ubicados en las ciudades de “Santa Marta”, “Cartagena” y\n" +
                        "“Barranquilla”";
                panelResultados(titulo);
            }
        });
        btnInforme3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String titulo = " Compras realizadas por los proyectos con el proveedor “Homecenter” y para la ciudad “Salento”";
                panelResultados(titulo);
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

    // metodo para mostrar los resultados de la consulta en el panel
    public void panelResultados(String titulo) {
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
            JLabel lblTitulo2 = new JLabel(titulo);
            panel1.add(lblTitulo2, BorderLayout.NORTH);
            lblTitulo2.setHorizontalAlignment(lblTitulo2.CENTER);
            // agragar color #E7F6F2 a la letra del label
            lblTitulo2.setForeground(new Color(231, 246, 242));
            // agregar margenes al label
            lblTitulo2.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
            pack(); // ajustar el tamaño del jFrame a los componentes que contiene

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al listar los resultados");
        }
    }
}
