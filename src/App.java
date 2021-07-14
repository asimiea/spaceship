/**@author Asimiea Sobomate-Victor */

import java.util.Random;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class App extends Application{

    private int height=500;
    private int width=500;
    private double newX;

    @Override
    public void start(Stage primaryStage){
        primaryStage.setTitle("Spaceship");
        
        Image spaceBackground = new Image("space.jpg");
        Image s = new Image("spaceship.png");
        Image a = new Image("asteroid.png");

        
        final Circle circ = new Circle(250, 450, 30);
        //final Circle boulder = new Circle(250, 250, 30);

        circ.setFill(new ImagePattern(s, 0,0,1,1,true));
        //boulder.setFill(new ImagePattern(a,0,0,1,1,true));

        Group group = new Group(circ);
        Random rand = new Random();

        Circle c[] = new Circle[500];
        //int i = 1;
        for(int i =0;i<100; i++) {
            c[i] = new Circle(rand.nextInt(500), rand.nextInt(10), 30);
            c[i].setFill(new ImagePattern(a,0,0,1,1,true));
            group.getChildren().add(c[i]);
            Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(5), 
                new KeyValue(c[i].layoutYProperty(), 1000-c[i].getRadius())));
        timeline.setCycleCount(500);
        timeline.play();
            //Raining(c[i]);
        }

        Scene scene = new Scene(group, width, height);
        scene.setFill(new ImagePattern(spaceBackground, 0,0,1,1,true));        
        scene.setOnKeyPressed(e ->{
            if(e.getCode() == KeyCode.RIGHT){
                newX = newX + 10;
                circ.setTranslateX(newX);
            }
            else if(e.getCode() == KeyCode.LEFT){
                newX = newX - 10;
                circ.setTranslateX(newX);
            }
            //else if(e.getCode()==KeyCode.SPACE){}
        });

        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args) throws Exception {
        launch(args);
    }
}

