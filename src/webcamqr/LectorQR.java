package webcamqr;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import com.github.sarxos.webcam.WebcamResolution;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import java.awt.Dimension;
import java.awt.image.BufferedImage;

import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;

public class LectorQR extends javax.swing.JFrame implements Runnable{

        private static int idAula = 0;
	private Thread hilo = new Thread(this);
	private Webcam webcam = null;
	private WebcamPanel panel = null;

    public LectorQR() {
        
        initComponents();
        this.setResizable(false); // Deshabilitar maximizacion del jframe
        this.setLocationRelativeTo(null); // Centrar jframe
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelQR = new javax.swing.JPanel();
        btnIniciar = new javax.swing.JButton();
        textoQR = new javax.swing.JTextField();
        codig_qr = new javax.swing.JLabel();
        btnConfig = new javax.swing.JButton();
        label_cabecera = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Lector QR");
        setIconImage(getIconImage());
        setResizable(false);

        panelQR.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        javax.swing.GroupLayout panelQRLayout = new javax.swing.GroupLayout(panelQR);
        panelQR.setLayout(panelQRLayout);
        panelQRLayout.setHorizontalGroup(
            panelQRLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panelQRLayout.setVerticalGroup(
            panelQRLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 344, Short.MAX_VALUE)
        );

        btnIniciar.setText("Iniciar");
        btnIniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarActionPerformed(evt);
            }
        });

        textoQR.setEnabled(false);

        codig_qr.setText("Mensaje");

        btnConfig.setText("Configuracion");
        btnConfig.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfigActionPerformed(evt);
            }
        });

        label_cabecera.setText("Acerca el QR a la camara");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panelQR, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(6, 6, 6)
                                    .addComponent(codig_qr)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(textoQR, javax.swing.GroupLayout.PREFERRED_SIZE, 419, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(btnIniciar)
                                    .addGap(316, 316, 316)
                                    .addComponent(btnConfig)))
                            .addContainerGap())
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(label_cabecera, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(154, 154, 154)))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(label_cabecera)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelQR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textoQR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(codig_qr))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnIniciar)
                    .addComponent(btnConfig))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnIniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarActionPerformed

        if (idAula != 0){ // Condicional para saber si se ha configurado el aula, en ese caso se inicia la webcam 
            
            Dimension size = WebcamResolution.QVGA.getSize();     
            webcam = Webcam.getWebcams().get(0);
            webcam.setViewSize(size);

            panel = new WebcamPanel(webcam);
            panel.setPreferredSize(size);
            panel.setFPSDisplayed(true);
            
            javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(panelQR);
            panelQR.setLayout(jPanel1Layout);
            
            jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, 476, Short.MAX_VALUE)
            );
            jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, 344, Short.MAX_VALUE)
            );    
            hilo.start();
            btnIniciar.setEnabled(false);
        }
        else{
            
            JOptionPane.showMessageDialog(null, "Debe configurar un aula para continuar!");
            
        }
        				
    }//GEN-LAST:event_btnIniciarActionPerformed

    private void btnConfigActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfigActionPerformed
       
        new Aula().setVisible(true);
        
    }//GEN-LAST:event_btnConfigActionPerformed
    
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(() -> {
            
            new LectorQR().setVisible(true);
            
        });
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConfig;
    private javax.swing.JButton btnIniciar;
    private javax.swing.JLabel codig_qr;
    private javax.swing.JLabel label_cabecera;
    private javax.swing.JPanel panelQR;
    private javax.swing.JTextField textoQR;
    // End of variables declaration//GEN-END:variables

    @Override
    public void run() {
       
	do {
            
            try {
                
                hilo.sleep(2000);  // Retrasar lectura codigo QR por 2 segundos en cada iteracion 
                
            } catch (InterruptedException e) {
                            
                e.printStackTrace();
			
            }
	
            Result result = null;	
            BufferedImage image = null;
                        
            if (webcam.isOpen()) {
                         
                if ((image = webcam.getImage()) == null) {
                                
                    continue;
                            
                }
                                      
                LuminanceSource source = new BufferedImageLuminanceSource(image);        
                BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));
                            
                try {
                                
                    result = new MultiFormatReader().decode(bitmap);
                            
                } catch (NotFoundException e) {
				
                    // fall thru, it means there is no QR code in image
                            
                }
			
            }
                        
            if (result != null) { //Si se leyo un codigo QR
                                
                verificarPresente(result);    
			
            }
            else{
                           
                textoQR.setText("Esperando..");
                        
            }
	
        } while (true); // Bucle infinito
	
    }
   
    // Metodo para verificar las condiciones necesarias para el presente
    public void verificarPresente(Result result){
        
        String dateTime = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(LocalDateTime.now()); // Obtener fecha y hora actual
        String hora = dateTime.substring(dateTime.indexOf(" ")); // Obtener hora actual
        String dia = DateTimeFormatter.ofPattern("e").format(LocalDateTime.now()); // Obtener dia actual en formato de numeros

        String apellido,consulta,id_asignatura_a, id_asignatura_p,id_usuario;                           
        Statement sentencia;
        ResultSet resultado;
        id_usuario = result.getText();
                            
        consulta = "SELECT apellido,id_asignatura_a,id_asignatura_p FROM usuarios WHERE id_usuario='"+id_usuario+"'";

        try {

            sentencia = Conexion.obtener().createStatement();
            resultado = sentencia.executeQuery(consulta);

            if (resultado.next()){

                apellido = resultado.getString(1);
                id_asignatura_a = resultado.getString(2);
                id_asignatura_p = resultado.getString(3);

                if (id_asignatura_a != null || id_asignatura_p != null){

                    consulta = "SELECT id_asignatura FROM asignaturas WHERE ((id_aula='"+idAula+"') AND (FIND_IN_SET(id_asignatura,'"+id_asignatura_a+"')) AND (FIND_IN_SET("+dia+",dias)) AND ('"+hora+"' BETWEEN hora_inicio AND hora_fin))";
                    resultado = sentencia.executeQuery(consulta);

                    if (resultado.next()){ // Es un alumno
                            
                        id_asignatura_a = "'"+resultado.getString(1)+"'";
                        id_asignatura_p = "null";

                        consulta = "SELECT asistencias.id_asistencia FROM asistencias,asignaturas WHERE ((asignaturas.id_asignatura=asistencias.id_asignatura_a) AND (asistencias.id_asignatura_a="+id_asignatura_a+") AND (asistencias.id_usuario='"+id_usuario+"') AND (DATE(asistencias.fecha)=CURDATE())AND (DATE_FORMAT(asistencias.fecha,'%H:%i') BETWEEN asignaturas.hora_inicio AND asignaturas.hora_fin))";
                        resultado = sentencia.executeQuery(consulta);

                        if (resultado.next()){
                                
                            textoQR.setText("Asistencia ya existente para el usuario "+apellido); 
                                
                        }
                        else{
                                
                            consulta = "INSERT INTO asistencias VALUES (null,'"+id_usuario+"',"+id_asignatura_a+","+id_asignatura_p+",'"+dateTime+"')";
                            sentencia.executeUpdate(consulta);
                            textoQR.setText("Asistencia cargada para el usuario "+apellido); 
                                
                        }

                    }
                    else{
                            
                        consulta = "SELECT id_asignatura FROM asignaturas WHERE ((id_aula='"+idAula+"') AND (FIND_IN_SET(id_asignatura,'"+id_asignatura_p+"')) AND (FIND_IN_SET("+dia+",dias)) AND ('"+hora+"' BETWEEN hora_inicio AND hora_fin))";
                        resultado = sentencia.executeQuery(consulta);

                        if (resultado.next()){ // Es un profesor
                                
                            id_asignatura_p = "'"+resultado.getString(1)+"'"; 
                            id_asignatura_a = "null";

                            consulta = "SELECT asistencias.id_asistencia FROM asistencias,asignaturas WHERE ((asignaturas.id_asignatura=asistencias.id_asignatura_p) AND (asistencias.id_asignatura_p="+id_asignatura_p+") AND (asistencias.id_usuario='"+id_usuario+"') AND (DATE(asistencias.fecha)=CURDATE()) AND (DATE_FORMAT(asistencias.fecha,'%H:%i') BETWEEN asignaturas.hora_inicio AND asignaturas.hora_fin))";
                            resultado = sentencia.executeQuery(consulta);

                            if (resultado.next()){ 
                                    
                                textoQR.setText("Asistencia ya existente para el usuario "+apellido);
                                    
                            }
                            else{
                                    
                                consulta = "INSERT INTO asistencias VALUES (null,'"+id_usuario+"',"+id_asignatura_a+","+id_asignatura_p+",'"+dateTime+"')";
                                sentencia.executeUpdate(consulta);
                                textoQR.setText("Asistencia cargada para el usuario "+apellido); 
                                    
                            }

                        }
                        else{
                                
                            textoQR.setText("No se encontro una materia en este horario para el usuario "+apellido); 
                                
                        }
                            
                    }

                }
                else{ // Es un personal
                        
                    consulta = "SELECT id_asistencia FROM asistencias WHERE ((id_usuario='"+id_usuario+"') AND (DATE(fecha)=CURDATE()))";
                    resultado = sentencia.executeQuery(consulta);

                    if (resultado.next()){   
                            
                        textoQR.setText("Asistencia ya existente para el usuario "+apellido);
                            
                    }
                    else
                    {
                            
                        consulta = "INSERT INTO asistencias VALUES (null,'"+id_usuario+"',"+id_asignatura_a+","+id_asignatura_p+",'"+dateTime+"')";
                        sentencia.executeUpdate(consulta);
                        textoQR.setText("Asistencia cargada para el usuario "+apellido);
                            
                    }
                        
                }

            }
            else
            {
                    
                textoQR.setText("Usuario no encontrado");
                    
            }

        } catch (ClassNotFoundException | SQLException e) {

            e.printStackTrace();

        }

    }
    
    // Metodo para cerrar camara web y para parar el hilo
    public void close(){
        webcam.close();
        hilo.stop();
    }
    
    // Metodo para checkear si se selecciono algun aula, recibiendo el id de la misma
    public static void check(int id){
        idAula = id;
    }
    
}
