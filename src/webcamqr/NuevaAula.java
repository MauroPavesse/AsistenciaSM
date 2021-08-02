package webcamqr;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class NuevaAula extends javax.swing.JFrame {
    
    private ArrayList<Integer> listAulas = new ArrayList<Integer>();
    private static int idAula;
    
    public NuevaAula() {
        
        initComponents();
        cargarAulas();
        this.setResizable(false); // Deshabilitar maximizacion del jframe
        this.setLocationRelativeTo(null); // Centrar jframe
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        label_nombre = new javax.swing.JLabel();
        nombreAula = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        selectAulas = new javax.swing.JComboBox<>();
        btnEliminar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnModificar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Nueva aula");

        label_nombre.setText("Nombre del aula:");

        nombreAula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombreAulaActionPerformed(evt);
            }
        });

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        selectAulas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectAulasActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        jLabel1.setText("Eliminar aula:");

        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(label_nombre)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(nombreAula, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(selectAulas, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(btnGuardar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnEliminar)
                        .addGap(36, 36, 36))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(132, 132, 132)
                        .addComponent(btnModificar)))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_nombre)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(selectAulas, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(nombreAula, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnGuardar)
                    .addComponent(btnEliminar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnModificar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nombreAulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombreAulaActionPerformed

    }//GEN-LAST:event_nombreAulaActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        
        Statement sentencia;
        ResultSet resultado;
        String consulta;
        
        if (btnGuardar.getText().equals("Guardar")){
            
            try {

                PreparedStatement pps = Conexion.obtener().prepareStatement("INSERT INTO aulas (nombre) VALUES (?)");
                pps.setString(1, nombreAula.getText());
                pps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Datos guardados");

            } catch (Exception e) {

                System.err.println("Error: "+e);

            }

        }
        else
        {
            try {
                
                consulta = "UPDATE aulas SET nombre='"+nombreAula.getText()+"' WHERE id_aula='"+idAula+"'";
                
                sentencia = Conexion.obtener().createStatement();
                sentencia.executeUpdate(consulta);
                
                JOptionPane.showMessageDialog(null, "Modificado con exito");

            } catch (Exception e) {

                System.err.println("Error: "+e);

            }
        }
        
        this.dispose();
        
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void selectAulasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectAulasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_selectAulasActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        
        int resp = JOptionPane.showConfirmDialog(null, "Todo lo relacionado con esta aula sera eliminado, desea continuar?", "Confirmar eliminar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);            
        
        if (resp == 0){
        
            Statement sentencia;
            String consulta;

            consulta = "DELETE FROM asistencias WHERE (id_asignatura_a IN (SELECT id_asignatura FROM asignaturas WHERE id_aula='"+listAulas.get(selectAulas.getSelectedIndex())+"')) OR (id_asignatura_p IN (SELECT id_asignatura FROM asignaturas WHERE id_aula='"+listAulas.get(selectAulas.getSelectedIndex())+"'))"; 

            try {

                sentencia = Conexion.obtener().createStatement();
                sentencia.executeUpdate(consulta);

                consulta = "DELETE FROM asignaturas WHERE id_aula='"+listAulas.get(selectAulas.getSelectedIndex())+"'"; 
                sentencia.executeUpdate(consulta);

                consulta = "DELETE FROM aulas WHERE id_aula='"+listAulas.get(selectAulas.getSelectedIndex())+"'";
                sentencia.executeUpdate(consulta);

                listAulas.remove(selectAulas.getSelectedIndex());
                selectAulas.removeItemAt(selectAulas.getSelectedIndex());
                JOptionPane.showMessageDialog(null, "Eliminado con exito");

                if (selectAulas.getItemCount() <= 0){
                    btnEliminar.setEnabled(false);
                }

            } catch (ClassNotFoundException | SQLException e) {

                e.printStackTrace();

            }
        }
        
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        
        if (btnModificar.getText().equals("Modificar")){
        
            Modificar vm = new Modificar();
            vm.setVisible(true);
            vm.form(2);
            
        }
        else
        {
            this.dispose();
        }
        
    }//GEN-LAST:event_btnModificarActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            
            public void run() {
                
                new NuevaAula().setVisible(true);
                
            }
        });
    }
    
    // Metodo para cargar aulas en el combo box
    public void cargarAulas(){
        
        Statement sentencia;
        ResultSet resultado;
        String consulta;
        
        consulta = "SELECT * FROM aulas ORDER BY id_aula ASC";
        
        try {
            
            sentencia = Conexion.obtener().createStatement();
            resultado = sentencia.executeQuery(consulta);
            
            if(resultado.isBeforeFirst()) // Si la consulta trae algo
            {
                while(resultado.next()){

                    selectAulas.addItem(resultado.getString(2));
                    listAulas.add(resultado.getInt(1));

                }
            }
            else
            {
                btnEliminar.setEnabled(false); // Deshabilitar boton
            }
            
        } catch (ClassNotFoundException | SQLException e) {
                            
            e.printStackTrace();
                        
        }
        
    }   
    
    // Metodo para recibir la respuesta de Modificar.java
    public static void resp(int id, String nombre){
        
        idAula = id;
        nombreAula.setText(nombre); // Rellenar el input
        btnGuardar.setLabel("Modificar"); // Cambiar nombre del boton
        btnModificar.setLabel("Cancelar"); 
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminar;
    private static javax.swing.JButton btnGuardar;
    private static javax.swing.JButton btnModificar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel label_nombre;
    private static javax.swing.JTextField nombreAula;
    private javax.swing.JComboBox<String> selectAulas;
    // End of variables declaration//GEN-END:variables

}
