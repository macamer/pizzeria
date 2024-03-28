package Vistas;

import Pedido.Modelo.ListaPedidos;
import Pedido.Modelo.Pedido;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import static Libreria.Libreria.*;
import javafx.stage.Stage;

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
    Button btnGuardar, btnCancelar;

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
    public void cancelar() {
        Stage v = (Stage) btnCancelar.getScene().getWindow();
        v.close();
    }

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
                        try {
                            cantidad = Integer.parseInt(cant.getText());
                            if (cantidad > 10 || cantidad < 1) {
                                correcto = false;
                                errorCant.setText("Debe ser entre 1 y 10");
                            }
                        } catch (NumberFormatException ex) {
                            correcto = false;
                            errorCant.setText("Introducir un número");
                        }
                    }
                    if (extras.isSelected()) {
                        extrasP = true;
                        if (queso.getSelectedToggle() == null && cham.getSelectedToggle() == null && bacon.getSelectedToggle() == null) {
                            result.setText("Debes seleccionar algún extra");
                            correcto = false;
                        } else {
                            if (queso.getSelectedToggle() != null) {
                                try {
                                    cantIng1 = Integer.parseInt(((RadioButton) queso.getSelectedToggle()).getText());
                                } catch (Exception e) {
                                    result.setText("Error de conversión");
                                }
                            }
                            if (cham.getSelectedToggle() != null) {
                                try {
                                    cantIng2 = Integer.parseInt(((RadioButton) cham.getSelectedToggle()).getText());
                                } catch (Exception e) {
                                    result.setText("Error de conversión");
                                }
                            }
                            if (bacon.getSelectedToggle() != null) {
                                try {
                                    cantIng3 = Integer.parseInt(((RadioButton) bacon.getSelectedToggle()).getText());
                                } catch (Exception e) {
                                    result.setText("Error de conversión");
                                }
                            }
                        }
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
                    Stage v = (Stage) btnGuardar.getScene().getWindow();
                    v.close();
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
