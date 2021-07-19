import java.util.ArrayList;
import java.util.Random;

import javafx.animation.KeyFrame;
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
    Bullet bullet[];

    
    //private ArrayList<Entity> entities = new ArrayList<>();
    private ArrayList<Asteroid> enemies = new ArrayList<>();
    private ArrayList<Bullet> projectiles = new ArrayList<>();

    ArrayList<Asteroid> asteroidAdd = new ArrayList<>();
    ArrayList<Asteroid> asteroidRemove = new ArrayList<>();
    //ArrayList<ParticleExplosion> explosionsToAdd = new ArrayList<>();
    //ArrayList<ParticleExplosion> explosionsToRemove = new ArrayList<>();
    
    

    public Gameplay() throws InterruptedException {
        /*Canvas canvas = new Canvas(configuration.width,configuration.height);	
		gc = canvas.getGraphicsContext2D();
		Timeline timeline = new Timeline(new KeyFrame(Duration.millis(100), e -> run(gc)));
		timeline.setCycleCount(Timeline.INDEFINITE);
		timeline.play();*/
        
        root = new Pane();
        scene = new Scene(root, configuration.width, configuration.height);

        backGround = new Background(root);
        Ship = new Spaceship(root);
        a = new Asteroid[10];
        bullet = new Bullet[12];

        setupKeybinds();

        
        /*asteroidLoop = new Timeline(new KeyFrame(Duration.millis(3), new EventHandler<ActionEvent>() {
              
            @Override
            public void handle(final ActionEvent t) {
                if(a.imageView.getY()>-10){
                a.imageView.setX(a.imageView.getX() - 10);
                }
                else{
                //imageView.setY(0);
                a.imageView.setY(rand.nextDouble());
                }
                 
            }
        }));
        asteroidLoop.setCycleCount(Timeline.INDEFINITE);
        asteroidLoop.play();*/

        for(int i =0;i<10;i++) {
            a[i] = new Asteroid(root, 100, -50);
            asteroidLoop = new Timeline(new KeyFrame(Duration.seconds(25), new EventHandler<ActionEvent>() {
              
                @Override
                public void handle(final ActionEvent t) {
                    
                }
            }));
            asteroidLoop.setDelay(Duration.millis(10000* i + 1000));
            asteroidLoop.setCycleCount(500);
            asteroidLoop.play();
        //break;
        //Raining(a[i]);
        }        
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
                Ship.shoot();
            }
        });
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

    
    public void finishGame() {
        if(Ship.collide(a[1])){
            Text textGameOver = new Text(500, 300, " ");
            textGameOver.prefHeight(100);
            textGameOver.prefWidth(100);
            textGameOver.setStyle("-fx-font: 54 arial;");
            textGameOver.setFill(Color.WHITE);
            root.getChildren().add(textGameOver);
        }
    }
}
