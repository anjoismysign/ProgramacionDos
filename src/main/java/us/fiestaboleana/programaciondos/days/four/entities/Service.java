package us.fiestaboleana.programaciondos.days.four.entities;

import us.fiestaboleana.java.libraries.AlgorithmLib;

import java.util.Collection;

public class Service {

    public static void fillClientCollection(Collection<Cliente> collection,
                                            String message) {
        AlgorithmLib.dynamicRun(() -> {
            Cliente cliente = Cliente.build();
            cliente.fillMovies();
            collection.add(cliente);
        }, message);
    }
}
