package game.model.entities;

import java.awt.*;

public abstract class Entities {
    private int pos_x;
    private int pos_y;
    private Dimension d ;
    private boolean kill;


    public Entities(Dimension d){
        this.d = d;
        this.pos_x = 100;
        this.pos_y = 100;
        kill = false;
    }
    public Entities(int x, int y){
        this.d = null;
        this.pos_x = x;
        this.pos_y = y;
        kill = false;
    }


    public int getPos_x() {
        return pos_x;
    }

    public void setPos_x(int pos_x) {
        this.pos_x = pos_x;
    }

    public int getPos_y() {
        return pos_y;
    }

    public void setPos_y(int pos_y) {
        this.pos_y = pos_y;
    }

    public boolean isKill() {
        return kill;
    }

    public void setKill(boolean kill) {
        this.kill = kill;
    }

    public Dimension getD() {
        return d;
    }

    public void setD(Dimension d) {
        this.d = d;
    }

    public void draw(Graphics2D g2D){

    }
}
