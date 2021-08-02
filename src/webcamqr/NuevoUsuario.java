package webcamqr;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class NuevoUsuario extends javax.swing.JFrame {
    
    private static int idUsuario;
    private String asignaturasA = "";
    private String asignaturasP = "";
    private int contA = 0,contP = 0;
    private ArrayList<Integer> listUsuarios = new ArrayList<Integer>();
    private ArrayList<Integer> listAsignaturas = new ArrayList<Integer>();

    public NuevoUsuario() {
        
        initComponents();
        cargarAsignaturas();
        cargarUsuarios();
        this.setResizable(false); // Deshabilitar maximizacion del jframe
        this.setLocationRelativeTo(null); // Centrar jframe
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        label_nombre = new javax.swing.JLabel();
        label_apellido = new javax.swing.JLabel();
        label_dni = new javax.swing.JLabel();
        usuNombre = new javax.swing.JTextField();
        usuApellido = new javax.swing.JTextField();
        usuDNI = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        id_asignaturaA = new javax.swing.JComboBox<>();
        btnCargarAsignaturaA = new javax.swing.JButton();
        labelAsigAlumno = new javax.swing.JLabel();
        labelAsigProfesor = new javax.swing.JLabel();
        id_asignaturaP = new javax.swing.JComboBox<>();
        btnCargarAsignaturaP = new javax.swing.JButton();
        label_nuevo = new javax.swing.JLabel();
        selectUsuarios = new javax.swing.JComboBox<>();
        btnEliminar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnModificar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Nuevo usuario");

        label_nombre.setText("Nombre:");

        label_apellido.setText("Apellido:");

        label_dni.setText("DNI:");

        usuDNI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usuDNIActionPerformed(evt);
            }
        });

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        id_asignaturaA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                id_asignaturaAActionPerformed(evt);
            }
        });

        btnCargarAsignaturaA.setText("Cargar seleccionado");
        btnCargarAsignaturaA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCargarAsignaturaAActionPerformed(evt);
            }
        });

        labelAsigAlumno.setText("Asignatura como alumno:");

        labelAsigProfesor.setText("Asignatura como profesor:");

        id_asignaturaP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                id_asignaturaPActionPerformed(evt);
            }
        });

        btnCargarAsignaturaP.setText("Cargar seleccionado");
        btnCargarAsignaturaP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCargarAsignaturaPActionPerformed(evt);
            }
        });

        label_nuevo.setText("Nuevo usuario");

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        jLabel1.setText("Eliminar usuario");

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(label_nuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(114, 114, 114))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(label_nombre)
                                    .addComponent(label_dni)
                                    .addComponent(label_apellido))
                                .addGap(23, 23, 23)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(usuApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(usuDNI, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(usuNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(btnEliminar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnModificar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnGuardar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(selectUsuarios, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnCargarAsignaturaP, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnCargarAsignaturaA, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(id_asignaturaP, javax.swing.GroupLayout.Alignment.TRAILING, 0, 184, Short.MAX_VALUE)
                                .addComponent(id_asignaturaA, javax.swing.GroupLayout.Alignment.TRAILING, 0, 184, Short.MAX_VALUE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(labelAsigProfesor, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelAsigAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(60, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label_nuevo)
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_nombre)
                    .addComponent(usuNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_apellido)
                    .addComponent(usuApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_dni)
                    .addComponent(usuDNI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelAsigAlumno)
                .addGap(4, 4, 4)
                .addComponent(id_asignaturaA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCargarAsignaturaA)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelAsigProfesor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(id_asignaturaP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCargarAsignaturaP)
                .addGap(18, 18, 18)
                .addComponent(btnGuardar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnModificar)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(selectUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnEliminar)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        
        Statement sentencia;
        String consulta;
        
        if (btnGuardar.getText().equals("Guardar")){
            
            try {

                PreparedStatement pps = Conexion.obtener().prepareStatement("INSERT INTO usuarios (nombre,apellido,dni,id_asignatura_a,id_asignatura_p) VALUES (?,?,?,?,?)");
                pps.setString(1, usuNombre.getText());
                pps.setString(2, usuApellido.getText());
                pps.setString(3, usuDNI.getText());

                if(asignaturasA == "")
                    pps.setString(4, null);
                else
                    pps.setString(4, asignaturasA);
                if(asignaturasP == "")
                    pps.setString(5, null);
                else
                    pps.setString(5, asignaturasP);

                pps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Datos guardados");

            }catch (Exception e){

                System.err.println("Error: "+e);

            }   
        }
        else
        {
            try {
               
                if(asignaturasA == "")
                    asignaturasA = "null";
                else
                    asignaturasA = "'"+asignaturasA+"'";

  
                if(asignaturasP == "")
                    asignaturasP = "null";
                else
                    asignaturasP = "'"+asignaturasP+"'";
                
                consulta = "UPDATE usuarios SET dni='"+usuDNI.getText()+"',nombre='"+usuNombre.getText()+"',apellido='"+usuApellido.getText()+"',id_asignatura_a="+asignaturasA+",id_asignatura_p="+asignaturasP+" WHERE id_usuario='"+idUsuario+"'";
                
                sentencia = Conexion.obtener().createStatement();
                sentencia.executeUpdate(consulta);
                
                JOptionPane.showMessageDialog(null, "Modificado con exito");

            } catch (Exception e) {

                System.err.println("Error: "+e);

            }
        }
        
        this.dispose();
        
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void usuDNIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usuDNIActionPerformed

    }//GEN-LAST:event_usuDNIActionPerformed

    private void id_asignaturaAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_id_asignaturaAActionPerformed

    }//GEN-LAST:event_id_asignaturaAActionPerformed

    private void btnCargarAsignaturaAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCargarAsignaturaAActionPerformed
       
        String item;
        
        contA++;
        
        item = String.valueOf(listAsignaturas.get(id_asignaturaA.getSelectedIndex()));
        labelAsigAlumno.setText("Asignatura como alumno: "+contA);
        
        if(this.asignaturasA == "")
            this.asignaturasA += item;
        else
            this.asignaturasA += "," + item;
        
    }//GEN-LAST:event_btnCargarAsignaturaAActionPerformed

    private void id_asignaturaPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_id_asignaturaPActionPerformed

    }//GEN-LAST:event_id_asignaturaPActionPerformed

    private void btnCargarAsignaturaPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCargarAsignaturaPActionPerformed
       
        String item;
        
        contP++;
        
        item = String.valueOf(listAsignaturas.get(id_asignaturaP.getSelectedIndex()));
        labelAsigProfesor.setText("Asignatura como profesor: "+contP);
        
        if(this.asignaturasP == "")
            this.asignaturasP += item;
        else
            this.asignaturasP += "," + item;
        
    }//GEN-LAST:event_btnCargarAsignaturaPActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed

        int resp = JOptionPane.showConfirmDialog(null, "Todo lo relacionado con este usuario sera eliminado, desea continuar?", "Confirmar eliminar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);            
        
        if (resp == 0){
            
            Statement sentencia;
            String consulta;

            consulta = "DELETE FROM asistencias WHERE id_usuario='"+listUsuarios.get(selectUsuarios.getSelectedIndex())+"'";

            try {

                sentencia = Conexion.obtener().createStatement();
                sentencia.executeUpdate(consulta);

                consulta = "DELETE FROM usuarios WHERE id_usuario='"+listUsuarios.get(selectUsuarios.getSelectedIndex())+"'";
                sentencia.executeUpdate(consulta);

                listUsuarios.remove(selectUsuarios.getSelectedIndex());
                selectUsuarios.removeItemAt(selectUsuarios.getSelectedIndex());

                JOptionPane.showMessageDialog(null, "Eliminado con exito");

                if (selectUsuarios.getItemCount() <= 0){
                    btnEliminar.setEnabled(false);
                }

            } catch (ClassNotFoundException | SQLException e) {

                e.printStackTrace();

            }

        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        Modificar vm = new Modificar();
        vm.setVisible(true);
        vm.form(3);
    }//GEN-LAST:event_btnModificarActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                new NuevoUsuario().setVisible(true);
                
            }
        });
        
    }
    
    // Metodo para cargar asignaturas en el combo box
    public void cargarAsignaturas(){
        
        Statement sentencia;
        ResultSet resultado;
        String consulta;
        
        consulta = "SELECT id_asignatura,nombre FROM asignaturas ORDER BY id_asignatura ASC";
        
        try {
            
            sentencia = Conexion.obtener().createStatement();
            resultado = sentencia.executeQuery(consulta);

            while(resultado.next()){

                id_asignaturaA.addItem(resultado.getString(2));
                id_asignaturaP.addItem(resultado.getString(2));
                listAsignaturas.add(resultado.getInt(1));

            }
            
        } catch (ClassNotFoundException | SQLException e) {
                            
            e.printStackTrace();
                        
        }
        
    }   
    
    // Metodo para cargar usuarios en el combo box
    public void cargarUsuarios(){
        
        Statement sentencia;
        ResultSet resultado;
        String consulta;
        
        consulta = "SELECT id_usuario,dni FROM usuarios ORDER BY id_usuario ASC";
        
        try {
            
            sentencia = Conexion.obtener().createStatement();
            resultado = sentencia.executeQuery(consulta);
            
            if(resultado.isBeforeFirst())
            {
                while(resultado.next()){

                    selectUsuarios.addItem(resultado.getString(2));
                    listUsuarios.add(resultado.getInt(1));


                }
            }
            else
            {
                btnEliminar.setEnabled(false);
            }
            
        } catch (ClassNotFoundException | SQLException e) {
                            
            e.printStackTrace();
                        
        }
        
    }   
    
    // Metodo para recibir respuesta de Modificar.java
    public static void resp(int id, String dni,String nombre,String apellido){
        
        idUsuario = id;
        usuDNI.setText(dni);
        usuNombre.setText(nombre);
        usuApellido.setText(apellido);
        btnGuardar.setLabel("Modificar");
        btnModificar.hide();
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCargarAsignaturaA;
    private javax.swing.JButton btnCargarAsignaturaP;
    private javax.swing.JButton btnEliminar;
    private static javax.swing.JButton btnGuardar;
    private static javax.swing.JButton btnModificar;
    private javax.swing.JComboBox<String> id_asignaturaA;
    private javax.swing.JComboBox<String> id_asignaturaP;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel labelAsigAlumno;
    private javax.swing.JLabel labelAsigProfesor;
    private javax.swing.JLabel label_apellido;
    private javax.swing.JLabel label_dni;
    private javax.swing.JLabel label_nombre;
    private javax.swing.JLabel label_nuevo;
    private javax.swing.JComboBox<String> selectUsuarios;
    private static javax.swing.JTextField usuApellido;
    private static javax.swing.JTextField usuDNI;
    private static javax.swing.JTextField usuNombre;
    // End of variables declaration//GEN-END:variables

}
