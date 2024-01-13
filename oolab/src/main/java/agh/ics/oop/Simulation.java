package agh.ics.oop;

import agh.ics.oop.model.*;
import agh.ics.oop.model.util.MapVisualizer;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Simulation {
    private List<Animal> animals = new ArrayList<Animal>();
    private List<MoveDirection> moves;
    private WorldMap map;
    public Simulation(List<Vector2d> positions, List<MoveDirection> moves, WorldMap map) {
        this.moves = moves;
        this.map = map;
        for(Vector2d position : positions) {
            Animal animal = new Animal(position);
            try {
                map.place(animal);
                animals.add(animal);
            } catch (PositionAlreadyOccupiedException e) {
                System.err.println(e.getMessage());
            }
        }
    }
    public List<Animal> getAnimals() {
        return this.animals;
    }
    public void run() {
        int i = 0;
        int count = animals.size();
        try {
            for(MoveDirection move : moves) {
                Animal animal = animals.get(i%count);
                map.move(animal,move);
                i++;
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            System.err.println(e.getMessage());
        }
    }
}
