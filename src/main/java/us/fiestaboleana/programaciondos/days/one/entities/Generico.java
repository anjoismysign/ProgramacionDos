package us.fiestaboleana.programaciondos.days.one.entities;

import javax.swing.*;

public class Generico {

    public static String cadenaDeTexto(String mensaje) {
        return JOptionPane.showInputDialog(mensaje);
    }

    public static int entero(String mensaje) {
        int entero;
        try {
            entero = Integer.parseInt(JOptionPane.showInputDialog(mensaje));
            return entero;
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "No es un número entero");
            return entero(mensaje);
        }
    }

    public static double decimal(String mensaje) {
        double decimal;
        try {
            decimal = Double.parseDouble(JOptionPane.showInputDialog(mensaje));
            return decimal;
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "No es un número decimal ni entero");
            return decimal(mensaje);
        }
    }

    public static boolean booleano(String mensaje) {
        int respuesta = JOptionPane.showConfirmDialog(null, mensaje, "", JOptionPane.YES_NO_OPTION);
        if (respuesta == JOptionPane.YES_OPTION) {
            return true;
        } else {
            return false;
        }
    }
}
