/**@author Asimiea Sobomate-Victor */


import java.io.FileNotFoundException;

import javafx.application.Application;
import javafx.scene.Group;

import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.scene.paint.ImagePattern;
import javafx.stage.Stage;

public class App extends Application{

    @Override
    public void start(Stage primaryStage) throws FileNotFoundException, InterruptedException{
        primaryStage.setTitle("Spaceship");
        
        //Image spaceBackground = new Image("background.png");
        
        Group group = new Group();
        VBox root = new VBox();
        root.getChildren().add(group);
        
        Scene scene = new Scene(root, 500,500);
        //scene.setFill(new ImagePattern(spaceBackground, 0,0,1,1,true)); 
        gameplay gamePlayStart=new gameplay(scene, root);   

        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public static void main(String[] args) throws Exception {
        launch(args);
    }
}
