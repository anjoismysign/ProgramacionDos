package us.fiestaboleana.programaciondos.days.two.entities;

public abstract class PersonaTwo {

    private String cedula, nombre;
    private int edad;

    public PersonaTwo(String cedula, String nombre, int edad){
        this.cedula = cedula;
        this.nombre = nombre;
        this.edad = edad;
    }

    public PersonaTwo(){}

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

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
}
