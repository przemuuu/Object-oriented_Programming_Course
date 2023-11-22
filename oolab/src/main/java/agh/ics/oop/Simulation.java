package agh.ics.oop;

import agh.ics.oop.model.Animal;
import agh.ics.oop.model.MoveDirection;
import agh.ics.oop.model.Vector2d;
import agh.ics.oop.model.WorldMap;
import agh.ics.oop.model.util.MapVisualizer;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Simulation {
    private List<Animal> animals = new ArrayList<Animal>();
    private List<MoveDirection> moves;
    private WorldMap<Animal, Vector2d> map;
    private MapVisualizer visualizer;
    public Simulation(List<Vector2d> positions, List<MoveDirection> moves, WorldMap<Animal, Vector2d> map) {
        this.moves = moves;
        this.map = map;
        this.visualizer = new MapVisualizer(map);
        for(Vector2d position : positions) {
            Animal animal = new Animal(position);
            if(map.place(animal,position)) {
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
        Vector2d upperRight = map.getUpperRight();
        Vector2d lowerLeft = map.getLowerLeft();
        for(MoveDirection move : moves) {
            Animal animal = animals.get(i%count);
            map.move(animal,move);
            System.out.println(visualizer.draw(lowerLeft,upperRight));
            i++;
        }
    }

}
