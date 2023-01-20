package com.example.dictionary;

import com.example.dictionary.model.Dictionary;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Author: Franklin Neves Filho
 * Student ID: 6208239
 *
 * Title: Dictionary
 *
 * Description:
 *      This program is my take on creating a linked list from scratch.
 *      The entirety of this program does not contain any ArrayLists or arrays.
 *      You will find a Word class, which is the object used throughout the task,
 *      WordNode is the simple version of a real node in which it has the ability
 *      to refer to itself and the next node. WordList, is the class I used to
 *      define the linked list. One of the most difficult parts of this assignment
 *      was figuring out an algorithm to sort the lists. After days of researching
 *      and reading "Data Structures and Algorithms Made Easy In Java" by Narasimba Karumanchi
 *      I was able to use what is a called a bubble sort algorithm to sort them alphabetically.
 */
public class HelloApplication extends Application {

    // Once the application starts a new dictionary is created
    public Dictionary dictionary = new Dictionary();

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("testFile.fxml"));
        Scene scene = new Scene(fxmlLoader.load());

        MainScreenController mainController = fxmlLoader.getController();
        mainController.setDictionary(dictionary);

        stage.setTitle("Dictionary");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.sizeToScene();

        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}