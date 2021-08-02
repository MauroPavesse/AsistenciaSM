package webcamqr;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.sql.Time;
import java.util.ArrayList;
import java.util.stream.Stream;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;

public class NuevaAsignatura extends javax.swing.JFrame {
    
    private ArrayList<Integer> listAsignaturas = new ArrayList<Integer>();
    private ArrayList<Integer> listAulas = new ArrayList<Integer>();
    private static int idAsignatura;

    public NuevaAsignatura() {
        
        initComponents();
        cargarAulas();
        cargarAsignaturas();
        this.setResizable(false); // Deshabilitar maximizacion del jframe
        this.setLocationRelativeTo(null); // Centrar jframe
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        label_nombre = new javax.swing.JLabel();
        label_dia = new javax.swing.JLabel();
        label_horaInicio = new javax.swing.JLabel();
        label_horaFin = new javax.swing.JLabel();
        horaIni = new javax.swing.JTextField();
        horaFin = new javax.swing.JTextField();
        nomAsig = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        label_aula = new javax.swing.JLabel();
        aulaSelect = new javax.swing.JComboBox<>();
        lunes = new javax.swing.JCheckBox();
        martes = new javax.swing.JCheckBox();
        miercoles = new javax.swing.JCheckBox();
        jueves = new javax.swing.JCheckBox();
        viernes = new javax.swing.JCheckBox();
        sabado = new javax.swing.JCheckBox();
        label_cargar = new javax.swing.JLabel();
        selectAsignaturas = new javax.swing.JComboBox<>();
        btnEliminar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnModificar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Nueva asignatura");

        label_nombre.setText("Nombre:");

        label_dia.setText("Día/s:");

        label_horaInicio.setText("Hora inicio:");

        label_horaFin.setText("Hora fin:");

        horaIni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                horaIniActionPerformed(evt);
            }
        });

        horaFin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                horaFinActionPerformed(evt);
            }
        });

        nomAsig.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomAsigActionPerformed(evt);
            }
        });

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        label_aula.setText("Aula:");

        aulaSelect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aulaSelectActionPerformed(evt);
            }
        });

        lunes.setText("Lunes");
        lunes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lunesActionPerformed(evt);
            }
        });

        martes.setText("Martes");
        martes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                martesActionPerformed(evt);
            }
        });

        miercoles.setText("Miércoles");
        miercoles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miercolesActionPerformed(evt);
            }
        });

        jueves.setText("Jueves");
        jueves.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                juevesActionPerformed(evt);
            }
        });

        viernes.setText("Viernes");
        viernes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viernesActionPerformed(evt);
            }
        });

        sabado.setText("Sábado");
        sabado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sabadoActionPerformed(evt);
            }
        });

        label_cargar.setText("Nueva asignatura");

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        jLabel1.setText("Eliminar asignatura");

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
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label_aula)
                            .addComponent(label_nombre)
                            .addComponent(label_dia))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jueves)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(viernes)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(sabado))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lunes)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(martes)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(miercoles))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(label_cargar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(aulaSelect, javax.swing.GroupLayout.Alignment.LEADING, 0, 130, Short.MAX_VALUE)
                                        .addComponent(nomAsig, javax.swing.GroupLayout.Alignment.LEADING))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label_horaInicio)
                            .addComponent(label_horaFin))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnModificar, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(btnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                                .addComponent(btnGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(horaIni)
                                .addComponent(horaFin)
                                .addComponent(selectAsignaturas, 0, 130, Short.MAX_VALUE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(label_cargar)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_nombre)
                    .addComponent(nomAsig, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_aula)
                    .addComponent(aulaSelect, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_dia)
                    .addComponent(lunes)
                    .addComponent(martes)
                    .addComponent(miercoles))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jueves)
                    .addComponent(viernes)
                    .addComponent(sabado))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_horaInicio)
                    .addComponent(horaIni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_horaFin)
                    .addComponent(horaFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnGuardar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnModificar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(selectAsignaturas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnEliminar)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void horaIniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_horaIniActionPerformed

    }//GEN-LAST:event_horaIniActionPerformed

    private void horaFinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_horaFinActionPerformed
   
    }//GEN-LAST:event_horaFinActionPerformed

    private void nomAsigActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomAsigActionPerformed

    }//GEN-LAST:event_nomAsigActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        
        Statement sentencia;
        String consulta;
        
        if (btnGuardar.getText().equals("Guardar")){
            
            try {

                PreparedStatement pps = Conexion.obtener().prepareStatement("INSERT INTO asignaturas (id_aula,nombre,dias,hora_inicio,hora_fin) VALUES (?,?,?,?,?)");
                String item;
                
                item = String.valueOf(listAulas.get(aulaSelect.getSelectedIndex()));
                pps.setString(1, item);
                pps.setString(2, nomAsig.getText());
                pps.setString(3, verificarDias());
                Time fecha = null;
                Time hora = fecha.valueOf(horaIni.getText());
                pps.setTime(4, hora);
                hora = fecha.valueOf(horaFin.getText());
                pps.setTime(5, hora);
                pps.executeUpdate();
                
                JOptionPane.showMessageDialog(null, "Datos guardados");

            } catch (Exception e) {

                System.err.print(e);

            }

        }
        else
        {
             try {
                
                consulta = "UPDATE asignaturas SET nombre='"+nomAsig.getText()+"',id_aula='"+listAulas.get(aulaSelect.getSelectedIndex())+"',dias='"+verificarDias()+"',hora_inicio='"+horaIni.getText()+"',hora_fin='"+horaFin.getText()+"' WHERE id_asignatura='"+idAsignatura+"'";
                
                sentencia = Conexion.obtener().createStatement();
                sentencia.executeUpdate(consulta);
                
                JOptionPane.showMessageDialog(null, "Modificado con exito");

            } catch (Exception e) {

                System.err.println("Error: "+e);

            }
        }
        this.dispose();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private String verificarDias(){
        
        String dias = "";
        JCheckBox [] cadena = {lunes, martes, miercoles, jueves, viernes, sabado};
        
        for(int i = 0; i<cadena.length; i++){
            
            if(cadena[i].isSelected()){
                
                if(dias == "")
                    dias = String.valueOf(i+1);
                else
                    dias += ","+String.valueOf(i+1);
                
            }
            
        }
        
        return dias;
        
    }
    
    private void martesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_martesActionPerformed
 
    }//GEN-LAST:event_martesActionPerformed

    private void miercolesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miercolesActionPerformed
    
    }//GEN-LAST:event_miercolesActionPerformed

    private void juevesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_juevesActionPerformed
 
    }//GEN-LAST:event_juevesActionPerformed

    private void viernesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viernesActionPerformed
   
    }//GEN-LAST:event_viernesActionPerformed

    private void sabadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sabadoActionPerformed

    }//GEN-LAST:event_sabadoActionPerformed

    private void lunesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lunesActionPerformed
 
    }//GEN-LAST:event_lunesActionPerformed

    private void aulaSelectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aulaSelectActionPerformed

    }//GEN-LAST:event_aulaSelectActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        
        Statement sentencia;
        String consulta;
 
        consulta = "DELETE FROM asignaturas WHERE id_asignatura='"+listAsignaturas.get(selectAsignaturas.getSelectedIndex())+"'";
        
        try {
            
            sentencia = Conexion.obtener().createStatement();
            sentencia.executeUpdate(consulta);
            
            listAsignaturas.remove(selectAsignaturas.getSelectedIndex());
            selectAsignaturas.removeItemAt(selectAsignaturas.getSelectedIndex());
            
            JOptionPane.showMessageDialog(null, "Eliminado con exito");
            
            if (selectAsignaturas.getItemCount() <= 0){ // Si no existe nada mas en el combo box, deshabilitamos el boton Eliminar
                btnEliminar.setEnabled(false);
            }
            
        } catch (ClassNotFoundException | SQLException e) {
                            
            e.printStackTrace();
                        
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        Modificar vm = new Modificar();
        vm.setVisible(true);
        vm.form(1);
    }//GEN-LAST:event_btnModificarActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                new NuevaAsignatura().setVisible(true);
                
            }
        });
        
    }
    
    // Cargar aulas en el combo box
    public void cargarAulas(){
        
        Statement sentencia;
        ResultSet resultado;
        String consulta;
        
        consulta = "SELECT * FROM aulas ORDER BY id_aula ASC";
        
        try {
            
            sentencia = Conexion.obtener().createStatement();
            resultado = sentencia.executeQuery(consulta);
            
            if(resultado.isBeforeFirst()) // Si existen registros
            {       
                while(resultado.next()){

                    aulaSelect.addItem(resultado.getString(2));
                    listAulas.add(resultado.getInt(1));

                }      
            }
            else
            {
                btnGuardar.setEnabled(false);
            }
        } catch (ClassNotFoundException | SQLException e) {
                            
            e.printStackTrace();
                        
        }
        
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
            
            if(resultado.isBeforeFirst())
            {
                while(resultado.next()){

                    selectAsignaturas.addItem(resultado.getString(2));
                    listAsignaturas.add(resultado.getInt(1));

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
    public static void resp(int id, String nombre,String aula,String dias,String horaI,String horaF){
        
        idAsignatura = id;
        nomAsig.setText(nombre); // Rellenar el input
        aulaSelect.setSelectedItem(aula); // Setear el select en la posicion dada

        int[] d = Stream.of(dias.split(",")).mapToInt(Integer::parseInt).toArray(); // Convertir string a array de enteros
 
        for (int i = 0; i < d.length; i++) {
            
            switch(d[i]){
                case 1: lunes.setSelected(true); break; 
                case 2: martes.setSelected(true); break; 
                case 3: miercoles.setSelected(true); break; 
                case 4: jueves.setSelected(true); break; 
                case 5: viernes.setSelected(true); break; 
                case 6: sabado.setSelected(true); break;  
            }
            
        }
            
        horaIni.setText(horaI);
        horaFin.setText(horaF);
        btnGuardar.setLabel("Modificar");
        btnModificar.hide();
        
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static javax.swing.JComboBox<String> aulaSelect;
    private javax.swing.JButton btnEliminar;
    private static javax.swing.JButton btnGuardar;
    private static javax.swing.JButton btnModificar;
    private static javax.swing.JTextField horaFin;
    private static javax.swing.JTextField horaIni;
    private javax.swing.JLabel jLabel1;
    private static javax.swing.JCheckBox jueves;
    private javax.swing.JLabel label_aula;
    private javax.swing.JLabel label_cargar;
    private javax.swing.JLabel label_dia;
    private javax.swing.JLabel label_horaFin;
    private javax.swing.JLabel label_horaInicio;
    private javax.swing.JLabel label_nombre;
    private static javax.swing.JCheckBox lunes;
    private static javax.swing.JCheckBox martes;
    private static javax.swing.JCheckBox miercoles;
    private static javax.swing.JTextField nomAsig;
    private static javax.swing.JCheckBox sabado;
    private javax.swing.JComboBox<String> selectAsignaturas;
    private static javax.swing.JCheckBox viernes;
    // End of variables declaration//GEN-END:variables

}
