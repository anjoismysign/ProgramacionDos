package us.fiestaboleana.programaciondos;

import us.fiestaboleana.java.libraries.AlgorithmLib;
import us.fiestaboleana.programaciondos.days.one.Estudiante;

import java.util.ArrayList;
import java.util.List;

public class ProgramacionDos {

    public static void main(String[] args){
        Estudiante estudiante = Estudiante.build();
        estudiante.display();
//        List<Estudiante> estudiantes = new ArrayList<>();
//        AlgorithmLib.dynamicRun(()->{
//            estudiantes.add(Estudiante.build());
//        },"ULATINA","¿Desea ingresar otro estudiante?");
//        System.out.println(estudiantes.size());
//        estudiantes.parallelStream().forEach(estudiante -> {
//            estudiante.display();
//        });
    }
}
