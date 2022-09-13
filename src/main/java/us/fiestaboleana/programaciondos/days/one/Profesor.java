package us.fiestaboleana.programaciondos.days.one;

import us.fiestaboleana.java.libraries.PanelLib;
import us.fiestaboleana.programaciondos.objects.Displayable;

public class Profesor extends Persona implements Displayable {

    private String codigo;
    private double salario;
    private int cursosImpartidos;

    public Profesor(String cedula, String nombre, String apellidos, String direccion,
                    String codigo, double salario, int cursosImpartidos) {
        super(cedula, nombre, apellidos, direccion);
        this.codigo = codigo;
        this.salario = salario;
        this.cursosImpartidos = cursosImpartidos;
    }

    public static Profesor build(){
        String cedula = PanelLib.requestString("Profesor","Ingrese cedula");
        String nombre = PanelLib.requestString("Profesor","Ingrese nombre");
        String apellidos = PanelLib.requestString("Profesor","Ingrese apellidos");
        String direccion = PanelLib.requestString("Profesor","Ingrese direccion");
        String codigo = PanelLib.requestString("Profesor", "Ingrese código");
        double salario = PanelLib.requestDouble("¿Cuánto es el salario? Sin restar los impuestos");
        int cursosImpartidos = PanelLib.requestInteger("¿Cuántos cursos va a impartir este cuatrimestre?");
        return new Profesor(cedula,nombre,apellidos,direccion, codigo, salario, cursosImpartidos);
    }

    public Profesor(){}

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public int getCursosImpartidos() {
        return cursosImpartidos;
    }

    public void setCursosImpartidos(int cursosImpartidos) {
        this.cursosImpartidos = cursosImpartidos;
    }

    @Override
    public String getInfo() {
        return "Cedula: "+getCedula()+"\n"+
                "Nombre: "+getNombre()+"\n"+
                "Apellidos: "+getApellidos()+"\n"+
                "Direccion: "+getDireccion()+"\n"+
                "Código: "+ getCodigo()+"\n"+
                "Salario: "+getSalario()+"\n"+
                "Cursos impartidos: "+getCursosImpartidos()+"\n";
    }

    @Override
    public void display() {
        PanelLib.showMessage("Profesor - Resultado", getInfo());
    }

    public String educar(String curso, PrintType print){
        String string;
        if (curso == null || curso.length() == 0)
            string = getCodigo()+" esta enseñando...";
        else
            string = getCodigo()+" esta enseñando "+curso;
        switch (print){
            case SOUT -> System.out.println(string);
            case PANEL -> PanelLib.showMessage(string);
            default -> {}
        }
        return string;
    }

    public String educar(String curso){
        return educar(curso, PrintType.NONE);
    }

    public String educar(){
        return educar(null, PrintType.NONE);
    }

    public double calcularCargaPatronal(){
        return getSalario()*0.105;
    }
}
