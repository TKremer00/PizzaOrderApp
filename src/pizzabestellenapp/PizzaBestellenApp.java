package pizzabestellenapp;

import Views.Gui;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
/**
 * @author tim7v
 */
public class PizzaBestellenApp extends Application 
{

    @Override
    public void start(Stage primaryStage) 
    {
        GridPane root = new GridPane();
        Scene scene = new Scene(root, 420, 350);

        // start here new GUI
        new Gui(root);

        primaryStage.setTitle("Pizza Order");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        launch(args);
    }

}
