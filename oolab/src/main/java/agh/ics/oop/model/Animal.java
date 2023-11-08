package agh.ics.oop.model;

import java.util.Map;

public class Animal {
    private MapDirection orientation = MapDirection.NORTH;
    private Vector2d position;


    public Animal() {
        this.orientation = MapDirection.NORTH;
        this.position = new Vector2d(2,2);
    }
    public Animal(Vector2d positionChange) {
        this.orientation = MapDirection.NORTH;
        this.position = positionChange;
    }
    public String toString() {
        return(position.toString() + " " + orientation.toString());
    }
    public boolean isAt(Vector2d position) {
        return(this.position.equals(position));
    }
    public void move(MoveDirection direction) {
        switch(direction) {
            case RIGHT: {
                this.orientation = orientation.next();
                break;
            }
            case LEFT: {
                this.orientation = orientation.previous();
                break;
            }
            case FORWARD: {
                Vector2d positionOut = (position.add(orientation.toUnitVector()));
                if(positionOut.precedes(new Vector2d(4,4)) && positionOut.follows(new Vector2d(0,0))) {
                    this.position = positionOut;
                }
                break;
            }
            case BACKWARD: {
                Vector2d positionOut = (position.subtract(orientation.toUnitVector()));
                if(positionOut.precedes(new Vector2d(4,4)) && positionOut.follows(new Vector2d(0,0))) {
                    this.position = positionOut;
                }
                break;
            }
        }
    }
}
