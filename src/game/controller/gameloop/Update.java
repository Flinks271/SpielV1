package game.controller.gameloop;

import game.controller.gameloop.inputs.Playerinput;
import game.model.Model;
import game.model.entities.Entities;
import game.model.entities.players.Spieler;

import java.util.ArrayList;

public class Update {


    public static void update(Playerinput input, Model model, float diffrence){




        //Bewegung des Spielers
        Spieler spieler =(Spieler) model.getEntities().get(0);
        if (input.getUp() && input.getDown()){

        }else {
            if (input.getUp()){spieler.movePositionY(- diffrence);}
            if (input.getDown()){spieler.movePositionY(diffrence);}
        }
        if (input.getRight() && input.getLeft()){

        }else {
            if (input.getRight()){spieler.movePositionX(diffrence);}
            if (input.getLeft()){spieler.movePositionX(- diffrence);}
        }
        if (input.getSpace()){
            spieler.spacePressed(input.getMouse(), input);
            input.setSpace(false);
        }
        if (input.getAngriff()){
            spieler.leftMouseButton(input.getMouse());
            input.setAngriff(false);
        }
        spieler.setLocation();

        ArrayList<Entities> gone = new ArrayList<>();
        for (Entities k: model.getEntities()) {
            if (k.isKill()){
                gone.add(k);
            }
        }
        model.getEntities().removeAll(gone);


    }
}
