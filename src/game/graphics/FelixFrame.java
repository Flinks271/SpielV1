package game.graphics;

import game.controller.Playerthroughput;
import game.graphics.panels.FelixMenu;
import game.graphics.panels.GamePanel;

import javax.swing.*;
import java.awt.*;

public class FelixFrame extends JFrame {
    CardLayout crd = new CardLayout();
    private GamePanel game;
    private FelixMenu menu;


    public FelixFrame(Dimension d, Playerthroughput put){
        this.setTitle("Felix hat Spaß");
        this.setLayout(crd);

        menu = new game.graphics.panels.FelixMenu(crd, d , put);
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

    public FelixMenu getMenu() {
        return menu;
    }

    public void setMenu(FelixMenu menu) {
        this.menu = menu;
    }

    public void next(){
        crd.next(game.getParent());
    }
}
