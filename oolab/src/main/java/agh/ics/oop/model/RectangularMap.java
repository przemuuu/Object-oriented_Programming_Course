package agh.ics.oop.model;

import agh.ics.oop.model.util.MapVisualizer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class RectangularMap extends AbstractWorldMap{
    private Map<Vector2d, Animal> animals = new HashMap<>();
    private final Vector2d lowerLeft;
    private final Vector2d upperRight;
    private final MapVisualizer visualiser;

    public RectangularMap(int width , int height) {
        this.lowerLeft = new Vector2d(0, 0);
        this.upperRight = new Vector2d(width-1, height-1);
        this.visualiser = new MapVisualizer(this);
    }
    @Override
    public boolean canMoveTo(Vector2d targetPosition) {
        boolean inBorder = targetPosition.follows(lowerLeft) && targetPosition.precedes(upperRight);
        return (inBorder && super.canMoveTo(targetPosition));
    }
    @Override
    public String toString() {
        return (visualiser.draw(this.lowerLeft,this.upperRight));
    }
}
