package agh.ics.oop.model;

import agh.ics.oop.model.util.MapVisualizer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class RectangularMap implements WorldMap<Animal,Vector2d> {
    Map<Vector2d, Animal> animals = new HashMap<>();
    private final Vector2d lowerLeft;
    private final Vector2d upperRight;
    private final MapVisualizer visualiser;

    public RectangularMap(int width , int height) {
        this.lowerLeft = new Vector2d(0, 0);
        this.upperRight = new Vector2d(width-1, height-1);
        this.visualiser = new MapVisualizer(this);
    }
    public Vector2d getLowerLeft() {
        return(this.lowerLeft);
    }
    public Vector2d getUpperRight() {
        return(this.upperRight);
    }
    @Override
    public boolean isOccupied(Vector2d targetPosition) {
        return (animals.get(targetPosition)!=null);
    }
    @Override
    public boolean place(Animal animal, Vector2d position) {
        if(!isOccupied(position)) {
            animals.put(position,animal);
            return true;
        }
        return false;
    }
    @Override
    public Animal objectAt(Vector2d targetPosition) {
        return (animals.get(targetPosition));
    }
    @Override
    public void move(Animal object, MoveDirection direction) {
        Vector2d oldPosition = object.getPosition();
        object.move(direction,this);
        if(!object.getPosition().equals(oldPosition)) {
            animals.remove(oldPosition);
            animals.put(object.getPosition(),object);
        }
    }
    @Override
    public boolean canMoveTo(Vector2d targetPosition) {
        boolean inBorder = targetPosition.follows(lowerLeft) && targetPosition.precedes(upperRight);
        boolean occupied = isOccupied(targetPosition);
        return (inBorder && !occupied);
    }
    @Override
    public String toString() {
        return (visualiser.draw(this.lowerLeft,this.upperRight));
    }
}
