package game.model.actions.leftmouse;

import game.model.Model;
import game.model.actions.Action;
import game.model.entities.attacks.MeleeAtack;
import game.model.entities.players.Spieler;

import java.awt.*;

public class MeleeInit extends Action {
    Spieler spieler;
    Model model;

    public MeleeInit(Spieler spieler, Model model){
        super(500);
        this.spieler = spieler;
        this.model = model;
    }

    public void cast(Point mouse){
        if (System.currentTimeMillis() - getLasttime() > getCooldown()){
            setLasttime(System.currentTimeMillis());
            if (spieler.getAngriff() == 0){
                model.addEntities(new MeleeAtack(12,100,spieler,mouse, model));
            }
        }
    }
}
