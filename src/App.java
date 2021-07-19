/**@author Asimiea Sobomate-Victor */


import java.io.FileNotFoundException;


import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;
import javafx.util.Duration;

public class App extends Application{
    
    @Override
    public void start(Stage primaryStage) throws FileNotFoundException, InterruptedException{
        primaryStage.setTitle("Spaceship");
        
        Gameplay Start=new Gameplay();
        
        
        primaryStage.setScene(Gameplay.getScene());
        primaryStage.show();
    }
    
    public static void main(String[] args) throws Exception {
        launch(args);
    }
}
