package dominio;

import java.util.*;

/**
 *
 * @author Paula Brenlla (311149) && Agustin Russo (286669)
 */
public class CriterioOrdenTipoProductoYNombre implements Comparator<Producto> {

    /* 
    * Criterio para ordenar la lista de productos primero por frutas y verduras,
    * y dentro de estos, de forma alfabetica 
     */
    @Override
    public int compare(Producto p1, Producto p2) {
        int retorno = 0;
        String tipoP1 = p1.getTipoProducto();
        String tipoP2 = p2.getTipoProducto();

        if (tipoP1.equals(tipoP2)) {
            //si son del mismo tipo comparo sus nombres
            retorno = p1.compareTo(p2);
        } else if (tipoP1.equalsIgnoreCase("fruta")) {
            //si no son del mismo tipo y el primero es fruta, ira primero
            retorno = -1;
        } else if (tipoP1.equalsIgnoreCase("verdura")) {
            //si no son del mismo tipo y el primero es verdura, ira luego
            retorno = 1;
        }

        return retorno;
    }
}
