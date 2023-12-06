package agh.ics.oop.model;

import agh.ics.oop.model.util.MapVisualizer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class GrassField extends AbstractWorldMap{
    private Vector2d lowerLeft = new Vector2d(Integer.MAX_VALUE,Integer.MAX_VALUE);
    private Vector2d upperRight = new Vector2d(Integer.MIN_VALUE,Integer.MIN_VALUE);
    private Map<Vector2d, Grass> grasses = new HashMap<>();
    public void borders(Vector2d newPosition) {
        this.lowerLeft = newPosition.lowerLeft(this.lowerLeft);
        this.upperRight = newPosition.upperRight(this.upperRight);
    }
    public GrassField(int grassNumber) {
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
        }else if (grasses.get(targetPosition)!=null) {
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
    public ArrayList<WorldElement> getElements() {
        ArrayList<WorldElement> elements = super.getElements();
        elements.addAll(grasses.values());
        return elements;
    }
    @Override
    public Boundary getCurrentBounds() {
        this.lowerLeft = new Vector2d(Integer.MAX_VALUE,Integer.MAX_VALUE);
        this.upperRight = new Vector2d(Integer.MIN_VALUE,Integer.MIN_VALUE);
        ArrayList<WorldElement> animals = super.getElements();
        grasses.forEach((key,value) -> borders(key));
        animals.forEach((animal) -> borders(animal.getPosition()));
        return new Boundary(this.lowerLeft,this.upperRight);
    }
}
