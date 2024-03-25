/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Vistas;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class FXMLController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private Label error;

    @FXML
    private void btnIntroClicked() throws IOException {
        try {
            Stage stage1 = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("../Vistas/FXMLAlta.fxml"));
            Scene scene = new Scene(root);
            scene.getStylesheets().add("resources/css/fxmlAlta.css");
            stage1.setScene(scene);
            stage1.setTitle("Introducir Pedido");
            stage1.show();
        } catch (IOException ex) {
            error.setText("Error al crear la vista");
            System.out.println("Error al crear la vista");
        } catch (Exception e){
             error.setText("No se ha encontrado la vista");
            System.out.println(e.getMessage());
        }

    }
}