package agh.ics.oop.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class RandomPositionGenerator implements Iterable<Vector2d> {
    private final int maxWidth;
    private final int maxHeight;
    private final int grassCount;
    public RandomPositionGenerator(int maxWidth, int maxHeight, int grassCount) {
        this.maxWidth = maxWidth;
        this.maxHeight = maxHeight;
        this.grassCount = grassCount;
    }
    @Override
    public Iterator<Vector2d> iterator() {
        List<Vector2d> positions = generateRandomPositions();
        return positions.iterator();
    }
    public List<Vector2d> generateRandomPositions() {
        List<Vector2d> positions = new ArrayList<>();
        for (int x = 0; x < maxWidth; x++) {
            for (int y = 0; y < maxHeight; y++) {
                positions.add(new Vector2d(x, y));
            }
        }
        Collections.shuffle(positions);
        return positions.subList(0, grassCount);
    }
}

