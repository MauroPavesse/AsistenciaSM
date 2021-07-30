package webcamqr;

import javax.swing.table.DefaultTableModel;

import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Admin extends javax.swing.JFrame implements Runnable{
    
    private Thread hilo = new Thread(this);
    
    public Admin() {
        
        initComponents();
        hilo.start();
        this.setResizable(false); // Deshabilitar maximizacion del jframe
        this.setLocationRelativeTo(null); // Centrar jframe
       }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelAdmin = new javax.swing.JLabel();
        Scroll_tabla = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        label_tabla = new javax.swing.JLabel();
        btn_usuario = new javax.swing.JButton();
        btn_aula = new javax.swing.JButton();
        btn_asignatura = new javax.swing.JButton();
        btn_cerrarsesion = new javax.swing.JButton();
        btn_asistencias = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Admin");

        labelAdmin.setText("No data");

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Usuario", "Asignatura", "Hora"
            }
        ));
        Scroll_tabla.setViewportView(tabla);

        label_tabla.setText("Presentes de hoy");

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

        btn_asistencias.setText("Asistencias");
        btn_asistencias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_asistenciasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(labelAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_cerrarsesion))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btn_usuario)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_asignatura))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Scroll_tabla, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_asistencias, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(label_tabla, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btn_aula)
                        .addGap(178, 178, 178))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelAdmin)
                    .addComponent(btn_cerrarsesion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_usuario)
                    .addComponent(btn_aula)
                    .addComponent(btn_asignatura))
                .addGap(20, 20, 20)
                .addComponent(label_tabla)
                .addGap(18, 18, 18)
                .addComponent(Scroll_tabla, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(btn_asistencias)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_usuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_usuarioActionPerformed
        new NuevoUsuario().setVisible(true);
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

    private void btn_asistenciasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_asistenciasActionPerformed
        new Asistencias().setVisible(true);
    }//GEN-LAST:event_btn_asistenciasActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(()-> {

                new Admin().setVisible(true);

        });
    }
    
    // Metodo para llenar la tabla
    public void tabla (){

        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        modelo.setRowCount(0); // Limpiar tabla

        Statement sentencia;
        ResultSet resultado;
        String consulta;
        // Se crea un array que será una de las filas de la tabla.
        Object [] fila = new Object[3]; // Hay tres columnas en la tabla

        fila[0] = "";
        fila[1] = "ALUMNOS";
        fila[2] = "";
        modelo.addRow(fila);

        consulta = "SELECT usuarios.nombre,asignaturas.nombre,TIME(asistencias.fecha) as 'time'  FROM asistencias,usuarios,asignaturas WHERE ((usuarios.id_usuario=asistencias.id_usuario) AND (asignaturas.id_asignatura=asistencias.id_asignatura_a) AND (DATE(asistencias.fecha)=CURDATE())) ORDER BY time DESC";

        try {

            sentencia = Conexion.obtener().createStatement();
            resultado = sentencia.executeQuery(consulta);

            // Bucle para cada resultado en la consulta
            while (resultado.next())
            {
               // Se rellena cada posición del array con una de las columnas de la tabla en base de datos.
               for (int i=0;i<3;i++)
                  fila[i] = resultado.getObject(i+1); // El primer indice en resultado es el 1, no el cero, por eso se suma 1.

               // Se añade al modelo la fila completa.
               modelo.addRow(fila);

            }

            fila[0] = "";
            fila[1] = "PROFESORES";
            fila[2] = "";
            modelo.addRow(fila);

            consulta = "SELECT usuarios.nombre,asignaturas.nombre,TIME(asistencias.fecha) as 'time' FROM asistencias,usuarios,asignaturas WHERE ((usuarios.id_usuario=asistencias.id_usuario) AND (asignaturas.id_asignatura=asistencias.id_asignatura_p) AND (DATE(asistencias.fecha)=CURDATE())) ORDER BY time DESC";
            resultado = sentencia.executeQuery(consulta);

            // Bucle para cada resultado en la consulta
            while (resultado.next())
            {

               // Se rellena cada posición del array con una de las columnas de la tabla en base de datos.
               for (int i=0;i<3;i++)
                  fila[i] = resultado.getObject(i+1); // El primer indice en resultado es el 1, no el cero, por eso se suma 1.

               // Se añade al modelo la fila completa.
               modelo.addRow(fila);

            }

            fila[0] = "";
            fila[1] = "PERSONAL";
            fila[2] = "";
            modelo.addRow(fila);

            consulta = "SELECT usuarios.nombre,TIME(asistencias.fecha) as 'time' FROM asistencias,usuarios WHERE ((usuarios.id_usuario=asistencias.id_usuario) AND (asistencias.id_asignatura_a IS NULL) AND (asistencias.id_asignatura_p IS NULL) AND (DATE(asistencias.fecha)=CURDATE())) ORDER BY time DESC";
            resultado = sentencia.executeQuery(consulta);

            // Bucle para cada resultado en la consulta
            while (resultado.next())
            {
               fila[0] = resultado.getObject(1);
               fila[1] = "-";
               fila[2] = resultado.getObject(2);
               // Se añade al modelo la fila completa.
               modelo.addRow(fila);

            }
            
        }catch (ClassNotFoundException | SQLException e) {

            e.printStackTrace();

        }
        
    }
    
    // Metodo para obtener el nombre del administrador brindada por la ventana anterior
    public void nombreAdmin(String admin){
        
        labelAdmin.setText("Administrador: "+admin);
        
    }
    
    public void stopThread(){
        hilo.stop();
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane Scroll_tabla;
    private javax.swing.JButton btn_asignatura;
    private javax.swing.JButton btn_asistencias;
    private javax.swing.JButton btn_aula;
    private javax.swing.JButton btn_cerrarsesion;
    private javax.swing.JButton btn_usuario;
    private javax.swing.JLabel labelAdmin;
    private javax.swing.JLabel label_tabla;
    private javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables
    
    @Override
    public void run() {

        while(true){

            try {
                 
                hilo.sleep(5000);  // Retrasar lectura codigo QR por 5 segundos en cada iteracion
                
            } catch (InterruptedException e) {
                
                e.printStackTrace();
                
            }
            
            tabla();
            
         }
        
    }
    
}
