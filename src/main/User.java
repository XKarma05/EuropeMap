/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.Scanner;

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

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import javafx.scene.control.PasswordField;

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
        PasswordField  TFpassword = new PasswordField();
        
        pane.getChildren().addAll(new Label("username: "), TFusername);
        pane.getChildren().addAll(new Label("password: "), TFpassword);
        
        Scene scene = new Scene(pane, 400, 400);
        
        primaryStage.setTitle("Log in");
        primaryStage.setScene(scene);
        primaryStage.show();
        
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
        loginBtn.setText("Log in");
        loginBtn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Checking..");
                if(checkin(TFusername.getText(), TFpassword.getText()) == 1)
                {
                    pane.getChildren().add(mapBtn);
                }
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
    
    public static int checkin(String username, String password){
        BufferedReader br = null;
  
        try{
            File file = new File("usersData.txt");
            
            //create BufferedReader object from the File
            br = new BufferedReader(new FileReader(file) );
            
            Scanner input = new Scanner(br);
            try
            {
                while(!input.next().equals(username))
                {
                    
                }
            }
            catch(Exception e){
                System.out.println("incorrect username");
            }
            
            if(input.next().equals(password))
                    {
                        System.out.println("Access granted");
                        return 1;
                    }
                    else
                    {
                        System.out.println(input.next() + "et" + password);
                        System.out.println("Access denied");
                        return 0;
                    }
            
                        
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("Impossible d'ouvrir le fichier");
        }finally{
            if(br != null){
                try { 
                    br.close(); 
                }catch(Exception e){};
                System.out.println("fermeture impossible");
            }
        }  
        return -1;
    }
}
   
