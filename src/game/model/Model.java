package game.model;

import game.model.entities.Entities;
import game.model.entities.players.Spieler;
import game.model.entities.StatMenu;
import game.model.actions.Action;

import java.awt.*;
import java.util.ArrayList;

public class Model {
    private ArrayList<Entities> entities;
    private StatMenu statMenu;
    private ArrayList<Action> activeActions;


    public Model(Dimension d){
        statMenu = new StatMenu(d);
        entities = new ArrayList<>();
        activeActions = new ArrayList<>();
    }

    public void addPlayer(Dimension dtemp, String name){
        entities.add(0, new Spieler(new Dimension(30,30),dtemp, this, name, 100));
    }

    public void removePalyer(){
        entities.remove(0);
    }

    public ArrayList<Action> getActiveActions() {
        return activeActions;
    }

    public void setActiveActions(ArrayList<Action> activeActions) {
        this.activeActions = activeActions;
    }

    public ArrayList<Entities> getEntities() {
        return entities;
    }

    public void addEntities(Entities e) {
        entities.add(e);
    }

    public void removeEntities(Entities e) {
        entities.remove(e);
    }

    public void setEntities(ArrayList<Entities> entities) {
        this.entities = entities;
    }

    public StatMenu getStatMenu() {
        return statMenu;
    }

    public void setStatMenu(StatMenu statMenu) {
        this.statMenu = statMenu;
    }
}
