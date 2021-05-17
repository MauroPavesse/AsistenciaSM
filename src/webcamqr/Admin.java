/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webcamqr;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author Seba
 */
public class Admin extends javax.swing.JFrame {

    /**
     * Creates new form Admin
     */

    public Admin() {
        
        initComponents();
        tabla();
        this.setResizable(false);
        this.setLocationRelativeTo(null); 
        this.setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
    }
   
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        label_admin = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        btn_usuario = new javax.swing.JButton();
        btn_aula = new javax.swing.JButton();
        btn_asignatura = new javax.swing.JButton();
        btn_cerrarsesion = new javax.swing.JButton();
        btn_inasistencias = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        label_admin.setText("No data");

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Usuario", "Asignatura", "Fecha"
            }
        ));
        jScrollPane2.setViewportView(tabla);

        jLabel1.setText("Presentes");

        btn_usuario.setText("Usuario");
        btn_usuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_usuarioActionPerformed(evt);
            }
        });

        btn_aula.setText("Aula");
        btn_aula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_aulaActionPerformed(evt);
            }
        });

        btn_asignatura.setText("Asignatura");
        btn_asignatura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_asignaturaActionPerformed(evt);
            }
        });

        btn_cerrarsesion.setText("Cerrar Sesion");
        btn_cerrarsesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cerrarsesionActionPerformed(evt);
            }
        });

        btn_inasistencias.setText("Inasistencias");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(label_admin, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_cerrarsesion))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn_usuario)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_asignatura)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_aula)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(142, 142, 142))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_inasistencias, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label_admin)
                    .addComponent(btn_cerrarsesion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_usuario)
                    .addComponent(btn_aula)
                    .addComponent(btn_asignatura))
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(btn_inasistencias)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_usuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_usuarioActionPerformed
        new Usuario().setVisible(true);
    }//GEN-LAST:event_btn_usuarioActionPerformed

    private void btn_aulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_aulaActionPerformed
        new NuevaAula().setVisible(true);
    }//GEN-LAST:event_btn_aulaActionPerformed

    private void btn_asignaturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_asignaturaActionPerformed
        new NuevaAsignatura().setVisible(true);
    }//GEN-LAST:event_btn_asignaturaActionPerformed

    private void btn_cerrarsesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cerrarsesionActionPerformed
        this.dispose();
    }//GEN-LAST:event_btn_cerrarsesionActionPerformed

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
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Admin().setVisible(true);
            }
        });
    }

    public void tabla (){
    
    DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
   
    Statement sentencia;
    ResultSet resultado;
    String consulta;
        
    consulta = "SELECT usuarios.nombre,asignaturas.nombre,asistencias.fecha FROM asistencias,usuarios,asignaturas WHERE ((usuarios.id_usuario=asistencias.id_usuario) AND (asignaturas.id_asignatura=asistencias.id_asignatura_a)) ORDER BY asistencias.id_asistencia ASC";
        
    try {
            
    sentencia = Conexion.obtener().createStatement();
    resultado = sentencia.executeQuery(consulta);

    // Bucle para cada resultado en la consulta
    while (resultado.next())
    {
       // Se crea un array que será una de las filas de la tabla.
       Object [] fila = new Object[3]; // Hay tres columnas en la tabla

       // Se rellena cada posición del array con una de las columnas de la tabla en base de datos.
       for (int i=0;i<3;i++)
          fila[i] = resultado.getObject(i+1); // El primer indice en rs es el 1, no el cero, por eso se suma 1.

       // Se añade al modelo la fila completa.
       modelo.addRow(fila);

    }
    }catch (ClassNotFoundException | SQLException e) {
                            
        e.printStackTrace();
                        
    }
    }
     public void nombreAdmin(String admin){
        label_admin.setText("Administrador: "+admin);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_asignatura;
    private javax.swing.JButton btn_aula;
    private javax.swing.JButton btn_cerrarsesion;
    private javax.swing.JButton btn_inasistencias;
    private javax.swing.JButton btn_usuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel label_admin;
    private javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables
}
