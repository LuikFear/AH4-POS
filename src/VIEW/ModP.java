/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VIEW;

import DAO.ProductosDAORelacional;
import MODEL.Productos;
import javax.swing.ButtonModel;
import javax.swing.JOptionPane;

/**
 *
 * @author LuikFear
 */
public class ModP extends javax.swing.JFrame {

        
        
        
    int estado;
    int codigo = 0;
    int codigo_id = -1;
  
    
    int content;
            
        
    public ModP(Productos pro) {
        initComponents();
        cargar(pro);
        this.setLocationRelativeTo(this);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        JTcodigo = new javax.swing.JTextField();
        JTnombre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        JTdes = new javax.swing.JTextField();
        JTcantidad = new javax.swing.JTextField();
        JTprecio = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(102, 153, 255));
        jPanel1.setForeground(new java.awt.Color(102, 102, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setText("descripcion");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, -1, -1));

        jLabel6.setText("cantidad");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, -1, -1));

        JTcodigo.setEnabled(false);
        JTcodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTcodigoActionPerformed(evt);
            }
        });
        jPanel1.add(JTcodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 50, 140, -1));
        jPanel1.add(JTnombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 90, 140, -1));

        jLabel2.setText("Codigo");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 56, -1, -1));

        jLabel3.setText("Nombre");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 94, -1, -1));

        jButton1.setText("Modificar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(186, 302, 116, 59));

        jLabel7.setText("precio Q:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 230, -1, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Modificar Producto");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(114, 20, -1, -1));

        jButton2.setText("Regresar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 338, -1, -1));
        jPanel1.add(JTdes, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 130, 195, 44));
        jPanel1.add(JTcantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 190, 156, -1));
        jPanel1.add(JTprecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 230, 156, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 356, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 423, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JTcodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTcodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JTcodigoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if (JTcodigo.getText().isEmpty() && JTnombre.getText().isEmpty()
            && JTdes.getText().isEmpty() && JTcantidad.getText().isEmpty() && JTprecio.getText().isEmpty()  ) {
            JOptionPane.showMessageDialog(null, "Llena todos los campos");
        } else {
         

          enviarV();
           Main Newframe = new Main() ;
            Newframe.setVisible(true);
            dispose();

        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        
        
        Main Newframe = new Main() ;
            Newframe.setVisible(true);
            dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    
       public void Mostrar(int codigo_id) {

        codigo = codigo_id;
        ProductosDAORelacional sd = new ProductosDAORelacional();

        Productos Ven = sd.obtener_pro(codigo_id);

        JTcodigo.setText(Ven.getCodigo()+ "");
        JTnombre.setText(Ven.getNombre() + "");
        JTdes.setText(Ven.getDescripcion()+ "");
        JTcantidad.setText(Ven.getCantidad()+ "");
        JTprecio.setText(Ven.getPrecio()+ "");
        
        

    }
            
            
        private void enviarV() {


       Productos VE = new Productos(Integer.parseInt(JTcodigo.getText()), JTnombre.getText(), JTdes.getText(), Integer.parseInt(JTcantidad.getText()), Float.parseFloat(JTprecio.getText()));
       ProductosDAORelacional VEDAO = new ProductosDAORelacional();
       VEDAO.modificar_pro(VE);


       }
            
     public void cargar(Productos pro) {
        JTcodigo.setText(String.valueOf(pro.getCodigo()));
        JTnombre.setText(pro.getNombre());
            JTdes.setText(pro.getDescripcion());
        JTcantidad.setText(String.valueOf(pro.getCantidad()));
        JTprecio.setText(String.valueOf(pro.getPrecio()));
        
     
       
        codigo_id = pro.getCodigo();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField JTcantidad;
    private javax.swing.JTextField JTcodigo;
    private javax.swing.JTextField JTdes;
    private javax.swing.JTextField JTnombre;
    private javax.swing.JTextField JTprecio;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}

