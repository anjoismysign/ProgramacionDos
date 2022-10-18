package us.fiestaboleana.programaciondos.tests.one.entities;

import us.fiestaboleana.java.libraries.PanelLib;
import us.fiestaboleana.java.objects.IntegerResult;
import us.fiestaboleana.java.swing.AnjoComponent;
import us.fiestaboleana.java.swing.AnjoPane;
import us.fiestaboleana.programaciondos.interfaces.Displayable;
import us.fiestaboleana.programaciondos.tests.one.Pos;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class Player implements Displayable {
    private String fullName;
    private Pos position;
    private long goals;

    /**
     * @param team  equipo al que el jugador va a pertenecer.
     * @param image para el menú. puede ser null.
     * @return
     */
    public static Player build(NationalTeam team, Image image) {
        AnjoPane pane = AnjoPane.build(Arrays.asList(new AnjoComponent[]{
                        new AnjoComponent("Nombre", new JTextField(27)),
                        new AnjoComponent("Posición", new JComboBox<>(new String[]{"PORTERO", "DEFENSA",
                                "MEDIOCAMPO", "DELANTERO"})),
                        new AnjoComponent("Goles", new JTextField(27))}),
                team.getCountry() + " - JUG. NUEVO", 0, image);
        String name = pane.getTextFieldText(0);
        String posSelection = pane.getComboBoxText(1);
        IntegerResult goalsResult = pane.getInteger(2);
        if (!goalsResult.isValid())
            return Player.build(team, image);
        Pos pos;
        switch (posSelection) {
            case "PORTERO" -> pos = Pos.GOALKEEPER;
            case "DEFENSA" -> pos = Pos.DEFENDER;
            case "MEDIOCAMPO" -> pos = Pos.MIDFIELDER;
            case "DELANTERO" -> pos = Pos.STRIKER;
            default -> {
                return Player.build(team, image);
            }
        }
        return new Player(name, pos, goalsResult.value());
    }

    /**
     * @param fullName el nombre. se pretende que sea completo.
     * @param position la posición del jugador.
     * @param goals    long datatype acepta "int".
     */
    public Player(String fullName, Pos position, long goals) {
        this.fullName = fullName;
        this.position = position;
        this.goals = goals;
    }

    public Player() {
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Pos getPosition() {
        return position;
    }

    public void setPosition(Pos position) {
        this.position = position;
    }

    public long getGoals() {
        return goals;
    }

    public void setGoals(long goals) {
        this.goals = goals;
    }

    @Override
    public String getInfo() {
        return getFullName() + "\n" +
                translatePosition() + "\n" +
                getGoals() + " goles" + "\n";
    }

    public String translatePosition() {
        switch (getPosition()) {
            case STRIKER -> {
                return "DELANTERO";
            }
            case DEFENDER -> {
                return "DEFENSA";
            }
            case MIDFIELDER -> {
                return "MEDIOCAMPO";
            }
            case GOALKEEPER -> {
                return "PORTERO";
            }
        }
        return "";
    }

    @Override
    public void display() {
        PanelLib.showMessage("JUGADOR", getInfo());
    }
}
