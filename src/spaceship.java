import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class Spaceship {
    Image s = configuration.ship;
    ImageView imageView = new ImageView(s);
    
    public Spaceship(Pane root) {
        
        //Setting the position of the image 
        imageView.setX(200);
        imageView.setY(425);
        imageView.setFitWidth(75);
        imageView.setPreserveRatio(true);
        imageView.setSmooth(true);
        imageView.setCache(true);
        
        root.getChildren().add(imageView);

    }
    
}
