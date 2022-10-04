package us.fiestaboleana.programaciondos.days.three.entities;

public class PersonaThree {
    private String cedula, nombre;
    private boolean vacunado;

    public PersonaThree(String cedula, String nombre, boolean vacunado) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.vacunado = vacunado;
    }

    public PersonaThree() {
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

    public boolean isVacunado() {
        return vacunado;
    }

    public void setVacunado(boolean vacunado) {
        this.vacunado = vacunado;
    }

    public String comportamiento() {
        return "Me comporto como una persona";
    }
}
