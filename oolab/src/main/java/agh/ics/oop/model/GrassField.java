package agh.ics.oop.model;

import agh.ics.oop.model.util.MapVisualizer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GrassField implements WorldMap{
    private Vector2d lowerLeft = new Vector2d(Integer.MAX_VALUE,Integer.MAX_VALUE);
    private Vector2d upperRight = new Vector2d(Integer.MIN_VALUE,Integer.MIN_VALUE);
    private final MapVisualizer visualiser;
    Map<Vector2d, WorldElement> map = new HashMap<>();
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
            map.put(position,grass);
            System.out.println(position);
        }
    }
    @Override
    public boolean isOccupied(Vector2d targetPosition) {
        return (map.get(targetPosition)!=null);
    }
    @Override
    public boolean place(Animal animal) {
        if(!isOccupied(animal.getPosition())) {
            map.put(animal.getPosition(),animal);
            return true;
        }
        return false;
    }
    @Override
    public void move(Animal animal, MoveDirection direction) {
        Vector2d oldPosition = animal.getPosition();
        animal.move(direction,this);
        if(!animal.getPosition().equals(oldPosition)) {
            map.remove(oldPosition);
            map.put(animal.getPosition(),animal);
        }
    }
    @Override
    public boolean canMoveTo(Vector2d targetPosition) {
        return(!isOccupied(targetPosition));
    }
    @Override
    public WorldElement objectAt(Vector2d targetPosition) {
        return (map.get(targetPosition));
    }

    @Override
    public String toString() {
        lowerLeft = new Vector2d(Integer.MAX_VALUE,Integer.MAX_VALUE);
        upperRight = new Vector2d(Integer.MIN_VALUE,Integer.MIN_VALUE);
        map.forEach((key,value) -> borders(key));
        return(visualiser.draw(lowerLeft,upperRight));
    }
}
