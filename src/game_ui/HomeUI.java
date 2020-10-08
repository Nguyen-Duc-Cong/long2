package game_ui;

import game_client.ClientManager;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class HomeUI extends javax.swing.JFrame {

    private final ClientManager playerControl;
    private final DefaultListModel<String> listOnline;

    public HomeUI(ClientManager playerControl) {
        JPanel panel = new javax.swing.JPanel() {
            protected void paintComponent(Graphics g) {
                if (g instanceof Graphics2D) {
                    Paint p = new GradientPaint(0.0f, 0.0f, new Color(136, 211, 206), getWidth(), getHeight(), new Color(110, 69, 226), true);
                    Graphics2D g2d = (Graphics2D) g;
                    g2d.setPaint(p);
                    g2d.fillRect(0, 0, getWidth(), getHeight());
                } else {
                    super.paintComponent(g);
                }
            }
        };
        setContentPane(panel);
        initComponents();
        setTitle("Caro Room");
        setResizable(false);
        setLocation(520, 220);
        listOnline = new DefaultListModel<>();
        jlistOnline.setModel(listOnline);
        this.playerControl = playerControl;
    }

    public int getUserChoice(String from) {
        return JOptionPane.showConfirmDialog(this, "Do you want to play Tic Tac Toe with " +
                from + "?", "Invite", JOptionPane.YES_NO_OPTION);
    }

    public void removeUserFromList(String userName) {
        listOnline.removeElement(userName);
    }

    public void addUserToList(String userName) {
        listOnline.addElement(userName);
    }

    public void displayMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jlistOnline = new javax.swing.JList<>();
        btnInvite = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jlistOnline.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jlistOnline.setForeground(new java.awt.Color(51, 51, 51));
        jScrollPane1.setViewportView(jlistOnline);

        btnInvite.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnInvite.setForeground(new java.awt.Color(51, 51, 51));
        btnInvite.setText("Invite");
        btnInvite.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInviteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
                    .addComponent(btnInvite, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnInvite)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnInviteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInviteActionPerformed
        int idx = jlistOnline.getSelectedIndex();
        if (idx > 0) {
            playerControl.sendInvite(listOnline.getElementAt(idx));
        }
    }//GEN-LAST:event_btnInviteActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        playerControl.setOffline();
    }//GEN-LAST:event_formWindowClosing


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnInvite;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<String> jlistOnline;
    // End of variables declaration//GEN-END:variables
}
