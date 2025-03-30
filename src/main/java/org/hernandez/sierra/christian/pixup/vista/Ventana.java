package org.hernandez.sierra.christian.pixup.vista;

import javax.swing.*;

public class Ventana implements Ejecutable {

    private static Ventana ventana;
    private JLabel jLabel;

    private Ventana() {

    }

    public static Ventana getInstance() {
        if (ventana == null) {
            ventana = new Ventana();
        }
        return ventana;
    }

    @Override
    public void run() {
        System.out.println("Aun en proceso de desarrollo");
        }
    }

