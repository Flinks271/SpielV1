package game.graphics.panels;

import game.model.Model;
import game.model.entities.Entities;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class GamePanelCanvas extends Canvas {
    private BufferStrategy strategy;

    GamePanelCanvas(Dimension d){

        this.setSize(d);
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

        for (Entities e: model.getEntities()){
            ((Graphics2D) g).fill(e.getBoundingArea());
        }

    }

    public void paint(Graphics g){
        Graphics2D g2D = (Graphics2D) g ;
    }

}
