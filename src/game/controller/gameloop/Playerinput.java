package game.controller.gameloop;

public class Playerinput {
    private Boolean up;
    private Boolean down;
    private Boolean right;
    private Boolean left;
    private Boolean soll;

    Playerinput(){
        up = false;
        down = false;
        right = false;
        left = false;
        soll = true;
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
}
