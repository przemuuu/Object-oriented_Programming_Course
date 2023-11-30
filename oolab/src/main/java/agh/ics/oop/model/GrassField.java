package agh.ics.oop.model;

import agh.ics.oop.model.util.MapVisualizer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class GrassField extends AbstractWorldMap{
    private Vector2d lowerLeft = new Vector2d(Integer.MAX_VALUE,Integer.MAX_VALUE);
    private Vector2d upperRight = new Vector2d(Integer.MIN_VALUE,Integer.MIN_VALUE);
    private final MapVisualizer visualiser;
    private Map<Vector2d, Grass> grasses = new HashMap<>();
    public void borders(Vector2d newPosition) {
        int newX = newPosition.get_x();
        int newY = newPosition.get_y();
        int leftX = lowerLeft.get_x();
        int leftY = lowerLeft.get_y();
        int rightX = upperRight.get_x();
        int rightY = upperRight.get_y();
        if(newX < leftX && newY < leftY) {
            lowerLeft = newPosition;
        }else if(newX > rightX && newY > rightY) {
            upperRight = newPosition;
        }else if(newX < leftX) {
            lowerLeft = new Vector2d(newX,leftY);
        }else if(newY < leftY) {
            lowerLeft = new Vector2d(leftX,newY);
        }else if(newX > rightX) {
            upperRight = new Vector2d(newX, rightY);
        }else if(newY > rightY) {
            upperRight = new Vector2d(rightX, newY);
        }
    }
    public GrassField(int grassNumber) {
        this.visualiser = new MapVisualizer(this);
        RandomPositionGenerator randomPositionGenerator = new RandomPositionGenerator((int)(Math.sqrt(grassNumber*10)),(int)(Math.sqrt(grassNumber*10)),grassNumber);
        for (Vector2d grassPosition : randomPositionGenerator) {
            grasses.put(grassPosition, new Grass(grassPosition));
        }
    }
    @Override
    public boolean isOccupied(Vector2d targetPosition) {
        if(super.isOccupied(targetPosition)) {
            return true;
        }else if(grasses.get(targetPosition)!=null) {
            return true;
        }else {
            return false;
        }
    }
    @Override
    public WorldElement objectAt(Vector2d targetPosition) {
        if(super.isOccupied(targetPosition)) {
            return (super.objectAt(targetPosition));
        } else if(grasses.get(targetPosition)!=null) {
            return (grasses.get(targetPosition));
        } else {
            return null;
        }
    }
    public String toString() {
        lowerLeft = new Vector2d(Integer.MAX_VALUE,Integer.MAX_VALUE);
        upperRight = new Vector2d(Integer.MIN_VALUE,Integer.MIN_VALUE);
        ArrayList<WorldElement> animals = super.getElements();
        grasses.forEach((key,value) -> borders(key));
        animals.forEach((animal) -> borders(animal.getPosition()));
        return(visualiser.draw(lowerLeft,upperRight));
    }
    @Override
    public ArrayList<WorldElement> getElements() {
        ArrayList<WorldElement> elements = super.getElements();
        elements.addAll(grasses.values());
        return elements;
    }
}
