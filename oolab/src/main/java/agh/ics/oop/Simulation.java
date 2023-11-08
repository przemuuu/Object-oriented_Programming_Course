package agh.ics.oop;

import agh.ics.oop.model.Animal;
import agh.ics.oop.model.MoveDirection;
import agh.ics.oop.model.Vector2d;

import java.util.ArrayList;
import java.util.List;

public class Simulation {
    private List<Animal> animals = new ArrayList<Animal>();
    private List<MoveDirection> moves;
    private int count;
    public Simulation(List<Vector2d> positions, List<MoveDirection> moves) {
        this.count = positions.size();
        this.moves = moves;
        for(Vector2d position : positions) {
            animals.add(new Animal(position));
        }
    }
    public void run() {
        int i = 0;
        for(MoveDirection move : this.moves) {
            animals.get(i%count).move(move);
            System.out.print("Zwierzę ");
            System.out.print((i%count)+1);
            System.out.print(" : ");
            System.out.print(animals.get(i % count).toString());
            System.out.print("\n");
            i++;
        }
    }

}
