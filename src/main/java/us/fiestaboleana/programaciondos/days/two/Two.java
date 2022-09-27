package us.fiestaboleana.programaciondos.days.two;

import us.fiestaboleana.java.libraries.AlgorithmLib;
import us.fiestaboleana.programaciondos.days.two.entities.Escuela;
import us.fiestaboleana.programaciondos.days.two.entities.EstudianteTwo;

import java.util.ArrayList;
import java.util.List;

public class Two {

    public static void run(){
        Escuela escuela = Escuela.build();
        escuela.getEstudiantes().forEach(EstudianteTwo::display);
    }
}
