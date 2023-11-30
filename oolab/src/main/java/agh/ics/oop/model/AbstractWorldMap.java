package agh.ics.oop.model;

import agh.ics.oop.model.util.MapVisualizer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractWorldMap implements WorldMap{
    protected Vector2d lowerLeft = new Vector2d(Integer.MAX_VALUE,Integer.MAX_VALUE);
    protected Vector2d upperRight = new Vector2d(Integer.MIN_VALUE,Integer.MIN_VALUE);
    protected final MapVisualizer visualiser = new MapVisualizer(this);
    protected Map<Vector2d, Animal> animals = new HashMap<>();
    @Override
    public boolean place(Animal animal) {
        if(canMoveTo(animal.getPosition())) {
            animals.put(animal.getPosition(),animal);
            return true;
        }
        return false;
    }
    @Override
    public void move(Animal animal, MoveDirection direction) {
        Vector2d oldPosition = animal.getPosition();
        animal.move(direction,this);
        if(!animal.getPosition().equals(oldPosition)) {
            animals.remove(oldPosition);
            animals.put(animal.getPosition(),animal);
        }
    }
    @Override
    public String toString() {
        return (visualiser.draw(this.lowerLeft,this.upperRight));
    }
    @Override
    public boolean isOccupied(Vector2d targetPosition) {
        return (animals.get(targetPosition)!=null);
    }
    @Override
    public WorldElement objectAt(Vector2d targetPosition) {
        return (animals.get(targetPosition));
    }
    @Override
    public boolean canMoveTo(Vector2d targetPosition) {
        return(animals.get(targetPosition)==null);
    }
    @Override
    public ArrayList<WorldElement> getElements() {
        return new ArrayList<>(animals.values());
    }
}
