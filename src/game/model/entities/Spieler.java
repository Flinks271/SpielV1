package game.model.entities;

import game.controller.gameloop.inputs.Playerinput;
import game.model.Model;
import game.model.entities.actions.Action;
import game.model.entities.actions.space.Dash;
import game.model.entities.actions.space.DashDirMov;

import java.awt.*;
import java.util.ArrayList;

public class Spieler extends Entities{
    private Action space;
    private String name;

    public Spieler(Dimension size, Dimension d, Model model, String name){
        super(size,d);
        this.name = name;
        System.out.println(name);
        space = new DashDirMov();
        ArrayList actions = new ArrayList<>();
        actions.add(space);
        model.setActiveActions(actions);
    }

    public void spacePressed(Point mouse, Playerinput input){
        if (space.getClass() == Dash.class){
            Dash spaceü = (Dash) space;
            spaceü.castSpace(this , mouse , getD());
        } else if (space.getClass() == DashDirMov.class) {
            DashDirMov spaceü = (DashDirMov) space;
            spaceü.castSpace(this , input);
        }
    }

    @Override
    public void draw(Graphics2D g2D ){
        int nameWidth = g2D.getFontMetrics().stringWidth(name);
        int nameHeight = g2D.getFontMetrics().getHeight();
        int y = (int) (getPos_y() - (nameHeight/2) );
        if (y < 11){
            y =(int) (getPos_y() + getSize().getHeight() + nameHeight);
        }

        g2D.drawString(name,(int) (getPos_x() + (getSize().width / 2) - (nameWidth / 2)),y);

        g2D.fill(getBoundingArea());
    }



}