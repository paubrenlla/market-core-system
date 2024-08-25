package interfaz;

/**
 *
 * @author Paula Brenlla (311149) && Agustin Russo (286669)
 */
public class Auxiliar {

    /**
     * Verifica que un String tenga un largo minimo y maximo.
     *
     * @param linea
     * @param min
     * @param max
     * @return true si el largo del String se encuentra entre los parametros
     * solicitados, false de lo contrario.
     */
    public static boolean verificarLinea(String linea, int min, int max) {
        boolean noTieneSoloEspacios = !linea.trim().isEmpty();
        boolean estaEnRango = ((linea.length() >= min) && (linea.length() <= max));
        return noTieneSoloEspacios && estaEnRango;
    }

}
