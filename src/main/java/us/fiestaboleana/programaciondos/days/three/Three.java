package us.fiestaboleana.programaciondos.days.three;

import us.fiestaboleana.java.libraries.PanelLib;
import us.fiestaboleana.programaciondos.days.three.entities.FuncionarioThree;
import us.fiestaboleana.programaciondos.days.three.entities.UberDouble;
import us.fiestaboleana.programaciondos.libs.AlgorithmLibTwo;

import java.util.ArrayList;
import java.util.List;

public class Three {
    public static void run() {
        List<FuncionarioThree> funcionarios = new ArrayList<>();
        UberDouble avg = new UberDouble(0);
        AlgorithmLibTwo.dynamicRun(() -> {
            funcionarios.add(FuncionarioThree.build());
        }, "FUNCIONARIO", "¿Desea agregar otro funcionario?");
        funcionarios.forEach(funcionario -> {
            funcionario.display();
            avg.setValue(avg.getValue() + funcionario.salarioTotal());
        });
        avg.setValue(avg.getValue() / funcionarios.size());
        PanelLib.showMessage("SIS. HOSP.", "Promedio salarial: " + avg.getValue());

//        List<PersonaThree> personas = new ArrayList<>();
//        if (PanelLib.requestInteger("¿Desea agregar estudiantes? Ingrese '0' de ser así.") == 0)
//            AlgorithmLib.dynamicRun(() -> {
//                EstudianteThree estudiante = EstudianteThree.build();
//                personas.add(estudiante);
//            }, "¿Desea agregar otro estudiante?");
//        if (PanelLib.requestInteger("¿Desea agregar profesores? Ingrese '0' de ser así.") == 0)
//            AlgorithmLib.dynamicRun(() -> {
//                ProfesorThree profesor = new ProfesorThree().build();
//                personas.add(profesor);
//            }, "¿Desea agregar otro profesor?");
//        personas.forEach(persona -> {
//            persona.getCedula()
//        });
    }
}
