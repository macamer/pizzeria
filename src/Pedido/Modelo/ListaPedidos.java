package Pedido.Modelo;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Maria Cavaller
 */
public class ListaPedidos {

    private ArrayList<Pedido> listaPedidos;

    //constructor por defecto
    public ListaPedidos() {
        this.listaPedidos = new ArrayList<>();
    }

    // Método para agregar un pedido a la lista
    public boolean agregarPedido(Pedido p) {
        boolean insertado = false;
        if (p != null) {
            insertado = listaPedidos.add(p);
        }
        return insertado;
    }

    public Pedido buscaPedido(int numPed) {
        Pedido p = null;
        p = listaPedidos.get(numPed);
        return p;
    }

    //devuelve la longitud de la lista
    public int numPedidos() {
        int num = 0;
        num = listaPedidos.size();
        return num;
    }

    /*
    // borrar Pedido de la lista
    // a partir de un num de pedido
    public boolean borrarPedido(int numPed) {
        boolean insertado = false;
        Pedido a;
        a = buscaPedido(numPed);
        if (a != null) {
            insertado = listaPedidos.remove(a);
        }
        return insertado;
    }

    // Indica si un usuario cuyo dni está en la lista
    public boolean existePedido(int numPed) {
        Pedido p = null;
        boolean enc = false;
        Iterator<Pedido> iterator = listaPedidos.iterator();

        while (enc == false && iterator.hasNext()) {
            p = iterator.next();
            if (p.getNumeroPedido() == numPed) {
                enc = true;
            }
        }
        return enc;
    }

    // borrar Artículo de la lista
    // a partir de un objeto de la lista
    public boolean borrarPedido(Pedido p) {
        boolean insertado = false;
        if (p != null) {
            insertado = listaPedidos.remove(p);
        }
        return insertado;
    }

    public int numPedidos() {
        int num = 0;
        num = listaPedidos.size();
        return num;
    }

    // Comprobar si la lista está vacía
    public boolean vaciaLista() {
        boolean vacia = false;
        if (listaPedidos.isEmpty()) {
            vacia = true;
        }
        return vacia;
    }

    public boolean vaciarLista() {
        boolean vacia = false;
        if (listaPedidos != null) {
            vacia = true;
            listaPedidos.clear();
        }
        return vacia;
    }

    // mostrar todos los usuarios
    public void mostrarPedidos() {

        for (Pedido p : listaPedidos) {
            p.mostrarPedido();
            System.out.println("");
        }
        System.out.println();
    }

    public int proxNumPedido() {
        int num = 1;
        Pedido ultimoPedido;
        try {
            if (listaPedidos.size() > 0) { // Verificar si la lista no está vacía
                ultimoPedido = listaPedidos.get(listaPedidos.size() - 1);
                num = ultimoPedido.getNumeroPedido() + 1;
            }
        } catch (IndexOutOfBoundsException ex) {
            System.err.println("Se ha salido de la Lista");
        }
        return num;
    }*/
}
