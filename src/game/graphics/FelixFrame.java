package game.graphics;

import javax.swing.*;
import java.awt.*;

public class FelixFrame extends JFrame {
    CardLayout crd = new CardLayout();

    public FelixFrame(){
        this.setTitle("Felix hat Spaß");
        this.setLayout(crd);


        this.add(new game.graphics.panels.Menu(crd));
        this.add(new game.graphics.panels.GamePanel(crd));


        this.setSize(new Dimension(1000,600));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }




}
