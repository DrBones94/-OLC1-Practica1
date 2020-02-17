/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1;

import java.awt.Container;
import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author drbones
 */
public class Interfaz extends javax.swing.JFrame {

  String archA = ""; //Variable para manejar el path del archivo actual.
  AnalisisL analisis = new AnalisisL();
  FileInputStream entrada;
  File P;
  Container contenedor;
  
  /**
   * Creates new form Interfaz
   */
  public Interfaz() {
    initComponents();
    contenedor = this.getContentPane();
    contenedor.setLayout(null);
  }

  /**
   * This method is called from within the constructor to initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is always
   * regenerated by the Form Editor.
   */
  
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    jMenuItem5 = new javax.swing.JMenuItem();
    jScrollPane1 = new javax.swing.JScrollPane();
    jTextArea1 = new javax.swing.JTextArea();
    jLabel1 = new javax.swing.JLabel();
    jMenuBar1 = new javax.swing.JMenuBar();
    jMenu1 = new javax.swing.JMenu();
    jMenuItem2 = new javax.swing.JMenuItem();
    jMenuItem1 = new javax.swing.JMenuItem();
    jMenuItem3 = new javax.swing.JMenuItem();
    jMenu2 = new javax.swing.JMenu();
    jMenuItem7 = new javax.swing.JMenuItem();
    jMenu3 = new javax.swing.JMenu();
    jMenuItem4 = new javax.swing.JMenuItem();
    jMenuItem6 = new javax.swing.JMenuItem();

    jMenuItem5.setText("jMenuItem5");

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    setPreferredSize(new java.awt.Dimension(650, 500));

    jTextArea1.setColumns(20);
    jTextArea1.setRows(5);
    jScrollPane1.setViewportView(jTextArea1);

    jLabel1.setText("Entrada:");

    jMenu1.setText("Archivo");

    jMenuItem2.setText("Abrir");
    jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jMenuItem2ActionPerformed(evt);
      }
    });
    jMenu1.add(jMenuItem2);

    jMenuItem1.setText("Guardar");
    jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jMenuItem1ActionPerformed(evt);
      }
    });
    jMenu1.add(jMenuItem1);

    jMenuItem3.setText("Guardar Como");
    jMenu1.add(jMenuItem3);

    jMenuBar1.add(jMenu1);

    jMenu2.setText("Analizar");

    jMenuItem7.setText("Analizar");
    jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jMenuItem7ActionPerformed(evt);
      }
    });
    jMenu2.add(jMenuItem7);

    jMenuBar1.add(jMenu2);

    jMenu3.setText("Reportes");

    jMenuItem4.setText("Tokens");
    jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jMenuItem4ActionPerformed(evt);
      }
    });
    jMenu3.add(jMenuItem4);

    jMenuItem6.setText("Errores");
    jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jMenuItem6ActionPerformed(evt);
      }
    });
    jMenu3.add(jMenuItem6);

    jMenuBar1.add(jMenu3);

    setJMenuBar(jMenuBar1);

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(jLabel1)
          .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addContainerGap(283, Short.MAX_VALUE))
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
        .addContainerGap(21, Short.MAX_VALUE)
        .addComponent(jLabel1)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 405, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(21, 21, 21))
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

  public String getArchivo(String ruta){
    FileReader fr = null;
    BufferedReader br = null;
    String contenido = "";

    try{
        fr = new FileReader(ruta);
        br = new BufferedReader(fr);

        String linea;

        while((linea = br.readLine()) != null){
            contenido += linea + "\n";
        }
    }catch(Exception e){}
    finally{
        try{
            br.close();
        }catch(Exception ex){}
    }
    return contenido;
  }
  
  private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_jMenuItem1ActionPerformed

  private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
    // REPORTE TOKENS
    
    try {
            String rutaC = System.getProperty("user.home") + "/Desktop/graph";
            File file_T = new File(rutaC , "REPORTE_TOKENS"+ ".html");
            java.io.FileOutputStream archivo = new java.io.FileOutputStream(file_T); //permite abrir el archivo que se le indica
            archivo.write("<html> \n".getBytes());
            archivo.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\"/>".getBytes());
            archivo.write("<head>\n".getBytes());
            archivo.write("<title>REPORTE: TABLA DE TOKENS VALIDOS</title>\n".getBytes());
            archivo.write("</head>\n".getBytes());
            //archivo.write("<body bgcolor = CornflowerBlue >\n".getBytes());

            archivo.write("<center>\n".getBytes());
            archivo.write("<h1>TABLA DE TOKENS VALIDOS<br><br></h1>\n".getBytes());
            archivo.write("</center>\n".getBytes());
                 
            archivo.write("<table border=\"collapse\" align = center>".getBytes());
            archivo.write("<tr><td>No.</td><td>TOKEN</td><td>LEXEMA</td><td>ID</td><td>FILA</td><td>COLUMNA</td></tr>".getBytes());
            if(analisis.LTokens.size() > 1){
                for (int i = 0; i < analisis.LTokens.size(); i++) {
                    //TOKENS
                    int w = i+1;
                    archivo.write(("<tr><td>"+w+"</td><td>"+analisis.LTokens.get(i).getToken()+"</td><td>"+analisis.LTokens.get(i).getLexema()+"</td><td>"+analisis.LTokens.get(i).getId()+"</td><td>"+analisis.LTokens.get(i).getFila()+"</td><td>"+analisis.LTokens.get(i).getColumna()+"</td></tr>").getBytes());
                }
//                for (int j = 0; j < analisis.LComentarios.size(); j++){
//                    //COMENTARIOS
//                    int w = j+1;
//                    archivo.write(("<tr><td>"+w+"</td><td>"+analisis.LComentarios.get(j).getToken()+"</td><td>"+analisis.LComentarios.get(j).getLexema()+"</td><td>"+analisis.LComentarios.get(j).getId()+"</td><td>"+analisis.LComentarios.get(j).getFila()+"</td><td>"+analisis.LComentarios.get(j).getColumna()+"</td></tr>").getBytes());
//                }
            }
            else{
                JOptionPane.showMessageDialog(null, "No hay Tokens que mostrar!", "Sin TOKENS", JOptionPane.INFORMATION_MESSAGE);
            }
            archivo.write("</table>".getBytes());
            
            archivo.write("<center>\n".getBytes());
            archivo.write(("</br>" + "</br>" + "</br>" + "</br>" + "DANILO GEOVANNI PINEDA ALCANTARA 201513680").getBytes());
            archivo.write("</center>\n".getBytes());

            archivo.write("</body>\n".getBytes());
            archivo.write("</html>".getBytes());
            //Runtime.getRuntime().exec("explorer.exe "+rutaC.replace("\\", "\\\\") +"\\\\" +"REPORTE_TOKENS"+ ".html");
          
            Desktop.getDesktop().open(file_T.getAbsoluteFile());
        } catch (java.io.IOException e) {
            System.out.println(e);
        }
  }//GEN-LAST:event_jMenuItem4ActionPerformed

  private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
    //ABRIR
    JFileChooser selector = null;
    FileNameExtensionFilter extension = new FileNameExtensionFilter("ER FILE", "er");
    
    if(selector == null){
      selector = new JFileChooser();
      selector.setFileFilter(extension);
    }
    
    int seleccion = selector.showOpenDialog(this);
    
    if(seleccion == JFileChooser.APPROVE_OPTION){
      try{
        archA = selector.getSelectedFile().getAbsolutePath();
        String contenido = getArchivo(selector.getSelectedFile().getAbsolutePath());
        jTextArea1.setText(contenido);
      }catch(Exception exp){
        System.out.println(exp);
      }
    }
  }//GEN-LAST:event_jMenuItem2ActionPerformed

  private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
    //ANALIZAR
    analisis.LTokens.clear();
    analisis.LErrores.clear();;
    
    analisis.A_Lexico(jTextArea1.getText());
    
    File folder = new File(System.getProperty("user.home") + "/Desktop/Graph");
    folder.mkdir();
    
  }//GEN-LAST:event_jMenuItem7ActionPerformed

  private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
    //REPORTE ERRORES
    
    try {
            String rutaC = System.getProperty("user.home") + "/Desktop/graph";
            File file_E = new File(rutaC , "REPORTE_ERRORES"+ ".html");
            java.io.FileOutputStream archivo = new java.io.FileOutputStream(file_E); //permite abrir el archivo que se le indica
            archivo.write("<html> \n".getBytes());
            archivo.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\"/>".getBytes());
            archivo.write("<head>\n".getBytes());
            archivo.write("<title>REPORTE: TABLA DE ERRORES</title>\n".getBytes());
            archivo.write("</head>\n".getBytes());
            //archivo.write("<body bgcolor = CornflowerBlue >\n".getBytes());

            archivo.write("<center>\n".getBytes());
            archivo.write("<h1>TABLA DE ERRORES<br><br></h1>\n".getBytes());
            archivo.write("</center>\n".getBytes());
                 
            archivo.write("<table border=\"collapse\" align = center>".getBytes());
            archivo.write("<tr><td>No.</td><td>CARÁCTER</td><td>TIPO ERROR</td><td>FILA</td><td>COLUMNA</td><td>DESCRIPCIÓN</td></tr>".getBytes());
            if(analisis.LErrores.size() > 0){
                 for (int d = 0; d <= analisis.LErrores.size() -1; d++) {
                     int w = d+1;
                     archivo.write(("<tr><td>"+w+"</td><td>"+analisis.LErrores.get(d).getError()+"</td><td>"+analisis.LErrores.get(d).getTipo()+"</td><td>"+analisis.LErrores.get(d).getFila()+"</td><td>"+analisis.LErrores.get(d).getColumna()+"</td><td>"+analisis.LErrores.get(d).getDescripcion()+"</td></tr>").getBytes());
                 }
            }
            else{
                JOptionPane.showMessageDialog(null, "No hay erroes lexicos que mostrar!", "Sin ERRORES", JOptionPane.INFORMATION_MESSAGE);
            }
            archivo.write("</table>".getBytes());
            
            archivo.write("<center>\n".getBytes());
            archivo.write(("</br>" + "</br>" + "</br>" + "</br>" + "DANILO GEOVANNI PINEDA ALCANTARA 201513680").getBytes());
            archivo.write("</center>\n".getBytes());

            archivo.write("</body>\n".getBytes());
            archivo.write("</html>".getBytes());
            //Runtime.getRuntime().exec("explorer.exe"+rutaC +"\\" +"REPORTE_TOKENS"+ ".html");
            
            Desktop.getDesktop().open(file_E.getAbsoluteFile());
        } catch (java.io.IOException e) {
            System.out.println(e);
        }
  }//GEN-LAST:event_jMenuItem6ActionPerformed

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
      java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (InstantiationException ex) {
      java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex) {
      java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (javax.swing.UnsupportedLookAndFeelException ex) {
      java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    //</editor-fold>

    /* Create and display the form */
    java.awt.EventQueue.invokeLater(new Runnable() {
      public void run() {
        new Interfaz().setVisible(true);
      }
    });
  }

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JLabel jLabel1;
  private javax.swing.JMenu jMenu1;
  private javax.swing.JMenu jMenu2;
  private javax.swing.JMenu jMenu3;
  private javax.swing.JMenuBar jMenuBar1;
  private javax.swing.JMenuItem jMenuItem1;
  private javax.swing.JMenuItem jMenuItem2;
  private javax.swing.JMenuItem jMenuItem3;
  private javax.swing.JMenuItem jMenuItem4;
  private javax.swing.JMenuItem jMenuItem5;
  private javax.swing.JMenuItem jMenuItem6;
  private javax.swing.JMenuItem jMenuItem7;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JTextArea jTextArea1;
  // End of variables declaration//GEN-END:variables
}
