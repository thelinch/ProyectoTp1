/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tony.Vista;

import javax.swing.JOptionPane;

/**
 *
 * @author lzJonathanHz
 */
public class Home_User extends javax.swing.JFrame {

    /**
     * Creates new form Home_User
     */
    public Home_User() {
        initComponents();
         this.setLocationRelativeTo(null);
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
        jLabelID_Persona = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel_Persona = new javax.swing.JLabel();
        jLabel_DNI = new javax.swing.JLabel();
        jTextField_DNI = new javax.swing.JTextField();
        jLabel_TipoPersona = new javax.swing.JLabel();
        jTextField_TipoPersona = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jTextField_Ruc = new javax.swing.JTextField();
        jLabel_Ruc = new javax.swing.JLabel();
        jLabel_Organizacion = new javax.swing.JLabel();
        jTextField_Organizacion = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelID_Persona.setText("Id_persona(BD)");
        jPanel1.add(jLabelID_Persona, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 70, 149, 37));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Home User");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 1, 630, 50));

        jLabel_Persona.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel_Persona.setText("Id Persona");
        jPanel1.add(jLabel_Persona, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, 37));

        jLabel_DNI.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel_DNI.setText("DNI");
        jPanel1.add(jLabel_DNI, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 80, 40));

        jTextField_DNI.setEditable(false);
        jTextField_DNI.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel1.add(jTextField_DNI, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 110, 180, 40));

        jLabel_TipoPersona.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel_TipoPersona.setText("Tipo Persona");
        jPanel1.add(jLabel_TipoPersona, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, -1, 40));

        jTextField_TipoPersona.setEditable(false);
        jTextField_TipoPersona.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel1.add(jTextField_TipoPersona, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 160, 180, 40));

        jTextField_Ruc.setEditable(false);
        jTextField_Ruc.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel_Ruc.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel_Ruc.setText("RUC");

        jLabel_Organizacion.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel_Organizacion.setText("Organizacion");

        jTextField_Organizacion.setEditable(false);
        jTextField_Organizacion.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel_Ruc, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jTextField_Ruc, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel_Organizacion, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField_Organizacion, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(58, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField_Organizacion, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                    .addComponent(jLabel_Organizacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField_Ruc)
                    .addComponent(jLabel_Ruc, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 600, 70));

        jTable1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Documentos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 0, 12), new java.awt.Color(51, 51, 255))); // NOI18N
        jTable1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id_Doc", "Proceso", "Asunto", "Estado"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, 540, 196));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 640, 520));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(Home_User.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home_User.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home_User.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home_User.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home_User().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelID_Persona;
    private javax.swing.JLabel jLabel_DNI;
    private javax.swing.JLabel jLabel_Organizacion;
    private javax.swing.JLabel jLabel_Persona;
    private javax.swing.JLabel jLabel_Ruc;
    private javax.swing.JLabel jLabel_TipoPersona;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField_DNI;
    private javax.swing.JTextField jTextField_Organizacion;
    private javax.swing.JTextField jTextField_Ruc;
    private javax.swing.JTextField jTextField_TipoPersona;
    // End of variables declaration//GEN-END:variables
}
