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

        for (Entities e: model.getEntities()){
            e.draw(g2D);
        }

        model.getStatMenu().draw(g2D, model);





        //System.out.println(b.getBounds2D().intersects(a.getBounds2D()));

        /*Area area = new Area(a);
        area.intersect(new Area(b));
        if(!area.isEmpty()){
            System.out.println("intersects: yes");
        }
        else{
            System.out.println("intersects: no");
        }*/



    }

    public void paint(Graphics g){
        Graphics2D g2D = (Graphics2D) g ;
    }

}
