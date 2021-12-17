package com.example.app;

import com.esri.arcgisruntime.mapping.view.MapView;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
// Add
import javafx.fxml.FXMLLoader;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class App extends Application {

    private MapView mapView;

//    public void showMap()

    @Override
    public void start(Stage stage) throws IOException {
        // Login
        URL url = new File("src/main/fxml/login.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        stage.setTitle("Login");
        stage.setScene(new Scene(root, 570, 500));
        stage.show();

        /*
        // create a JavaFX scene with a stack pane as the root node, and add it to the scene
        StackPane stackPane = new StackPane();
        Scene scene = new Scene(stackPane);

        // set the title and size of the stage and show it
        stage.setTitle("Display a map tutorial");
        stage.setWidth(800);
        stage.setHeight(700);
        stage.setScene(scene);
        stage.show();

        // Note: it is not best practice to store API keys in source code.
        // The API key is referenced here for the convenience of this tutorial.
        String yourApiKey = "AAPK6088b003dca542c9bf689960e076a8ddW5JKJBRvjIPAnR3_s7X9-Qt4EwpzMABAsPenBuPyMyaqkcj5_E48MsR17Su9g6WE";
        ArcGISRuntimeEnvironment.setApiKey(yourApiKey);

        // create a map view to display the map and add it to the stack pane
        mapView = new MapView();

        ArcGISMap map = new ArcGISMap(BasemapStyle.ARCGIS_TOPOGRAPHIC);

        // set the map on the map view
        mapView.setMap(map);

        mapView.setViewpoint(new Viewpoint(45.943161, 24.96676, 5000000));

        // create a graphics overlay and add it to the map view
        GraphicsOverlay graphicsOverlay = new GraphicsOverlay();
        mapView.getGraphicsOverlays().add(graphicsOverlay);

        stackPane.getChildren().add(mapView);
        */
    }

    /**
     * Stops and releases all resources used in application.
     */
        /*
    @Override
    public void stop() {
        if (mapView != null) {
            mapView.dispose();
        }
    }*/

    public static void main(String[] args) {
        launch(args);
    }

}
