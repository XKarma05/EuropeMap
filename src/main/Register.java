/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.io.FileWriter;
import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import static main.User.checkin;

/**
 *
 * @author Hippolyte
 */
public class Register extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        VBox pane = new VBox();
        
        pane.setAlignment(Pos.CENTER);
        
        TextField TFusername = new TextField();
        PasswordField  TFpassword = new PasswordField();
        TextField TFage = new TextField();
        TextField TFcountry = new TextField();
        TextField TFinterest = new TextField();
        
        pane.getChildren().addAll(new Label("username: "), TFusername);
        pane.getChildren().addAll(new Label("password: "), TFpassword);
        pane.getChildren().addAll(new Label("age"), TFage);
        pane.getChildren().addAll(new Label("residence country: "), TFcountry);
        pane.getChildren().addAll(new Label("interests: "), TFinterest);
        
        Scene scene = new Scene(pane, 400, 400);
         
        Button mapBtn = new Button();
        mapBtn.setText("Go to the Map");
        mapBtn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                map mp = new map();
                mp.start(primaryStage);
            }        
        });

        Button loginBtn = new Button();
        loginBtn.setText("Sign up");
        loginBtn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Signed up !");
                dataRegistration(TFusername.getText(), TFpassword.getText(), TFage.getText(), TFcountry.getText(), TFinterest.getText());
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
        
        primaryStage.setTitle("Log in");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public void dataRegistration(String username, String password, String age, String country, String interest){
        
        try {
            FileWriter fichier = new FileWriter("usersData.txt", true); 
            try {
                fichier.write(username + " " + password + " " + age + " " + country + " " + interest + "\n");
            } finally {
                // quoiqu'il arrive, on ferme le fichier
                fichier.close();
            }
        } catch (IOException e) {
            System.out.println("Impossible de creer le fichier");
        }
    }
}


