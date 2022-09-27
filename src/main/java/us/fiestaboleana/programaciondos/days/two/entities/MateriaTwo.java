package us.fiestaboleana.programaciondos.days.two.entities;

import us.fiestaboleana.java.UlatinaJava;
import us.fiestaboleana.java.swing.AnjoComponent;
import us.fiestaboleana.java.swing.AnjoPane;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

public class MateriaTwo {

    private String nombre, codigo;

    public static MateriaTwo build(){
        AnjoPane pane =  AnjoPane.build(Arrays.asList(new AnjoComponent[]{new AnjoComponent("Nombre de Materia", new JTextField(20)),
                new AnjoComponent("Codigo de Materia", new JTextField(20))}),
                "MATERIA", 0, new ImageIcon("src/main/resources/icon.png").getImage().getScaledInstance(128, 128, Image.SCALE_SMOOTH));
        String nombre = pane.getTextFieldText(0);
        String codigo = pane.getTextFieldText(1);
        return new MateriaTwo(nombre, codigo);
    }

    public MateriaTwo(String nombre, String codigo){
        this.nombre = nombre;
        this.codigo = codigo;
    }

    public MateriaTwo(){}

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
}
