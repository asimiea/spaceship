import java.util.concurrent.ThreadLocalRandom;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

public class asteroid {
    Image image = configuration.asteroid;
    ImageView imageView = new ImageView(image);
    public Timeline asteroidMoveloop;

    public asteroid(Scene scene, Pane root,int x,int y) {
        imageView.setX(x);
        imageView.setY(y);
        imageView.setFitHeight(10);
        imageView.setFitWidth(10);
        root.getChildren().add(imageView);

        asteroidMoveloop = new Timeline(new KeyFrame(Duration.millis(3), new EventHandler<ActionEvent>() {

            @Override
            public void handle(final ActionEvent t) {
                if(imageView.getY()>-10){
                imageView.setY(imageView.getY() - 10);
                }
               else{
                imageView.setY(0);
                imageView.setY(randomPositionFactor());
                }
                
            }
        }));
        asteroidMoveloop.setCycleCount(Timeline.INDEFINITE);
        asteroidMoveloop.play();

    }

    public static int randomSpeedFactor() {

        return ThreadLocalRandom.current().nextInt(1, 10);
    }

    public static int randomPositionFactor() {

        return ThreadLocalRandom.current().nextInt(50, 510);
    }
}
