/**
 * @author Asimiea Sobomate-Victor
 * 
 */
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class Background {
    Image image = configuration.background;
    ImageView imageView = new ImageView(image);

    public Background(Pane root) {
        imageView.setFitHeight(configuration.height);
        imageView.setFitWidth(configuration.width);
                
        root.getChildren().add(imageView);
    }

}
