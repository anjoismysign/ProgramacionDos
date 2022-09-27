package us.fiestaboleana.programaciondos.days.two.entities;

import us.fiestaboleana.java.libraries.AlgorithmLib;
import us.fiestaboleana.java.libraries.PanelLib;
import us.fiestaboleana.java.objects.IntegerResult;
import us.fiestaboleana.java.swing.AnjoComponent;
import us.fiestaboleana.java.swing.AnjoPane;
import us.fiestaboleana.programaciondos.interfaces.Displayable;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class EstudianteTwo extends PersonaTwo implements Displayable {

    private String carne;
    private List<MateriaTwo> materias;

    public static EstudianteTwo build(){
        AnjoPane pane =  AnjoPane.build(Arrays.asList(new AnjoComponent[]{new AnjoComponent("Carné de estudiante", new JTextField(20)),
                new AnjoComponent("Cédula", new JTextField(20)),
                new AnjoComponent("Nombre", new JTextField(20)),
                new AnjoComponent("Edad", new JTextField(20))}),
                "ESTUDIANTE", 0, new ImageIcon("src/main/resources/icon.png").getImage().getScaledInstance(128, 128, Image.SCALE_SMOOTH));
        String carne = pane.getTextFieldText(0);
        String cedula = pane.getTextFieldText(1);
        String nombre = pane.getTextFieldText(2);
        IntegerResult edad = pane.getInteger(3);
        if (!edad.isValid())
            build();
        EstudianteTwo estudianteTwo = new EstudianteTwo(carne, cedula, nombre, edad.value());
        estudianteTwo.fillMaterias();
        return estudianteTwo;
    }

    public EstudianteTwo(String carne, String cedula, String nombre, int edad) {
        super(cedula, nombre, edad);
        this.carne = carne;
        this.materias = new ArrayList<>();
    }

    public EstudianteTwo(){}

    public void fillMaterias(){
        AlgorithmLib.dynamicRun(() -> {
            MateriaTwo materia = MateriaTwo.build();
            materias.add(materia);
        },"Desea agregar otra materia?");
    }

    public String getCarne() {
        return carne;
    }

    public void setCarne(String carne) {
        this.carne = carne;
    }

    @Override
    public String getInfo() {
        return "Carné: " + getCarne() + "\n" +
                "Cédula: " + getCedula() + "\n" +
                "Nombre: " + getNombre() + "\n" +
                "Edad: " + getEdad() + "\n" +
                "Materias: " + getMaterias().stream().map(MateriaTwo::getNombre).collect(Collectors.joining(", "));
    }

    @Override
    public void display() {
        PanelLib.showMessage("ESTUDIANTE", getInfo());
    }

    public List<MateriaTwo> getMaterias() {
        return materias;
    }
}
