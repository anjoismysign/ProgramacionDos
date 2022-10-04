package us.fiestaboleana.programaciondos.days.three.entities;

import us.fiestaboleana.java.swing.AnjoComponent;
import us.fiestaboleana.java.swing.AnjoPane;
import us.fiestaboleana.programaciondos.interfaces.Displayable;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public abstract class FuncionarioThree implements Displayable, Empleado {

    private String nombre, apellido;
    private long horasTrabajadas;

    public static FuncionarioThree build() {
        AnjoPane pane = AnjoPane.build(Arrays.asList(new AnjoComponent[]{
                        new AnjoComponent("Tipo de funcionario", new JComboBox<>(new String[]{"PRACTICANTE", "MÉDICO"}))}),
                "FUNCIONARIO", 0, new ImageIcon("src/main/resources/icon.png").getImage().getScaledInstance(128, 128, Image.SCALE_SMOOTH));
        if (pane.getComboBoxText(0).equals("PRACTICANTE"))
            return PracticanteThree.build();
        return MedicoThree.build();
    }

    public FuncionarioThree(String nombre, String apellido, long horasTrabajadas) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.horasTrabajadas = horasTrabajadas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public long getHorasTrabajadas() {
        return horasTrabajadas;
    }

    public void setHorasTrabajadas(long horasTrabajadas) {
        this.horasTrabajadas = horasTrabajadas;
    }

    public double salarioTotal() {
        return getCargo().getSalarioPorHora() * (double) getHorasTrabajadas();
    }
}
