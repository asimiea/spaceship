/**@author Asimiea Sobomate-Victor */


import javafx.application.Application;
import javafx.stage.Stage;

public class App extends Application{
    
    @Override
    public void start(Stage primaryStage) throws InterruptedException{
        primaryStage.setTitle("Spaceship");
        
       new Gameplay();
        
        
        primaryStage.setScene(Gameplay.getScene());
        primaryStage.show();
        
    }
    
    public static void main(String[] args) throws Exception {
        launch(args);
    }
}
