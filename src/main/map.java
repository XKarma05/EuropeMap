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
import javafx.stage.Stage;

import java.io.FileInputStream; 
import java.io.FileNotFoundException; 
import javafx.application.Application; 
import javafx.scene.Group; 
import javafx.scene.Scene; 
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;  
import javafx.stage.Stage; 

/**
 *
 * @author Hippolyte
 */
public class map extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
      try{
      //Creating an image 
        Image image = new Image(new FileInputStream("mapOfEurope.png"));  

        //Setting the image view 
        ImageView imageView = new ImageView(image); 

        //Setting the position of the image 
        //imageView.setX(50); 
        //imageView.setY(25); 

        //setting the fit height and width of the image view 
        imageView.setFitHeight(763); 
        imageView.setFitWidth(1050); 

        //Setting the preserve ratio of the image view 
        imageView.setPreserveRatio(true);  

        //Creating a Group object  
        Group root = new Group(imageView);  

        //Creating a scene object 
        Scene scene = new Scene(root, 1050, 750);  

        //Setting title to the Stage 
        primaryStage.setTitle("Map of Europe");  

        //Adding scene to the stage 
        primaryStage.setScene(scene);

        //Displaying the contents of the stage 
        primaryStage.show(); 
      }
      catch(Exception e)
      {
          System.out.println("file not found");
      }
      
    }
    
}
