package com.example.dictionary;

import com.example.dictionary.model.Dictionary;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Consumer;

public class MainScreenController implements Initializable {

    private Dictionary dictionary;

    @FXML
    private Button addBtn;
    @FXML
    private Button deleteBtn;
    @FXML
    private Button toggleListBtn;
    @FXML
    private ScrollPane scrollPnl;

    public MainScreenController(){}

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }


    // Consumer is a functional Interface part of Java 8 and up
    private Consumer<String> loadScreen = screen ->{
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource(screen));
            Parent root = fxmlLoader.load();
            Stage stage = new Stage();

            stage.setTitle("Dictionary");
            Scene scene = new Scene(root);

            stage.setScene(scene);

            AddScreenController addScreen = fxmlLoader.getController();
            addScreen.loadWindow();

            stage.setResizable(false);
            stage.show();

        }catch(Exception ignored){

        }
    };


    public void setDictionary(Dictionary dictionary) {
        this.dictionary = dictionary;
    }

    public void addButton() throws IOException {
        loadScreen.accept("add-screen.fxml");
    }

    public void deleteButton() throws IOException {
        loadScreen.accept("delete-screen.fxml");
    }

    public void toggleList(){

    }
}