package us.fiestaboleana.programaciondos.days.four.entities;

import us.fiestaboleana.java.swing.AnjoComponent;
import us.fiestaboleana.java.swing.AnjoPane;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public record Movie(String title, MovieGenre genre) {

    public static Movie build(String anjoPaneTitle) {
        AnjoPane pane = AnjoPane.build(Arrays.asList(new AnjoComponent[]{
                        new AnjoComponent("Título", new JTextField(27)),
                        new AnjoComponent("Género", new JComboBox<>(new String[]{"ACCION", "COMEDIA", "FICCION", "DRAMA"}))}),
                anjoPaneTitle, 0, new ImageIcon("src/main/resources/rec.png").getImage().getScaledInstance(128, 128, Image.SCALE_SMOOTH));
        String title = pane.getTextFieldText(0);
        MovieGenre genre = MovieGenre.valueOf(pane.getComboBoxText(1));
        return new Movie(title, genre);
    }

}
