package game.model.entities.attacks;

import game.model.entities.players.Spieler;
import game.model.actions.Action;

import java.awt.*;
import java.awt.geom.Arc2D;
import java.util.Random;

public class MeleeAtack extends Action {
    private int damage;
    private int duration;
    private int pos_x;
    private int pos_y;
    private int rad;
    private int iteriror;
    private boolean dir;
    private double StartAngle;
    

    private Arc2D arc;

    MeleeAtack(int cooldown, int damage, int duration, Spieler spieler, Point mouse){
        super(cooldown);
        dir = new Random().nextBoolean();
        Point s = spieler.getCenter();

        // angle in radians
        double angle =Math.toDegrees( Math.atan2(mouse.getX() - s.getX(), mouse.getY() - s.getY()));

        this.damage = damage;
        this.duration = duration;
        pos_x = -1;
        pos_y = -1;
        rad = 200;
        iteriror = 0;
        arc = new Arc2D.Double((pos_x - rad),( pos_y - rad),( 2 * rad),( 2 * rad), 0, 0,Arc2D.PIE);
    }


    private void cast(Spieler spieler, Point mouse){
        Point s = spieler.getCenter();

        // angle in radians
        double angle =Math.toDegrees( Math.atan2(mouse.getX() - s.getX(), mouse.getY() - s.getY()));

        iteriror+=10;
    }




}
