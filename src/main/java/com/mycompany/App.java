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
                frame.setSize(850, 300);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });


    }
}
