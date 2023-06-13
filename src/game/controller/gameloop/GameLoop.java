package game.controller.gameloop;

import game.controller.Playerthroughput;
import game.controller.gameloop.inputs.CollectPlayerInput;
import game.controller.gameloop.inputs.CollectPlayerMouseInput;
import game.controller.gameloop.inputs.Playerinput;
import game.graphics.FelixFrame;
import game.model.Model;

import java.awt.*;
import java.awt.event.*;

public class GameLoop{
    private final Model model;
    private final FelixFrame frame;
    Playerinput input;



    public GameLoop(Model model, FelixFrame frame, Playerthroughput put){
        this.model = model;
        this.frame = frame;
        input = new Playerinput();


        CollectPlayerInput collect = new game.controller.gameloop.inputs.CollectPlayerInput(input,put);
        CollectPlayerMouseInput mouse = new CollectPlayerMouseInput(input);

        frame.getGame().addKeyListener(collect);
        frame.getGame().getCanvas().addMouseListener(mouse);
        frame.getGame().getCanvas().addMouseMotionListener(mouse);


        frame.getGame().requestFocus();

        frame.getGame().getCanvas().setSize();
        Dimension dtemp = new Dimension(frame.getGame().getWidth(),frame.getGame().getHeight());
        model.getStatMenu().setD(dtemp);
    }


    public void loop(){
        Dimension dtemp = new Dimension(frame.getGame().getWidth(),frame.getGame().getHeight());
        dtemp.setSize(dtemp.getWidth(),dtemp.getHeight() - 40);
        frame.getGame().requestFocus();

        model.getEntities().get(0).setD(dtemp);
        long lastViewGame_time = System.currentTimeMillis();

        while (input.getSoll()){

            long currentViewGame_time = System.currentTimeMillis();
            float differenceViewGame = ((float)(currentViewGame_time - lastViewGame_time))/1000f;
            lastViewGame_time = currentViewGame_time;

            Update.update(input, model, differenceViewGame);

            Render.render(frame.getGame().getCanvas(), model);

            long pauseTime = System.currentTimeMillis() - currentViewGame_time;

            try {
                long auszeit = 1000 / 60 - pauseTime;
                if (auszeit > 0){
                    Thread.sleep(auszeit);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

        for (KeyListener k:frame.getGame().getKeyListeners()) {
            frame.getGame().removeKeyListener(k);
        }
        for (MouseListener k: frame.getGame().getCanvas().getMouseListeners()) {
            frame.getGame().getCanvas().removeMouseListener(k);
        }
        for (MouseMotionListener k: frame.getGame().getCanvas().getMouseMotionListeners()) {
            frame.getGame().getCanvas().removeMouseMotionListener(k);
        }


        input.setSoll(true);
        frame.next();
    }
}
