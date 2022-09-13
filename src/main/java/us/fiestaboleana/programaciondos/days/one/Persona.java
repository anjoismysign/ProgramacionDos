package us.fiestaboleana.programaciondos.days.one;

import us.fiestaboleana.java.libraries.PanelLib;
import us.fiestaboleana.programaciondos.objects.Displayable;

public abstract class Persona implements Displayable {

    private String cedula, nombre, apellidos, direccion;

    public Persona(){}

    public Persona(String cedula, String nombre,
                   String apellidos, String direccion) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.direccion = direccion;
        display();
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public String getInfo() {
        return "Cedula: "+getCedula()+"\n"+
                "Nombre: "+getNombre()+"\n"+
                "Apellidos: "+getApellidos()+"\n"+
                "Direccion: "+getDireccion()+"\n";
    }

    @Override
    public void display() {
        PanelLib.showMessage("Persona - Resultado", getInfo());
    }

    public String conocer(PrintType print){
        String string = "Mi nombre es "+getNombre();
        switch (print){
            case SOUT -> System.out.println(string);
            case PANEL -> PanelLib.showMessage(string);
            default -> {}
        }
        return string;
    }

    public String conocer(){
        return conocer(PrintType.NONE);
    }

    public String caminar(PrintType print){
        String string = "Estoy caminando...";
        switch (print){
            case SOUT -> System.out.println(string);
            case PANEL -> PanelLib.showMessage(string);
            default -> {}
        }
        return string;
    }

    public String caminar(){
        return caminar(PrintType.NONE);
    }

    public String comer(String comida, PrintType print){
        String string;
        if (comida == null || comida.length() == 0)
            string = "Yummie, estoy comiendo";
        else
            string = "Estoy comiendo "+comida;
        switch (print){
            case SOUT -> System.out.println(string);
            case PANEL -> PanelLib.showMessage(string);
            default -> {}
        }
        return string;
    }

    public String comer(String comida){
        return comer(comida, PrintType.NONE);
    }

    public String comer(){
        return comer(null, PrintType.NONE);
    }
}
