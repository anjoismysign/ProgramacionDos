package us.fiestaboleana.programaciondos.carry.algebraone.entities;

import us.fiestaboleana.java.objects.IntegerResult;
import us.fiestaboleana.java.swing.AnjoComponent;
import us.fiestaboleana.java.swing.AnjoPane;

import javax.swing.*;
import java.util.Arrays;

public class Course {
    private String name;
    private int booksInventory;

    public static Course build(Library library) {
        AnjoPane pane = AnjoPane.build(Arrays.asList(new AnjoComponent[]{
                        new AnjoComponent("Nombre del curso", new JTextField(27)),
                        new AnjoComponent("Inventario de libros", new JTextField(27))}),
                "NUEVO CURSO", 0, library.scaledIcon(128, 128));
        String name = pane.getTextFieldText(0);
        IntegerResult result = pane.getInteger(1);
        if (!result.isValid())
            return Course.build(library);
        return new Course(name, result.value());
    }

    public Course(String name, int booksInventory) {
        this.name = name;
        this.booksInventory = booksInventory;
    }

    public Course() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBooksInventory() {
        return booksInventory;
    }

    public void setBooksInventory(int booksInventory) {
        this.booksInventory = booksInventory;
    }
}
