package us.fiestaboleana.programaciondos.days.four.entities;

import us.fiestaboleana.java.libraries.AlgorithmLib;
import us.fiestaboleana.java.libraries.PanelLib;
import us.fiestaboleana.java.swing.AnjoComponent;
import us.fiestaboleana.java.swing.AnjoPane;
import us.fiestaboleana.programaciondos.interfaces.Displayable;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Cliente implements Displayable {
    private String nombre, apellido;
    private List<Movie> movies;

    public static Cliente build() {
        AnjoPane pane = AnjoPane.build(Arrays.asList(new AnjoComponent[]{
                        new AnjoComponent("Nombre", new JTextField(20)),
                        new AnjoComponent("Apellido", new JTextField(20))}),
                "REC", -1, new ImageIcon("src/main/resources/rec.png").getImage().getScaledInstance(128, 128, Image.SCALE_SMOOTH));
        String nombre = pane.getTextFieldText(0);
        String apellido = pane.getTextFieldText(1);
        return new Cliente(nombre, apellido);
    }

    public Cliente(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.movies = new ArrayList<>();
    }

    public Cliente() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

    public String fullName() {
        return getNombre() + " " + getApellido();
    }

    public void fillMovies() {
        AlgorithmLib.dynamicRun(() -> {
            movies.add(Movie.build("REC - " + fullName()));
        }, "¿Desea agregar otra película?");
    }

    public String compressMovies() {
        StringBuilder sb = new StringBuilder();
        for (Movie movie : movies) {
            sb.append(movie.title()).append(", ");
        }
        sb.delete(sb.length() - 3, sb.length() - 1);
        return sb.toString();
    }

    @Override
    public String getInfo() {
        return "Nombre: " + getNombre() + "\n" +
                "Apellido: " + getApellido() + "\n" +
                "Películas: " + compressMovies() + "\n";
    }

    @Override
    public void display() {
        PanelLib.showMessage("REC - " + fullName(), getInfo());
    }
}
