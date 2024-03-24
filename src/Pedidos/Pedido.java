package Pedidos;

/**
 *
 * @author Maria Cavaller
 */
public class Pedido {

    private String nombreC;
    private String apeC;
    private String dni;
    private String nomPizza;
    private int cantidad;
    private boolean extras;
    private int cantIng1;
    private int cantIng2;
    private int cantIng3;

    public Pedido(String nombreC, String apeC, String dni, String nomPizza, int cantidad, boolean extras, int cantIng1, int cantIng2, int cantIng3) {
        this.nombreC = nombreC;
        this.apeC = apeC;
        this.dni = dni;
        this.nomPizza = nomPizza;
        this.cantidad = cantidad;
        this.extras = extras;
        this.cantIng1 = cantIng1;
        this.cantIng2 = cantIng2;
        this.cantIng3 = cantIng3;
    }
}
