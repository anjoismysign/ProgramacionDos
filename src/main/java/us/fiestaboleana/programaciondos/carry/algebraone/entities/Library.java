package us.fiestaboleana.programaciondos.carry.algebraone.entities;

import com.google.common.collect.Iterables;
import us.fiestaboleana.java.libraries.AlgorithmLib;
import us.fiestaboleana.java.libraries.PanelLib;
import us.fiestaboleana.java.swing.AnjoComponent;
import us.fiestaboleana.java.swing.AnjoPane;
import us.fiestaboleana.programaciondos.interfaces.Displayable;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Library implements Displayable {
    private String name;
    private HashMap<String, Course> courses;
    private HashMap<Course, List<LibraryResult>> results;
    private ImageIcon icon;

    public static Library build() {
        ImageIcon icon = new ImageIcon("src/main/resources/icon.png");
        AnjoPane pane = AnjoPane.build(Arrays.asList(new AnjoComponent[]{
                        new AnjoComponent("Nombre de la biblioteca", new JTextField(27))}),
                "NUEVA BIBLIOTECA", 0, icon.getImage().getScaledInstance(128, 128, Image.SCALE_SMOOTH));
        String name = pane.getTextFieldText(0);
        Library library = new Library(name, icon);
        library.fillCourses();
        library.queryOperations();
        return library;
    }

    /**
     * @param name nombre del curso.
     * @param icon imagen del menú. puede ser null.
     */
    public Library(String name, ImageIcon icon) {
        this.name = name;
        this.results = new HashMap<>();
        this.courses = new HashMap<>();
        this.icon = icon;
    }

    public Library() {
    }

    private LibraryResult perform(LibraryOperation operation, boolean addToResults) {
        Course course = operation.getCourse();
        List<Integer> quantities = arithmeticQuantities(pullLast(course), operation);
        LibraryResult result = new LibraryResult(operation.getCourse(), quantities);
        if (addToResults)
            pushResult(course, result);
        return result;
    }

    private List<Integer> arithmeticQuantities(LibraryResult last, LibraryOperation operation) {
        List<Integer> quantities;
        List<Integer> operationQuantities = operation.getQuantities();
        if (last == null) {
            quantities = operation.getQuantities();
        } else {
            quantities = new ArrayList<>();
            int i = 0;
            boolean add = operation.getType() == OperationType.ADDITION ? true : false;
            if (add)
                for (Integer integer : last.quantities()) {
                    quantities.add(integer + Iterables.get(operationQuantities, i, 0));
                    i++;
                }
            else
                for (Integer integer : last.quantities()) {
                    quantities.add(integer - Iterables.get(operationQuantities, i, 0));
                    i++;
                }
        }
        return quantities;
    }

    public void fillCourses() {
        AlgorithmLib.dynamicRun(() -> {
            Course course = Course.build(this);
            courses.put(course.getName(), course);
            pushResult(course, perform(LibraryOperation.firstSet(this,
                    course), true));
        }, getName(), "¿Desea ingresar otro curso?");
    }

    public void queryOperations() {
        AlgorithmLib.dynamicRun(() -> {
            LibraryOperation operation = LibraryOperation.query(this);
            pushResult(operation.getCourse(), perform(operation, true));
        }, getName(), "¿Desea agregar otra operación?");
    }

    public List<String> getListStringCourses() {
        List<String> list = new ArrayList<>();
        for (Course course : courses.values()) {
            list.add(course.getName());
        }
        return list;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HashMap<Course, List<LibraryResult>> getResults() {
        return results;
    }

    public void setResults(HashMap<Course, List<LibraryResult>> results) {
        this.results = results;
    }

    public void pushResult(Course course, LibraryResult result) {
        if (results.containsKey(course)) {
            List<LibraryResult> courseResults = results.get(course);
            courseResults.add(result);
        } else {
            List<LibraryResult> courseResults = new ArrayList<>();
            courseResults.add(result);
            results.put(course, courseResults);
        }
    }

    public LibraryResult pullLast(Course course) {
        if (!results.containsKey(course)) {
            return null;
        }
        return results.get(course).get(results.get(course).size() - 1);
    }

    public HashMap<String, Course> getCourses() {
        return courses;
    }

    public void setCourses(HashMap<String, Course> courses) {
        this.courses = courses;
    }

    public Course getCourse(String name) {
        return courses.get(name);
    }

    public ImageIcon getIcon() {
        return icon;
    }

    public void setIcon(ImageIcon icon) {
        this.icon = icon;
    }

    public Image scaledIcon(int width, int height) {
        return icon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
    }

    @Override
    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        results.forEach((course, results) -> {
            sb.append(course.getName().toUpperCase() + ": \n");
            sb.append("  Inventario inicial:" + "\n");
            sb.append("  - " + course.getBooksInventory() + "\n");
            sb.append("  Matriz:" + "\n");
            StringBuilder courseBuilder = new StringBuilder();
            results.get(results.size() - 1).quantities().forEach(integer -> {
                courseBuilder.append(integer + ",");
            });
            courseBuilder.deleteCharAt(courseBuilder.length() - 1);
            sb.append("  - " + courseBuilder + "\n");
        });
        return sb.toString();
    }

    @Override
    public void display() {
        PanelLib.showMessage(getName().toUpperCase(), getInfo());
    }
}
