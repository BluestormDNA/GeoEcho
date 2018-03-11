/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geoecho.view;

import static helpers.Constants.*;
import java.awt.Frame;
import java.awt.Toolkit;
import javax.swing.JPanel;

/**
 *
 * @author BlueStorm
 */
public class GUIForm extends javax.swing.JFrame {

    /**
     * Creates new form Gui
     */
    public GUIForm() {
        initComponents();
        this.setLocationRelativeTo(null);
        setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelTop = new javax.swing.JPanel();
        jLabelIconoCerrar = new javax.swing.JLabel();
        jLabelIconoMinimizar = new javax.swing.JLabel();
        jPanelSup = new javax.swing.JPanel();
        jLabelTitulo = new javax.swing.JLabel();
        jLabelLogo = new javax.swing.JLabel();
        jPanelBPosition = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanelBUser = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanelBWorld = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanelBConfig = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanelBStatistic = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanelLateral = new javax.swing.JPanel();
        jLayeredPane = new javax.swing.JLayeredPane();
        jPanelStart = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jPanelUser = new javax.swing.JPanel();
        jPanelUser.setVisible(false);
        jButtonLogout = new javax.swing.JButton();
        jPanelWorld = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("GeoEcho");
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/res/icon.png")));
        setLocation(new java.awt.Point(0, 0));
        setUndecorated(true);
        setResizable(false);
        setSize(new java.awt.Dimension(800, 600));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelTop.setBackground(new java.awt.Color(255, 255, 255));
        jPanelTop.setName("barraSuperior"); // NOI18N
        jPanelTop.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanelTopMouseDragged(evt);
            }
        });
        jPanelTop.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanelTopMousePressed(evt);
            }
        });

        jLabelIconoCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/close.png"))); // NOI18N
        jLabelIconoCerrar.setName("labelCerrar"); // NOI18N
        jLabelIconoCerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabelIconoCerrarMouseReleased(evt);
            }
        });

        jLabelIconoMinimizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/minimize.png"))); // NOI18N
        jLabelIconoMinimizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabelIconoMinimizarMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanelTopLayout = new javax.swing.GroupLayout(jPanelTop);
        jPanelTop.setLayout(jPanelTopLayout);
        jPanelTopLayout.setHorizontalGroup(
            jPanelTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelTopLayout.createSequentialGroup()
                .addContainerGap(686, Short.MAX_VALUE)
                .addComponent(jLabelIconoMinimizar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelIconoCerrar)
                .addContainerGap())
        );
        jPanelTopLayout.setVerticalGroup(
            jPanelTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelTopLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelIconoCerrar, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelIconoMinimizar, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(22, 22, 22))
        );

        getContentPane().add(jPanelTop, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 750, 30));

        jPanelSup.setBackground(new java.awt.Color(255, 255, 255));
        jPanelSup.setName("panelSuperior"); // NOI18N

        jLabelTitulo.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabelTitulo.setText("Admin Tools");

        jLabelLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/logo.png"))); // NOI18N

        javax.swing.GroupLayout jPanelSupLayout = new javax.swing.GroupLayout(jPanelSup);
        jPanelSup.setLayout(jPanelSupLayout);
        jPanelSupLayout.setHorizontalGroup(
            jPanelSupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelSupLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanelSupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelTitulo)
                    .addComponent(jLabelLogo))
                .addContainerGap(546, Short.MAX_VALUE))
        );
        jPanelSupLayout.setVerticalGroup(
            jPanelSupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelSupLayout.createSequentialGroup()
                .addComponent(jLabelLogo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addComponent(jLabelTitulo)
                .addContainerGap())
        );

        getContentPane().add(jPanelSup, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, 750, 120));

        jPanelBPosition.setBackground(new java.awt.Color(33, 33, 33));
        jPanelBPosition.setName("lateral"); // NOI18N
        jPanelBPosition.setPreferredSize(new java.awt.Dimension(50, 50));
        jPanelBPosition.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanelBPositionMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanelBPositionMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanelBPositionMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jPanelBPositionMouseReleased(evt);
            }
        });

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/map-marker.png"))); // NOI18N

        javax.swing.GroupLayout jPanelBPositionLayout = new javax.swing.GroupLayout(jPanelBPosition);
        jPanelBPosition.setLayout(jPanelBPositionLayout);
        jPanelBPositionLayout.setHorizontalGroup(
            jPanelBPositionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBPositionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanelBPositionLayout.setVerticalGroup(
            jPanelBPositionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBPositionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(jPanelBPosition, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, -1, -1));

        jPanelBUser.setBackground(new java.awt.Color(33, 33, 33));
        jPanelBUser.setName("lateral"); // NOI18N
        jPanelBUser.setPreferredSize(new java.awt.Dimension(50, 50));
        jPanelBUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanelBPositionMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanelBPositionMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanelBPositionMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jPanelBPositionMouseReleased(evt);
            }
        });

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/account.png"))); // NOI18N

        javax.swing.GroupLayout jPanelBUserLayout = new javax.swing.GroupLayout(jPanelBUser);
        jPanelBUser.setLayout(jPanelBUserLayout);
        jPanelBUserLayout.setHorizontalGroup(
            jPanelBUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBUserLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanelBUserLayout.setVerticalGroup(
            jPanelBUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBUserLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(jPanelBUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jPanelBWorld.setBackground(new java.awt.Color(33, 33, 33));
        jPanelBWorld.setName("lateral"); // NOI18N
        jPanelBWorld.setPreferredSize(new java.awt.Dimension(50, 50));
        jPanelBWorld.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanelBPositionMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanelBPositionMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanelBPositionMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jPanelBPositionMouseReleased(evt);
            }
        });

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/web.png"))); // NOI18N

        javax.swing.GroupLayout jPanelBWorldLayout = new javax.swing.GroupLayout(jPanelBWorld);
        jPanelBWorld.setLayout(jPanelBWorldLayout);
        jPanelBWorldLayout.setHorizontalGroup(
            jPanelBWorldLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBWorldLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanelBWorldLayout.setVerticalGroup(
            jPanelBWorldLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBWorldLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(jPanelBWorld, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, -1, -1));

        jPanelBConfig.setBackground(new java.awt.Color(33, 33, 33));
        jPanelBConfig.setName("lateral"); // NOI18N
        jPanelBConfig.setPreferredSize(new java.awt.Dimension(50, 50));
        jPanelBConfig.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanelBPositionMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanelBPositionMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanelBPositionMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jPanelBPositionMouseReleased(evt);
            }
        });

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/wrench.png"))); // NOI18N

        javax.swing.GroupLayout jPanelBConfigLayout = new javax.swing.GroupLayout(jPanelBConfig);
        jPanelBConfig.setLayout(jPanelBConfigLayout);
        jPanelBConfigLayout.setHorizontalGroup(
            jPanelBConfigLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBConfigLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanelBConfigLayout.setVerticalGroup(
            jPanelBConfigLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBConfigLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(jPanelBConfig, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, -1, -1));

        jPanelBStatistic.setBackground(new java.awt.Color(33, 33, 33));
        jPanelBStatistic.setName("lateral"); // NOI18N
        jPanelBStatistic.setPreferredSize(new java.awt.Dimension(50, 50));
        jPanelBStatistic.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanelBPositionMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanelBPositionMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanelBPositionMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jPanelBPositionMouseReleased(evt);
            }
        });

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/finance.png"))); // NOI18N

        javax.swing.GroupLayout jPanelBStatisticLayout = new javax.swing.GroupLayout(jPanelBStatistic);
        jPanelBStatistic.setLayout(jPanelBStatisticLayout);
        jPanelBStatisticLayout.setHorizontalGroup(
            jPanelBStatisticLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBStatisticLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanelBStatisticLayout.setVerticalGroup(
            jPanelBStatisticLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBStatisticLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(jPanelBStatistic, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, -1, -1));

        jPanelLateral.setBackground(new java.awt.Color(33, 33, 33));

        javax.swing.GroupLayout jPanelLateralLayout = new javax.swing.GroupLayout(jPanelLateral);
        jPanelLateral.setLayout(jPanelLateralLayout);
        jPanelLateralLayout.setHorizontalGroup(
            jPanelLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );
        jPanelLateralLayout.setVerticalGroup(
            jPanelLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 350, Short.MAX_VALUE)
        );

        getContentPane().add(jPanelLateral, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 250, 50, 350));

        jLabel6.setText("PANEL NOT IMPLEMENTED YET USE BUTTONS ON THE LEFT <---");

        javax.swing.GroupLayout jPanelStartLayout = new javax.swing.GroupLayout(jPanelStart);
        jPanelStart.setLayout(jPanelStartLayout);
        jPanelStartLayout.setHorizontalGroup(
            jPanelStartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelStartLayout.createSequentialGroup()
                .addGap(208, 208, 208)
                .addComponent(jLabel6)
                .addContainerGap(234, Short.MAX_VALUE))
        );
        jPanelStartLayout.setVerticalGroup(
            jPanelStartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelStartLayout.createSequentialGroup()
                .addContainerGap(224, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(212, 212, 212))
        );

        jButtonLogout.setText("Logout");

        javax.swing.GroupLayout jPanelUserLayout = new javax.swing.GroupLayout(jPanelUser);
        jPanelUser.setLayout(jPanelUserLayout);
        jPanelUserLayout.setHorizontalGroup(
            jPanelUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelUserLayout.createSequentialGroup()
                .addGap(322, 322, 322)
                .addComponent(jButtonLogout)
                .addContainerGap(363, Short.MAX_VALUE))
        );
        jPanelUserLayout.setVerticalGroup(
            jPanelUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelUserLayout.createSequentialGroup()
                .addGap(208, 208, 208)
                .addComponent(jButtonLogout)
                .addContainerGap(219, Short.MAX_VALUE))
        );

        jPanelWorld.setLayout(new java.awt.BorderLayout());

        jLayeredPane.setLayer(jPanelStart, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane.setLayer(jPanelUser, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane.setLayer(jPanelWorld, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPaneLayout = new javax.swing.GroupLayout(jLayeredPane);
        jLayeredPane.setLayout(jLayeredPaneLayout);
        jLayeredPaneLayout.setHorizontalGroup(
            jLayeredPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelStart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jLayeredPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanelUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jLayeredPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanelWorld, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jLayeredPaneLayout.setVerticalGroup(
            jLayeredPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelStart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jLayeredPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanelUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jLayeredPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanelWorld, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jLayeredPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, 750, 450));

        pack();
    }// </editor-fold>//GEN-END:initComponents
private int x;
    private int y;
    private void jPanelTopMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelTopMousePressed
        // Reiniciar la posicion x y al hacer click
        x = evt.getX();
        y = evt.getY();
    }//GEN-LAST:event_jPanelTopMousePressed

    private void jPanelTopMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelTopMouseDragged
        // actualiza x y al hacer arrastrar
        this.setLocation(this.getLocation().x + evt.getX() - x, this.getLocation().y + evt.getY() - y);
    }//GEN-LAST:event_jPanelTopMouseDragged

    private void jPanelBPositionMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelBPositionMouseEntered
        evt.getComponent().setBackground(new java.awt.Color(55, 55, 55));
    }//GEN-LAST:event_jPanelBPositionMouseEntered

    private void jPanelBPositionMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelBPositionMouseExited
        evt.getComponent().setBackground(new java.awt.Color(33, 33, 33));
    }//GEN-LAST:event_jPanelBPositionMouseExited

    private void jPanelBPositionMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelBPositionMousePressed
        evt.getComponent().setBackground(new java.awt.Color(77, 77, 77));
    }//GEN-LAST:event_jPanelBPositionMousePressed

    private void jPanelBPositionMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelBPositionMouseReleased
        evt.getComponent().setBackground(new java.awt.Color(55, 55, 55));
        JPanel jPanel = (JPanel) evt.getSource(); //TODO
        if (jPanel == jPanelBUser) {
            jLabelTitulo.setText(TITLE_USER);
            this.jPanelUser.setVisible(true);
            this.jPanelWorld.setVisible(false);
            //this.jLayeredPane.moveToFront(jPanelUser);
        } else if (jPanel == jPanelBWorld) {
            jLabelTitulo.setText(TITLE_WORLD);
            this.jPanelWorld.setVisible(true);
            //this.jLayeredPane.moveToFront(jPanelWorld);
        } else {
            jLabelTitulo.setText(TITLE_NOT_IMPLEMENTED);
            this.jPanelStart.setVisible(true);
            this.jPanelWorld.setVisible(false);
            //this.jLayeredPane.moveToFront(jPanelStart);
        }
    }//GEN-LAST:event_jPanelBPositionMouseReleased

    private void jLabelIconoMinimizarMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelIconoMinimizarMouseReleased
        // Minimiza la app
        this.setState(Frame.ICONIFIED);
    }//GEN-LAST:event_jLabelIconoMinimizarMouseReleased

    private void jLabelIconoCerrarMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelIconoCerrarMouseReleased
        // Cierra la app
        System.exit(0);
    }//GEN-LAST:event_jLabelIconoCerrarMouseReleased

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
            java.util.logging.Logger.getLogger(GUIForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUIForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUIForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUIForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUIForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonLogout;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabelIconoCerrar;
    private javax.swing.JLabel jLabelIconoMinimizar;
    private javax.swing.JLabel jLabelLogo;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JLayeredPane jLayeredPane;
    private javax.swing.JPanel jPanelBConfig;
    private javax.swing.JPanel jPanelBPosition;
    private javax.swing.JPanel jPanelBStatistic;
    private javax.swing.JPanel jPanelBUser;
    private javax.swing.JPanel jPanelBWorld;
    private javax.swing.JPanel jPanelLateral;
    private javax.swing.JPanel jPanelStart;
    private javax.swing.JPanel jPanelSup;
    private javax.swing.JPanel jPanelTop;
    private javax.swing.JPanel jPanelUser;
    private javax.swing.JPanel jPanelWorld;
    // End of variables declaration//GEN-END:variables

    public javax.swing.JButton getjButtonLogout() {
        return jButtonLogout;
    }
    
    public javax.swing.JPanel getjPanelBWorld() {
        return jPanelBWorld;
    }
    
    public javax.swing.JPanel getjPanelWorld() {
        return jPanelWorld;
    }
}
