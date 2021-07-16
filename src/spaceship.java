import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;

public class spaceship {
    Image s = configuration.ship;
    ImageView imageView = new ImageView(s);

    public spaceship(Pane root, Scene scene) {
        
        //Setting the position of the image 
        imageView.setX(250);
        imageView.setY(0);
        //imageView.setFitHeight(configuration.height);
        //imageView.setFitWidth(configuration.width);
        final Circle circ = new Circle(250, 450, 30);
        //final Circle boulder = new Circle(250, 250, 30);

        circ.setFill(new ImagePattern(s, 0,0,1,1,true));
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (configuration.spaceshipMove == true) {

                    if (event.getCode() == KeyCode.LEFT && imageView.getX() > 10) {
                        imageView.setX(imageView.getX() - 10);
                       
                    }
                    if (event.getCode() == KeyCode.RIGHT && imageView.getX() < 500) {
                        imageView.setX(imageView.getX() + 10);
                    }
                    configuration.spaceshipX= imageView.getX();
                    configuration.spaceshipY= imageView.getY();
                }
            }

        });
        root.getChildren().add(imageView);

    }
}
