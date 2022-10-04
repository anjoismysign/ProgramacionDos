package us.fiestaboleana.programaciondos.days.three.entities;

import us.fiestaboleana.java.libraries.PanelLib;
import us.fiestaboleana.java.swing.AnjoComponent;
import us.fiestaboleana.java.swing.AnjoPane;
import us.fiestaboleana.programaciondos.interfaces.Displayable;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class EstudianteThree extends PersonaThree implements Displayable {

    private String carne;

    public static EstudianteThree build() {
        AnjoPane pane = AnjoPane.build(Arrays.asList(new AnjoComponent[]{new AnjoComponent("Carné de estudiante", new JTextField(20)),
                        new AnjoComponent("Cédula", new JTextField(20)),
                        new AnjoComponent("Nombre", new JTextField(20)),
                        new AnjoComponent("Vacunado", new JComboBox<>(new String[]{"No", "Sí"}))}),
                "ESTUDIANTE", 0, new ImageIcon("src/main/resources/icon.png").getImage().getScaledInstance(128, 128, Image.SCALE_SMOOTH));
        String carne = pane.getTextFieldText(0);
        String cedula = pane.getTextFieldText(1);
        String nombre = pane.getTextFieldText(2);
        String vacunadoText = pane.getComboBoxText(3);
        boolean vacunado = true;
        if (vacunadoText.equals("No"))
            vacunado = false;
        EstudianteThree estudiante = new EstudianteThree(cedula, nombre, vacunado, carne);
        estudiante.display();
        return estudiante;
    }

    public EstudianteThree(String cedula, String nombre, boolean vacunado, String carne) {
        super(cedula, nombre, vacunado);
        this.carne = carne;
    }

    public EstudianteThree() {
    }

    public String getCarne() {
        return carne;
    }

    public void setCarne(String carne) {
        this.carne = carne;
    }

    @Override
    public String comportamiento() {
        return "Me comporto como un estudiante";
    }

    @Override
    public String getInfo() {
        return "Carné: " + getCarne() + "\n" +
                "Cédula: " + getCedula() + "\n" +
                "Nombre: " + getNombre() + "\n" +
                "Vacunado: " + isVacunado();
    }

    @Override
    public void display() {
        PanelLib.showMessage("ESTUDIANTE", getInfo());
    }
}
