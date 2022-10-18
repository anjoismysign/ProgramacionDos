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

public class Tournament implements Displayable {
    private ImageIcon icon;
    private String tournamentName;
    private List<NationalTeam> teams;

    public static Tournament build() {
        AnjoPane pane = AnjoPane.build(Arrays.asList(new AnjoComponent[]{
                        new AnjoComponent("Nombre del torneo", new JTextField(27))}),
                "NUEVO TORNEO", 0, null);
        String tournamentName = pane.getTextFieldText(0);
        Tournament tournament = new Tournament(tournamentName);
        tournament.fillTeams();
        return tournament;
    }

    public static Tournament QATAR() {
        Tournament tournament = new Tournament("QATAR 2022 WORLD CUP");
        tournament.setIcon(new ImageIcon("src/main/resources/qatar.png"));
        tournament.fillTeams();
        return tournament;
    }

    public Tournament(String tournamentName) {
        this.tournamentName = tournamentName;
        this.teams = new ArrayList<>();
    }

    public String getTournamentName() {
        return tournamentName;
    }

    public void setTournamentName(String tournamentName) {
        this.tournamentName = tournamentName;
    }

    public ImageIcon getIcon() {
        return icon;
    }

    public void setIcon(ImageIcon icon) {
        this.icon = icon;
    }

    public Image scaledIcon(int width, int height) {
        return icon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
    }

    public void fillTeams() {
        AlgorithmLib.dynamicRun(() -> {
            NationalTeam team = NationalTeam.build(this);
            teams.add(team);
        }, "¿Desea agregar otra selección?");
    }

    public long totalGoals() {
        UberLong total = new UberLong(0);
        teams.forEach(team -> {
            total.setValue(total.getValue() + team.totalGoals());
        });
        return total.getValue();
    }

    public long totalPlayers() {
        UberLong total = new UberLong(0);
        teams.forEach(team -> {
            total.setValue(total.getValue() + team.totalPlayers());
        });
        return total.getValue();
    }

    public double averageTeamGoals() {
        return totalGoals() / teams.size();
    }

    public double averagePlayerGoals() {
        double avg = totalGoals() / totalPlayers();
        return avg;
    }

    @Override
    public String getInfo() {
        return getTournamentName() + "\n" +
                teams.size() + " equipo(s)";
    }

    @Override
    public void display() {
        teams.forEach(team -> {
            team.display();
        });
        PanelLib.showMessage(getTournamentName(),
                "Cantidad total de Selecciones registradas: " + teams.size() + "\n" +
                        "Cantidad total de jugadores registrados: " + totalPlayers() + "\n" +
                        "Cantidad total de goles anotados: " + totalGoals() + "\n" +
                        "Promedio de goles por Selección: " + averageTeamGoals() + "\n" +
                        "Promedio de goles por jugador: " + averagePlayerGoals());
    }
}
