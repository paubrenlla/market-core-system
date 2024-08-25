package dominio;

import java.io.Serializable;
import java.util.*;

/**
 *
 * @author Paula Brenlla (311149) && Agustin Russo (286669)
 */
public class Puesto implements Comparable<Puesto>, Serializable {

    private String identifiacion;
    private DuenoPuesto dueno;
    private String ubicacion;
    private int cantEmpleados;
    private HashMap<Producto, Integer> stock;

    //Constructor//
    public Puesto(String unaIdentificacion, DuenoPuesto unDueño, String unaUbicacion, int unaCantEmpleados) {
        this.setIdentifiacion(unaIdentificacion);
        this.setDueno(unDueño);
        this.setUbicacion(unaUbicacion);
        this.setCantEmpleados(unaCantEmpleados);
        this.stock = new HashMap<>();
    }

    //Getters && Setters
    public String getIdentifiacion() {
        return identifiacion;
    }

    public void setIdentifiacion(String unaIdentifiacion) {
        this.identifiacion = unaIdentifiacion;
    }

    public DuenoPuesto getDueno() {
        return dueno;
    }

    public void setDueno(DuenoPuesto unDueño) {
        this.dueno = unDueño;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String unaUbicacion) {
        this.ubicacion = unaUbicacion;
    }

    public int getCantEmpleados() {
        return cantEmpleados;
    }

    public void setCantEmpleados(int unaCantEmpleados) {
        this.cantEmpleados = unaCantEmpleados;
    }

    public HashMap<Producto, Integer> getStock() {
        return stock;
    }

    public void setStock(HashMap<Producto, Integer> stock) {
        this.stock = stock;
    }

    //Metodos//
    /**
     * Chequea que la venta que se quiere hacer no supere e stock actual de
     * producto del puesto. En el caso de que se pueda hacer la venta, la
     * realiza.
     *
     * @param p
     * @param cantidad
     * @return true si la venta no supera el stock, false de lo contrario
     */
    public boolean realizarVentaProducto(Producto p, int cantidad) {
        boolean hecha = false;
        int actual = this.getStock().get(p);

        if (actual > cantidad) {
            this.getStock().put(p, actual - cantidad);
            hecha = true;
        } else if (actual == cantidad) {
            this.getStock().remove(p);
            hecha = true;
        }
        return hecha;
    }

    @Override
    public boolean equals(Object obj) {
        Puesto p = (Puesto) obj;

        return ((p.getIdentifiacion().equalsIgnoreCase(this.getIdentifiacion())));
    }

    @Override
    public int compareTo(Puesto p) {
        return (this.getIdentifiacion()).compareToIgnoreCase(p.getIdentifiacion());
    }

    @Override
    public String toString() {
        return this.getIdentifiacion();
    }
}
