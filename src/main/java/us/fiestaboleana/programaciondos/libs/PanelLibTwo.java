package us.fiestaboleana.programaciondos.libs;

import javax.swing.*;

public class PanelLibTwo {

    /**
     * Pide un boolean de la forma mas elegante
     * En caso de cerrarse la ventana, se hará recursión
     * En caso del mensaje ser escrito en español,
     * se recomienda PanelLib#esEs al inicio del
     * método main
     * La diferencia de este método es que permite poner un título al JOptionPane
     *
     * @param title   Título del JOptionPane
     * @param message Mensaje que se muestra mientras se pide
     *                el boolean
     * @return el boolean seleccionado
     */
    public static boolean requestBoolean(String title, String message) {
        JOptionPane.setRootFrame(null);
        int x = JOptionPane.showConfirmDialog(null, message, title,
                0, -1);
        if (x == JOptionPane.CLOSED_OPTION)
            return requestBoolean(title, message);
        return x == 0 ? true : false;
    }
}
