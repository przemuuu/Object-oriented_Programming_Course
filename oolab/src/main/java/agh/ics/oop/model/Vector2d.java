package agh.ics.oop.model;

import java.util.Objects;

public class Vector2d {
    private final int x;
    private final int y;
    public Vector2d(int x,int y) {
        this.x=x;
        this.y=y;
    }
    public int get_x() {
        return this.x;
    }
    public int get_y() {
        return this.y;
    }
    public String toString() {
        return ("("+this.x+","+this.y+")");
    }
    public boolean precedes(Vector2d other) {
        if(this.x<=other.x && this.y<=other.y) {
            return true;
        }
        return false;
    }
    public boolean follows(Vector2d other) {
        if(this.x>=other.x && this.y>=other.y) {
            return true;
        }
        return false;
    }
    public Vector2d add(Vector2d other) {
        Vector2d created = new Vector2d(this.x+other.x,this.y+other.y);
        return created;
    }
    public Vector2d subtract(Vector2d other) {
        Vector2d created = new Vector2d(this.x-other.x,this.y-other.y);
        return created;
    }
    public Vector2d upperRight(Vector2d other) {
        int upX = 0;
        int upY = 0;
        upX = Math.max(this.x, other.x);
        upY = Math.max(this.y, other.y);
        Vector2d created = new Vector2d(upX,upY);
        return created;
    }
    public Vector2d lowerLeft(Vector2d other) {
        int downX = 0;
        int downY = 0;
        downX = Math.min(this.x, other.x);
        downY = Math.min(this.y, other.y);
        Vector2d created = new Vector2d(downX,downY);
        return created;
    }
    public Vector2d opposite() {
        Vector2d created = new Vector2d(this.y,this.x);
        return created;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vector2d vector2d = (Vector2d) o;
        return x == vector2d.x && y == vector2d.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
