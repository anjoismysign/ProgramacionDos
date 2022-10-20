package us.fiestaboleana.programaciondos.carry.algebraone.entities;

import us.fiestaboleana.java.swing.AnjoComponent;
import us.fiestaboleana.java.swing.AnjoPane;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

enum OperationType {
    ADDITION,
    SUBTRACTION,
    FIRSTSET
}

public class LibraryOperation {
    private Course course;
    private OperationType operationType;
    private List<Integer> quantities;

    public static LibraryOperation query(Library library) {
        JComboBox<String> courses = new JComboBox<>(library.getListStringCourses().toArray(new String[0]));
        AnjoPane pane = AnjoPane.build(Arrays.asList(new AnjoComponent[]{
                        new AnjoComponent("Curso", courses),
                        new AnjoComponent("Tipo de operación", new JComboBox<>(new String[]{"SUMA", "RESTA"})),
                        new AnjoComponent("Cantidades (i.e: '1,4')", new JTextField(30))}),
                library.getName().toUpperCase() + " - NUEVA OP.", 0, library.scaledIcon(128, 128));
        Course course = library.getCourses().get(pane.getComboBoxText(0));
        OperationType operationType = pane.getComboBoxText(1).equals("SUMA") ? OperationType.ADDITION : OperationType.SUBTRACTION;
        List<Integer> quantities = new ArrayList<>();
        Arrays.stream(pane.getTextFieldText(2).split(",")).forEach(quantity -> quantities.add(Integer.parseInt(quantity)));
        return new LibraryOperation(course, operationType, quantities);
    }

    public static LibraryOperation firstSet(Library library, Course course) {
        AnjoPane pane = AnjoPane.build(Arrays.asList(new AnjoComponent[]{
                        new AnjoComponent("Cantidades (i.e: '1,4')", new JTextField(30))}),
                course.getName().toUpperCase() + " - PRIMER MATRIZ", 0, library.scaledIcon(128, 128));
        List<Integer> quantities = new ArrayList<>();
        Arrays.stream(pane.getTextFieldText(0).split(",")).forEach(quantity -> quantities.add(Integer.parseInt(quantity)));
        return new LibraryOperation(course, OperationType.FIRSTSET, quantities);
    }

    public LibraryOperation(Course course, OperationType operationType, List<Integer> quantities) {
        this.course = course;
        this.operationType = operationType;
        this.quantities = quantities;
    }

    public LibraryOperation() {
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public OperationType getType() {
        return operationType;
    }

    public void setType(OperationType operationType) {
        this.operationType = operationType;
    }

    public List<Integer> getQuantities() {
        return quantities;
    }

    public void setQuantities(List<Integer> quantities) {
        this.quantities = quantities;
    }

    public void addQuantity(int quantity) {
        this.quantities.add(quantity);
    }
}
