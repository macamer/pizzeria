package Vistas;

import Pedido.Modelo.ListaPedidos;
import Pedido.Modelo.Pedido;
import java.net.URL;
import java.util.Iterator;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class FXMLMostrarController implements Initializable {

    Pedido pedido;
    ListaPedidos miLista;

    String nomP, apeP, dniP, nomPizza;
    int cantidad, cantIng1 = 0, cantIng2 = 0, cantIng3 = 0;
    int numLista = 0;
    boolean extrasP = false;
    boolean correcto = true;

    @FXML
    private TextField nom, ape, dni, cant;
    @FXML
    ComboBox<String> pizza;
    @FXML
    private CheckBox extras;
    @FXML
    ToggleGroup queso, cham, bacon;
    @FXML
    private Button btnPri, btnAnt, btnSig, btnUlt, btnSalir;
    @FXML
    private Label result;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            pizza.getItems().addAll("Provenzal", "Barbacoa", "Mediterránea");
            pizza.getSelectionModel().selectFirst();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setDatos(ListaPedidos lista) {
        miLista = lista;
        mostrarPrimero();
    }

    @FXML
    public void mostrarPrimero() {
        try {
            pedido = miLista.buscaPedido(0);
            mostrarDatos(pedido);
        } catch (IndexOutOfBoundsException e){
            result.setText("No hay datos");
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }

    @FXML
    private void elegirLista(ActionEvent e) {
        Button b = (Button) e.getSource();
        if (b == btnPri) {
            pedido = miLista.buscaPedido(0);
            numLista = 0;
            System.out.println("Primero - Numero Lista: " + numLista);
        } else if (b == btnAnt) {
            if (numLista > 0) {
                numLista = numLista - 1;
                pedido = miLista.buscaPedido(numLista);
                System.out.println("Ant - Numero Lista: " + numLista);
            } else {
                result.setText("No hay más pedidos");
                result.setTextFill(Color.RED);
            }
        } else if (b == btnSig) {
            if (numLista < (miLista.numPedidos() - 1)) {
                numLista += 1;
                pedido = miLista.buscaPedido(numLista);
                System.out.println("Sigui - Numero Lista: " + numLista);
            } else {
                result.setText("No hay más pedidos");
                result.setTextFill(Color.RED);
            }
        } else if (b == btnUlt) {
            if (numLista < (miLista.numPedidos() - 1)) {
                numLista = (miLista.numPedidos() - 1);
                pedido = miLista.buscaPedido(numLista);
                System.out.println("Último - Numero Lista: " + numLista);
            } else {
                result.setText("Ya estás en el último");
                result.setTextFill(Color.RED);
            }
        }
        mostrarDatos(pedido);
    }

    public void mostrarDatos(Pedido pedido) {
        try {
            nom.setText(pedido.getNombreC());
            ape.setText(pedido.getApeC());
            dni.setText(pedido.getDni());
            pizza.setValue(pedido.getNomPizza());
            cant.setText(String.valueOf(pedido.getCantidad()));
            habilitarRadio(true); //deshabilitar
            cantIng1 = pedido.getCantIng1();
            cantIng2 = pedido.getCantIng2();
            cantIng3 = pedido.getCantIng3();
            selectRadio(cantIng1, queso);
            selectRadio(cantIng2, cham);
            selectRadio(cantIng3, bacon);
            if (pedido.isExtras()) {
                extras.setSelected(true); //seleccionar
            } else {
                extras.setSelected(false); //seleccionar
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    @FXML
    public void salir() {
        Stage v = (Stage) btnSalir.getScene().getWindow();
        v.close();
    }

    void habilitarRadio(Boolean b) {
        queso.getToggles().forEach(toggle -> ((RadioButton) toggle).setDisable(b));
        cham.getToggles().forEach(toggle -> ((RadioButton) toggle).setDisable(b));
        bacon.getToggles().forEach(toggle -> ((RadioButton) toggle).setDisable(b));
    }

    void selectRadio(int cant, ToggleGroup tg) {
        RadioButton rButtonE = null; //encontrado
        RadioButton rButton;
        if (cant != 0) {
            Iterator<Toggle> iterator = tg.getToggles().iterator();
            while (iterator.hasNext() && rButtonE == null) {
                rButton = (RadioButton) iterator.next();
                if (rButton.getText().equals(String.valueOf(cant))) {
                    rButtonE = rButton;
                }
            }
            tg.selectToggle(rButtonE);
        } else {
            tg.selectToggle(null);
        }
    }
}
