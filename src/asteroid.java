import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;


public class Asteroid {
    
    Image image = configuration.asteroid;
    ImageView imageView = new ImageView(image);
        
    public Asteroid(Pane root, int x, int y) {

        imageView.setX(x);
        imageView.setY(y);
        imageView.setFitWidth(75);
        imageView.setPreserveRatio(true);
        imageView.setSmooth(true);
        imageView.setCache(true);
        root.getChildren().add(imageView);
    }
}
