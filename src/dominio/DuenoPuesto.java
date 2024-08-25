package dominio;

import java.io.Serializable;

/**
 *
 * @author Paula Brenlla (311149) && Agustin Russo (286669)
 */
public class DuenoPuesto implements Comparable<DuenoPuesto>, Serializable {

    private String nombre;
    private int edad;
    private int anosExperiencia;

    //Constructor//
    public DuenoPuesto(String unNombre, int unaEdad, int unosAnosExperiencia) {
        this.setNombre(unNombre);
        this.setEdad(unaEdad);
        this.setAnosExperiencia(unosAnosExperiencia);
    }

    //Getters && Setters//
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String unNombre) {
        this.nombre = unNombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int unaEdad) {
        this.edad = unaEdad;
    }

    public int getAnosExperiencia() {
        return anosExperiencia;
    }

    public void setAnosExperiencia(int unosAñosExperiencia) {
        this.anosExperiencia = unosAñosExperiencia;
    }

    //Metodos//    
    @Override
    public boolean equals(Object obj) {
        DuenoPuesto d = (DuenoPuesto) obj;

        return ((d.getNombre()).equalsIgnoreCase(this.getNombre()));
    }

    @Override
    public String toString() {
        return this.getNombre() + ". Edad: " + this.getEdad() + ". Años exp.: " + this.getAnosExperiencia() + ".";
    }

    @Override
    public int compareTo(DuenoPuesto unDueno) {
        return this.getNombre().compareToIgnoreCase(unDueno.getNombre());
    }

}
