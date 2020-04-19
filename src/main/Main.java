/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

/**
 *
 * @author Hippolyte
 */
public class Main extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        FlowPane root = new FlowPane();
        Scene mainScene = new Scene(root, 300, 250);
        
        Button btn1 = new Button("Go to Feedback Scene");
        btn1.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                Feedback fb = new Feedback();
                fb.start(primaryStage);
            }
        });
        
        Button btn2 = new Button("Go to Map Scene");
        btn2.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                map mp = new map();
                mp.start(primaryStage);
            }
        });
		
        primaryStage.setTitle("Menu");
        primaryStage.setScene(mainScene);
        primaryStage.show();
        
        root.getChildren().add(btn1);
        root.getChildren().add(btn2);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
