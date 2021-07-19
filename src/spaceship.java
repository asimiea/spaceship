import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class Spaceship {
    Image s = configuration.ship;
    ImageView imageView = new ImageView(s);
    Bullet bullet;
    Bullet[] b;

    public Spaceship(Pane root) {
        
        //Setting the position of the image 
        imageView.setX(200);
        imageView.setY(425);
        imageView.setFitWidth(75);
        imageView.setPreserveRatio(true);
        imageView.setSmooth(true);
        imageView.setCache(true);
        //imageView.setFitHeight(configuration.height);
        //imageView.setFitWidth(configuration.width);
        
        /*scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (configuration.spaceshipMove == true) {

                    if (event.getCode() == KeyCode.LEFT && imageView.getX() > 5) {
                        imageView.setX(imageView.getX() - 10);
                       
                    }
                    if (event.getCode() == KeyCode.RIGHT && imageView.getX() < 430) {
                        imageView.setX(imageView.getX() + 10);
                    }
                    if(event.getCode()==KeyCode.SPACE){
                        ImageView laser = bullet.imageView;
                        laser.relocate(imageView.getX(), 0);
                        root.getChildren().add(laser);
                    }
                    configuration.spaceshipX= imageView.getX();
                }
            }

        });*/
        root.getChildren().add(imageView);

    }
    public Bullet shoot() {
        return new Bullet(20,25);
    }

    public Boolean collide(Asteroid other){
        if(this.imageView.getX()==other.imageView.getX() && this.imageView.getY()==other.imageView.getY()){
            return true;
        }
        return false;
    }
}
