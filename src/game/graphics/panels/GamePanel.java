package game.graphics.panels;

import java.awt.*;

public class GamePanel extends Panel {
    private GamePanelCanvas canvas;

    CardLayout crd;
    public GamePanel(CardLayout crd,Dimension d){
        this.crd = crd;
        this.setSize(d);
        canvas = new GamePanelCanvas(d);

        this.add(canvas);
    }

    public GamePanelCanvas getCanvas() {
        return canvas;
    }

    public void setCanvas(GamePanelCanvas canvas) {
        this.canvas = canvas;
    }
}
