/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Vistas;

import Pedido.Modelo.ListaPedidos;
import Pedido.Modelo.Pedido;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class FXMLAltaController implements Initializable {

    Pedido pedido;
    ListaPedidos miLista;

    @FXML
    ComboBox <String> pizza;
    
    @FXML
    RadioButton queso1,queso2,queso3,queso4,queso5,queso6;
    
    @FXML
    RadioButton cham1,cham2,cham3,cham4,cham5,cham6;
    
    @FXML
    RadioButton bac1,bac2,bac3,bac4,bac5,bac6;
    
    @FXML
    private TextField nom;
    @FXML
    private TextField ape;
    @FXML
    private TextField dni;
    @FXML
    private Label errorDatos;
    @FXML
    private CheckBox extras;
    @FXML
    private VBox tablaExtras;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            pizza.getItems().addAll("Provenzal", "Barbacoa", "Mediterránea");
            /* pizza.getItems().add("Provenzal");
            pizza.getItems().add("Barbacoa");
            pizza.getItems().add("Mediterránea");*/
            pizza.getSelectionModel().selectFirst();
            /*
            ToggleGroup tgQueso = new ToggleGroup();
            queso1.setToggleGroup(tgQueso);
            queso2.setToggleGroup(tgQueso);
            queso3.setToggleGroup(tgQueso);
            queso4.setToggleGroup(tgQueso);
            queso5.setToggleGroup(tgQueso);
            queso6.setToggleGroup(tgQueso);
            ToggleGroup tgCham = new ToggleGroup();
            cham1.setToggleGroup(tgCham);
            cham2.setToggleGroup(tgCham);
            cham3.setToggleGroup(tgCham);
            cham4.setToggleGroup(tgCham);
            cham5.setToggleGroup(tgCham);
            cham6.setToggleGroup(tgCham);
            ToggleGroup tgBac = new ToggleGroup();
            bac1.setToggleGroup(tgBac);
            bac2.setToggleGroup(tgBac);
            bac3.setToggleGroup(tgBac);
            bac4.setToggleGroup(tgBac);
            bac5.setToggleGroup(tgBac);
            bac6.setToggleGroup(tgBac);*/
            
            
            
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
