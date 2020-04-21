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
import javafx.scene.layout.StackPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import javafx.scene.paint.Color; 
import javafx.stage.Stage; 
import javafx.scene.shape.Circle; 
import javafx.scene.text.Font; 
import javafx.scene.text.Text; 

/**
 *
 * @author Hippolyte
 */
public class Main extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        VBox root = new VBox();
        root.setAlignment(Pos. CENTER);
        
        Scene mainScene = new Scene(root, 400, 400);
        
        StackPane sp = new StackPane();
        StackPane sp1 = new StackPane();
        /*
        Circle circle = new Circle();    
      
        circle.setCenterX(300.0f); 
        circle.setCenterY(180.0f); 
        circle.setRadius(90.0f); 

        circle.setFill(Color.DARKRED);    
 
        circle.setStrokeWidth(3); 
 
        circle.setStroke(Color.DARKSLATEBLUE);
*/
        Text text = new Text("Welcome to EuropeMap"); 

        text.setFont(Font.font("Edwardian Script ITC", 50)); 

        //Setting the position of the text 
        text.setX(155); 
        text.setY(50); 

        //Setting color to the text 
        text.setFill(Color.BEIGE); 
        text.setStrokeWidth(2); 
        text.setStroke(Color.DARKSLATEBLUE); 
      
        Button submitBtn = new Button("Go to Feedback Scene");
        submitBtn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                Feedback fb = new Feedback();
                fb.start(primaryStage);
            }
        });
        
        Button loginBtn = new Button("Go to Log in Scene");
        loginBtn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                User ur = new User();
                ur.start(primaryStage);
            }
        });
        
        Button signupBtn = new Button("Go to Sign up Scene");
        signupBtn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                Register rg = new Register();
                rg.start(primaryStage);
            }
        });
        
        Button mapBtn = new Button("Go to Map Scene");
        mapBtn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                map mp = new map();
                mp.start(primaryStage);
            }
        });
       
        root.getChildren().addAll(text, loginBtn, signupBtn, submitBtn);

                
       
        primaryStage.setTitle("Menu");
        primaryStage.setScene(mainScene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
