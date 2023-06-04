package game.controller.gameloop;

import game.graphics.panels.GamePanelCanvas;
import game.model.Model;

public class Render {

    public static void render(GamePanelCanvas canvas, Model model){
        canvas.repaintScreen(model);
    }

}
