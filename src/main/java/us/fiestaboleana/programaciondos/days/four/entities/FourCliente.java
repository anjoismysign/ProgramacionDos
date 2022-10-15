package us.fiestaboleana.programaciondos.days.four.entities;

import us.fiestaboleana.java.libraries.AlgorithmLib;
import us.fiestaboleana.java.libraries.PanelLib;
import us.fiestaboleana.java.swing.AnjoComponent;
import us.fiestaboleana.java.swing.AnjoPane;
import us.fiestaboleana.programaciondos.interfaces.Displayable;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class FourCliente implements Displayable, Serializable {
    private String nombre, apellido, id;
    private List<FourMovie> movies;

    public static FourCliente build(String id) {
        AnjoPane pane = AnjoPane.build(Arrays.asList(new AnjoComponent[]{
                        new AnjoComponent("Nombre", new JTextField(20)),
                        new AnjoComponent("Apellido", new JTextField(20))}),
                "REC", -1, new ImageIcon("src/main/resources/rec.png").getImage().getScaledInstance(128, 128, Image.SCALE_SMOOTH));
        String nombre = pane.getTextFieldText(0);
        String apellido = pane.getTextFieldText(1);
        return new FourCliente(nombre, apellido, id);
    }

    public static FourCliente deserialize(byte[] serialized) {
        FourCliente proprietor;
        if (serialized == null)
            return FourCliente.build(UUID.randomUUID().toString());
        ByteArrayInputStream bis = new ByteArrayInputStream(serialized);
        ObjectInput in;
        try {
            in = new ObjectInputStream(bis);
            proprietor = (FourCliente) in.readObject();
            return proprietor;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public FourCliente(String nombre, String apellido, String id) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.movies = new ArrayList<>();
        this.id = id;
    }

    public FourCliente() {
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

    public List<FourMovie> getMovies() {
        return movies;
    }

    public void setMovies(List<FourMovie> movies) {
        this.movies = movies;
    }

    public String fullName() {
        return getNombre() + " " + getApellido();
    }

    public void fillMovies() {
        AlgorithmLib.dynamicRun(() -> {
            movies.add(FourMovie.build("REC - " + fullName()));
        }, "¿Desea agregar otra película?");
    }

    public String compressMovies() {
        StringBuilder sb = new StringBuilder();
        for (FourMovie movie : movies) {
            sb.append(movie.title()).append(", ");
        }
        sb.delete(sb.length() - 3, sb.length() - 1);
        return sb.toString();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public byte[] serialize() {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutput out;
        try {
            out = new ObjectOutputStream(bos);
            out.writeObject(this);
            byte b[] = bos.toByteArray();
            out.close();
            bos.close();
            return b;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
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
