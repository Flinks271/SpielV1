package game.graphics.panels;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends Panel {
    Rectangle r = new Rectangle(100, 100, 100, 50);

    CardLayout crd;
    public GamePanel(CardLayout crd){
        this.crd = crd;
        this.setSize(1000,600);

        Graphics g = this.getGraphics();

    }




    public void paint(Graphics g){
        Graphics2D g2D = (Graphics2D) g ;
        g2D.draw(r);
    }
}
