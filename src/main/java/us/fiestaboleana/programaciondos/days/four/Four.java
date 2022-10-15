package us.fiestaboleana.programaciondos.days.four;

import us.fiestaboleana.java.swing.AnjoComponent;
import us.fiestaboleana.java.swing.AnjoPane;
import us.fiestaboleana.programaciondos.days.four.entities.Cliente;
import us.fiestaboleana.programaciondos.days.four.entities.MovieGenre;
import us.fiestaboleana.programaciondos.days.four.entities.Service;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Four {
    public static void run() {
        List<Cliente> clientes = new ArrayList<>();
        HashMap<String, Cliente> clientesMap = new HashMap<>();
        HashMap<MovieGenre, Integer> total = new HashMap<>();
        Service.fillClientCollection(clientes, "¿Desea agregar otro cliente?");
        List<String> clientesString = new ArrayList<>();
        clientes.parallelStream().forEach(cliente -> {
            String fullName = cliente.fullName();
            clientesString.add(fullName);
            clientesMap.put(fullName, cliente);
            cliente.getMovies().parallelStream().forEach(movie -> {
                total.put(movie.genre(), total.getOrDefault(movie.genre(), 0) + 1);
            });
        });
        JComboBox<String> movies = new JComboBox<>();
        JComboBox<String> clients = new JComboBox<>(clientesString.toArray(new String[0]));
        clients.addItemListener(e -> {
            if (e.getStateChange() != ItemEvent.SELECTED)
                return;
            movies.removeAllItems();
            String selected = (String) e.getItem();
            Cliente cliente = clientesMap.get(selected);
            cliente.getMovies().forEach(movie -> {
                movies.addItem(movie.title());
            });
        });
        String selected = (String) clients.getSelectedItem();
        clientesMap.get(selected).getMovies().forEach(movie -> {
            movies.addItem(movie.title());
        });
        AnjoPane clientsPane = AnjoPane.build(Arrays.asList(new AnjoComponent("Clientes", clients),
                        new AnjoComponent("Películas", movies)),
                "REC - Adm.", -1, new ImageIcon("src/main/resources/rec.png").getImage().getScaledInstance(128, 128, Image.SCALE_SMOOTH));
        AnjoPane totalPane = AnjoPane.build(Arrays.asList(new AnjoComponent("ACCIÓN", new JLabel(String.valueOf(total.get(MovieGenre.ACCION)))),
                        new AnjoComponent("COMEDIA", new JLabel(String.valueOf(total.get(MovieGenre.COMEDIA)))),
                        new AnjoComponent("FICCIÓN", new JLabel(String.valueOf(total.get(MovieGenre.FICCION)))),
                        new AnjoComponent("DRAMA", new JLabel(String.valueOf(total.get(MovieGenre.DRAMA))))),
                "REC - Total", -1, new ImageIcon("src/main/resources/rec.png").getImage().getScaledInstance(128, 128, Image.SCALE_SMOOTH));
    }
}
