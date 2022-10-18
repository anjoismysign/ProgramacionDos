package us.fiestaboleana.programaciondos.days.four;

import us.fiestaboleana.java.swing.AnjoComponent;
import us.fiestaboleana.java.swing.AnjoPane;
import us.fiestaboleana.programaciondos.days.four.entities.FourCliente;
import us.fiestaboleana.programaciondos.days.four.entities.FourDatabaseManager;
import us.fiestaboleana.programaciondos.days.four.entities.FourMovieGenre;
import us.fiestaboleana.programaciondos.days.four.entities.FourService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Four {
    public static void run() {
        FourDatabaseManager manager = new FourDatabaseManager();
        HashMap<String, FourCliente> clientesMap = new HashMap<>();
        {
            try {
                PreparedStatement statement = manager.getConnection().prepareStatement("select * from data");
                ResultSet resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    FourCliente cliente = FourDatabaseManager.fromResultSet(resultSet);
                    if (cliente == null)
                        return;
                    clientesMap.put(cliente.fullName(), cliente);
                }
                resultSet.close();
                statement.close();
                statement.getConnection().close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        HashMap<FourMovieGenre, Integer> total = new HashMap<>();
        FourService.fillClientMap(clientesMap, "¿Desea agregar otro cliente?", manager);
        clientesMap.values().forEach(cliente -> {
            System.out.println("Cliente: " + cliente.fullName());
            manager.save(cliente);
        });
        List<String> clientesString = new ArrayList<>();
        clientesMap.values().parallelStream().forEach(cliente -> {
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
            FourCliente cliente = clientesMap.get(selected);
            cliente.getMovies().forEach(movie -> {
                movies.addItem(movie.title());
            });
        });
        String selected = (String) clients.getSelectedItem();
        clientesMap.get(selected).getMovies().forEach(movie -> {
            movies.addItem(movie.title());
        });
        AnjoPane.build(Arrays.asList(new AnjoComponent("Clientes", clients),
                        new AnjoComponent("Películas", movies)),
                "REC - Adm.", -1, new ImageIcon("src/main/resources/rec.png").getImage().getScaledInstance(128, 128, Image.SCALE_SMOOTH));
        AnjoPane.build(Arrays.asList(new AnjoComponent("ACCIÓN", new JLabel(String.valueOf(total.get(FourMovieGenre.ACCION)))),
                        new AnjoComponent("COMEDIA", new JLabel(String.valueOf(total.get(FourMovieGenre.COMEDIA)))),
                        new AnjoComponent("FICCIÓN", new JLabel(String.valueOf(total.get(FourMovieGenre.FICCION)))),
                        new AnjoComponent("DRAMA", new JLabel(String.valueOf(total.get(FourMovieGenre.DRAMA))))),
                "REC - Total", -1, new ImageIcon("src/main/resources/rec.png").getImage().getScaledInstance(128, 128, Image.SCALE_SMOOTH));
    }
}
