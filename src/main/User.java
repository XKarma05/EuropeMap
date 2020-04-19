/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import static main.Feedback.feedback;

/**
 *
 * @author Hippolyte
 */
public class User extends Application {
    
    @Override
    public void start(Stage primaryStage) {
                
        VBox pane = new VBox();
        
        pane.setAlignment(Pos.CENTER);
        
        TextField TFusername = new TextField();
        TextField TFpassword = new TextField();
        
        pane.getChildren().addAll(new Label("username: "), TFusername);
        pane.getChildren().addAll(new Label("password: "), TFpassword);
        
        Scene scene = new Scene(pane, 300, 250);
        
        primaryStage.setTitle("Log in");
        primaryStage.setScene(scene);
        primaryStage.show();
        

        Button loginBtn = new Button();
        loginBtn.setText("Log in");
        loginBtn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Submitted");
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
        
        pane.getChildren().add(loginBtn);
        pane.getChildren().add(mainBtn);
    }
    
    public static void checkin(){
        
    }
    
}
