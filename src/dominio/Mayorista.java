package dominio;

import java.io.Serializable;
import java.util.*;

/**
 *
 * @author Paula Brenlla (311149) && Agustin Russo (286669)
 */
public class Mayorista implements Comparable<Mayorista>, Serializable {

    private Long RUT;
    private String nombre;
    private String direccion;
    ArrayList<Producto> prodsQueOfrece;

    //Constructor//
    public Mayorista(Long unRUT, String unNombre, String unaUbicacion, ArrayList<Producto> losProductos) {
        this.setRUT(unRUT);
        this.setNombre(unNombre);
        this.setDireccion(unaUbicacion);
        this.setProdsQueOfrece(losProductos);
    }

    //Getters && Setters//
    public Long getRUT() {
        return RUT;
    }

    public void setRUT(Long unRUT) {
        this.RUT = unRUT;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String unNombre) {
        this.nombre = unNombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String unaUbicacion) {
        this.direccion = unaUbicacion;
    }

    public ArrayList<Producto> getProdsQueOfrece() {
        return prodsQueOfrece;
    }

    public void setProdsQueOfrece(ArrayList<Producto> losProdsQueOfrece) {
        this.prodsQueOfrece = losProdsQueOfrece;
    }

    //Metodos//
    @Override
    public boolean equals(Object obj) {
        Mayorista m = (Mayorista) obj;

        return m.getRUT().equals(this.getRUT());
    }

    @Override
    public String toString() {
        return this.getNombre() + " (" + this.getRUT() + ")";
    }

    @Override
    public int compareTo(Mayorista m) {
        return (this.getRUT()).compareTo(m.getRUT());
    }

}
