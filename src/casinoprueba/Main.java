/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package casinoprueba;

import java.awt.Color;
import java.awt.Image;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */

public class Main extends javax.swing.JFrame {
        boolean flag=true, modo=false;
        int comp,gano=0;
        Hilo Primero = new Hilo();
        Hilo Segundo = new Hilo();
        Hilo Tercero = new Hilo();
    /**
     * Creates new form Main
     */
    public Main() {
        initComponents();
        Ant.setVisible(false);
        Stop.setEnabled(false);
        Stop.setVisible(false);
        Bloqueo();
       
      //  img2 = img2.getScaledInstance(110, 110, java.awt.Image.SCALE_SMOOTH);
      //  Uno.setIcon(new ImageIcon(img2));
        
    }

    private void Iniciar() {
        if(flag==false){
        Primero.Anterior();
        Segundo.Anterior();
        Tercero.Anterior();
        Ant.setVisible(true);
        } else
        {
            
        flag=false;
        }
        comp=3;
        Primero=new Hilo();
        Segundo=new Hilo();
         Tercero=new Hilo();
          Primero.setVentana(1);
          Segundo.setVentana(2);
          Tercero.setVentana(3);
        Primero.start();
        Segundo.start();
        Tercero.start();
    }

    private void Parar() {
        Primero.EstadoCambiar();
        Segundo.EstadoCambiar();
        Tercero.EstadoCambiar();
        
    }

    private void Comparar() {
            Image img;
        if(((Primero.getGuardado()==Segundo.getGuardado())&&(Segundo.getGuardado()==Tercero.getGuardado()))&&true)
        {
            System.out.println("PREMIO MAYOR"+ Primero.getGuardado() +" "+ Segundo.getGuardado() +" "+ Tercero.getGuardado() +" ");
                    img = new ImageIcon(this.getClass().getResource("/Imagenes/win.png")).getImage();
                                img = img.getScaledInstance(130, 160, java.awt.Image.SCALE_SMOOTH);
                                 Aviso.setIcon(new ImageIcon(img));
                                 gano=gano+3;
                                 Acum.setText("PT: "+ gano);
        }else if((Primero.getGuardado()==Segundo.getGuardado()) ||  (Segundo.getGuardado()==Tercero.getGuardado()))
        {
            System.out.println("PREMIO MENOR");
            Aviso.setText("PREMIO MENOR");
                                 gano=gano+1;
                                 Acum.setText("PT: "+ gano);
            
        }
       
        else 
        {
            System.out.println("FALLASTE");
            
            Aviso.setText("FALLASTE");
        }
        
    }

    
    
    
    public class Hilo extends Thread {
        private int ventana, guardado;
        private boolean bandera=false;
        public Hilo() {
            ventana = 0;
        }
        
        // El método run es llamado con la acción start() del hilo y a su vez se usa un hilo diferente al principal (main)
        @Override
        public void run(){
            int x=0;
            Random random=new Random();
            Image img;
            int op= random.nextInt(4)+1;
                    while(bandera!=true)
                    {
                        op= random.nextInt(4)+1;
                        switch(op)
                        {
                            case 1:
                                 img = new ImageIcon(this.getClass().getResource("/Imagenes/7.jpg")).getImage();
                                img = img.getScaledInstance(110, 110, java.awt.Image.SCALE_SMOOTH);
                                break;
                            case 2:
                                 img = new ImageIcon(this.getClass().getResource("/Imagenes/Cash.jpg")).getImage();
                                img = img.getScaledInstance(110, 110, java.awt.Image.SCALE_SMOOTH);
                                break;
                            case 3:
                                 img = new ImageIcon(this.getClass().getResource("/Imagenes/uva.jpg")).getImage();
                                img = img.getScaledInstance(110, 110, java.awt.Image.SCALE_SMOOTH);
                                break;
                            default:
                                 img = new ImageIcon(this.getClass().getResource("/Imagenes/limon.jpg")).getImage();
                                img = img.getScaledInstance(110, 110, java.awt.Image.SCALE_SMOOTH);
                                break;
                        }
                        guardado=op;
                    
                       switch(ventana)
                       {
                           case 1:
                                Uno.setIcon(new ImageIcon(img));
                               break;
                               case 2:
                                Dos.setIcon(new ImageIcon(img));
                               break;
                               case 3:
                                Tres.setIcon(new ImageIcon(img));
                               break;
                       }
                         
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
                    public void EstadoCambiar() {
            if(bandera==true)
                bandera=false;
            else if(bandera==false)
            bandera=true;
        }
        public void setVentana(Integer num) {
            ventana=num;
        }
        public Integer getGuardado()
        {
           
             return guardado;
        }
        
        public void Anterior()
        {
             Image img;
             switch(guardado)
                        {
                            case 1:
                                 img = new ImageIcon(this.getClass().getResource("/Imagenes/7.jpg")).getImage();
                                img = img.getScaledInstance(90, 90, java.awt.Image.SCALE_SMOOTH);
                                break;
                            case 2:
                                 img = new ImageIcon(this.getClass().getResource("/Imagenes/Cash.jpg")).getImage();
                                img = img.getScaledInstance(90, 90, java.awt.Image.SCALE_SMOOTH);
                                break;
                            case 3:
                                 img = new ImageIcon(this.getClass().getResource("/Imagenes/uva.jpg")).getImage();
                                img = img.getScaledInstance(90, 90, java.awt.Image.SCALE_SMOOTH);
                                break;
                            default:
                                 img = new ImageIcon(this.getClass().getResource("/Imagenes/limon.jpg")).getImage();
                                img = img.getScaledInstance(90, 90, java.awt.Image.SCALE_SMOOTH);
                                break;
                        }
                    
                       switch(ventana)
                       {
                           case 1:
                                Uno1.setBorder(BorderFactory.createLineBorder(Color.blue));
                                Uno1.setIcon(new ImageIcon(img));
                               break;
                               case 2:
                                Dos1.setBorder(BorderFactory.createLineBorder(Color.blue));
                                Dos1.setIcon(new ImageIcon(img));
                               break;
                               case 3:
                                Tres1.setBorder(BorderFactory.createLineBorder(Color.blue));
                                Tres1.setIcon(new ImageIcon(img));
                               break;
                       }
        }
    }


    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        Cambiar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Stop1 = new javax.swing.JLabel();
        Stop2 = new javax.swing.JLabel();
        Stop3 = new javax.swing.JLabel();
        Stop = new javax.swing.JLabel();
        Acum = new javax.swing.JLabel();
        Ant = new javax.swing.JLabel();
        Uno1 = new javax.swing.JLabel();
        Dos1 = new javax.swing.JLabel();
        Tres1 = new javax.swing.JLabel();
        Aviso = new javax.swing.JLabel();
        Uno = new javax.swing.JLabel();
        Dos = new javax.swing.JLabel();
        Tres = new javax.swing.JLabel();
        Boton = new javax.swing.JLabel();
        Fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        setResizable(false);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Cambiar.setText("1x1");
        Cambiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CambiarActionPerformed(evt);
            }
        });
        jPanel1.add(Cambiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/neon-cat-cat.gif"))); // NOI18N
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 80, 500, 160));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/neon-cat-cat.gif"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 480, 480, 90));

        Stop1.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        Stop1.setForeground(new java.awt.Color(255, 255, 255));
        Stop1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Stop1.setText("Detener");
        Stop1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Stop1MouseClicked(evt);
            }
        });
        jPanel1.add(Stop1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 460, 60, 50));

        Stop2.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        Stop2.setForeground(new java.awt.Color(255, 255, 255));
        Stop2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Stop2.setText("Detener");
        Stop2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Stop2MouseClicked(evt);
            }
        });
        jPanel1.add(Stop2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 460, 60, 50));

        Stop3.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        Stop3.setForeground(new java.awt.Color(255, 255, 255));
        Stop3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Stop3.setText("Detener");
        Stop3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Stop3MouseClicked(evt);
            }
        });
        jPanel1.add(Stop3, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 460, 60, 50));

        Stop.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        Stop.setForeground(new java.awt.Color(255, 255, 255));
        Stop.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Stop.setText("Detener");
        Stop.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                StopMouseClicked(evt);
            }
        });
        jPanel1.add(Stop, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 460, 60, 50));

        Acum.setFont(new java.awt.Font("Dialog", 1, 48)); // NOI18N
        Acum.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Acum.setText("PT: 0");
        jPanel1.add(Acum, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 550, 200, 80));

        Ant.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        Ant.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Ant.setText("Resultado Anterior");
        jPanel1.add(Ant, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 0, 330, 50));

        Uno1.setBackground(new java.awt.Color(153, 255, 102));
        jPanel1.add(Uno1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 70, 90, 90));

        Dos1.setBackground(new java.awt.Color(153, 255, 102));
        jPanel1.add(Dos1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 70, 90, 90));

        Tres1.setBackground(new java.awt.Color(153, 255, 102));
        jPanel1.add(Tres1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 70, 90, 90));

        Aviso.setFont(new java.awt.Font("Dialog", 1, 48)); // NOI18N
        Aviso.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(Aviso, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 300, 410, 160));
        jPanel1.add(Uno, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 230, 110, 110));
        jPanel1.add(Dos, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 230, 110, 110));
        jPanel1.add(Tres, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 230, 110, 110));

        Boton.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        Boton.setForeground(new java.awt.Color(255, 255, 255));
        Boton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Boton.setText("PUSH");
        Boton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BotonMouseClicked(evt);
            }
        });
        jPanel1.add(Boton, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 20, 60, 50));

        Fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/istockphoto-1199368587-1024x1024.jpg"))); // NOI18N
        jPanel1.add(Fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 720, 670));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 714, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 664, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BotonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotonMouseClicked
        // TODO add your handling code here:
        Aviso.setText("");
        Aviso.setIcon(null);
        Iniciar();
        Boton.setEnabled(false);
        Boton.setVisible(false);
        
        Stop.setEnabled(true);
        Stop.setEnabled(true);
    }//GEN-LAST:event_BotonMouseClicked

    private void StopMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_StopMouseClicked
        // TODO add your handling code here:
        Parar();
        Boton.setEnabled(true);
        Boton.setVisible(true);
        Comparar();
    }//GEN-LAST:event_StopMouseClicked

    private void CambiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CambiarActionPerformed
        // TODO add your handling code here:
        Bloqueo();
    }//GEN-LAST:event_CambiarActionPerformed

    private void Bloqueo(){
        if(modo==false)
        {
            Stop1.setEnabled(false);
            Stop2.setEnabled(false);
            Stop3.setEnabled(false);
            Stop1.setVisible(false);
            Stop2.setVisible(false);
            Stop3.setVisible(false);
            Stop.setEnabled(true);
            Stop.setVisible(true);
            modo=true;
        }else
        {
            Stop1.setEnabled(true);
            Stop2.setEnabled(true);
            Stop3.setEnabled(true);
            Stop1.setVisible(true);
            Stop2.setVisible(true);
            Stop3.setVisible(true);
            Stop.setEnabled(false);
            Stop.setVisible(false);
            modo=false;
        }
    }
    private void CompararSep()
    {
        comp--;
        if(comp==0)
        {
            Comparar();
        }
    }
    private void Stop1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Stop1MouseClicked
        // TODO add your handling code here:
        Primero.EstadoCambiar();
        Boton.setEnabled(true);
        Boton.setVisible(true);
        CompararSep();
    }//GEN-LAST:event_Stop1MouseClicked

    private void Stop2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Stop2MouseClicked
        // TODO add your handling code here:
        Segundo.EstadoCambiar();
        Boton.setEnabled(true);
        Boton.setVisible(true);
        CompararSep();
    }//GEN-LAST:event_Stop2MouseClicked

    private void Stop3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Stop3MouseClicked
        // TODO add your handling code here:
        Tercero.EstadoCambiar();
        Boton.setEnabled(true);
        Boton.setVisible(true);
        CompararSep();
    }//GEN-LAST:event_Stop3MouseClicked

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
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Acum;
    private javax.swing.JLabel Ant;
    private javax.swing.JLabel Aviso;
    private javax.swing.JLabel Boton;
    private javax.swing.JButton Cambiar;
    private javax.swing.JLabel Dos;
    private javax.swing.JLabel Dos1;
    private javax.swing.JLabel Fondo;
    private javax.swing.JLabel Stop;
    private javax.swing.JLabel Stop1;
    private javax.swing.JLabel Stop2;
    private javax.swing.JLabel Stop3;
    private javax.swing.JLabel Tres;
    private javax.swing.JLabel Tres1;
    private javax.swing.JLabel Uno;
    private javax.swing.JLabel Uno1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
