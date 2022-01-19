package com.example.app;

import com.esri.arcgisruntime.ArcGISRuntimeEnvironment;
import com.esri.arcgisruntime.mapping.ArcGISMap;
import com.esri.arcgisruntime.mapping.BasemapStyle;
import com.esri.arcgisruntime.mapping.Viewpoint;
import com.esri.arcgisruntime.mapping.view.GraphicsOverlay;
import com.esri.arcgisruntime.mapping.view.MapView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.SubScene;
import javafx.scene.layout.AnchorPane;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class MainPageTransportatorController {
    private MapView mapView;
    @FXML
    private SubScene mapSubscene;
    @FXML private AnchorPane mapAnchorPane;

    @FXML
    private void initialize() {

        String yourApiKey = "AAPKca3243df47d54960a91f32f48753bcb75WL_YiH-kakWmW-wRipIm9-H95_FeyNZbQSwxXyHsmWGURszNG-Xx8-YejWCvnxd";
        ArcGISRuntimeEnvironment.setApiKey(yourApiKey);

        mapView = new MapView();


        ArcGISMap map = new ArcGISMap(BasemapStyle.ARCGIS_TOPOGRAPHIC);

        // set the map on the map view
        mapView.setMap(map);
        mapView.setViewpoint(new Viewpoint(45.943161, 24.96676, 5000000.0));

        // create a graphics overlay and add it to the map view
        GraphicsOverlay graphicsOverlay = new GraphicsOverlay();
        mapView.getGraphicsOverlays().add(graphicsOverlay);


        mapAnchorPane.setTopAnchor(mapView, 0.0);
        mapAnchorPane.setLeftAnchor(mapView, 0.0);
        mapAnchorPane.setRightAnchor(mapView, 0.0);
        mapAnchorPane.setBottomAnchor(mapView, 0.0);

        mapAnchorPane.getChildren().add(mapView);
    }

    public void publicaOfertaButtonOnAction(ActionEvent event) throws IOException, ParseException {
        App.setPagePath("C:\\Users\\irina\\Documents\\Facultate\\Anul 4\\Semestrul 1\\ISI\\Proiect\\Proiect\\src\\main\\fxml\\publicare_oferta.fxml");
        App.setPageTitle("Publica Oferta Transport");

        URL url = new File(App.getPagePath()).toURI().toURL();
        Parent root = FXMLLoader.load(url);
        App.getStage().setTitle(App.getPageTitle());
        App.getStage().setScene(new Scene(root, 1200, 800));
        App.getStage().show();
    }

    public void listaCereriButtonOnAction(ActionEvent event) throws IOException, ParseException {
        App.setPagePath("C:\\Users\\irina\\Documents\\Facultate\\Anul 4\\Semestrul 1\\ISI\\Proiect\\Proiect\\src\\main\\fxml\\list_cereri.fxml");
        App.setPageTitle("Cereri de Transport");

        URL url = new File(App.getPagePath()).toURI().toURL();
        Parent root = FXMLLoader.load(url);
        App.getStage().setTitle(App.getPageTitle());
        App.getStage().setScene(new Scene(root, 1200, 800));
        App.getStage().show();
    }

    void terminate() {

        if (mapView != null) {
            mapView.dispose();
        }
    }

}
