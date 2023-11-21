package agh.ics.oop.model;

import agh.ics.oop.model.util.MapVisualizer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class RectangularMap implements WorldMap {
    Map<Vector2d, Animal> animals = new HashMap<>();
    private final int width;
    private final int height;
    private final Vector2d lowerLeft;
    private final Vector2d upperRight;
    private final MapVisualizer visualiser;

    public RectangularMap(int width , int height) {
        this.width = width;
        this.height = height;
        this.lowerLeft = new Vector2d(0, 0);
        this.upperRight = new Vector2d(this.width-1, this.height-1);
        this.visualiser = new MapVisualizer(this);
    }

    @Override
    public boolean isOccupied(Vector2d targetPosition) {
        for(Animal animal : animals.values()) {
            if(animal.isAt(targetPosition)) {
                return true;
            }
        }
        return false;
    }
    @Override
    public boolean place(Animal animal) {
        if(!isOccupied(animal.getPosition())) {
            animals.put(animal.getPosition(),animal);
            return true;
        }
        return false;
    }
    @Override
    public Animal objectAt(Vector2d targetPosition) {
//        for(Vector2d position : animals.keySet()) {
//            if(position.equals(targetPosition)) {
//                return (animals.get(position));
//            }
//        }
        return (animals.get(targetPosition));
        //return null;
    }
    @Override
    public void move(Animal animal,MoveDirection direction) {
        animal.move(direction,this);
    }
//    @Override
//    public void move(Animal animal,MoveDirection direction) {
//        Vector2d positionNow = animal.getPosition();
//        MapDirection orientation = animal.getOrientation();
//        if(animals.containsValue(animal)) {
//            switch(direction) {
//                case RIGHT: {
//                    orientation = orientation.next();
//                    Animal newAnimal = new Animal(positionNow);
//                    newAnimal.setOrientation()
//                    break;
//                }
//                case LEFT: {
//                    orientation = orientation.previous();
//                    break;
//                }
//                case FORWARD: {
//                    Vector2d positionThen = (positionNow.add(orientation.toUnitVector()));
//                    if(canMoveTo(positionThen)) {
//
//                    }
//                    break;
//                }
//                case BACKWARD: {
//                    Vector2d positionThen = (positionNow.subtract(orientation.toUnitVector()));
//                    if(canMoveTo(positionThen)) {
//                        animals.remove(positionNow);
//                        Animal newAnimal = new Animal(positionThen);
//                        newAnimal.setOrientation(orientation)
//                    }
//                    break;
//                }
//            }
//        }
//
//
//        //        if(animals.containsValue(animal)) {
////            animals.remove(animal.getPosition());
////            animal.move(direction);
////            animals.put(animal.getPosition(),animal);
////        }
//
//    }
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
