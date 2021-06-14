package webcamqr;

import javax.swing.JFrame;

public class Inicio extends javax.swing.JFrame {

    public Inicio() {
        
        initComponents();
        this.setResizable(false); // Deshabilitar maximizacion del jframe
        this.setLocationRelativeTo(null); // Centrar jframe
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        qr = new javax.swing.JToggleButton();
        admin = new javax.swing.JToggleButton();
        label_bienvenida = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Inicio");

        qr.setText("LectorQR");
        qr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                qrActionPerformed(evt);
            }
        });

        admin.setText("Administracion");
        admin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adminActionPerformed(evt);
            }
        });

        label_bienvenida.setText("Bienvenidos a AsistenciaSM");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(label_bienvenida, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(qr, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                        .addComponent(admin)))
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addComponent(label_bienvenida)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(admin)
                    .addComponent(qr))
                .addGap(25, 25, 25))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Metodo para devolver el Jframe 
    private JFrame getFrame(){
        
        return this;
        
    }
    
    private void adminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adminActionPerformed
        
        new Login(){
            
            @Override
            public void dispose(){
                
                //Hacemos visible la principal
                getFrame().setVisible(true);
                //Cerramos vNueva
                super.dispose();
                
            }
            
        }.setVisible(true);
            
        this.setVisible(false);
        
    }//GEN-LAST:event_adminActionPerformed

    private void qrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_qrActionPerformed
        
        new LectorQR(){
            
            @Override
            public void dispose(){
                
                //Hacemos visible la principal
                getFrame().setVisible(true);
                //Cerramos vNueva
                super.dispose();
                close(); // Detener el hilo
                
            }
            
        }.setVisible(true);
            
        this.setVisible(false);
        
    }//GEN-LAST:event_qrActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                new Inicio().setVisible(true);
                
            }
        });
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton admin;
    private javax.swing.JLabel label_bienvenida;
    private javax.swing.JToggleButton qr;
    // End of variables declaration//GEN-END:variables

}
