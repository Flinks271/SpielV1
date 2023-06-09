package game.model.entities;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Arc2D;

public class Attack {


    public static void main(String[] args)
    {
        JFrame frmMain = new JFrame();
        frmMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmMain.setSize(400, 400);

        Canvas cnvs = new Canvas();
        cnvs.setSize(400, 400);

        frmMain.add(cnvs);
        frmMain.setVisible(true);

        Graphics g = cnvs.getGraphics();
        g.setColor(new Color(255, 0, 0));
        Arc2D a = new Arc2D.Double(1, 1, 20, 20, 90, 180, Arc2D.OPEN);
        Graphics2D g2D = (Graphics2D) g ;
        g2D.fill(a);


        frmMain.validate();
        frmMain.repaint();
    }
}


