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

    @FXML
    private TextField nom, ape, dni, cant;
    @FXML
    private Label errorDatos, result;
    @FXML
    ComboBox<String> pizza;
    @FXML
    private CheckBox extras;
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
    }

    @FXML
    public void btnGuardar() {
        result.setText("");
        errorDatos.setText("");
        try {
            nomP = nom.getText();
            apeP = ape.getText();
            dniP = dni.getText();
            nomPizza = pizza.getValue().toString();
            cantidad = Integer.parseInt(cant.getText());
            if (extras.isSelected()) {
                extrasP = true;
                //calcular cantIng
            }
            //instanciar
            pedido = new Pedido(nomP, apeP, dniP, nomPizza, cantidad, extrasP, cantIng1, cantIng2, cantIng3);
            System.out.println(pedido.toString());
            if (miLista.agregarPedido(pedido)) {
                result.setText("Pedido Guardado con éxito");
            } else {
                result.setText("No se ha podido guardar");
                result.setTextFill(Color.RED);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setDatos(ListaPedidos lista) {
        miLista = lista;
    }
}
