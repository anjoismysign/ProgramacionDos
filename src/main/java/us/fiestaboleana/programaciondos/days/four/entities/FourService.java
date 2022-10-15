package us.fiestaboleana.programaciondos.days.four.entities;

import us.fiestaboleana.java.libraries.AlgorithmLib;
import us.fiestaboleana.java.libraries.PanelLib;

import java.util.Collection;
import java.util.Map;
import java.util.UUID;

public class FourService {

    public static void fillClientCollection(Collection<FourCliente> collection,
                                            String message,
                                            FourDatabaseManager manager) {
        AlgorithmLib.dynamicRun(() -> {
            FourCliente cliente = FourCliente.build(UUID.randomUUID().toString());
            manager.createUser(cliente.getId(), true);
            cliente.fillMovies();
            collection.add(cliente);
        }, message);
    }

    public static void fillClientMap(Map<String, FourCliente> map,
                                     String message,
                                     FourDatabaseManager manager) {
        AlgorithmLib.dynamicRun(() -> {
            FourCliente cliente = FourCliente.build(UUID.randomUUID().toString());
            if (map.containsKey(cliente.fullName())) {
                PanelLib.showMessage("ERROR", "El cliente ya existe");
                return;
            }
            manager.createUser(cliente.getId(), true);
            cliente.fillMovies();
            map.put(cliente.fullName(), cliente);
        }, message);
    }
}
