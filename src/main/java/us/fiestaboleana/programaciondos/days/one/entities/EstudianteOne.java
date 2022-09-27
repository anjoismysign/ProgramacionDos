package us.fiestaboleana.programaciondos.days.one.entities;

import us.fiestaboleana.java.libraries.PanelLib;
import us.fiestaboleana.java.objects.IntegerResult;
import us.fiestaboleana.java.swing.AnjoComponent;
import us.fiestaboleana.java.swing.AnjoPane;
import us.fiestaboleana.programaciondos.days.one.PrintType;
import us.fiestaboleana.programaciondos.interfaces.Displayable;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class EstudianteOne extends PersonaOne implements Displayable {

    private String carne;
    private int cantidadMaterias, cuatrimestre;

    public EstudianteOne() {}

    public EstudianteOne(String cedula, String nombre, String apellidos, String direccion, String carnet, int cantidadMaterias, int cuatrimestre) {
        super(cedula, nombre, apellidos, direccion);
        this.carne = carnet;
        this.cantidadMaterias = cantidadMaterias;
        this.cuatrimestre = cuatrimestre;
    }

    public static EstudianteOne build(){
        List<AnjoComponent> components = new ArrayList<>();
        components.add(new AnjoComponent("Cedula", new JTextField(20)));
        components.add(new AnjoComponent("Nombre", new JTextField(20)));
        components.add(new AnjoComponent("Apellidos", new JTextField(20)));
        components.add(new AnjoComponent("Direccion", new JTextField(20)));
        components.add(new AnjoComponent("Carné", new JTextField(20)));
        components.add(new AnjoComponent("Cantidad de materias", new JTextField(1)));
        components.add(new AnjoComponent("Cuatrimestre", new JTextField(1)));
        AnjoPane pane = AnjoPane.build(components, "ESTUDIANTE - NUEVO", 0, null);
        String cedula = pane.getTextFieldText(0);
        String nombre = pane.getTextFieldText(1);
        String apellidos = pane.getTextFieldText(2);
        String direccion = pane.getTextFieldText(3);
        String carne = pane.getTextFieldText(4);
        IntegerResult cantidadMateriasResult = pane.getInteger(5);
        IntegerResult cuatrimestreResult = pane.getInteger(6);

        boolean cantidadMateriasFailed = !cantidadMateriasResult.isValid();
        boolean cuatrimestreFailed = !cuatrimestreResult.isValid();
        if (cantidadMateriasFailed || cuatrimestreFailed){
            if (cantidadMateriasFailed)
                PanelLib.showMessage("ERROR", "La cantidad de materias no es un número entero");
            if (cuatrimestreFailed)
                PanelLib.showMessage("ERROR", "El cuatrimestre no es un número entero");
            return EstudianteOne.build();
        }
        return new EstudianteOne(cedula,nombre,apellidos,direccion, carne, cantidadMateriasResult.value(), cuatrimestreResult.value());
    }

    public String getCarne() {
        return carne;
    }

    public void setCarne(String carne) {
        this.carne = carne;
    }

    public int getCantidadMaterias() {
        return cantidadMaterias;
    }

    public void setCantidadMaterias(int cantidadMaterias) {
        this.cantidadMaterias = cantidadMaterias;
    }

    public int getCuatrimestre() {
        return cuatrimestre;
    }

    public void setCuatrimestre(int cuatrimestre) {
        this.cuatrimestre = cuatrimestre;
    }

    @Override
    public String getInfo() {
        return "Cedula: "+getCedula()+"\n"+
                "Nombre: "+getNombre()+"\n"+
                "Apellidos: "+getApellidos()+"\n"+
                "Direccion: "+getDireccion()+"\n"+
                "Carnet: "+ getCarne()+"\n"+
                "Cantidad de Materias: "+getCantidadMaterias()+"\n"+
                "Cuatrimestre: "+getCuatrimestre()+"\n";
    }

    @Override
    public void display() {
        PanelLib.showMessage("ESTUDIANTE - RESULTADO", getInfo());
    }

    public String estudiar(String curso, PrintType print){
        String string;
        if (curso == null || curso.length() == 0)
            string = getCarne()+" esta estudiando...";
        else
            string = getCarne()+" esta estudiando "+curso;
        switch (print){
            case SOUT -> System.out.println(string);
            case PANEL -> PanelLib.showMessage(string);
            default -> {}
        }
        return string;
    }

    public String estudiar(String curso){
        return estudiar(curso, PrintType.NONE);
    }

    public String estudiar(){
        return estudiar(null, PrintType.NONE);
    }

    public String matricular(PrintType print){
        String string = getCarne()+" esta matriculando...";
        switch (print){
            case SOUT -> System.out.println(string);
            case PANEL -> PanelLib.showMessage(string);
            default -> {}
        }
        return string;
    }

    public String matricular(){
        return matricular(PrintType.NONE);
    }

    public String practicar(String curso, PrintType print){
        String string;
        if (curso == null || curso.length() == 0)
            string = getCarne()+" esta practicando...";
        else
            string = getCarne()+" esta practicando "+curso;
        switch (print){
            case SOUT -> System.out.println(string);
            case PANEL -> PanelLib.showMessage(string);
            default -> {}
        }
        return string;
    }

    public String practicar(String curso){
        return practicar(curso, PrintType.NONE);
    }

    public String practicar(){
        return practicar(null, PrintType.NONE);
    }
}
