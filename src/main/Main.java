/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

/**
 *
 * @author Hippolyte
 */
public class Main extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        VBox root = new VBox();
        root.setAlignment(Pos.CENTER);
        
        Scene mainScene = new Scene(root, 300, 250);
        
        Button submitBtn = new Button("Go to Feedback Scene");
        submitBtn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                Feedback fb = new Feedback();
                fb.start(primaryStage);
            }
        });
        
        Button loginBtn = new Button("Go to Login Scene");
        loginBtn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                User ur = new User();
                ur.start(primaryStage);
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
        
        root.getChildren().add(submitBtn);
        root.getChildren().add(loginBtn);
        root.getChildren().add(btn2);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
