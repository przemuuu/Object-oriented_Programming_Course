package agh.ics.oop.model;

import java.util.Map;

public class Animal implements WorldElement{
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
    @Override
    public String toString() {
        return(orientation.toString());
    }
    @Override
    public boolean isAt(Vector2d position) {
        return(this.position.equals(position));
    }
    @Override
    public Vector2d getPosition() {
        return (this.position);
    }
    public void move(MoveDirection direction, MoveValidator validator) {
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
                if(validator.canMoveTo(positionOut)) {
                    this.position = positionOut;
                }
                break;
            }
            case BACKWARD: {
                Vector2d positionOut = (position.subtract(orientation.toUnitVector()));
                if(validator.canMoveTo(positionOut)) {
                    this.position = positionOut;
                }
                break;
            }
        }
    }
    @Override
    public String toImage() {
        switch(this.orientation) {
            case NORTH: {
                return "up";
            }
            case SOUTH: {
                return "down";
            }
            case EAST: {
                return "right";
            }
            case WEST: {
                return "left";
            }
        }
        return null;
    }
}
