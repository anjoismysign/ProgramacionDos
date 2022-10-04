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

public class PracticanteThree extends FuncionarioThree implements Displayable, Empleado {
    private String almaMater;
    private CargoThree cargo;

    public static PracticanteThree build() {
        AnjoPane pane = AnjoPane.build(Arrays.asList(new AnjoComponent[]{new AnjoComponent("Horas trabajadas", new JTextField(20)),
                        new AnjoComponent("Nombre", new JTextField(20)),
                        new AnjoComponent("Apellido", new JTextField(20)),
                        new AnjoComponent("Alma mater", new JTextField(20)),
                        new AnjoComponent("Descripción del cargo", new JTextField(20)),
                        new AnjoComponent("Salario por hora", new JTextField(20))}),
                "PRACTICANTE", 0, new ImageIcon("src/main/resources/icon.png").getImage().getScaledInstance(128, 128, Image.SCALE_SMOOTH));
        IntegerResult horasTrabajadas = pane.getInteger(0);
        if (!horasTrabajadas.isValid())
            return PracticanteThree.build();
        String nombre = pane.getTextFieldText(1);
        String apellido = pane.getTextFieldText(2);
        String almaMater = pane.getTextFieldText(3);
        String descripcion = pane.getTextFieldText(4);
        DoubleResult wage = pane.getDouble(5);
        if (!wage.isValid())
            return PracticanteThree.build();
        PracticanteThree practicante = new PracticanteThree(nombre, apellido, horasTrabajadas.value(), almaMater, new CargoThree(descripcion, wage.value()));
        return practicante;
    }

    public PracticanteThree(String nombre, String apellido, long horasTrabajadas, String almaMatter, CargoThree cargo) {
        super(nombre, apellido, horasTrabajadas);
        this.almaMater = almaMatter;
        this.cargo = cargo;
    }

    public String getAlmaMater() {
        return almaMater;
    }

    public void setAlmaMater(String almaMater) {
        this.almaMater = almaMater;
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
                "Alma mater: " + getAlmaMater() + "\n" +
                "Cargo: " + getCargo().toString() + "\n" +
                "Salario total: " + salarioTotal();
    }


    @Override
    public void display() {
        PanelLib.showMessage("PRACTICANTE", getInfo());
    }
}
