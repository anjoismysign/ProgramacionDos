package us.fiestaboleana.programaciondos.days.one;

import us.fiestaboleana.java.libraries.PanelLib;
import us.fiestaboleana.java.libraries.SwingLib;
import us.fiestaboleana.java.objects.AnjoComponent;
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
        JPanel panel = SwingLib.anjoPane(components, "Profesor", 2, -1, 0);
        String cedula = SwingLib.getTextFromAnjoJTextField(panel, 0);
        String nombre = SwingLib.getTextFromAnjoJTextField(panel, 1);
        String apellidos = SwingLib.getTextFromAnjoJTextField(panel, 2);
        String direccion = SwingLib.getTextFromAnjoJTextField(panel, 3);
        String codigo = SwingLib.getTextFromAnjoJTextField(panel, 4);
        boolean salarioFailed = false;
        boolean cursosImpartidosFailed = false;
        double salario;
        try{
            salario = Double.parseDouble(SwingLib.getTextFromAnjoJTextField(panel, 5));
        } catch (NumberFormatException e) {
            salario = 0;
            salarioFailed = true;
        }
        int cursosImpartidos;
        try{
            cursosImpartidos = Integer.parseInt(SwingLib.getTextFromAnjoJTextField(panel, 6));
        } catch (NumberFormatException e) {
            cursosImpartidos = 0;
            cursosImpartidosFailed = true;
        }
        if (salarioFailed){
            PanelLib.showMessage("ERROR", "La cantidad de materias debe ser un número entero");
        }
        if (cursosImpartidosFailed){
            PanelLib.showMessage("ERROR", "El cuatrimestre debe ser un número entero");
        }
        if (salarioFailed || cursosImpartidosFailed){
            return Profesor.build();
        }
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
