package game.controller.gameloop;

import game.controller.Playerthroughput;
import game.graphics.FelixFrame;
import game.model.Model;

import java.awt.*;
import java.util.Arrays;

public class GameLoop{
    private Model model;
    private FelixFrame frame;
    Playerinput input;



    public GameLoop(Model model, FelixFrame frame, Playerthroughput put){
        this.model = model;
        this.frame = frame;
        input = new Playerinput();


        CollectPlayerInput collect = new CollectPlayerInput(input,put);

        frame.getGame().addKeyListener(collect);

        frame.getGame().requestFocus();

        frame.getGame().getCanvas().setSize();
        model.getEntities().get(0).setD(new Dimension(frame.getGame().getWidth(),frame.getGame().getHeight()));
    }


    public void loop(){
        long lastViewGame_time = System.currentTimeMillis();

        while (input.getSoll()){

            long currentViewGame_time = System.currentTimeMillis();
            float differenceViewGame = ((float)(currentViewGame_time - lastViewGame_time))/1000f;
            lastViewGame_time = currentViewGame_time;
            frame.getGame().requestFocus();

            //sollte unnötig sein
            //input = collect.getInput();

            Update.update(input, model, differenceViewGame);

            Render.render(frame.getGame().getCanvas(), model);

            try {
                long auszeit = (long)(1000 / 60 - differenceViewGame);
                Thread.sleep(auszeit);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

        input.setSoll(true);
        frame.next();
    }
}
