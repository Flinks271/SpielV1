package game.model.entities.players;

import game.controller.gameloop.inputs.Playerinput;
import game.model.Model;
import game.model.actions.Action;
import game.model.actions.leftmouse.MeleeInit;
import game.model.actions.space.Dash;
import game.model.actions.space.DashDirMov;
import game.model.entities.AliveThings;

import java.awt.*;
import java.util.ArrayList;

public class Spieler extends AliveThings {
    private Action space;
    private Action atack;
    private final String name;
    private int angriff;

    public Spieler(Dimension size, Dimension d, Model model, String name, int health){
        super(size,d, health);
        this.name = name;
        angriff = 0;
        space = new DashDirMov();
        atack = new MeleeInit(this, model);
        ArrayList<Action> actions = new ArrayList<>();
        actions.add(atack);
        actions.add(space);
        model.setActiveActions(actions);
    }

    public int getAngriff() {
        return angriff;
    }

    public void setAngriff(int angriff) {
        this.angriff = angriff;
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

    public void leftMouseButton(Point mouse){
        if (atack.getClass() == MeleeInit.class){
            MeleeInit k = (MeleeInit) atack;
            k.cast(mouse);
        }
    }

    @Override
    public void draw(Graphics2D g2D ){
        int nameWidth = g2D.getFontMetrics().stringWidth(name);
        int nameHeight = g2D.getFontMetrics().getHeight();
        int y = getPos_y() - (nameHeight/2);
        if (y < 11){
            y =(int) (getPos_y() + getSize().getHeight() + nameHeight);
        }

        g2D.drawString(name, getPos_x() + (getSize().width / 2) - (nameWidth / 2),y);

        g2D.fill(getBoundingArea());
    }



}