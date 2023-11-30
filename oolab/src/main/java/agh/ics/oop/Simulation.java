package agh.ics.oop;

import agh.ics.oop.model.*;
import agh.ics.oop.model.util.MapVisualizer;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Simulation {
    private List<Animal> animals = new ArrayList<Animal>();
    private List<MoveDirection> moves;
    private AbstractWorldMap map;
    public Simulation(List<Vector2d> positions, List<MoveDirection> moves, AbstractWorldMap map) {
        this.moves = moves;
        this.map = map;
        for(Vector2d position : positions) {
            Animal animal = new Animal(position);
            if(map.place(animal)) {
                animals.add(animal);
            }
        }
    }
    public List<Animal> getAnimals() {
        return this.animals;
    }
    public void run() {
        int i = 0;
        int count = animals.size();
        for(MoveDirection move : moves) {
            Animal animal = animals.get(i%count);
            map.move(animal,move);
            System.out.println(map.toString());
            i++;
        }
    }
}
