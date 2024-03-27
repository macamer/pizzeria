/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Vistas;

import Pedido.Modelo.ListaPedidos;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class FXMLController implements Initializable {

    ListaPedidos miLista = new ListaPedidos();

    @FXML
    private Label error;

    @FXML
    private void btnIntroClicked() throws IOException {
        try {

            FXMLLoader fxml = new FXMLLoader(getClass().getResource("../Vistas/FXMLAlta.fxml"));
            AnchorPane root = fxml.<AnchorPane>load();
            Scene scene = new Scene(root);
            Stage stage1 = new Stage();
            scene.getStylesheets().add("resources/css/fxmlAlta.css");
            stage1.setScene(scene);
            stage1.setTitle("Introducir Pedido");
            //crear el Modity
            stage1.initModality(Modality.APPLICATION_MODAL);
            //crear setController  para enviar los datos a AltaController
            stage1.show();
            FXMLAltaController cc = fxml.getController();
            cc.setDatos(miLista);
            stage1.show();
        } catch (IOException ex) {
            error.setText("Error al crear la vista");
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        } catch (Exception e) {
            error.setText("No se ha encontrado la vista");
            System.out.println(e.getMessage());
            e.getStackTrace();
        }
    }

    @FXML
    private void btnMostrarClicked() throws IOException {
        try {
            FXMLLoader fxml = new FXMLLoader(getClass().getResource("../Vistas/FXMLMostrar.fxml"));
            AnchorPane root = fxml.<AnchorPane>load();
            Scene scene = new Scene(root);
            Stage stage1 = new Stage();
            scene.getStylesheets().add("resources/css/fxmlMostrar.css");
            stage1.setScene(scene);
            stage1.setTitle("Mostrar Pedido");
            stage1.initModality(Modality.APPLICATION_MODAL);
            stage1.show();
            FXMLMostrarController cc = fxml.getController();
            cc.setDatos(miLista);
        } catch (IOException ex) {
            error.setText("Error al crear la vista");
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        } catch (Exception e) {
            error.setText("No se ha encontrado la vista");
            System.out.println(e.getMessage());
            e.getStackTrace();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
