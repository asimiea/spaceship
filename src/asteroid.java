import javafx.animation.Timeline;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;


public class Asteroid {
    Image image = configuration.asteroid;
    ImageView imageView = new ImageView(image);
    public Timeline asteroidMoveloop;
    Bullet bullet;

    public Asteroid(Pane root,int x,int y) {
        imageView.setX(x);
        imageView.setY(y);
        imageView.setFitWidth(75);
        imageView.setPreserveRatio(true);
        imageView.setSmooth(true);
        imageView.setCache(true);
        root.getChildren().add(imageView);

        /*asteroidMoveloop = new Timeline(new KeyFrame(Duration.millis(3), new EventHandler<ActionEvent>() {

            @Override
            public void handle(final ActionEvent t) {
                if(imageView.getY()>-10){
                imageView.setX(imageView.getX() - 10);
                }
               else{
                //imageView.setY(0);
                imageView.setY(randomPositionFactor());
                }
                
            }
        }));
        asteroidMoveloop.setCycleCount(Timeline.INDEFINITE);
        asteroidMoveloop.play();
*/
    }
}
