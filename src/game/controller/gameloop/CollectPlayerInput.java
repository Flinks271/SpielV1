package game.controller.gameloop;

import game.graphics.panels.GamePanel;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class CollectPlayerInput implements KeyListener {
    private final Playerinput input;

    CollectPlayerInput(Playerinput input, GamePanel canvas){
        System.out.println(canvas.isFocusable());
        canvas.requestFocus();
        canvas.addKeyListener(this);
        this.input = input;
    }

    public Playerinput getInput() {
        return input;
    }

    //keyboard commands
    @Override
    public void keyTyped(KeyEvent e) {
        System.out.println("Typed");

    }

    @Override
    public void keyReleased(KeyEvent e) {
        System.out.println("REalesed");
        if(e.getKeyCode() == KeyEvent.VK_A) input.setLeft(false);
        if(e.getKeyCode() == KeyEvent.VK_D) input.setRight(false);
        if(e.getKeyCode() == KeyEvent.VK_W) input.setUp(false);
        if(e.getKeyCode() == KeyEvent.VK_S) input.setDown(false);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("Pressed");
        if(e.getKeyCode() == KeyEvent.VK_A) input.setLeft(true);
        if(e.getKeyCode() == KeyEvent.VK_D) input.setRight(true);
        if(e.getKeyCode() == KeyEvent.VK_W) input.setUp(true);
        if(e.getKeyCode() == KeyEvent.VK_S) input.setDown(true);
        if(e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            input.setSoll(false);
        }
    }
}
