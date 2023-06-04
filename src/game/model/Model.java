package game.model;

import game.model.entities.Entities;
import game.model.entities.Spieler;

import java.awt.*;
import java.util.ArrayList;

public class Model {
    private ArrayList<Entities> entities;


    public Model(){
        entities = new ArrayList<>();
        entities.add(new Spieler(30,new Dimension(30,30)));
    }


    public ArrayList<Entities> getEntities() {
        return entities;
    }

    public void setEntities(ArrayList<Entities> entities) {
        this.entities = entities;
    }
}
