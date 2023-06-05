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
        Dimension d = new Dimension(1000,600);


        model = new Model(d);
        frame = new FelixFrame(d);
        loop = new GameLoop(model, frame);

        loop.loop();

    }




}
