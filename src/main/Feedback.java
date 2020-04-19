/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.io.File;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.FileWriter;

import java.io.IOException;

/**
 *
 * @author Hippolyte
 */
public class Feedback extends Application {
    
    @Override
    public void start(Stage primaryStage) {

        
        VBox pane = new VBox();
        pane.setPadding(new Insets(10, 10, 300, 10));
        
        TextField TF = new TextField();
        
        pane.getChildren().addAll(new Label("Leave a feedback: "), TF);
        
        Scene scene = new Scene(pane, 300, 250);
        
        primaryStage.setTitle("Feedback");
        primaryStage.setScene(scene);
        primaryStage.show();
        

        Button submitBtn = new Button();
        submitBtn.setText("Submit");
        submitBtn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Submitted");
                feedback(TF.getText());
            }        
        });
        
        Button mainBtn = new Button("Go back to Main Scene");
        mainBtn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                Main m = new Main();
		m.start(primaryStage);
            }
        });
        
        pane.getChildren().add(submitBtn);
        pane.getChildren().add(mainBtn);
    }
    
    public static void feedback(String feedback)
    {
        System.out.println(feedback);

        try {
            FileWriter fichier = new FileWriter("feedback.txt", true); 
            try {
                fichier.write(feedback + "\n");
            } finally {
                // quoiqu'il arrive, on ferme le fichier
                fichier.close();
            }
        } catch (IOException e) {
            System.out.println("Impossible de creer le fichier");
        }
    }
}

