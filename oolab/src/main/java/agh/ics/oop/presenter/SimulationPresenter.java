package agh.ics.oop.presenter;

import agh.ics.oop.OptionsParser;
import agh.ics.oop.model.*;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.geometry.HPos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

import java.io.IOException;
import java.util.List;

public class SimulationPresenter implements MapChangeListener{
    private static final double CELL_WIDTH = 30;
    private static final double CELL_HEIGHT = 30;
    private WorldMap worldMap;
    private Boundary bounds;
    private int counter = 1;
    @FXML
    private TextField importMoves;
    @FXML
    private Label moveDescription;
    @FXML
    private GridPane mapGrid;
    public void setWorldMap(WorldMap map) {
        this.worldMap = map;
    }
    private void clearGrid() {
        mapGrid.getChildren().retainAll(mapGrid.getChildren().get(0)); // hack to retain visible grid lines
        mapGrid.getColumnConstraints().clear();
        mapGrid.getRowConstraints().clear();
    }
    public void drawMap(WorldMap worldMap) {
        bounds = worldMap.getCurrentBounds();
        clearGrid();
        Label header = new Label();
        header.setText(" y\\x ");
        mapGrid.add(header,0,0);
        GridPane.setHalignment(header, HPos.CENTER);
        mapGrid.getRowConstraints().add(new RowConstraints(CELL_HEIGHT));
        mapGrid.getColumnConstraints().add(new ColumnConstraints(CELL_WIDTH));
        for(int i=bounds.upperRight().get_y();i>=bounds.lowerLeft().get_y();i--) {
            Label height = new Label();
            height.setText(""+i);
            mapGrid.add(height,0,bounds.upperRight().get_y()-i+1);
            GridPane.setHalignment(height, HPos.CENTER);
            mapGrid.getRowConstraints().add(new RowConstraints(CELL_HEIGHT));
        }
        for(int j=bounds.lowerLeft().get_x();j<=bounds.upperRight().get_x();j++) {
            Label width = new Label();
            width.setText(""+j);
            mapGrid.add(width,j-bounds.lowerLeft().get_x()+1,0);
            GridPane.setHalignment(width, HPos.CENTER);
            mapGrid.getColumnConstraints().add(new ColumnConstraints(CELL_WIDTH));
        }
        for(int i=bounds.lowerLeft().get_x();i<=bounds.upperRight().get_x();i++) {
            for(int j=bounds.upperRight().get_y();j>=bounds.lowerLeft().get_y();j--) {
                Label label = new Label();
                Vector2d position = new Vector2d(i, j);
                if(worldMap.objectAt(position) != null) {
                    label.setText(worldMap.objectAt(position).toString());
                } else {
                    label.setText("");
                }
                mapGrid.add(label,i-bounds.lowerLeft().get_x()+1,bounds.upperRight().get_y()-j+1);
                GridPane.setHalignment(label, HPos.CENTER);
            }
        }
    }
    @Override
    public void mapChanged(WorldMap map, String message) {
        Platform.runLater(() -> {
            moveDescription.setText(message);
            drawMap(worldMap);
        });
    }
    @FXML
    public void onSimulationStartClicked() {
        try {
            String[] args = importMoves.getText().split(" ");
            List<MoveDirection> directions = OptionsParser.parse(args);
            List<Vector2d> positions = List.of(new Vector2d(2, 2), new Vector2d(3, 4));
            SimulationApp app = new SimulationApp();
            app.initializeSimulation(positions, directions, counter);
            counter++;
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
