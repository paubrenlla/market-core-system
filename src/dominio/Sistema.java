package dominio;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import static javax.swing.JOptionPane.showMessageDialog;

/**
 * @author Paula Brenlla (311149) & Agustin Russo (286669)
 */
public class Sistema extends Observable implements Serializable {

    private ArrayList<Producto> listaProductos;
    private ArrayList<DuenoPuesto> listaDuenos;
    private ArrayList<Puesto> listaPuestos;
    private ArrayList<Mayorista> listaMayoristas;
    private ArrayList<Movimiento> listaMovimientos;

    //Constructor//
    public Sistema() {
        this.listaProductos = new ArrayList<>();
        this.listaDuenos = new ArrayList<>();
        this.listaPuestos = new ArrayList<>();
        this.listaMayoristas = new ArrayList<>();
        this.listaMovimientos = new ArrayList<>();
    }

    //Getters && Setters//
    public ArrayList<Producto> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(ArrayList<Producto> losProductos) {
        this.listaProductos = losProductos;
    }

    public ArrayList<DuenoPuesto> getListaDuenos() {
        return listaDuenos;
    }

    public void setListaDuenos(ArrayList<DuenoPuesto> losDueños) {
        this.listaDuenos = losDueños;
    }

    public ArrayList<Puesto> getListaPuestos() {
        return listaPuestos;
    }

    public void setListaPuestos(ArrayList<Puesto> losPuestos) {
        this.listaPuestos = losPuestos;
    }

    public ArrayList<Mayorista> getListaMayoristas() {
        return listaMayoristas;
    }

    public void setListaMayoristas(ArrayList<Mayorista> losMayoristas) {
        this.listaMayoristas = losMayoristas;
    }

    public ArrayList<Movimiento> getListaMovimientos() {
        return listaMovimientos;
    }

    public void setListaMovimientos(ArrayList<Movimiento> losMovimientos) {
        this.listaMovimientos = losMovimientos;
    }

    //Metodos para agregar elementos con listeners//
    public boolean agregarDuenoALista(DuenoPuesto d) {
        boolean agrega = true;
        Iterator<DuenoPuesto> lista = this.getListaDuenos().iterator();

        //recorro lista de duenos hasta que haya repetido (o no)
        while (lista.hasNext() && !agrega) {
            DuenoPuesto dueno = lista.next();
            if (dueno.equals(d)) {
                agrega = false;
            }
        }
        if (agrega) {
            this.getListaDuenos().add(d);
            ordenarListaDuenos();
            setChanged();
            notifyObservers();
        }
        return agrega;
    }

    public boolean agregarProductoALista(Producto p) {
        boolean agrega = true;
        Iterator<Producto> lista = this.getListaProductos().iterator();

        //recorro lista de productos hasta que haya repetido (o no)
        while (lista.hasNext() && agrega) {
            Producto prod = lista.next();
            if (prod.equals(p)) {
                agrega = false;
            }
        }

        if (agrega) {
            this.getListaProductos().add(p);
            ordenarListaProductosAlfabetico();
            setChanged();
            notifyObservers();
        }

        return agrega;
    }

    public boolean agregarMayoristaALista(Mayorista m) {
        boolean agrega = true;
        Iterator<Mayorista> lista = this.getListaMayoristas().iterator();

        //recorro lista de productos hasta que haya repetido (o no)
        while (lista.hasNext() && agrega) {
            Mayorista mayor = lista.next();
            if (mayor.equals(m)) {
                agrega = false;
            }
        }

        if (agrega) {
            this.getListaMayoristas().add(m);
            ordenarListaMayoristas();
            setChanged();
            notifyObservers();
        }
        return agrega;
    }

    public boolean agregarPuestoALista(Puesto p) {
        boolean agrega = true;
        Iterator<Puesto> lista = this.getListaPuestos().iterator();

        //recorro lista de productos hasta que haya repetido (o no)
        while (lista.hasNext() && agrega) {
            Puesto puest = lista.next();
            if (puest.equals(p)) {
                agrega = false;
            }
        }

        if (agrega) {
            this.getListaPuestos().add(p);
            ordenarListaPuestos();
            setChanged();
            notifyObservers();
        }
        return agrega;
    }

    public void agregarMovimientoALista(Movimiento m) {
        this.getListaMovimientos().add(m);
        setChanged();
        notifyObservers();
    }

    public void agregarStockProducto(Producto prod, int cantidad, Puesto p) {
        if (p.getStock().containsKey(prod)) {
            int actual = p.getStock().get(prod);
            p.getStock().put(prod, actual + cantidad);
        } else {
            p.getStock().put(prod, cantidad);
        }
        setChanged();
        notifyObservers();
    }

    //Metodos//
    //Ordenar las listas//
    public ArrayList<Producto> ordenarListaProductosAlfabetico() {
        Collections.sort(this.getListaProductos());

        return this.getListaProductos();
    }

    public ArrayList<DuenoPuesto> ordenarListaDuenos() {
        Collections.sort(this.getListaDuenos());

        return this.getListaDuenos();
    }

    public ArrayList<Puesto> ordenarListaPuestos() {
        Collections.sort(this.getListaPuestos());

        return this.getListaPuestos();
    }

    public ArrayList<Mayorista> ordenarListaMayoristas() {
        Collections.sort(this.getListaMayoristas());

        return this.getListaMayoristas();
    }

    /**
     * Genera un archivo en la carpeta del proyecto con los datos solicitados.
     *
     * @param listaPuestosAImprimir
     * @param tipo
     * @param minimo
     * @param maximo
     * @param nombre
     */
    public void generarArchivo(ArrayList<Puesto> listaPuestosAImprimir, char tipo, int minimo, int maximo, String nombre) {
        //Obtengo fecha y hora actual
        Date fechaActual = new Date();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String fechaHoraActual = formatoFecha.format(fechaActual);

        ArchivoGrabacion archG = new ArchivoGrabacion(nombre.replace(" ", "_") + ".txt");
        archG.grabarLinea(fechaHoraActual);
        int contadorLineas = 0;
        for (int i = minimo; i <= maximo; i++) {
            for (int j = 0; j < listaPuestosAImprimir.size(); j++) {
                Movimiento m = this.getListaMovimientos().get(i);
                Puesto p = listaPuestosAImprimir.get(j);
                if ((m.getPuesto().equals(p)) && (tipo == 'T' || m.getTipoMovimiento() == tipo)) {
                    contadorLineas++;
                    archG.grabarLinea(m.toString());
                }
            }
        }

        archG.grabarLinea("Cantidad de movimientos en el archivo: " + contadorLineas);
        archG.cerrar();
    }

    /**
     * Serializacion de la clase sistema, con todas sus listas y contenidos.
     */
    public void serializar() {
        try {
            FileOutputStream ff = new FileOutputStream("salida.ser");
            BufferedOutputStream bb = new BufferedOutputStream(ff);
            ObjectOutputStream out = new ObjectOutputStream(bb);

            out.writeObject(this);
            out.close();
        } catch (IOException e) {
            showMessageDialog(null, "No se han podido guardar los datos.", "Error", ERROR_MESSAGE);
        }
    }

    /**
     * Busca en la carpeta de proyecto el archivo "salida.ser" y en caso de
     * existir, lo desserializa.
     *
     * @return El sistema contenido en "archivo.ser".
     */
    public static Sistema desserializar() {
        Sistema s = new Sistema();
        try {
            FileInputStream ff = new FileInputStream("salida.ser");
            BufferedInputStream bb = new BufferedInputStream(ff);
            ObjectInputStream in = new ObjectInputStream(bb);

            s = (Sistema) (in.readObject());
            in.close();
        } catch (IOException |ClassNotFoundException  e) {
            showMessageDialog(null, "No se han podido cargar datos.", "Error", ERROR_MESSAGE);
        }
        return s;
    }
}
