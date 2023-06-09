package game.model.entities;

import java.awt.*;

public abstract class Entities {
    private int movSpeed;
    private Dimension size;
    private int pos_x;
    private int pos_y;
    private Dimension d ;
    private final Rectangle boundingArea;


    Entities(Dimension size, Dimension d){
        this.d = d;
        this.size = size;
        this.pos_x = 100;
        this.pos_y = 0;
        this.movSpeed = 100;
        boundingArea = new Rectangle(size);
        boundingArea.setLocation(pos_x,pos_y);
    }



    //moves the x - coordinate with the help of the time difference since the last painted frame
    public void movePositionX(float timeDifference) {
        timeDifference *= (float)movSpeed;
        if((this.pos_x += timeDifference) < 0) {
            this.pos_x = 0;
        }else if((this.pos_x += timeDifference) > d.getWidth()-size.getWidth()) {
            this.pos_x =(int) (d.getWidth() - size.getWidth());
        }else {
            this.pos_x += timeDifference;
        }
        boundingArea.setLocation(pos_x,pos_y);
    }

    //moves the y - coordinate with the help of the time difference since the last painted frame
    public void movePositionY(float timeDifference) {
        timeDifference *= (float)movSpeed;
        if((this.pos_y += timeDifference) < 0) {
            this.pos_y = 0;
        }else if((this.pos_y += timeDifference) > d.getHeight()-size.getHeight()) {
            this.pos_y =(int) (d.getHeight() -size.getHeight());
        }else {
            this.pos_y += timeDifference;
        }
    }

    public void setLocation(){
        boundingArea.setLocation(pos_x,pos_y);
    }

    public int getMovSpeed() {
        return movSpeed;
    }

    public void setMovSpeed(int movSpeed) {
        this.movSpeed = movSpeed;
    }

    public Dimension getSize() {
        return size;
    }

    public void setSize(Dimension size) {
        this.size = size;
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

    public Dimension getD() {
        return d;
    }

    public void setD(Dimension d) {
        this.d = d;
    }

    public Rectangle getBoundingArea() {
        return boundingArea;
    }

    public Point getCenter(){
        return new Point(pos_x + (int)size.getWidth() / 2, pos_y + (int)size.getHeight() / 2);
    }

    public void draw(Graphics2D g2D){

    }
}
