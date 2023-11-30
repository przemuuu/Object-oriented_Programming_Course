package agh.ics.oop.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractWorldMap implements WorldMap{
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
