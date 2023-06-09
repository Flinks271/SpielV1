package game.graphics.panels;

import game.model.Model;
import game.model.entities.Entities;

import java.awt.*;
import java.awt.geom.Arc2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferStrategy;

public class GamePanelCanvas extends Canvas {
    private BufferStrategy strategy;

    GamePanelCanvas(Dimension d){
        this.setSize(d);
    }

    public void setSize(){
        this.setSize(this.getParent().getWidth(),this.getParent().getHeight());
    }

    public void generateStrategy() {
        createBufferStrategy(2);
        strategy = getBufferStrategy();
    }


    //draws the method paint
    public void repaintScreen(Model model) {
        Graphics2D graphics = (Graphics2D) strategy.getDrawGraphics();

        paint(graphics, model);

        graphics.dispose();
        strategy.show();
    }

    //contains the objects to be drawn
    public void paint(Graphics g, Model model){
        Graphics2D g2D = (Graphics2D) g ;
        super.paint(g);
        Arc2D a = new    Arc2D.Double(200, 200, 40, 40, 0, 45, Arc2D.PIE);
        Rectangle2D b = new Rectangle(238,200,10,10);
        for (Entities e: model.getEntities()){
            e.draw(g2D);
        }

        model.getStatMenu().draw(g2D, model);

        g2D.fill(a);
        g2D.fill(b);
        //System.out.println(b.getBounds2D().intersects(a.getBounds2D()));

        /*Area area = new Area(a);
        area.intersect(new Area(b));
        if(!area.isEmpty()){
            System.out.println("intersects: yes");
        }
        else{
            System.out.println("intersects: no");
        }*/

        int x = 100; // x-Koordinate des Mittelpunkts
        int y = 100; // y-Koordinate des Mittelpunkts
        int radius = 100; // Radius des Kreises
        int startAngle = 60; // Startwinkel
        int arcAngle = 60; // Winkel des Teilkreises
        Arc2D arc = new Arc2D.Double((x - radius),( y - radius),( 2 * radius),( 2 * radius), startAngle, arcAngle,Arc2D.PIE);
        ((Graphics2D) g).fill(arc);


    }

    public void paint(Graphics g){
        Graphics2D g2D = (Graphics2D) g ;
    }

}
