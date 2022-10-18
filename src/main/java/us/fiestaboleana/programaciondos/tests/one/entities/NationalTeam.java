package us.fiestaboleana.programaciondos.tests.one.entities;

import us.fiestaboleana.java.libraries.AlgorithmLib;
import us.fiestaboleana.java.libraries.PanelLib;
import us.fiestaboleana.java.swing.AnjoComponent;
import us.fiestaboleana.java.swing.AnjoPane;
import us.fiestaboleana.programaciondos.interfaces.Displayable;
import us.fiestaboleana.programaciondos.tests.one.UberLong;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NationalTeam implements Displayable {
    private String country;
    private List<Player> players;

    public static NationalTeam build(Tournament tournament) {
        Image image = tournament.scaledIcon(128, 128);
        AnjoPane pane = AnjoPane.build(Arrays.asList(new AnjoComponent[]{
                        new AnjoComponent("País", new JTextField(27))}),
                tournament.getTournamentName(),
                0, image);
        String country = pane.getTextFieldText(0);
        NationalTeam team = new NationalTeam(country);
        team.fillPlayers(image);
        return team;
    }

    public NationalTeam(String country) {
        this.country = country;
        this.players = new ArrayList<>();
    }

    public NationalTeam() {
    }


    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * @param image para el menú. puede ser null.
     */
    public void fillPlayers(Image image) {
        AlgorithmLib.dynamicRun(() -> {
            Player player = Player.build(this, image);
            players.add(player);
        }, "¿Desea agregar otro jugador?");
    }

    public int totalPlayers() {
        return players.size();
    }

    public long totalGoals() {
        UberLong total = new UberLong(0);
        players.forEach(player -> {
            total.setValue(total.getValue() + player.getGoals());
        });
        return total.getValue();
    }

    @Override
    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append(getCountry().toUpperCase() + ":\n");
        players.forEach(player -> {
            sb.append(player.getInfo());
        });
        sb.append("Cantidad de goles de " + getCountry().toUpperCase() + " " + totalGoals() + " goles.");
        return sb.toString();
    }

    @Override
    public void display() {
        PanelLib.showMessage(getCountry().toUpperCase(), getInfo());
    }
}
