package game.model.entities.attacks;

import game.model.Model;
import game.model.entities.Entities;
import game.model.entities.players.Spieler;
import game.model.actions.Action;

import java.awt.*;
import java.awt.geom.Arc2D;
import java.util.Random;

public class MeleeAtack extends Entities {
    private int damage;
    private int duration;
    private int pos_x;
    private int pos_y;
    private int rad;
    private int ausmaß;
    private boolean dir;
    private double startAngle;
    private long time;
    private Model model;
    

    private Arc2D arc;

    public MeleeAtack(int damage, int duration, Spieler spieler, Point mouse, Model model){
        super((int)spieler.getCenter().getX(),(int)spieler.getCenter().getY());
        dir = new Random().nextBoolean();
        Point s = spieler.getCenter();

        // angle in radians
        startAngle = Math.toDegrees( Math.atan2(mouse.getX() - s.getX(), mouse.getY() - s.getY())) - 90;

        if (dir){
            startAngle -= 30 % 360;
        }else {
            startAngle += 30 % 360;
        }

        time = System.currentTimeMillis();

        this.damage = damage;
        this.duration = duration;
        this.model = model;
        pos_x = (int) s.getX();
        pos_y = (int) s.getY();
        rad = 150;
        ausmaß = 60;
        arc = new Arc2D.Double((pos_x - rad),( pos_y - rad),( 2 * rad),( 2 * rad), startAngle, 30,Arc2D.PIE);
    }


    public void draw(Graphics2D g){

        double angle2;
        g.fill(arc);
        if (dir){
            angle2 = startAngle + (((System.currentTimeMillis() - time)* 1.0/duration) * ausmaß);
            if (angle2 > startAngle + ausmaß - 1){
                setKill(true);
            }
        }else {
            angle2 = startAngle - (((System.currentTimeMillis() - time)* 1.0/duration) * ausmaß);
            if (angle2 < startAngle - ausmaß + 1){
                setKill(true);
            }
        }
        arc.setAngleStart(angle2);

    }
}
