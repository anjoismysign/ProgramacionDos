package us.fiestaboleana.programaciondos.days.three.entities;

public class CargoThree {
    private String descripcion;
    private double salarioPorHora;

    public CargoThree(String descripcion, double salarioPorHora) {
        this.descripcion = descripcion;
        this.salarioPorHora = salarioPorHora;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getSalarioPorHora() {
        return salarioPorHora;
    }

    public void setSalarioPorHora(double salarioPorHora) {
        this.salarioPorHora = salarioPorHora;
    }

    public String toString() {
        return getDescripcion() + " | " + getSalarioPorHora() + "/h";
    }
}
