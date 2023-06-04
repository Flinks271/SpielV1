package game.controller.gameloop;

import game.graphics.FelixFrame;
import game.model.Model;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Arrays;

public class GameLoop{
    private Model model;
    private FelixFrame frame;


    public GameLoop(Model model, FelixFrame frame){
        this.model = model;
        this.frame = frame;
    }


    public void loop(){
        Playerinput input = new Playerinput();
        CollectPlayerInput collect = new CollectPlayerInput(input, frame.getGame());
        long lastViewGame_time = System.currentTimeMillis();



        while (input.getSoll()){

            long currentViewGame_time = System.currentTimeMillis();
            float differenceViewGame = ((float)(currentViewGame_time - lastViewGame_time))/1000f;
            lastViewGame_time = currentViewGame_time;

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
    }
}
