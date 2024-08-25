package dominio;

import java.io.Serializable;

/**
 *
 * @author Paula Brenlla (311149) && Agustin Russo (286669)
 */
public class Movimiento implements Serializable {

    private char tipoMovimiento;
    private Producto producto;
    private int precio;
    private int cantidad;
    private int numeroMovimiento;
    private Puesto puesto;

    //Constructor//
    public Movimiento(char unTipoMovimiento, Producto unProducto, int elPrecio, int laCantidad, int elNumeroCompra, Puesto unPuesto) {
        this.setTipoMovimiento(unTipoMovimiento);
        this.setProducto(unProducto);
        this.setPrecio(elPrecio);
        this.setCantidad(laCantidad);
        this.setNumeroMovimiento(elNumeroCompra);
        this.setPuesto(unPuesto);
    }

    //Getters && Setters//
    public char getTipoMovimiento() {
        return tipoMovimiento;
    }

    public void setTipoMovimiento(char unTipoMovimiento) {
        this.tipoMovimiento = unTipoMovimiento;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto unProducto) {
        this.producto = unProducto;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int elPrecio) {
        this.precio = elPrecio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int laCantidad) {
        this.cantidad = laCantidad;
    }

    public int getNumeroMovimiento() {
        return numeroMovimiento;
    }

    public void setNumeroMovimiento(int elNumeroCompra) {
        this.numeroMovimiento = elNumeroCompra;
    }

    public Puesto getPuesto() {
        return puesto;
    }

    public void setPuesto(Puesto unPuestoIdent) {
        this.puesto = unPuestoIdent;
    }

    //Metodos//
    @Override
    public String toString() {
        return this.getNumeroMovimiento() + "#" + this.getProducto()
                            + "#" + this.getPuesto() + "#" + this.getTipoMovimiento() + "#"
                            + this.getCantidad() + "#" + this.getPrecio();
    }
}
