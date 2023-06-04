package game.graphics;

import game.graphics.panels.GamePanel;

import javax.swing.*;
import java.awt.*;

public class FelixFrame extends JFrame {
    CardLayout crd = new CardLayout();
    private GamePanel game;


    public FelixFrame(Dimension d){
        this.setTitle("Felix hat Spaß");
        this.setLayout(crd);

        JPanel menu = new game.graphics.panels.Menu(crd, d);
        game = new game.graphics.panels.GamePanel(crd,d);


        this.add(menu);
        this.add(game);


        this.setSize(d);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
        game.getCanvas().generateStrategy();
    }

    public GamePanel getGame() {
        return game;
    }

    public void setGame(GamePanel game) {
        this.game = game;
    }
}
