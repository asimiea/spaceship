import java.util.ArrayList;
import java.util.Random;

import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class Gameplay {
    private Pane root;
    private static Scene scene;
    private GraphicsContext gc;

    Timeline isDeadLoop;
    Timeline bulletLoop;
    Timeline asteroidLoop;
    Random rand;
    Boolean gameOver;
    Background backGround;
    Spaceship Ship;
    Asteroid a[];
    Bullet bullet;   
    private AnimationTimer gameTimer;
    
    

    public Gameplay() throws InterruptedException {
              
        root = new Pane();
        scene = new Scene(root, configuration.width, configuration.height);

        backGround = new Background(root);
        Ship = new Spaceship(root);
        a = new Asteroid[10];
        bullet = new Bullet(10,100);

        setupKeybinds();
        createGameLoop();        
    }
    
    private void setupKeybinds() {
        scene.setOnKeyPressed(e -> {
            if(e.getCode() == KeyCode.LEFT && Ship.imageView.getX() > 5){
                Ship.imageView.setX(Ship.imageView.getX()-10);
            }
            if(e.getCode() == KeyCode.RIGHT && Ship.imageView.getX() < 427){
                Ship.imageView.setX(Ship.imageView.getX()+10);
            }
            if(e.getCode()==KeyCode.SPACE){
                shoot();
            }
        });
    }

    private void shoot() {
        
        bullet.imageView.setLayoutX(Ship.imageView.getX() + 38);
		//bullet.imageView.setLayoutY(Ship.imageView.getY() - 45);
		root.getChildren().add(bullet.imageView);
    }

    public void fall(){

        for (int i = 0; i < a.length; i++) {
            a[i] = new Asteroid(root, 400, 30);
			a[i].imageView.setLayoutY(a[i].imageView.getLayoutY() + 7);
			a[i].imageView.setRotate(a[i].imageView.getRotate() + 4 * i);
        
        }
    }

    private void createGameLoop() {
		gameTimer = new AnimationTimer() {

			@Override
			public void handle(long now) {
				fall();
                shoot();
			}
		};
		gameTimer.start();
    }

   /* private void add(Entity entity) {
        entities.add(entity);
        if (entity instanceof Player) {
            player = (Player)entity;
            pane.bindHealth(player.healthPropertyUnmodifiable());
        }
        if (entity instanceof Enemy) {
            enemies.add((Enemy)entity);
            root.getChildren().add(((Enemy)entity).getHealthBar());
        }
        if (entity instanceof Projectile) projectiles.add((Projectile)entity);
        root.getChildren().add(entity);
    }*/

    public static Scene getScene(){
        return scene;
    }

    public Pane getPane(){
        return root;
    }

    
    /*public void finishGame() {
        if(Ship.collide(a[1])){
            Text textGameOver = new Text(500, 300, " ");
            textGameOver.prefHeight(100);
            textGameOver.prefWidth(100);
            textGameOver.setStyle("-fx-font: 54 arial;");
            textGameOver.setFill(Color.WHITE);
            root.getChildren().add(textGameOver);
        }
    }*/
}
