package interfaz;

import dominio.*;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.*;

/**
 *
 * @author Agustin Russo (286669)
 */
public class VentanaGenerarArchivo extends javax.swing.JFrame implements Observer {

    private Sistema modelo;

    //constructor
    public VentanaGenerarArchivo(Sistema unModelo) {
        this.setModelo(unModelo);
        this.modelo.addObserver(this);
        initComponents();
        this.update(this.modelo, this);
    }

    //Getters && Setters//
    public void setModelo(Sistema unModelo) {
        this.modelo = unModelo;
    }

    public Sistema getModelo() {
        return this.modelo;
    }

    // metodo de instancia
    /**
     * valida los valores introducidos en el rango
     *
     * @return
     */
    public boolean validar() {
        boolean valido = false;
        String strMin = txtMin.getText();
        String strMax = txtMax.getText();
        if (!strMin.isEmpty() && !strMax.isEmpty()) {
            int valorMin = Integer.parseInt(strMin) - 1;
            int valorMax = Integer.parseInt(strMax) - 1;
            if ((valorMin >= 0 && valorMax >= valorMin)) {
                if (this.getModelo().getListaMovimientos().isEmpty()) {
                    valido = valorMax == 0;
                } else {
                    valido = valorMax <= this.getModelo().getListaMovimientos().size();
                }
            }
        }
        return valido;
    }

    // metodos de observer
    @Override
    public void update(Observable o, Object obj
    ) {
        this.objetoAPantalla();
    }

    public void objetoAPantalla() {
        lstPuestos.setListData(this.getModelo().getListaPuestos().toArray());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblNombre = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        btnGenerar = new javax.swing.JButton();
        lblTipo = new javax.swing.JLabel();
        cboxTipo = new javax.swing.JComboBox<>();
        lblRango = new javax.swing.JLabel();
        txtMax = new javax.swing.JTextField();
        lblHasta = new javax.swing.JLabel();
        txtMin = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        lblPuesto = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstPuestos = new javax.swing.JList();
        cboxPuesto = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Mercado de Frutas y Verduras - Generacion de Archivo");
        getContentPane().setLayout(null);

        lblNombre.setText("Nombre de archivo:");

        btnGenerar.setText("Generar archivo");
        btnGenerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarActionPerformed(evt);
            }
        });

        lblTipo.setText("Tipo de movimiento:");

        cboxTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Solo compras", "Solo ventas", "Todos" }));
        cboxTipo.setSelectedIndex(2);

        lblRango.setText("Rango de numero de movimiento");

        txtMax.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtMaxKeyTyped(evt);
            }
        });

        lblHasta.setText("-");

        txtMin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtMinKeyTyped(evt);
            }
        });

        jLabel1.setText("(hay " + this.getModelo().getListaMovimientos().size() + " movimientos registrados)");

        lblPuesto.setText("Puesto:");

        jScrollPane1.setMaximumSize(new java.awt.Dimension(258, 130));
        jScrollPane1.setMinimumSize(new java.awt.Dimension(258, 130));

        lstPuestos.setVisible(false);
        jScrollPane1.setViewportView(lstPuestos);

        cboxPuesto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "Seleccionar" }));
        cboxPuesto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboxPuestoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblPuesto, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(cboxPuesto, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52)
                        .addComponent(btnGenerar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(lblNombre)
                            .addGap(49, 49, 49)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(lblTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cboxTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblRango, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtMin, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(lblHasta, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(txtMax, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(52, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnGenerar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNombre)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTipo)
                            .addComponent(cboxTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblRango)
                            .addComponent(txtMin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblHasta)
                            .addComponent(txtMax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblPuesto)
                            .addComponent(cboxPuesto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(20, 30, 620, 300);

        setSize(new java.awt.Dimension(677, 363));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtMaxKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMaxKeyTyped
        char caracter = evt.getKeyChar();
        if (!Character.isDigit(caracter)) {
            evt.consume();
        }
    }//GEN-LAST:event_txtMaxKeyTyped

    private void btnGenerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarActionPerformed
        if (!this.getModelo().getListaMovimientos().isEmpty()) {

            String nombre = txtNombre.getText();
            if (Auxiliar.verificarLinea(nombre, 1, 50)) {

                if (this.validar()) {
                    //obtengo rango de movimientos validado
                    int min = Integer.parseInt(txtMin.getText()) - 1;
                    int max = Integer.parseInt(txtMax.getText()) - 1;

                    int idxTipo = cboxTipo.getSelectedIndex();
                    char tipo = 'T';
                    //tipo de movimiento que pide
                    switch (idxTipo) {
                        case 0:
                            tipo = 'C';
                            break;
                        case 1:
                            tipo = 'V';
                            break;
                        case 2:
                            tipo = 'T';
                            break;
                    }

                    int[] indicesElegidos = lstPuestos.getSelectedIndices();
                    ArrayList<Puesto> puestosAImprimir = new ArrayList<>();
                    if (cboxPuesto.getSelectedIndex() == 0) {
                        //si elige todos los puestos
                        puestosAImprimir = this.getModelo().getListaPuestos();
                    } else {
                        //si elige puesto por puesto
                        for (int indice : indicesElegidos) {
                            puestosAImprimir.add(this.getModelo().getListaPuestos().get(indice));
                        }
                    }
                    this.getModelo().generarArchivo(puestosAImprimir, tipo, min, max, nombre);
                    showMessageDialog(this, "El archivo fue generado con éxito.", "Generación exitosa", INFORMATION_MESSAGE);
                } else { //si los numeros no estan en el intervalo valido
                    JOptionPane.showMessageDialog(this, "Debe introducir un rango de movimientos entre 1 y " + this.getModelo().getListaMovimientos().size() + ".", "Error", ERROR_MESSAGE);
                }
            } else { //si pone un nombre no valido
                JOptionPane.showMessageDialog(this, "Debe escribir el nombre al archivo a generar de entre 1 y 50 caracteres.", "Error", ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "No existen movimientos, no se puede generar un archivo.", "Error", ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnGenerarActionPerformed

    private void txtMinKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMinKeyTyped
        char caracter = evt.getKeyChar();
        if (!Character.isDigit(caracter)) {
            evt.consume();
        }
    }//GEN-LAST:event_txtMinKeyTyped

    private void cboxPuestoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboxPuestoActionPerformed
        if (cboxPuesto.getSelectedIndex() == 1) {
            lstPuestos.setVisible(true);
        } else {
            lstPuestos.setVisible(false);
        }
    }//GEN-LAST:event_cboxPuestoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGenerar;
    private javax.swing.JComboBox<String> cboxPuesto;
    private javax.swing.JComboBox<String> cboxTipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblHasta;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblPuesto;
    private javax.swing.JLabel lblRango;
    private javax.swing.JLabel lblTipo;
    private javax.swing.JList lstPuestos;
    private javax.swing.JTextField txtMax;
    private javax.swing.JTextField txtMin;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
