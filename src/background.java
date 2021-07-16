import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

public class background {
    Image image = configuration.background;
    ImageView imageView = new ImageView(image);

    Image image2 = configuration.background;
    ImageView imageView2 = new ImageView(image2);

    public static Timeline BackGroundLoop;

    public background(Scene scene, Pane root) {
        imageView.setFitHeight(configuration.height);
        imageView.setFitWidth(configuration.width);
        imageView2.setFitHeight(configuration.height);
        imageView2.setFitWidth(configuration.width);
        imageView.setX(250);
        imageView.setY(0);
        imageView2.setX(250);
        imageView2.setY(0);

        root.getChildren().add(imageView);
        root.getChildren().add(imageView2);

        BackGroundLoop = new Timeline(new KeyFrame(Duration.millis(3), new EventHandler<ActionEvent>() {

            @Override
            public void handle(final ActionEvent t) {
                if (imageView.getX() > -1195) {
                    imageView.setX(imageView.getX() - 1);
                } else {
                    imageView.setX(1200);

                }
                if (imageView2.getX() > -1195) {
                    imageView2.setX(imageView2.getX() - 1);
                } else {
                    imageView2.setX(1200);

                }
                //System.out.println("x1 : " + imageView.getX());
                //System.out.println("x2 : " + imageView2.getX());
            }
        }));
        BackGroundLoop.setCycleCount(Timeline.INDEFINITE);
        BackGroundLoop.play();
    }

}
