package agh.ics.oop.model;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

import java.util.*;

public class WorldElementBox extends VBox {
    public WorldElementBox(WorldElement element) {
        String imageName = element.toImage();
        Vector2d position = element.getPosition();
        Label label;
        if(Objects.equals(imageName, "grass")) {
            label = new Label("Trawa");
        } else {
            label = new Label("Z " + position.toString());
        }
        ImageView imageView = new ImageView(imageName + ".png");
        imageView.setFitWidth(20);
        imageView.setFitHeight(20);
        setAlignment(Pos.CENTER);
        getChildren().addAll(imageView, label);
    }
}
