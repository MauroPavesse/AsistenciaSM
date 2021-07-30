package webcamqr;

import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
        
public class Aula extends javax.swing.JFrame {

    private ArrayList<Integer> listAulas = new ArrayList<Integer>();
    
    public Aula() {
        
        initComponents(); 
        cargarAulas();
        this.setResizable(false); // Deshabilitar maximizacion del jframe
        this.setLocationRelativeTo(null); // Centrar jframe
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        selectAulas = new javax.swing.JComboBox<>();
        label_aulas = new javax.swing.JLabel();
        btnAceptar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Aulas");

        selectAulas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectAulasActionPerformed(evt);
            }
        });

        label_aulas.setText("Aulas");

        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAceptar)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(label_aulas, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(50, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(selectAulas, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(label_aulas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(selectAulas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnAceptar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void selectAulasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectAulasActionPerformed

    }//GEN-LAST:event_selectAulasActionPerformed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed

        LectorQR.check(listAulas.get(selectAulas.getSelectedIndex()));
        this.dispose();
        
    }//GEN-LAST:event_btnAceptarActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                new Aula().setVisible(true);
                
            }
        });
        
    }
    
    // Metodo para cargar las aulas en el combo box
    public void cargarAulas(){
        
        Statement sentencia;
        ResultSet resultado;
        String consulta;
        
        consulta = "SELECT * FROM aulas ORDER BY id_aula ASC";
        
        try {
            
            sentencia = Conexion.obtener().createStatement();
            resultado = sentencia.executeQuery(consulta);
            
            if(resultado.isBeforeFirst())
            {
                while(resultado.next()){

                    selectAulas.addItem(resultado.getString(2));
                    listAulas.add(resultado.getInt(1));

                }
            }
            else
            {
                btnAceptar.setEnabled(false);
            }
            
        } catch (ClassNotFoundException | SQLException e) {
                            
            e.printStackTrace();
                        
        }
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JLabel label_aulas;
    private javax.swing.JComboBox<String> selectAulas;
    // End of variables declaration//GEN-END:variables

}
