package us.fiestaboleana.programaciondos;

import us.fiestaboleana.programaciondos.days.one.Estudiante;
import us.fiestaboleana.programaciondos.days.one.Util;

import java.util.ArrayList;
import java.util.List;

public class ProgramacionDos {

    public static void main(String[] args){
        List<Estudiante> estudiantes = new ArrayList<>();
        boolean next = true;
        while (next){
            estudiantes.add(Estudiante.build());
            next = Util.continuar();
        }
        estudiantes.parallelStream().forEach(estudiante -> {
            estudiante.display();
        });
    }
}
