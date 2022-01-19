package com.example.app;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;

public class LoginController {


    @FXML private Button loginButton;
    @FXML private TextField usernameField;
    @FXML private PasswordField passwordField;
    @FXML private Hyperlink signUp;


    public void loginButtonOnAction(ActionEvent event) {
        String username = usernameField.getText();
        String password = passwordField.getText();

        System.out.println(username);
        System.out.println(password);

        try {
            //parola trebuie criptata
            if (checkPassword(username, password)) {
                //login success
                //next scene
            }
        } catch(Exception ignored){
            System.out.println("Introduce login information");
        }

    }

    private boolean checkPassword(String usernameCheck, String passwordCheck) throws IOException, ParseException {
        //parser
        JSONParser parser = new JSONParser();

        JSONArray users = (JSONArray) parser.parse(new FileReader("C:\\Users\\irina\\Documents\\Facultate\\Anul 4\\Semestrul 1\\ISI\\Proiect\\Proiect\\src\\main\\json\\users.json"));
        //verificare
        for (Object user : users) {
            JSONObject person = (JSONObject) user;

            String username = (String) person.get("username");

            String password = (String) person.get("password");

            String type = (String) person.get("type");

            if (password.equals(passwordCheck)) {
                if (type.equals("client")) {
                    //main page client
                    App.setPagePath("C:\\Users\\irina\\Documents\\Facultate\\Anul 4\\Semestrul 1\\ISI\\Proiect\\Proiect\\src\\main\\fxml\\main_page_client.fxml");
                    App.setPageTitle("Main Page Client");
                    App.setType("client");
                    System.out.print("client logged in");

                    URL url = new File(App.getPagePath()).toURI().toURL();
                    Parent root = FXMLLoader.load(url);

                    App.getStage().setTitle(App.getPageTitle());
                    App.getStage().setScene(new Scene(root, 1200, 1200));
                    App.getStage().show();
                } else if (type.equals("transportator")) {
                    //main page transportator
                    App.setPagePath("C:\\Users\\irina\\Documents\\Facultate\\Anul 4\\Semestrul 1\\ISI\\Proiect\\Proiect\\src\\main\\fxml\\main_page_transportator.fxml");
                    App.setPageTitle("Main Page Transportator");
                    App.setType("transportator");

                    URL url = new File(App.getPagePath()).toURI().toURL();
                    Parent root = FXMLLoader.load(url);
                    App.getStage().setTitle(App.getPageTitle());
                    App.getStage().setScene(new Scene(root, 1200, 1200));
                    App.getStage().show();
                } else {
                    //va urma main page admin
                    App.setType("admin");
                }
                return true;
            }
        }
        return false;
    }

    public void signUpHyperlinkOnAction(ActionEvent event) throws IOException {
        App.setPagePath("C:\\Users\\irina\\Documents\\Facultate\\Anul 4\\Semestrul 1\\ISI\\Proiect\\Proiect\\src\\main\\fxml\\signup.fxml");
        App.setPageTitle("Create Account");

        URL url = new File(App.getPagePath()).toURI().toURL();
        Parent root = FXMLLoader.load(url);

        App.getStage().setTitle(App.getPageTitle());
        App.getStage().setScene(new Scene(root, 600, 400));
        App.getStage().show();
    }


}
