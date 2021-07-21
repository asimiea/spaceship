/**
 * @author Asimiea Sobomate-Victor
 * 
 */
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class Bullet {
    Image image = configuration.bullet;
    ImageView imageView = new ImageView(image);
    int speed = 10;

    public Bullet(int x, int y) {

        imageView.setFitHeight(y);
        imageView.setFitWidth(x);
        imageView.setPreserveRatio(true);
        imageView.setSmooth(true);
        imageView.setCache(true);
    }
}
