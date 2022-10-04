package us.fiestaboleana.programaciondos.libs;

public class AlgorithmLibTwo {

    /**
     * Ejecuta código mientras se cumpla una condición
     * La diferencia de este método es que permite poner un título al JOptionPane
     *
     * @param runnable código que se ejecutará mientras se desee
     * @param title    Título del JOptionPane
     * @param message  Mensaje que se muestra antes de agregar otro elemento
     * @return
     */
    public static void dynamicRun(Runnable runnable, String title, String message) {
        boolean next = true;
        while (next) {
            runnable.run();
            next = PanelLibTwo.requestBoolean(title, message);
        }
    }

    /**
     * Ejecuta código mientras se cumpla una condición
     *
     * @param runnable código que se ejecutará mientras se desee
     * @param message  Mensaje que se muestra antes de agregar otro elemento
     * @return
     */
    public static void dynamicRun(Runnable runnable, String message) {
        dynamicRun(runnable, "", message);
    }
}
