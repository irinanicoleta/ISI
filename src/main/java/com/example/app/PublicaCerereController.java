package com.example.app;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;

public class PublicaCerereController {
    @FXML private TextField loc_destinatie;
    @FXML private TextField loc_plecare;
    @FXML private TextField data_sosire;
    @FXML private TextField data_maxima_sosire;
    @FXML private TextField data_plecare;
    @FXML private TextField data_maxima_plecare;
    @FXML private TextField volum;
    @FXML private TextField tip;
    @FXML private TextField masa;
    @FXML private TextField buget;
    @FXML private TextField telefon;
    @FXML private TextField email;
    @FXML private Button publicaButton;
    JSONParser parser;
    JSONArray cereri;
    private int id = 0;

    @FXML
    private void initialize() throws IOException, ParseException {
        parser = new JSONParser();
        cereri = (JSONArray) parser.parse(new FileReader("C:\\Users\\irina\\Documents\\Facultate\\Anul 4\\Semestrul 1\\ISI\\Proiect\\Proiect\\src\\main\\json\\cereri.json"));

        FileWriter file = new FileWriter("C:\\Users\\irina\\Documents\\Facultate\\Anul 4\\Semestrul 1\\ISI\\Proiect\\Proiect\\src\\main\\json\\cereri.json");
        file.write(cereri.toJSONString());
        file.close();

    }

    public void publicaButtonOnAction(ActionEvent event) throws IOException, ParseException {
        String locDestinatie = loc_destinatie.getText();
        String locPlecare = loc_plecare.getText();
        String dataPlecare = data_plecare.getText();
        String dataSosire = data_sosire.getText();
        String dataMaximaPlecare = data_maxima_plecare.getText();
        String dataMaximaSosire = data_maxima_sosire.getText();
        String volumC = volum.getText();
        String masaC = masa.getText();
        String tipC = tip.getText();
        String bugetC = buget.getText();
        String telefonC = telefon.getText();
        String emailC = email.getText();


        JSONObject newCerere = new JSONObject();
        newCerere.put("id", Integer.toString(this.id));
        this.id++;
        newCerere.put("loc_plecare", locPlecare);
        newCerere.put("data_plecare", dataPlecare);
        newCerere.put("data_maxima_plecare", dataMaximaPlecare);
        newCerere.put("loc_destinatie", locDestinatie);
        newCerere.put("data_sosire", dataSosire);
        newCerere.put("data_maxima_sosire", dataMaximaSosire);
        newCerere.put("tip", tipC);
        newCerere.put("volum", volumC);
        newCerere.put("buget", bugetC);

        JSONObject contact = new JSONObject();
        contact.put("telefon", telefonC);
        contact.put("email", emailC);
        newCerere.put("contact", contact);

        cereri.add(newCerere);
        FileWriter file = new FileWriter("C:\\Users\\irina\\Documents\\Facultate\\Anul 4\\Semestrul 1\\ISI\\Proiect\\Proiect\\src\\main\\json\\cereri.json");
        file.write(cereri.toJSONString());
        file.close();

        App.setPagePath("C:\\Users\\irina\\Documents\\Facultate\\Anul 4\\Semestrul 1\\ISI\\Proiect\\Proiect\\src\\main\\fxml\\main_page_client.fxml");
        App.setPageTitle("Main Page Client");

        URL url = new File(App.getPagePath()).toURI().toURL();
        Parent root = FXMLLoader.load(url);
        App.getStage().setTitle(App.getPageTitle());
        App.getStage().setScene(new Scene(root, 1200, 800));
        App.getStage().show();
    }


}
