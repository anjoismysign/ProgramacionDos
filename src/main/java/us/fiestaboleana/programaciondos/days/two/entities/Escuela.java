package us.fiestaboleana.programaciondos.days.two.entities;

import us.fiestaboleana.java.libraries.AlgorithmLib;
import us.fiestaboleana.java.swing.AnjoComponent;
import us.fiestaboleana.java.swing.AnjoPane;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Escuela {
    private String nombre, campus;
    private List<EstudianteTwo> estudiantes;

    public static Escuela build(){
        AnjoPane pane =  AnjoPane.build(Arrays.asList(new AnjoComponent[]{new AnjoComponent("Nombre de la escuela", new JTextField(20)),
                        new AnjoComponent("Campus", new JTextField(20))}),
                "ESCUELA", 0, new ImageIcon("src/main/resources/icon.png").getImage().getScaledInstance(128, 128, Image.SCALE_SMOOTH));
        String nombre = pane.getTextFieldText(0);
        String campus = pane.getTextFieldText(1);
        Escuela escuela = new Escuela(nombre, campus);
        escuela.fillEstudiantes();
        return escuela;
    }

    public Escuela(String nombre, String campus) {
        this.nombre = nombre;
        this.campus = campus;
        this.estudiantes = new ArrayList<>();
    }

    public Escuela(){}

    public void fillEstudiantes(){
        AlgorithmLib.dynamicRun(() -> {
            EstudianteTwo estudiante = EstudianteTwo.build();
            estudiantes.add(estudiante);
        }, "Desea agregar otro estudiante?");
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCampus() {
        return campus;
    }

    public void setCampus(String campus) {
        this.campus = campus;
    }

    public List<EstudianteTwo> getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(List<EstudianteTwo> estudiantes) {
        this.estudiantes = estudiantes;
    }
}
