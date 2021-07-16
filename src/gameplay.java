import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class gameplay {
    Timeline isDeadLoop;

    public gameplay(Scene scene, Pane root) throws InterruptedException {

        background backGround = new background(scene, root);
        asteroid[] a = new asteroid[10];
        bullet[] bullet = new bullet[12];
        for (int i = 0; i < 12; i++) {
            bullet[i] = new bullet(scene, root,i*100,configuration.spaceshipY);

        }
        //int c=0;
        for(int i=0;i<12;i++){
            bullet[i].shoot();
            
        }
        for (int i = 0; i < 8; i++) {
            a[i] = new asteroid(scene, root, -100 - (500 * (i % 2)), i * 100);
        }

        spaceship playerShip = new spaceship(root, scene);

        Text textGameOver = new Text(500, 300, " ");
        textGameOver.prefHeight(100);
        textGameOver.prefWidth(100);
        textGameOver.setStyle("-fx-font: 54 arial;");
        textGameOver.setFill(Color.WHITE);
        root.getChildren().add(textGameOver);

        isDeadLoop = new Timeline(new KeyFrame(Duration.millis(1), new EventHandler<ActionEvent>() {

            @Override
            public void handle(final ActionEvent t) {
                for (int i = 0; i < 8; i++) {
                    if (isDead(playerShip, a[i])) {

                        textGameOver.setText("Game Over");
                        for (int j = 0; j < 8; j++) {
                            a[j].asteroidMoveloop.stop();
                        }
                        configuration.spaceshipMove = false;
                        //BackGround.BackGroundLoop.stop();
                        for (int j = 0; j < 12; j++) {
                            bullet[j].BulletLoop.stop();
                        }
                    }
                }
            }
        }));
        isDeadLoop.setCycleCount(Timeline.INDEFINITE);
        isDeadLoop.play();
    }

    static boolean isDead(spaceship p, asteroid o) {
        if (o.imageView.getX() <= p.imageView.getX() + 50 && o.imageView.getX() >= p.imageView.getX() - 50 && o.imageView.getY() <= p.imageView.getY() + 50 && o.imageView.getY() >= p.imageView.getY() - 50) {
            return true;
        }
        return false;

    }

    static void finishGame() {

    }
}
