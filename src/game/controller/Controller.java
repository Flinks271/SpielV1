package game.controller;

import game.controller.gameloop.GameLoop;
import game.graphics.FelixFrame;
import game.model.Model;

import java.awt.*;

public class Controller {

    private Model model;
    private GameLoop loop;
    private FelixFrame frame;
    private Playerthroughput put;

    public Controller(){
        Dimension d = new Dimension(1000,600);

        put = new Playerthroughput();

        model = new Model(d);
        frame = new FelixFrame(d, put);
        loop = new GameLoop(model, frame, put);

        long lastViewGame_time = System.currentTimeMillis();

        while(true){

            long currentViewGame_time = System.currentTimeMillis();
            float differenceViewGame = ((float)(currentViewGame_time - lastViewGame_time))/1000f;
            lastViewGame_time = currentViewGame_time;
            switch (put.getWelches()){
                case 0:
                    break;
                case 1:
                    loop.loop();
                    System.out.println("ff");
                    break;
            }

            try {
                long auszeit = (long)(1000 / 60 - differenceViewGame);
                Thread.sleep(auszeit);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }




}
