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
    private Map<Vector2d, Animal> animals = new HashMap<>();
    public void borders(Vector2d newPosition) {
        int newX = newPosition.get_x();
        int newY = newPosition.get_y();
        int leftX = this.lowerLeft.get_x();
        int leftY = this.lowerLeft.get_y();
        int rightX = this.upperRight.get_x();
        int rightY = this.upperRight.get_y();
        if(newX < leftX && newY < leftY) {
            this.lowerLeft = newPosition;
        }else if(newX > rightX && newY > rightY) {
            this.upperRight = newPosition;
        }else if(newX < leftX) {
            this.lowerLeft = new Vector2d(newX,leftY);
        }else if(newY < leftY) {
            this.lowerLeft = new Vector2d(leftX,newY);
        }else if(newX > rightX) {
            this.upperRight = new Vector2d(newX, rightY);
        }else if(newY > rightY) {
            this.upperRight = new Vector2d(rightX, newY);
        }
    }
    public GrassField(int grassNumber) {
        this.visualiser = new MapVisualizer(this);
        for(int i = 0; i < grassNumber; i++) {
            Vector2d position = new Vector2d((int)(Math.random()*Math.sqrt(grassNumber*10)),(int)(Math.random()*Math.sqrt(grassNumber*10)));
            while(isOccupied(position)) {
                position = new Vector2d((int)(Math.random()*Math.sqrt(grassNumber*10)),(int)(Math.random()*Math.sqrt(grassNumber*10)));
            }
            Grass grass = new Grass(position);
            grasses.put(position,grass);
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
    @Override
    public String toString() {
        lowerLeft = new Vector2d(Integer.MAX_VALUE,Integer.MAX_VALUE);
        upperRight = new Vector2d(Integer.MIN_VALUE,Integer.MIN_VALUE);
        animals.forEach((key,value) -> borders(key));
        grasses.forEach((key,value) -> borders(key));
        return(super.toString());
    }
    @Override
    public ArrayList<WorldElement> getElements() {
        ArrayList<WorldElement> elements = super.getElements();
        elements.addAll(grasses.values());
        return elements;
    }
}
