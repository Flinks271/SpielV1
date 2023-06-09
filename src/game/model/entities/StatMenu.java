package game.model.entities;

import game.model.Model;
import game.model.entities.actions.Action;

import java.awt.*;
import java.awt.geom.Arc2D;

public class StatMenu extends Entities{


    public StatMenu(Dimension d) {
        super(new Dimension((int)d.getWidth(),40),d);

        System.out.println(getBoundingArea());
    }


    @Override
    public void setD(Dimension d){
        setPos_x(0);
        setPos_y((int)d.getHeight() - 40);
        setLocation();
    }



    public void draw(Graphics2D g2D , Model model){
        g2D.setColor(Color.CYAN);
        g2D.fill(getBoundingArea());
        int x = 5;
        int y = getPos_y() + 5;
        for (Action k : model.getActiveActions()){
            g2D.setColor(Color.BLACK);
            g2D.fillOval(x,y, 30 , 30);
            g2D.setColor(Color.blue);
            //sich füllednde Kreise
            Arc2D arc = new Arc2D.Double(x,y,30,30, 90 , k.getCooldownPercent() * 360 ,Arc2D.PIE);
            g2D.fill(arc);
            x += 35;
        }
        g2D.setColor(Color.BLACK);
    }


}


