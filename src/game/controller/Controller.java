package game.controller;

import game.controller.gameloop.GameLoop;
import game.graphics.FelixFrame;
import game.model.Model;

import java.awt.*;

public class Controller {

    private Model model;
    private GameLoop loop;
    private FelixFrame frame;

    public Controller(){

        model = new Model();

        frame = new FelixFrame(new Dimension(1000,600));
        loop = new GameLoop(model, frame);
        loop.loop();

    }




}
