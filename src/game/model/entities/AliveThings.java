package game.model.entities;

import java.awt.*;

abstract public class AliveThings extends Entities{
    private Dimension size;
    private final Rectangle boundingArea;
    private int movSpeed;

    public AliveThings(Dimension size, Dimension d) {
        super(d);
        this.size = size;
        boundingArea = new Rectangle(size);
        boundingArea.setLocation(getPos_x(),getPos_y());
        this.movSpeed = 200;
    }

    //moves the x - coordinate with the help of the time difference since the last painted frame
    public void movePositionX(float timeDifference) {
        timeDifference *= (float)getMovSpeed();
        if((this.getPos_x() + timeDifference) < 0) {
            setPos_x(0);
        }else if((getPos_x()+ timeDifference) > getD().getWidth()-size.getWidth()) {
            setPos_x((int) (getD().getWidth() - getSize().getWidth()));
        }else {
            setPos_x(getPos_x() +(int) timeDifference);
        }
        boundingArea.setLocation(getPos_x(),getPos_y());
    }

    //moves the y - coordinate with the help of the time difference since the last painted frame
    public void movePositionY(float timeDifference) {
        timeDifference *= (float)movSpeed;
        if((getPos_y() + timeDifference) < 0) {
            setPos_y(0);
        }else if((getPos_y() + timeDifference) > getD().getHeight()-size.getHeight()) {
            setPos_y((int) (getD().getHeight() -size.getHeight()));
        }else {
            setPos_y(getPos_y() +(int) timeDifference);
        }
        boundingArea.setLocation(getPos_x(),getPos_y());
    }

    public void setLocation(){
        boundingArea.setLocation(getPos_x(),getPos_y());
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

    public Point getCenter(){
        return new Point(getPos_x() + (int)size.getWidth() / 2, getPos_y() + (int)size.getHeight() / 2);
    }

    public Rectangle getBoundingArea() {
        return boundingArea;
    }
}
