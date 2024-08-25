package dominio;

import java.io.Serializable;
import javax.swing.Icon;

/**
 *
 * @author Paula Brenlla (311149) && Agustin Russo (286669)
 */
public class Producto implements Comparable<Producto>, Serializable {

    private String nombre;
    private String descripcion;
    private String tipoProducto;
    private String formaVenta;
    private Icon imagen;

    //Constructor//
    public Producto(String unNombre, String unaDescripcion, String elTipoProducto, String laFormaVenta, Icon laImagen) {
        this.setNombre(unNombre);
        this.setDescripcion(unaDescripcion);
        this.setTipoProducto(elTipoProducto);
        this.setFormaVenta(laFormaVenta);
        this.setImagen(laImagen);
    }

    //Getters && Setters//
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String unNombre) {
        this.nombre = unNombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String unaDescripcion) {
        this.descripcion = unaDescripcion;
    }

    public String getTipoProducto() {
        return tipoProducto;
    }

    public void setTipoProducto(String elTipoProducto) {
        this.tipoProducto = elTipoProducto;
    }

    public String getFormaVenta() {
        return formaVenta;
    }

    public void setFormaVenta(String laFormaVenta) {
        this.formaVenta = laFormaVenta;
    }

    public Icon getImagen() {
        return imagen;
    }

    public void setImagen(Icon unaImagen) {
        this.imagen = unaImagen;
    }

    //Metodos//
    @Override
    public boolean equals(Object obj) {
        Producto p = (Producto) obj;

        return ((p.getNombre()).equalsIgnoreCase(this.getNombre()));
    }

    @Override
    public String toString() {
        return this.getNombre();
    }

    @Override
    public int compareTo(Producto p) {
        return (this.getNombre()).compareToIgnoreCase(p.getNombre());
    }

}
