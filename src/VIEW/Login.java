/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VIEW;

import DAO.VendedoresDAORelacional;
import MODEL.Vendedores;
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author LuikFear
 */
public class Login extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    public Login() {
        initComponents();
           //IN THE CONSTRUCTOR WE SPECIFIED THE ROOT OF THE IMAGE
        this.setLocationRelativeTo(this);
        
        SetimageLabel(jLabel1,"src/pic/pos.png");
        SetimageLabel(jLabel2,"src/pic/us.png");
        SetimageLabel(jLabel3,"src/pic/lock.png");
//        SetimageLabel(jLabel4,"src/pictures/frame select.gif");
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lu = new javax.swing.JLabel();
        Lc = new javax.swing.JLabel();
        JTuser = new javax.swing.JTextField();
        PFps = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(156, 140, 173));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 180, 30, 30));
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 240, 30, 30));
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 20, 170, 70));

        lu.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        lu.setText("Usuario");
        jPanel1.add(lu, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, -1, -1));

        Lc.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        Lc.setText("Contraseña");
        jPanel1.add(Lc, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, -1, -1));

        JTuser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTuserActionPerformed(evt);
            }
        });
        jPanel1.add(JTuser, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 180, 270, 30));
        jPanel1.add(PFps, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 240, 270, 30));

        jButton1.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pic/entrar.png"))); // NOI18N
        jButton1.setText("INGRESAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 310, 150, 70));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 407, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JTuserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTuserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JTuserActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
 if(JTuser.getText().equals("admin")&&PFps.getText().equals("admin")){
            Main pr = new Main();
            JOptionPane.showMessageDialog(null, "Bienvenido c:");
            pr.setVisible(true);
            dispose();
        }else{
            consulta();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

  
    //METHOD USED TO RESCALE THE LABELS 
       private void SetimageLabel(JLabel labelName, String root) {
        ImageIcon image = new ImageIcon(root);
        Icon icon = new ImageIcon(image.getImage().getScaledInstance(labelName.getWidth(), labelName.getHeight(),Image.SCALE_DEFAULT));
        
        labelName.setIcon(icon);
        this.repaint();
        
        }
        
    
    
    private void consulta(){
        
        VendedoresDAORelacional ud = new VendedoresDAORelacional();
        Vendedores ven = ud.consultar_vendedores (JTuser.getText(),PFps.getText());
         if (ven != null){
            
        } else {
        }
    Venderdor ve = new Venderdor();
    ve.informacion(ven);
    ve.setVisible(true);
    dispose();
        
     
    }
       


    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField JTuser;
    private javax.swing.JLabel Lc;
    private javax.swing.JPasswordField PFps;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lu;
    // End of variables declaration//GEN-END:variables
}
