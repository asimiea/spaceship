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
    private Spaceship Ship;
    private Asteroid a[];
    private Bullet bullet;
    private ImageView life;
    
    private int playerLife = 3;
	private int points;

    private AnimationTimer gameTimer;
        

    public Gameplay() throws InterruptedException {
        rand = new Random();
              
        root = new Pane();
        scene = new Scene(root, configuration.width, configuration.height);

        new Background(root);
        Ship = new Spaceship(root);
        //a = new Asteroid[10];
        bullet = new Bullet(10,100);

        setupKeybinds();
        createGameElements();
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
		life = new ImageView(configuration.life);
		setNewElementPos(life);
		root.getChildren().addAll(life);

		a = new Asteroid[3];
		for (int i = 0; i < a.length; i++) {
			a[i] = new Asteroid(root, 400, 30);
			setNewElementPos(a[i].imageView);
			//root.getChildren().add(a[i].imageView);
		}
	}

	private void setNewElementPos(ImageView image) {
		image.setLayoutX(rand.nextInt(configuration.width));
		image.setLayoutY(-(rand.nextInt(3200) + 600));
	}

	private void moveElements() {
		//star.setLayoutY(star.getLayoutY() + 5);
		life.setLayoutY(life.getLayoutY() + 5);
		for (int i = 0; i < a.length; i++) {
			a[i].imageView.setLayoutY(a[i].imageView.getLayoutY() + 7);
		}
	}

	private void checkElementsPos() {
		if (life.getLayoutY() > configuration.height) {
			setNewElementPos(life);
		}

		for (int i = 0; i < a.length; i++) {
			if (a[i].imageView.getLayoutY() > configuration.height) {
				setNewElementPos(a[i].imageView);
			}
		}
	}


    private void shoot() {
        if (spacePressed) {
			bullet = new Bullet(10, 100);
			bullet.imageView.setLayoutX(Ship.imageView.getLayoutX() + 38);
			bullet.imageView.setLayoutY(Ship.imageView.getLayoutY() - 45);

			root.getChildren().add(bullet.imageView);
			isBulletFired = true;
		}
    }

    private void moveBullet() {
		if (isBulletFired) {
			System.out.println("bullet fired at " + bullet.imageView.getY() + " now moving it");
			bullet.imageView.setY(bullet.imageView.getY() - 5);
			System.out.println("bullet is at: " + bullet.imageView.getLayoutY());
		}
	}

    public void fall(){

        for (int i = 0; i < a.length; i++) {
            a[i] = new Asteroid(root, 400, 30);
			a[i].imageView.setLayoutY(a[i].imageView.getLayoutY() + 7);
			//a[i].imageView.setRotate(a[i].imageView.getRotate() + 4 * i);
        
        }
    }

    private void createGameLoop() {
		gameTimer = new AnimationTimer() {
			@Override
			public void handle(long now) {
                //shoot();
                fall();
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
		if (37 + 12 > calculateDistance(Ship.imageView.getLayoutX() + 49, Ship.imageView.getLayoutY() + 49, life.getLayoutX() + 37,
				life.getLayoutY() + 15)) {
			setNewElementPos(life);
			addLife();
		}
		// collision detection with meteors
		for (int i = 0; i < a.length; i++) {
			if (a[i].imageView.getY() + Ship.imageView.getY() > calculateDistance(Ship.imageView.getLayoutX() + 49, Ship.imageView.getLayoutY() + 37,
					a[i].imageView.getLayoutX() + 20, a[i].imageView.getLayoutY() + 20)) {

				removeLife();
				setNewElementPos(a[i].imageView);
			}
		}
		/*for (int i = 0; i < a.length; i++) {
			if (METEOR_RADIUS + Ship.imageView.yProperty() > calculateDistance(Ship.getLayoutX() + 49, Ship.getLayoutY() + 37,
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
