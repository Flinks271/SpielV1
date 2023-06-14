package game.controller.gameloop.inputs;

import javax.swing.event.MouseInputListener;
import java.awt.event.MouseEvent;

public class CollectPlayerMouseInput implements MouseInputListener {

    private final Playerinput input;

    public CollectPlayerMouseInput(Playerinput input){
        this.input = input;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1){
            input.setAngriff(true);
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        input.setMouse(e.getPoint());
    }
}
