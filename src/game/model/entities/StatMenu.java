package game.model.entities;

import game.model.Model;
import game.model.actions.Action;
import game.model.entities.players.Spieler;

import java.awt.*;
import java.awt.geom.Arc2D;

public class StatMenu extends Entities{
    private final Rectangle boundingArea;


    public StatMenu(Dimension d) {
        super(d);
        boundingArea = new Rectangle((int)d.getWidth(),40);
    }


    @Override
    public void setD(Dimension d){
        setPos_x(0);
        setPos_y((int)d.getHeight() - 40);
        setLocation();
    }

    public void setLocation(){
        boundingArea.setLocation(getPos_x(),getPos_y());
    }

    public void draw(Graphics2D g2D , Model model){
        g2D.setColor(Color.CYAN);
        g2D.fill(boundingArea);
        int x = 10;
        int y = getPos_y() + 5;
        g2D.setColor(Color.BLACK);
        g2D.fillRect(x,y,200,30);
        g2D.setColor(Color.GREEN);
        Spieler kk = (Spieler) model.getEntities().get(0);
        g2D.fillRect(x,y,(int)(200 * kk.getHealthPercent()),30);
        g2D.setColor(Color.RED);
        g2D.drawString(kk.getHealth() + "/" + kk.getMaxhealth(), x + 5,y + 20);

        x = 220;
        for (Action k : model.getActiveActions()){
            g2D.setColor(Color.BLACK);
            g2D.fillOval(x,y, 30 , 30);
            g2D.setColor(Color.blue);
            //sich füllednde Kreise
            Arc2D arc = new Arc2D.Double(x,y,30,30, 90 , k.getCooldownPercent() * 360 ,Arc2D.PIE);
            g2D.fill(arc);
            x += 10;
        }
        g2D.setColor(Color.BLACK);
    }


}


