package us.fiestaboleana.programaciondos.days.one;

import us.fiestaboleana.java.libraries.PanelLib;
import us.fiestaboleana.java.objects.DoubleResult;
import us.fiestaboleana.java.objects.IntegerResult;
import us.fiestaboleana.java.swing.AnjoComponent;
import us.fiestaboleana.java.swing.AnjoPane;
import us.fiestaboleana.programaciondos.objects.Displayable;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

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
        List<AnjoComponent> components = new ArrayList<>();
        components.add(new AnjoComponent("Cedula", new JTextField(20)));
        components.add(new AnjoComponent("Nombre", new JTextField(20)));
        components.add(new AnjoComponent("Apellidos", new JTextField(20)));
        components.add(new AnjoComponent("Direccion", new JTextField(20)));
        components.add(new AnjoComponent("Código", new JTextField(20)));
        components.add(new AnjoComponent("Salario", new JTextField(9)));
        components.add(new AnjoComponent("Cantidad de cursos", new JTextField(2)));
        AnjoPane pane = AnjoPane.build(components, "PROFESOR - NUEVO", 0, -1);
        String cedula = pane.getTextFieldText(0);
        String nombre = pane.getTextFieldText(1);
        String apellidos = pane.getTextFieldText(2);
        String direccion = pane.getTextFieldText(3);
        String codigo = pane.getTextFieldText(4);
        DoubleResult salarioResult = pane.getDouble(5);
        IntegerResult cursosResult = pane.getInteger(6);

        boolean salarioFailed = !salarioResult.isValid();
        boolean cursosFailed = !cursosResult.isValid();
        if (salarioFailed || cursosFailed){
            if (salarioFailed)
                PanelLib.showMessage("ERROR", "El salario se debe expresar como un número entero o decimal");
            if (cursosFailed)
                PanelLib.showMessage("ERROR", "Cantidad de cursos no es un número entero");
            return Profesor.build();
        }
        return new Profesor(cedula,nombre,apellidos,direccion, codigo, salarioResult.value(), cursosResult.value());
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
        PanelLib.showMessage("PROFESOR - RESULTADO", getInfo());
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
