package us.fiestaboleana.programaciondos.days.four.entities;

import us.fiestaboleana.java.swing.AnjoComponent;
import us.fiestaboleana.java.swing.AnjoPane;

import javax.swing.*;
import java.awt.*;
import java.io.Serializable;
import java.util.Arrays;

public record FourMovie(String title, FourMovieGenre genre) implements Serializable {

    public static FourMovie build(String anjoPaneTitle) {
        AnjoPane pane = AnjoPane.build(Arrays.asList(new AnjoComponent[]{
                        new AnjoComponent("Título", new JTextField(27)),
                        new AnjoComponent("Género", new JComboBox<>(new String[]{"ACCION", "COMEDIA", "FICCION", "DRAMA"}))}),
                anjoPaneTitle, 0, new ImageIcon("src/main/resources/rec.png").getImage().getScaledInstance(128, 128, Image.SCALE_SMOOTH));
        String title = pane.getTextFieldText(0);
        FourMovieGenre genre = FourMovieGenre.valueOf(pane.getComboBoxText(1));
        return new FourMovie(title, genre);
    }

}
