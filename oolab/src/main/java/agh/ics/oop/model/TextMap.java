package agh.ics.oop.model;

import java.util.ArrayList;
import java.util.List;

public class TextMap implements WorldMap<String, Integer>{
    List<String> map = new ArrayList<String>();
    public TextMap() {
    }
    @Override
    public boolean place(String object, Integer position) {
        map.add(object);
        return true;
    }
    @Override
    public void move(String object,MoveDirection direction) {
        Integer position = map.indexOf(object);
        String temp = map.get(position);
        switch(direction) {
            case LEFT: {
                if(position-1>=0) {
                    map.set(position, map.get(position-1));
                    map.set(position-1, temp);
                }
                break;
            }
            case RIGHT: {
                if(position+1<map.size()) {
                    map.set(position, map.get(position+1));
                    map.set(position+1, temp);
                }
                break;
            }
            default: {
                break;
            }
        }
    }
    @Override
    public boolean isOccupied(Integer position) {
        if(position<0 || position>=map.size()) {
            return false;
        }
        if(map.get(position) == null)
            return false;
        return true;
    }
    @Override
    public Integer getLowerLeft() {
        return(0);
    }
    @Override
    public Integer getUpperRight() {
        return(map.size());
    }
    @Override
    public String objectAt(Integer position) {
        return(map.get(position));
    }
    @Override
    public boolean canMoveTo(Integer position) {
        if(position<0 || position>=map.size()) {
            return false;
        } else {
            return true;
        }
    }
}
