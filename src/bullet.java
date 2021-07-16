/**
 * @author Asimiea Sobomate-Victor
 */

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

/**
 * @author Asimiea Sobomate-Victor
 */

public class bullet {
    Image image = configuration.bullet;
    ImageView imageView = new ImageView(image);
    Timeline BulletLoop;
    

    public bullet(Scene scene, Pane root,double x,double y) {

        imageView.setFitHeight(50);
        imageView.setFitWidth(70);
        root.getChildren().add(imageView);
        imageView.setX(configuration.spaceshipX-x);
        imageView.setY(y);
        BulletLoop = new Timeline(new KeyFrame(Duration.millis(3), new EventHandler<ActionEvent>() {

            @Override
            public void handle(final ActionEvent t) {
                
                if(imageView.getX()==250){
                   imageView.setY(configuration.spaceshipY); 
                }
                if (imageView.getX() < 500) {
                    imageView.setX(imageView.getX() + 1);
                    
                } else {
                    imageView.setX(configuration.spaceshipX);
                    imageView.setY(configuration.spaceshipY);
                   
                    
                }

            }
        }));

    }

    public void shoot() {
        BulletLoop.setCycleCount(Timeline.INDEFINITE);
        BulletLoop.play();


    }
}
