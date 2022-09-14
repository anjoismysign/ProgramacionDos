package us.fiestaboleana.programaciondos.days.one;

import us.fiestaboleana.java.libraries.PanelLib;
import us.fiestaboleana.java.libraries.SwingLib;
import us.fiestaboleana.java.objects.AnjoComponent;
import us.fiestaboleana.programaciondos.objects.Displayable;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Estudiante extends Persona implements Displayable {

    private String carne;
    private int cantidadMaterias, cuatrimestre;

    public Estudiante() {}

    public Estudiante(String cedula, String nombre, String apellidos, String direccion, String carnet, int cantidadMaterias, int cuatrimestre) {
        super(cedula, nombre, apellidos, direccion);
        this.carne = carnet;
        this.cantidadMaterias = cantidadMaterias;
        this.cuatrimestre = cuatrimestre;
    }

    public static Estudiante build(){
        List<AnjoComponent> components = new ArrayList<>();
        components.add(new AnjoComponent("Cedula", new JTextField(20)));
        components.add(new AnjoComponent("Nombre", new JTextField(20)));
        components.add(new AnjoComponent("Apellidos", new JTextField(20)));
        components.add(new AnjoComponent("Direccion", new JTextField(20)));
        components.add(new AnjoComponent("Carné", new JTextField(20)));
        components.add(new AnjoComponent("Cantidad de materias", new JTextField(1)));
        components.add(new AnjoComponent("Cuatrimestre", new JTextField(1)));
        JPanel panel = SwingLib.anjoPane(components, "Estudiante", 2, -1, 0);
        String cedula = SwingLib.getTextFromAnjoJTextField(panel, 0);
        String nombre = SwingLib.getTextFromAnjoJTextField(panel, 1);
        String apellidos = SwingLib.getTextFromAnjoJTextField(panel, 2);
        String direccion = SwingLib.getTextFromAnjoJTextField(panel, 3);
        String carne = SwingLib.getTextFromAnjoJTextField(panel, 4);
        boolean cantidadMateriasFailed = false;
        boolean cuatrimestreFailed = false;

        int cantidadMaterias;
        try{
            cantidadMaterias = Integer.parseInt(SwingLib.getTextFromAnjoJTextField(panel, 5));
        } catch (NumberFormatException e) {
            cantidadMaterias = 0;
            cantidadMateriasFailed = true;
        }
        int cuatrimestre;
        try{
            cuatrimestre = Integer.parseInt(SwingLib.getTextFromAnjoJTextField(panel, 6));
        } catch (NumberFormatException e) {
            cuatrimestre = 0;
            cuatrimestreFailed = true;
        }
        if (cantidadMateriasFailed){
            PanelLib.showMessage("ERROR", "La cantidad de materias debe ser un número entero");
        }
        if (cuatrimestreFailed){
            PanelLib.showMessage("ERROR", "El cuatrimestre debe ser un número entero");
        }
        if (cantidadMateriasFailed || cuatrimestreFailed){
            return Estudiante.build();
        }
        return new Estudiante(cedula,nombre,apellidos,direccion, carne, cantidadMaterias, cuatrimestre);
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
        PanelLib.showMessage("Estudiante - Resultado", getInfo());
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
