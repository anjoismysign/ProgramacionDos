package us.fiestaboleana.programaciondos.days.one;

import us.fiestaboleana.java.libraries.PanelLib;
import us.fiestaboleana.programaciondos.objects.Displayable;

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
        String cedula = PanelLib.requestString("Estudiante","Ingrese cedula");
        String nombre = PanelLib.requestString("Estudiante","Ingrese nombre");
        String apellidos = PanelLib.requestString("Estudiante","Ingrese apellidos");
        String direccion = PanelLib.requestString("Estudiante","Ingrese direccion");
        String carne = PanelLib.requestString("Estudiante", "Ingrese carné");
        int cantidadMaterias = PanelLib.requestInteger("¿Cuántas materias lleva en este cuatrimeste?");
        int cuatrimestre = PanelLib.requestInteger("¿Cuál cuatrimestre está matriculando?");
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
