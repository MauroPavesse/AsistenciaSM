package webcamqr;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.table.DefaultTableModel;

public class Asistencias extends javax.swing.JFrame {
    
    private int idAsignatura = 0;
    
    public Asistencias() {
        
        initComponents();
        cargarAsignaturas();
        this.setResizable(false); // Deshabilitar maximizacion del jframe
        this.setLocationRelativeTo(null); // Centrar jframe
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ScrollInasistencias = new javax.swing.JScrollPane();
        tablaIna = new javax.swing.JTable();
        selectAsignaturas = new javax.swing.JComboBox<>();
        hora = new javax.swing.JLabel();
        selectFechas = new javax.swing.JComboBox<>();
        ScrollAsistencias = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        labelAsistencias = new javax.swing.JLabel();
        labelInasistencias = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Asistencias");

        tablaIna.setBackground(java.awt.Color.orange);
        tablaIna.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Usuario"
            }
        ));
        ScrollInasistencias.setViewportView(tablaIna);

        selectAsignaturas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectAsignaturasActionPerformed(evt);
            }
        });

        hora.setText("Hora de asignatura:");

        selectFechas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectFechasActionPerformed(evt);
            }
        });

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Usuario", "Fecha"
            }
        ));
        ScrollAsistencias.setViewportView(tabla);

        labelAsistencias.setText("Asistencias");

        labelInasistencias.setText("Inasistencias");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(38, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(selectAsignaturas, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(selectFechas, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(44, 44, 44))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(labelAsistencias, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(labelInasistencias, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE))
                                .addGap(108, 108, 108))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(ScrollInasistencias, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(100, 100, 100))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(hora, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44))))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ScrollAsistencias, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(hora)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(selectAsignaturas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(selectFechas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelAsistencias)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 115, Short.MAX_VALUE)
                .addComponent(labelInasistencias)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ScrollInasistencias, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(88, 88, 88)
                    .addComponent(ScrollAsistencias, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(141, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void selectAsignaturasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectAsignaturasActionPerformed
        
        Statement sentencia;
        ResultSet resultado;
        String consulta;
        
        consulta = "SELECT id_asignatura,hora_inicio,hora_fin FROM asignaturas WHERE nombre='"+selectAsignaturas.getSelectedItem()+"'";
        
        try {
            
            sentencia = Conexion.obtener().createStatement();
            resultado = sentencia.executeQuery(consulta);
      
            if (resultado.next()){
                
                idAsignatura = resultado.getInt(1);
                cargarFechas();
                hora.setText("Hora de asignatura: "+resultado.getString(2)+" - "+resultado.getString(3));
                
            }
            
        } catch (ClassNotFoundException | SQLException e) {
                            
            e.printStackTrace();
                        
        }
        
    }//GEN-LAST:event_selectAsignaturasActionPerformed

    private void selectFechasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectFechasActionPerformed

        tabla(selectFechas.getSelectedItem()); 
            
    }//GEN-LAST:event_selectFechasActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            
            public void run() {
                
                new Asistencias().setVisible(true);
                
            }
        });
        
    }
    
    // Metodo para llenar la tabla
    public void tabla (Object fecha){
        
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        DefaultTableModel modelo2 = (DefaultTableModel) tablaIna.getModel();

        modelo.setRowCount(0); // Limpiar tabla asistencias
        modelo2.setRowCount(0); // Limpiar tabla inasistencias
        labelAsistencias.setText("Asistencias 0");
        labelInasistencias.setText("Inasistencias 0");
        
        if (fecha != null){

            Statement sentencia;
            ResultSet resultado;
            String consulta;
            
            //Tabla asistencias 
            
            consulta = "SELECT usuarios.apellido,asistencias.fecha FROM usuarios,asistencias WHERE ((usuarios.id_usuario=asistencias.id_usuario) AND (asistencias.id_asignatura_a="+idAsignatura+") AND (DATE(asistencias.fecha)='"+fecha+"'))";

            try {
                
                // Se crea un array que será una de las filas de la tabla.
                Object [] fila = new Object[2]; // Hay tres columnas en la tabla
                
                sentencia = Conexion.obtener().createStatement();
                resultado = sentencia.executeQuery(consulta);
                
                int cont = 0;
                // Bucle para cada resultado en la consulta
                while (resultado.next())
                {  
                   // Se rellena cada posición del array con una de las columnas de la tabla en base de datos.
                   for (int i=0;i<2;i++)
                      fila[i] = resultado.getString(i+1); // El primer indice en resultado es el 1, no el cero, por eso se suma 1.

                   // Se añade al modelo la fila completa.
                   modelo.addRow(fila);
                   cont++;

                }
                labelAsistencias.setText("Asistencias "+cont);
                
                // Tabla inasistencias
                
                consulta = "SELECT usuarios.apellido FROM usuarios WHERE NOT EXISTS (SELECT * FROM asistencias WHERE (usuarios.id_usuario=asistencias.id_usuario) AND (asistencias.id_asignatura_a="+idAsignatura+") AND (DATE(asistencias.fecha)='"+fecha+"')) AND FIND_IN_SET("+idAsignatura+",usuarios.id_asignatura_a)";
                resultado = sentencia.executeQuery(consulta);
                
                cont = 0;
                // Bucle para cada resultado en la consulta
                while (resultado.next())
                {
                    // Se rellena cada posición del array con una de las columnas de la tabla en base de datos.
                    fila[0] = resultado.getString(1); // El primer indice en resultado es el 1, no el cero, por eso se suma 1.
                    fila[1] = "-";
                    // Se añade al modelo la fila completa.
                    modelo2.addRow(fila);

                }
                labelInasistencias.setText("Inasistencias "+cont);
                
            }catch (ClassNotFoundException | SQLException e) {

                e.printStackTrace();

            }
            
        }
        
    }
    
    // Metodo para cargar las aulas en el combo box
    public void cargarAsignaturas(){
        
        Statement sentencia;
        ResultSet resultado;
        String consulta;
        
        consulta = "SELECT nombre FROM asignaturas ORDER BY id_asignatura ASC";
        
        try {
            
            sentencia = Conexion.obtener().createStatement();
            resultado = sentencia.executeQuery(consulta);

            while(resultado.next()){
                
                selectAsignaturas.addItem(resultado.getString(1));
                
            }
            
        } catch (ClassNotFoundException | SQLException e) {
                            
            e.printStackTrace();
                        
        }
        
    }

    // Metodo para cargar las aulas en el combo box
    public void cargarFechas(){
        
        Statement sentencia;
        ResultSet resultado;
        String consulta;
        
        selectFechas.removeAllItems(); // Limpiar combobox de fechas
        
        consulta = "SELECT DATE_FORMAT(fecha,'%Y-%m-%d') AS 'date' FROM asistencias WHERE id_asignatura_a='"+idAsignatura+"' GROUP BY date ORDER BY fecha DESC";
        
        try {
            
            sentencia = Conexion.obtener().createStatement();
            resultado = sentencia.executeQuery(consulta);

            while(resultado.next()){
                
               selectFechas.addItem(resultado.getString(1));
               
            }
        } catch (ClassNotFoundException | SQLException e) {
                            
            e.printStackTrace();
                        
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane ScrollAsistencias;
    private javax.swing.JScrollPane ScrollInasistencias;
    private javax.swing.JLabel hora;
    private javax.swing.JLabel labelAsistencias;
    private javax.swing.JLabel labelInasistencias;
    private javax.swing.JComboBox<String> selectAsignaturas;
    private javax.swing.JComboBox<String> selectFechas;
    private javax.swing.JTable tabla;
    private javax.swing.JTable tablaIna;
    // End of variables declaration//GEN-END:variables

}
