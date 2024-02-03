package agh.ics.oop.model;

import agh.ics.oop.Simulation;
import agh.ics.oop.SimulationEngine;
import agh.ics.oop.presenter.SimulationPresenter;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SimulationApp extends Application {
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getClassLoader().getResource("simulation.fxml"));
        BorderPane viewRoot = loader.load();

        configureStage(primaryStage, viewRoot, 0);
        primaryStage.show();
    }
    private void configureStage(Stage primaryStage, BorderPane viewRoot, int counter) {
        var scene = new Scene(viewRoot);
        primaryStage.setScene(scene);
        if(counter == 0) {
            primaryStage.setTitle("Simulation controller");
        } else {
            primaryStage.setTitle("Simulation " + counter);
        }
        primaryStage.minWidthProperty().bind(viewRoot.minWidthProperty());
        primaryStage.minHeightProperty().bind(viewRoot.minHeightProperty());
    }
    public void initializeSimulation(List<Vector2d> positions, List<MoveDirection> directions, int counter) throws IOException{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getClassLoader().getResource("multiple_simulation.fxml"));
        BorderPane viewRoot = loader.load();
        SimulationPresenter newPresenter = loader.getController();
        Stage newStage = new Stage();
        configureStage(newStage, viewRoot, counter);
        FileMapDisplay fileDisplay = new FileMapDisplay();

        GrassField newMap = new GrassField(10);
        newMap.addObserver(newPresenter);
        newMap.addObserver(fileDisplay);
        newPresenter.setWorldMap(newMap);

        Simulation simulation = new Simulation(positions, directions, newMap);
        List<Simulation> simulations = new ArrayList<>();
        simulations.add(simulation);

        newStage.show();

        SimulationEngine simulationEngine = new SimulationEngine(simulations);
        Thread thread = new Thread(simulationEngine::runAsync);
        thread.start();
    }
}
