package us.fiestaboleana.programaciondos.days.two;

import us.fiestaboleana.programaciondos.days.one.entities.EstudianteOne;
import us.fiestaboleana.programaciondos.days.two.entities.Escuela;
import us.fiestaboleana.programaciondos.days.two.entities.EstudianteTwo;

import java.util.UUID;

public class Two {
    public static void run() {
        Escuela escuela = Escuela.build();
        escuela.getEstudiantes().forEach(EstudianteTwo::display);


        // INYECCIÓN DE DEPENDENCIA
        String cedula = UUID.randomUUID().toString();
        String carne = UUID.randomUUID().toString();
        String nombre = "Juan";
        String apellidos = "Mora Porras";
        String direccion = "San José, Costa Rica";
        int materias = 3;
        int cuatrimestre = 1;
        EstudianteOne estudiante = new EstudianteOne(cedula, nombre, apellidos, direccion,
                carne, materias, cuatrimestre);
        //cedula, nombre, apellidos, direccion, carne, materias y cuatrimestre son inyectados dentro de estudiante
        //en el constructor. el mismo constructor toma estas, pasa a super las que necesita haciendo
        //otra vez inyeccion de dependencia, pero esta vez a PersonaOne y ahora todas las variables son asignadas
        //en su respectiva clase.
    }
}