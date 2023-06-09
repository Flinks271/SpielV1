package game.controller.gameloop.inputs;

import java.awt.*;

public class Playerinput {
    private Boolean up;
    private Boolean down;
    private Boolean right;
    private Boolean left;
    private Boolean soll;
    private Boolean angriff;
    private Boolean space;
    private Point mouse;

    public Playerinput(){
        up = false;
        down = false;
        right = false;
        left = false;
        soll = true;
        angriff = false;
        space = false;
    }

    public Boolean getUp() {
        return up;
    }

    public void setUp(Boolean up) {
        this.up = up;
    }

    public Boolean getDown() {
        return down;
    }

    public void setDown(Boolean down) {
        this.down = down;
    }

    public Boolean getRight() {
        return right;
    }

    public void setRight(Boolean right) {
        this.right = right;
    }

    public Boolean getLeft() {
        return left;
    }

    public void setLeft(Boolean left) {
        this.left = left;
    }

    public Boolean getSoll() {
        return soll;
    }

    public void setSoll(Boolean soll) {
        this.soll = soll;
    }

    public Boolean getAngriff() {
        return angriff;
    }

    public void setAngriff(Boolean angriff) {
        this.angriff = angriff;
    }

    public Boolean getSpace() {
        return space;
    }

    public void setSpace(Boolean space) {
        this.space = space;
    }

    public Point getMouse() {
        return mouse;
    }

    public void setMouse(Point mouse) {
        this.mouse = mouse;
    }
}
