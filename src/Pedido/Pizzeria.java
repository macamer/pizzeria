
package Pedido;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Maria Cavaller
 */
public class Pizzeria extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        try {
            //Principal stage
            Parent root = FXMLLoader.load(getClass().getResource("../Vistas/FXML.fxml"));
            stage.setTitle("Pizza Mario");

            Scene scene = new Scene(root);
            scene.getStylesheets().add("resources/css/fxml.css");
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
