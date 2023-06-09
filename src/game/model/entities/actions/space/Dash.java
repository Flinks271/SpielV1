package game.model.entities.actions.space;

import game.model.entities.Spieler;
import game.model.entities.actions.Action;

import java.awt.*;

public class Dash extends Action {
    private int length;



    public Dash(){
        super();
        length = 150;
    }

    public void castSpace(Spieler spieler, Point mouse, Dimension d){
        if (System.currentTimeMillis() - getLasttime() > getCooldown()){
            setLasttime(System.currentTimeMillis());
            Point s = spieler.getCenter();


            // angle in radians
            double angle =Math.atan2(mouse.getX() - s.getX(), mouse.getY() - s.getY());
            System.out.println(angle);

            int x =spieler.getPos_x() +(int) (Math.sin(angle) * length);
            int y = spieler.getPos_y() +(int) (Math.cos(angle) * length);

            if (x < 0){
                x = 0;
            }
            if (x > d.getWidth() - spieler.getSize().getWidth()){
                x = (int) (d.getWidth() - spieler.getSize().getWidth());
            }

            if (y < 0){
                y = 0;
            }
            if (y > d.getHeight() - spieler.getSize().getHeight()){
                y = (int) (d.getHeight() - spieler.getSize().getHeight());
            }

            spieler.setPos_x(x);
            spieler.setPos_y(y);


            System.out.println(angle);
        }
    }



    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
}
