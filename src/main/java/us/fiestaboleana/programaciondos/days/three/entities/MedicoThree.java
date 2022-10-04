package us.fiestaboleana.programaciondos.days.three.entities;

import us.fiestaboleana.java.libraries.PanelLib;
import us.fiestaboleana.java.objects.DoubleResult;
import us.fiestaboleana.java.objects.IntegerResult;
import us.fiestaboleana.java.swing.AnjoComponent;
import us.fiestaboleana.java.swing.AnjoPane;
import us.fiestaboleana.programaciondos.interfaces.Displayable;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class MedicoThree extends FuncionarioThree implements Displayable, Empleado {
    private String especialidad;
    private CargoThree cargo;

    public static MedicoThree build() {
        AnjoPane pane = AnjoPane.build(Arrays.asList(new AnjoComponent[]{new AnjoComponent("Horas trabajadas", new JTextField(20)),
                        new AnjoComponent("Nombre", new JTextField(20)),
                        new AnjoComponent("Apellido", new JTextField(20)),
                        new AnjoComponent("Especialidad", new JTextField(20)),
                        new AnjoComponent("Descripción del cargo", new JTextField(20)),
                        new AnjoComponent("Salario por hora", new JTextField(20))}),
                "MÉDICO", 0, new ImageIcon("src/main/resources/icon.png").getImage().getScaledInstance(128, 128, Image.SCALE_SMOOTH));
        IntegerResult horasTrabajadas = pane.getInteger(0);
        if (!horasTrabajadas.isValid())
            return MedicoThree.build();
        String nombre = pane.getTextFieldText(1);
        String apellido = pane.getTextFieldText(2);
        String especialidad = pane.getTextFieldText(3);
        String descripcion = pane.getTextFieldText(4);
        DoubleResult wage = pane.getDouble(5);
        if (!wage.isValid())
            return MedicoThree.build();
        MedicoThree practicante = new MedicoThree(nombre, apellido, horasTrabajadas.value(), especialidad, new CargoThree(descripcion, wage.value()));
        return practicante;
    }

    public MedicoThree(String nombre, String apellido, long horasTrabajadas, String especialidad, CargoThree cargo) {
        super(nombre, apellido, horasTrabajadas);
        this.especialidad = especialidad;
        this.cargo = cargo;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public CargoThree getCargo() {
        return cargo;
    }

    public void setCargo(CargoThree cargo) {
        this.cargo = cargo;
    }

    @Override
    public String getInfo() {
        return "Nombre: " + getNombre() + "\n" +
                "Apellido: " + getApellido() + "\n" +
                "Horas trabajadas: " + getHorasTrabajadas() + "\n" +
                "Especialidad: " + getEspecialidad() + "\n" +
                "Cargo: " + getCargo().toString() + "\n" +
                "Salario total: " + salarioTotal();
    }

    @Override
    public void display() {
        PanelLib.showMessage("MÉDICO", getInfo());
    }
}
