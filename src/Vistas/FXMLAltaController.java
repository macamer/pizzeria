package Vistas;

import Pedido.Modelo.ListaPedidos;
import Pedido.Modelo.Pedido;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import static Libreria.Libreria.*;

/**
 *
 * @author Maria Cavaller
 */
public class FXMLAltaController implements Initializable {

    Pedido pedido;
    ListaPedidos miLista;

    String nomP, apeP, dniP, nomPizza;
    int cantidad, cantIng1 = 0, cantIng2 = 0, cantIng3 = 0;
    boolean extrasP = false;
    boolean correcto = true;

    @FXML
    private TextField nom, ape, dni, cant;
    @FXML
    private Label errorDatos, errorCant, result;
    @FXML
    ComboBox<String> pizza;
    @FXML
    private CheckBox extras;
    @FXML
    ToggleGroup queso, cham, bacon;
    @FXML
    RadioButton queso1, queso2, queso3, queso4, queso5, queso6;

    @FXML
    RadioButton cham1, cham2, cham3, cham4, cham5, cham6;

    @FXML
    RadioButton bac1, bac2, bac3, bac4, bac5, bac6;
    @FXML
    private VBox tablaExtras;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            pizza.getItems().addAll("Provenzal", "Barbacoa", "Mediterránea");
            pizza.getSelectionModel().selectFirst();
        } catch (Exception e) {
            e.printStackTrace();
        }

        extras.setOnAction(e -> {
            if (extras.isSelected()) {
                System.out.println("se ha seleccionado");
                queso.getToggles().forEach(toggle -> ((RadioButton) toggle).setDisable(false));
                cham.getToggles().forEach(toggle -> ((RadioButton) toggle).setDisable(false));
                bacon.getToggles().forEach(toggle -> ((RadioButton) toggle).setDisable(false));
            } else {
                System.out.println("se ha deseleccionado");
                queso.getToggles().forEach(toggle -> ((RadioButton) toggle).setDisable(true));
                cham.getToggles().forEach(toggle -> ((RadioButton) toggle).setDisable(true));
                bacon.getToggles().forEach(toggle -> ((RadioButton) toggle).setDisable(true));
            }
        });
    }

    @FXML
    public void btnGuardar() {
        correcto = true;
        result.setText("");
        errorDatos.setText("");
        errorCant.setText("");
        try {
            nomP = nom.getText();
            if (validaNomApe(nomP)) {
                apeP = ape.getText();
                if (validaNomApe(apeP)) {
                    dniP = dni.getText();
                    if (!validaFormatoDni(dniP)) {
                        errorDatos.setText("Formato de DNI incorrecto");
                        dni.setText("");
                        correcto = false;
                    } else if (!validaLetraDni(dniP)) {
                        errorDatos.setText("Letra de DNI incorrecto");
                        dni.setText("");
                        correcto = false;
                    }
                    nomPizza = pizza.getValue().toString();
                    if (correcto) {
                        cantidad = Integer.parseInt(cant.getText());
                        if (cant.getText().equals("")) {
                            correcto = false;
                            errorCant.setText("Introducir cantidad");
                        }
                    }
                    if (extras.isSelected()) {
                        extrasP = true;
                        System.out.println("se ha seleccionado");
                        queso.getToggles().forEach(toggle -> ((RadioButton) toggle).setDisable(false));
                        cham.getToggles().forEach(toggle -> ((RadioButton) toggle).setDisable(false));
                        bacon.getToggles().forEach(toggle -> ((RadioButton) toggle).setDisable(false));
                        //calcular cantIng
                    }
                } else {
                    correcto = false;
                    errorDatos.setText("Introducir apellido");
                }
            } else {
                correcto = false;
                errorDatos.setText("Introducir un nombre");
            }
            //instanciar si todos los datos son correctos
            if (correcto) {
                pedido = new Pedido(nomP, apeP, dniP, nomPizza, cantidad, extrasP, cantIng1, cantIng2, cantIng3);
                System.out.println(pedido.toString());
                if (miLista.agregarPedido(pedido)) {
                    result.setText("Pedido Guardado con éxito");
                    result.setTextFill(Color.GREEN);
                } else {
                    result.setText("No se ha podido guardar");
                    result.setTextFill(Color.RED);
                }
            }
        } catch (NumberFormatException e) {
            errorCant.setText("Introducir un número entero");
        }
    }

    public void setDatos(ListaPedidos lista) {
        miLista = lista;
    }

}
