/**@author Asimiea Sobomate-Vivtor
*/

import java.util.Random;
import javafx.animation.AnimationTimer;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;

public class Gameplay {
    private Pane root;
    private static Scene scene;
    
    private Boolean spacePressed;
    private boolean isBulletFired;
    Boolean gameOver;
    
    Random rand;
    
    //elements
    private ImageView Ship;
    private ImageView a[];
    private ImageView bullet;
    private ImageView life;
    
    private int playerLife = 3;
	private int points;

    private AnimationTimer gameTimer;
        

    public Gameplay() throws InterruptedException {
        rand = new Random();
              
        root = new Pane();
        scene = new Scene(root, configuration.width, configuration.height);

        new Background(root);

        setupKeybinds();
        createGameElements();
        createGameLoop();        
    }
    
    private void setupKeybinds() {
        scene.setOnKeyPressed(e -> {
            if(e.getCode() == KeyCode.LEFT && Ship.getX() > 5){
                Ship.setX(Ship.getX()-10);
            }
            if(e.getCode() == KeyCode.RIGHT && Ship.getX() < 427){
                Ship.setX(Ship.getX()+10);
            }
            if(e.getCode()==KeyCode.SPACE){
                spacePressed = true;
            }
        });
        scene.setOnKeyReleased(e-> {
			if (e.getCode() == KeyCode.SPACE) {
				spacePressed = false;
				isBulletFired = false;
			}
		});
    }

    public void createGameElements() {
		//Spaceship
		Ship = new ImageView(configuration.ship);
		Ship.setX(200);
        Ship.setY(425);
        Ship.setFitWidth(75);
        Ship.setPreserveRatio(true);
        Ship.setSmooth(true);
        Ship.setCache(true);
		root.getChildren().add(Ship);

		//extra life
		life = new ImageView(configuration.life);
		life.setFitWidth(25);
    	life.setPreserveRatio(true);
        life.setSmooth(true);
        life.setCache(true);
		setNewElementPos(life);
		root.getChildren().addAll(life);

		//bullet
		bullet = new ImageView(configuration.bullet);
		bullet.setLayoutX(Ship.getLayoutX());
		bullet.setLayoutY(Ship.getLayoutY());
		bullet.setFitHeight(100);
		bullet.setFitWidth(10);
		bullet.setPreserveRatio(true);
		bullet.setSmooth(true);
		bullet.setCache(true);

		//asteroids
		a = new ImageView[3];
		for (int i = 0; i < a.length; i++) {
			a[i] = new ImageView(configuration.asteroid);
			a[i].setFitWidth(75);
			a[i].setPreserveRatio(true);
			a[i].setSmooth(true);
			a[i].setCache(true);
			root.getChildren().add(a[i]);
			setNewElementPos(a[i]);
		}
	}

	private void setNewElementPos(ImageView image) {
		image.setLayoutX(rand.nextInt(configuration.width));
		image.setLayoutY(-(rand.nextInt(3200) + 600));
	}

	private void moveElements() {
		//star.setLayoutY(star.getLayoutY() + 5);
		life.setLayoutY(life.getLayoutY() + 2);
		for (int i = 0; i < a.length; i++) {
			a[i].setLayoutY(a[i].getLayoutY() + 2);
		}
	}

	private void checkElementsPos() {
		if (life.getLayoutY() > configuration.height) {
			setNewElementPos(life);
		}

		for (int i = 0; i < a.length; i++) {
			if (a[i].getLayoutY() > configuration.height) {
				setNewElementPos(a[i]);
			}
		}
	}


    private void shoot() {
        if (spacePressed) {
			root.getChildren().add(bullet);
			isBulletFired = true;
		}
    }

    private void moveBullet() {
		if (isBulletFired) {
			//System.out.println("bullet fired at " + bullet.getY() + " now moving it");
			bullet.setY(bullet.getY() - 2);
			//System.out.println("bullet is at: " + bullet.getLayoutY());
		}
	}

    private void createGameLoop() {
		gameTimer = new AnimationTimer() {
			@Override
			public void handle(long now) {
                shoot();
                moveElements();
				moveBullet();
				checkElementsPos();
				//collisionDetection();
			}
		};
		gameTimer.start();
    }

    private void collisionDetection() {
		// collision detection with life
		if (37 + 12 > calculateDistance(Ship.getLayoutX() + 49, Ship.getLayoutY() + 49, life.getLayoutX() + 37,
				life.getLayoutY() + 15)) {
			setNewElementPos(life);
			addLife();
		}
		// collision detection with meteors
		for (int i = 0; i < a.length; i++) {
			if (a[i].getY() + Ship.getY() > calculateDistance(Ship.getLayoutX() + 49, Ship.getLayoutY() + 37,
					a[i].getLayoutX() + 20, a[i].getLayoutY() + 20)) {

				removeLife();
				setNewElementPos(a[i]);
			}
		}
		/*for (int i = 0; i < a.length; i++) {
			if (METEOR_RADIUS + Ship.yProperty() > calculateDistance(Ship.getLayoutX() + 49, Ship.getLayoutY() + 37,
					greyMeteors[i].getLayoutX() + 20, greyMeteors[i].getLayoutY() + 20)) {

				removeLife();
				setNewElementPos(greyMeteors[i]);
			}
		}*/
	}

	private void removeLife() {		
		playerLife--;
		if (playerLife <= 0) {
			gameTimer.stop();
		}
	}

	private void addLife() {
		playerLife++;
	}

	private double calculateDistance(double x1, double y1, double x2, double y2) {
		return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
	}

    public static Scene getScene(){
        return scene;
    }

    public Pane getPane(){
        return root;
    }
}
