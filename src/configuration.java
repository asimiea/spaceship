/**
 * @author Asimiea Sobomate-Victor
 */
import javafx.scene.image.Image;

public class configuration {
    public static int width = 500;
    public static int height = 500;
    public static Image ship = new Image("spaceship.png");
    public static Image background=new Image("background.png"); //("space.jpg");
    public static Image bullet=new Image("bullet.png");
    public static Image asteroid = new Image("asteroid.png");
    public static Image explosion = new Image("explosion.png");
    public static Image life = new Image("heart.png");

    public static boolean spaceshipMove=true;
    public static double spaceshipX=250;
    public static double spaceshipY=0;
    
}
