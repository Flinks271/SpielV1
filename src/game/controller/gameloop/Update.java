package game.controller.gameloop;

import game.controller.gameloop.inputs.Playerinput;
import game.model.Model;
import game.model.entities.players.Spieler;

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
        spieler.setLocation();



    }
}
