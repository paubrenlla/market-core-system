package interfaz;

import dominio.*;
import java.util.*;

/**
 *
 * @author Paula Brenlla (311149) & Agustin Russo (286669)
 */
public class VentanaConsultaPorProducto extends javax.swing.JFrame implements Observer {

    private Sistema modelo;
    private int numeroProd;

    //Constructor//
    /**
     * Creates new form VentanaConsultaPorProducto
     *
     * @param unModelo
     */
    public VentanaConsultaPorProducto(Sistema unModelo) {
        this.setModelo(unModelo);
        this.setNumeroProd(0);

        this.getModelo().addObserver(this);

        initComponents();

        this.update(this.modelo, this);
    }

    //Getters && Setters//
    public Sistema getModelo() {
        return modelo;
    }

    public void setModelo(Sistema unModelo) {
        this.modelo = unModelo;
    }

    public int getNumeroProd() {
        return numeroProd;
    }

    public void setNumeroProd(int numeroProd) {
        this.numeroProd = numeroProd;
    }

    //Metodos//
    @Override
    public void update(Observable o, Object obj) {
        if (!this.getModelo().getListaProductos().isEmpty()) {
            this.mostrarDatosProducto(this.getNumeroProd());
            mostrarInformacionMovimientosDeProducto(this.getNumeroProd());
            lblSinProductos.setVisible(false);

            if (this.getModelo().getListaProductos().size() <= 1) {
                btnSigProd.setEnabled(false);
                btnPrevProd.setEnabled(false);
            } else {
                btnSigProd.setEnabled(true);
            }
        } else {
            btnSigProd.setEnabled(false);
            btnPrevProd.setEnabled(false);
        }

    }

    /**
     * Recibe la posicion de un producto en una lista y devuelve sus datos como
     * producto y la informacion relacionado a sus ventas/compras.
     *
     * @param numero
     */
    public void mostrarDatosInformacion(int numero) {
        this.mostrarDatosProducto(numero);
        this.mostrarInformacionMovimientosDeProducto(numero);
    }

    /**
     * Encuentra el producto de la posicion pasada en la lista de productos y
     * muestra en pantalla todos sus datos.
     *
     * @param numero
     */
    public void mostrarDatosProducto(int numero) {
        Producto p = this.getModelo().getListaProductos().get(numero);
        lblImgProducto.setIcon(p.getImagen());
        txtNombre.setText(p.getNombre());
        txtDescripcion.setText(p.getDescripcion());
        jboxTipo.setSelectedItem(p.getTipoProducto());
        jboxFormaVenta.setSelectedItem(p.getFormaVenta());
    }

    /**
     * Encuentra el producto de la posicion pasada en la lista de productos y
     * busca todos los movimientos que incluyen ese producto. Encuentra los
     * valores maximos y minimos vendidos, el total de compras y el total de
     * ventas, y el total de compras y el total de ventas por unidad o
     * kilogramo. Devuelve los datos en pantalla y los puestos con el precio mas
     * alto y mas bajo de ese producto.
     *
     * @param numero
     */
    public void mostrarInformacionMovimientosDeProducto(int numero) {
        Producto p = this.getModelo().getListaProductos().get(numero);

        int precioMaxVendido = 0;
        int precioMinVendido = Integer.MAX_VALUE;

        int cantidadProductoVendida = 0;
        int cantidadProductoComprada = 0;

        int totalVendidoPesos = 0;
        int totalCompradoPesos = 0;

        ArrayList<Puesto> puestosPrecioVentaMax = new ArrayList<>();
        ArrayList<Puesto> puestosPrecioVentaMin = new ArrayList<>();

        Iterator<Movimiento> itMovs = this.getModelo().getListaMovimientos().iterator();
        while (itMovs.hasNext()) {
            Movimiento m = itMovs.next();
            if (m.getProducto().equals(p)) {
                //tipo de movimiento: venta
                if (m.getTipoMovimiento() == 'V') {
                    //si es una venta
                    cantidadProductoVendida += m.getCantidad();
                    totalVendidoPesos += m.getPrecio();

                    int aux = m.getPrecio() / m.getCantidad();

                    //Si es mayor cambio el maximo y agrego el puesto a la lista
                    if (aux > precioMaxVendido) {
                        precioMaxVendido = aux;
                        puestosPrecioVentaMax.clear();
                    }
                    if ((aux == precioMaxVendido) && !puestosPrecioVentaMax.contains(m.getPuesto())) {
                        puestosPrecioVentaMax.add(m.getPuesto());
                    }

                    //Si es menor cambio el minimo y agrego el puesto a la lista
                    if (aux < precioMinVendido) {
                        precioMinVendido = aux;
                        puestosPrecioVentaMin.clear();
                    }
                    if ((aux == precioMinVendido) && !puestosPrecioVentaMin.contains(m.getPuesto())) {
                        puestosPrecioVentaMin.add(m.getPuesto());
                    }

                } else {
                    //tipo de movimiento: compra
                    cantidadProductoComprada+= m.getCantidad();
                    totalCompradoPesos += m.getPrecio();
                }
            } //if equals producto
        } //while

        //totales comprados
        txtTotalComprado.setText(String.valueOf(totalCompradoPesos));
        txtTotalVendido.setText(String.valueOf(totalVendidoPesos));

        txtCantTotalComprada.setText(String.valueOf(cantidadProductoComprada));
        txtCantTotalVendida.setText(String.valueOf(cantidadProductoVendida));

        txtPrecioMaximo.setText(String.valueOf(precioMaxVendido));
        if (cantidadProductoVendida != 0) {
            txtPrecioMinimo.setText(String.valueOf(precioMinVendido));
        } else {
            txtPrecioMinimo.setText(String.valueOf(0));
        }

        //listas de puestos con precios extremos
        lstPuestosPrecioMax.setListData(puestosPrecioVentaMax.toArray());
        lstPuestosPrecioMin.setListData(puestosPrecioVentaMin.toArray());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings(value = "unchecked")

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlDatos = new javax.swing.JPanel();
        lblImgProducto = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnPrevProd = new javax.swing.JButton();
        btnSigProd = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtNombre = new javax.swing.JTextPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDescripcion = new javax.swing.JTextPane();
        jboxTipo = new javax.swing.JComboBox<>();
        jboxFormaVenta = new javax.swing.JComboBox<>();
        lblSinProductos = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtTotalVendido = new javax.swing.JTextField();
        txtTotalComprado = new javax.swing.JTextField();
        txtCantTotalVendida = new javax.swing.JTextField();
        txtCantTotalComprada = new javax.swing.JTextField();
        txtPrecioMinimo = new javax.swing.JTextField();
        txtPrecioMaximo = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        lstPuestosPrecioMin = new javax.swing.JList();
        jScrollPane4 = new javax.swing.JScrollPane();
        lstPuestosPrecioMax = new javax.swing.JList();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Mercado de Frutas y Verduras - Consulta de productos");
        getContentPane().setLayout(null);

        jLabel1.setText("Nombre:");

        jLabel2.setText("Descripcion:");

        jLabel3.setText("Tipo:");

        jLabel4.setText("Venta por:");

        btnPrevProd.setEnabled(false);
        btnPrevProd.setText("<");
        btnPrevProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrevProdActionPerformed(evt);
            }
        });

        btnSigProd.setText(">");
        btnSigProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSigProdActionPerformed(evt);
            }
        });

        txtNombre.setEnabled(false);
        jScrollPane1.setViewportView(txtNombre);

        txtDescripcion.setEnabled(false);
        jScrollPane2.setViewportView(txtDescripcion);

        jboxTipo.setEnabled(false);
        jboxTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Fruta", "Verdura" }));
        jboxTipo.setSelectedIndex(-1);

        jboxFormaVenta.setEnabled(false);
        jboxFormaVenta.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Unidad", "Kilogramo" }));
        jboxFormaVenta.setSelectedIndex(-1);

        lblSinProductos.setForeground(javax.swing.UIManager.getDefaults().getColor("Actions.Red"));
        lblSinProductos.setText("No hay productos registrados");
        lblSinProductos.setVisible(this.getModelo().getListaProductos().isEmpty());

        javax.swing.GroupLayout pnlDatosLayout = new javax.swing.GroupLayout(pnlDatos);
        pnlDatos.setLayout(pnlDatosLayout);
        pnlDatosLayout.setHorizontalGroup(
            pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDatosLayout.createSequentialGroup()
                .addGap(81, 81, 81)
                .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlDatosLayout.createSequentialGroup()
                        .addComponent(btnPrevProd, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSigProd, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblSinProductos, javax.swing.GroupLayout.Alignment.LEADING))
                .addContainerGap(105, Short.MAX_VALUE))
            .addGroup(pnlDatosLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlDatosLayout.createSequentialGroup()
                        .addComponent(lblImgProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(pnlDatosLayout.createSequentialGroup()
                        .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)
                            .addComponent(jboxTipo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jboxFormaVenta, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        pnlDatosLayout.setVerticalGroup(
            pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDatosLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(lblImgProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jboxTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jboxFormaVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 95, Short.MAX_VALUE)
                .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSigProd, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPrevProd, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblSinProductos)
                .addGap(10, 10, 10))
        );

        getContentPane().add(pnlDatos);
        pnlDatos.setBounds(28, 23, 343, 447);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setText("Informacion del producto:");

        jLabel6.setText("Total $ vendido entre los puestos");

        jLabel7.setText("Total $ comprado entre los puestos");

        jLabel8.setText("Cantidad total vendida entre los puestos (unidad/kilo):");

        jLabel9.setText("Precio mínimo vendido:");

        jLabel10.setText("Cantidad total comprada entre los puestos (unidad/kilo):");

        jLabel11.setText("Precio máximo vendido:");

        jLabel13.setText("Puestos con el precio de venta mínimo:");

        jLabel14.setText("Puestos con el precio de venta máximo:");

        txtTotalVendido.setEnabled(false);

        txtTotalComprado.setEnabled(false);

        txtCantTotalVendida.setEnabled(false);

        txtCantTotalComprada.setEnabled(false);

        txtPrecioMinimo.setEnabled(false);

        txtPrecioMaximo.setEnabled(false);

        jScrollPane3.setMaximumSize(new java.awt.Dimension(258, 130));
        jScrollPane3.setMinimumSize(new java.awt.Dimension(258, 130));

        lstPuestosPrecioMin.setEnabled(false);
        jScrollPane3.setViewportView(lstPuestosPrecioMin);

        jScrollPane4.setMaximumSize(new java.awt.Dimension(258, 130));
        jScrollPane4.setMinimumSize(new java.awt.Dimension(258, 130));

        lstPuestosPrecioMax.setEnabled(false);
        lstPuestosPrecioMax.setFocusCycleRoot(true);
        jScrollPane4.setViewportView(lstPuestosPrecioMax);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60)
                        .addComponent(txtTotalVendido, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60)
                        .addComponent(txtTotalComprado, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(txtCantTotalVendida, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(txtPrecioMinimo, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(92, 92, 92)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(txtPrecioMaximo, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(24, 24, 24)
                            .addComponent(txtCantTotalComprada, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE))
                        .addGap(92, 92, 92)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel5)
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtTotalVendido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtTotalComprado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtCantTotalVendida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtCantTotalComprada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel9))
                    .addComponent(txtPrecioMinimo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(txtPrecioMaximo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jLabel13))
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(420, 50, 600, 450);

        setSize(new java.awt.Dimension(1063, 519));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSigProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSigProdActionPerformed
        if ((numeroProd + 1) < this.getModelo().getListaProductos().size()) {
            numeroProd++;
            this.mostrarDatosInformacion(numeroProd);
            btnPrevProd.setEnabled(true);
            //si es el ultimo de la lista, bloqueo el boton de siguiente
            if (numeroProd == this.getModelo().getListaProductos().size() - 1) {
                btnSigProd.setEnabled(false);
            }
        }
    }//GEN-LAST:event_btnSigProdActionPerformed

    private void btnPrevProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrevProdActionPerformed
        if ((numeroProd - 1) >= 0) {
            numeroProd--;
            this.mostrarDatosInformacion(numeroProd);
            btnSigProd.setEnabled(true);
            //si es el primero de la lista, bloqueo el boton anterior
            if (numeroProd == 0) {
                btnPrevProd.setEnabled(false);
            }
        }
    }//GEN-LAST:event_btnPrevProdActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPrevProd;
    private javax.swing.JButton btnSigProd;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JComboBox<String> jboxFormaVenta;
    private javax.swing.JComboBox<String> jboxTipo;
    private javax.swing.JLabel lblImgProducto;
    private javax.swing.JLabel lblSinProductos;
    private javax.swing.JList lstPuestosPrecioMax;
    private javax.swing.JList lstPuestosPrecioMin;
    private javax.swing.JPanel pnlDatos;
    private javax.swing.JTextField txtCantTotalComprada;
    private javax.swing.JTextField txtCantTotalVendida;
    private javax.swing.JTextPane txtDescripcion;
    private javax.swing.JTextPane txtNombre;
    private javax.swing.JTextField txtPrecioMaximo;
    private javax.swing.JTextField txtPrecioMinimo;
    private javax.swing.JTextField txtTotalComprado;
    private javax.swing.JTextField txtTotalVendido;
    // End of variables declaration//GEN-END:variables
}
