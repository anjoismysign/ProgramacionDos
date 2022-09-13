package us.fiestaboleana.programaciondos.days.one;

import us.fiestaboleana.java.libraries.PanelLib;

public class Util {

    public static boolean continuar(){
        String input = PanelLib.requestString("¿Desea ingresar otro estudiante? \nIngrese 'si' o 'no'");
        String lowercased = input.toLowerCase();
        if (!lowercased.equals("si") && !lowercased.equals("no")) {
            PanelLib.showMessage("'"+input+"' no es ni 'si' ni 'no'");
            return continuar();
        }
        if (lowercased.equals("si"))
            return true;
        else
            return false;
    }
}
