package game.controller.gameloop;

import game.model.Model;
import game.model.entities.Spieler;

public class Update {


    public static void update(Playerinput input, Model model, float diffrence){




        //Bewegung des Spielers
        Spieler spieler =(Spieler) model.getEntities().get(0);
        if (input.getUp()){spieler.movePositionY(- diffrence);}
        if (input.getDown()){spieler.movePositionY(diffrence);}
        if (input.getRight()){spieler.movePositionX(diffrence);}
        if (input.getLeft()){spieler.movePositionX(- diffrence);}
        spieler.setLocation();



    }
}
