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

public class PublicaOfertaController {
    @FXML private TextField loc_destinatie;
    @FXML private TextField loc_plecare;
    @FXML private TextField data_sosire;
    @FXML private TextField data_plecare;
    @FXML private TextField volum;
    @FXML private TextField pret_gol;
    @FXML private TextField pret_incarcat;
    @FXML private TextField inaltime;
    @FXML private TextField latime;
    @FXML private TextField lungime;
    @FXML private TextField greutate;
    @FXML private TextField tip;
    @FXML private TextField telefon;
    @FXML private TextField email;
    @FXML private Button publicaButton;

    JSONParser parser;
    JSONArray oferte;
    private int id = 0;

    @FXML
    private void initialize() throws IOException, ParseException {
        parser = new JSONParser();
        oferte = (JSONArray) parser.parse(new FileReader("C:\\Users\\irina\\Documents\\Facultate\\Anul 4\\Semestrul 1\\ISI\\Proiect\\Proiect\\src\\main\\json\\oferte.json"));

        FileWriter file = new FileWriter("C:\\Users\\irina\\Documents\\Facultate\\Anul 4\\Semestrul 1\\ISI\\Proiect\\Proiect\\src\\main\\json\\oferte.json");
        file.write(oferte.toJSONString());
        file.close();

    }

    public void publicaButtonOnAction(ActionEvent event) throws IOException, ParseException {
        String locDestinatie = loc_destinatie.getText();
        String locPlecare = loc_plecare.getText();
        String dataPlecare = data_plecare.getText();
        String dataSosire = data_sosire.getText();
        String volumT = volum.getText();
        String pretGol = pret_gol.getText();
        String pretIncarcat = pret_incarcat.getText();
        String greutateT = greutate.getText();
        String tipT = tip.getText();
        String latimeT = latime.getText();
        String lungimeT = lungime.getText();
        String inaltimeT = inaltime.getText();
        String telefonT = telefon.getText();
        String emailT = email.getText();


        JSONObject newOferta = new JSONObject();
        newOferta.put("id", Integer.toString(this.id));
        this.id++;
        newOferta.put("data_plecare", dataPlecare);
        newOferta.put("loc_plecare", locPlecare);
        newOferta.put("data_sosire", dataSosire);
        newOferta.put("loc_destinatie", locDestinatie);
        newOferta.put("tip", tipT);
        newOferta.put("volum", volumT);

        JSONObject gabarit = new JSONObject();
        gabarit.put("lungime", lungimeT);
        gabarit.put("latime", latimeT);
        gabarit.put("inaltime", inaltimeT);
        newOferta.put("gabarit", gabarit);
        newOferta.put("greutate", greutateT);

        JSONObject pret = new JSONObject();
        pret.put("gol", pretGol);
        pret.put("incarcat", pretIncarcat);
        newOferta.put("pret", pret);

        JSONObject contact = new JSONObject();
        contact.put("telefon", telefonT);
        contact.put("email", emailT);
        newOferta.put("contact", contact);

        oferte.add(newOferta);
        FileWriter file = new FileWriter("C:\\Users\\irina\\Documents\\Facultate\\Anul 4\\Semestrul 1\\ISI\\Proiect\\Proiect\\src\\main\\json\\oferte.json");
        file.write(oferte.toJSONString());
        file.close();

        App.setPagePath("C:\\Users\\irina\\Documents\\Facultate\\Anul 4\\Semestrul 1\\ISI\\Proiect\\Proiect\\src\\main\\fxml\\main_page_transportator.fxml");
        App.setPageTitle("Main Page Transportator");

        URL url = new File(App.getPagePath()).toURI().toURL();
        Parent root = FXMLLoader.load(url);
        App.getStage().setTitle(App.getPageTitle());
        App.getStage().setScene(new Scene(root, 1200, 800));
        App.getStage().show();
    }


}
