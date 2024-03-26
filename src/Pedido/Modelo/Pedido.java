package Pedido.Modelo;

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
    
    
    public String getNombreC() {
        return nombreC;
    }

    public void setNombreC(String nombreC) {
        this.nombreC = nombreC;
    }

    public String getApeC() {
        return apeC;
    }

    public void setApeC(String apeC) {
        this.apeC = apeC;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNomPizza() {
        return nomPizza;
    }

    public void setNomPizza(String nomPizza) {
        this.nomPizza = nomPizza;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public boolean isExtras() {
        return extras;
    }

    public void setExtras(boolean extras) {
        this.extras = extras;
    }

    public int getCantIng1() {
        return cantIng1;
    }

    public void setCantIng1(int cantIng1) {
        this.cantIng1 = cantIng1;
    }

    public int getCantIng2() {
        return cantIng2;
    }

    public void setCantIng2(int cantIng2) {
        this.cantIng2 = cantIng2;
    }

    public int getCantIng3() {
        return cantIng3;
    }

    public void setCantIng3(int cantIng3) {
        this.cantIng3 = cantIng3;
    }

}
