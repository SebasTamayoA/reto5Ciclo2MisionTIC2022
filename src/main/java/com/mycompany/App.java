package com.mycompany;

import com.mycompany.view.ReportesView;

import javax.swing.*;

public class App {
    public static void main(String[] args) {
        // invocar el jFrame ReportesView
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new ReportesView();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
                // dar tamaño a el jFrame
                frame.setSize(800, 600);
                //centrar el jFrame
                frame.setLocationRelativeTo(null);
            }
        });


    }
}
