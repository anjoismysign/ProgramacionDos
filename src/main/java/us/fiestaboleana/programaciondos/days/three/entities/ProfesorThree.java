package us.fiestaboleana.programaciondos.days.three.entities;

import us.fiestaboleana.java.libraries.PanelLib;
import us.fiestaboleana.java.objects.DoubleResult;
import us.fiestaboleana.java.swing.AnjoComponent;
import us.fiestaboleana.java.swing.AnjoPane;
import us.fiestaboleana.programaciondos.interfaces.Displayable;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class ProfesorThree extends PersonaThree implements Displayable {

    private double salario;

    public static ProfesorThree build() {
        AnjoPane pane = AnjoPane.build(Arrays.asList(new AnjoComponent[]{new AnjoComponent("Salario", new JTextField(20)),
                        new AnjoComponent("Cédula", new JTextField(20)),
                        new AnjoComponent("Nombre", new JTextField(20)),
                        new AnjoComponent("Vacunado", new JComboBox<>(new String[]{"No", "Sí"}))}),
                "ESTUDIANTE", 0, new ImageIcon("src/main/resources/icon.png").getImage().getScaledInstance(128, 128, Image.SCALE_SMOOTH));
        DoubleResult salario = pane.getDouble(0);
        if (!salario.isValid())
            return ProfesorThree.build();
        String cedula = pane.getTextFieldText(1);
        String nombre = pane.getTextFieldText(2);
        String vacunadoText = pane.getComboBoxText(3);
        boolean vacunado = true;
        if (vacunadoText.equals("No"))
            vacunado = false;
        ProfesorThree profesor = new ProfesorThree(cedula, nombre, vacunado, salario.value());
        profesor.display();
        return profesor;
    }

    public ProfesorThree(String cedula, String nombre, boolean vacunado, double salario) {
        super(cedula, nombre, vacunado);
        this.salario = salario;
    }

    public ProfesorThree() {
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    @Override
    public String comportamiento() {
        return "Me comporto como un profesor";
    }

    @Override
    public String getInfo() {
        return "Salario: " + getSalario() + "\n" +
                "Cédula: " + getCedula() + "\n" +
                "Nombre: " + getNombre() + "\n" +
                "Vacunado: " + isVacunado();
    }

    @Override
    public void display() {
        PanelLib.showMessage("PROFESOR", getInfo());
    }
}
