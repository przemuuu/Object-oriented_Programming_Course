package agh.ics.oop.model;

import agh.ics.oop.model.util.MapVisualizer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class AbstractWorldMap implements WorldMap{
    protected Map<Vector2d, Animal> animals = new HashMap<>();
    private List<MapChangeListener> observers = new ArrayList<>();
    private MapVisualizer visualizer = new MapVisualizer(this);
    private int id = this.hashCode();
    @Override
    public boolean place(Animal animal) throws PositionAlreadyOccupiedException {
        if(canMoveTo(animal.getPosition())) {
            animals.put(animal.getPosition(),animal);
            mapChanged("An animal was placed on " + animal.getPosition());
            return true;
        }
        throw new PositionAlreadyOccupiedException(animal.getPosition());
    }
    @Override
    public void move(Animal animal, MoveDirection direction) {
        Vector2d oldPosition = animal.getPosition();
        String directionBefore = animal.toString();
        animal.move(direction,this);
        if(!animal.getPosition().equals(oldPosition)) {
            animals.remove(oldPosition);
            animals.put(animal.getPosition(),animal);
            mapChanged("Animal at " + oldPosition + " moved to " + animal.getPosition());
        } else if (!directionBefore.equals(animal.toString())) {
            mapChanged("Animal at " + animal.getPosition() + " changed direction from " + directionBefore + " to " + animal.toString());
        }
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
    public void addObserver(MapChangeListener observer) {
        observers.add(observer);
    }
    public void removeObserver(MapChangeListener observer) {
        observers.remove(observer);
    }
    public void mapChanged(String message) {
        for(MapChangeListener observer : observers) {
            observer.mapChanged(this,message);
        }
    }
    @Override
    public abstract Boundary getCurrentBounds();
    @Override
    public int getId() {
        return this.id;
    }
    @Override
    public String toString() {
        Boundary bounds = getCurrentBounds();
        return visualizer.draw(bounds.lowerLeft(),bounds.upperRight());
    }
}
