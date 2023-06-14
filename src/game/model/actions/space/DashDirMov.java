package game.model.actions.space;

import game.controller.gameloop.inputs.Playerinput;
import game.model.entities.players.Spieler;
import game.model.actions.Action;

public class DashDirMov extends Action {
    private int length;



    public DashDirMov(){
        super();
        length = 150;
    }

    public void castSpace(Spieler spieler, Playerinput input){
        if (System.currentTimeMillis() - getLasttime() > getCooldown()){

            if (input.getUp() && input.getDown()){

            }else {
                int y = spieler.getPos_y();
                if (input.getUp()){
                    y = y -length;
                    if (y  < 0){
                        y = 0;
                    }
                    setLasttime(System.currentTimeMillis());
                }else if(input.getDown()){
                    y = y + length;
                    if (y  > spieler.getD().getHeight() - spieler.getSize().getHeight()){
                        y = (int) (spieler.getD().getHeight() - spieler.getSize().getHeight());
                    }
                    setLasttime(System.currentTimeMillis());
                }
                spieler.setPos_y(y);
            }

            if (input.getRight() && input.getLeft()){

            }else {
                int x = spieler.getPos_x();
                if (input.getLeft()){
                    x = x -length;
                    if (x < 0){
                        x = 0;
                    }
                    setLasttime(System.currentTimeMillis());
                }else if(input.getRight()){
                    x += length;
                    if (x > spieler.getD().getWidth() - spieler.getSize().getWidth()){
                        x =(int) (spieler.getD().getWidth() - spieler.getSize().getWidth());
                    }
                    setLasttime(System.currentTimeMillis());
                }
                spieler.setPos_x(x);
            }
        }
    }
}
