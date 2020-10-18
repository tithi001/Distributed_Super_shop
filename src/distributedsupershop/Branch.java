

package distributedsupershop;

import java.awt.event.ItemEvent;
import java.io.IOException;
import java.util.ArrayList;



public class Branch extends javax.swing.JFrame {
    
    DataBaseConnection2 db = new DataBaseConnection2();
    static int status;
    public void setBranchList() {
        branchList.removeAllItems();
        ArrayList list = db.getBranchList();
        for (int i = 0; i < list.size(); i++){
            branchList.addItem(list.get(i));
        }
       
    }
    

    
    public Branch(int status) {
        initComponents();
        Branch.status=status;
        setBranchList();
        if (status == 2 ){
            editButton.setVisible(false); editButton.setEnabled(false);
            createButton.setVisible(false); createButton.setEnabled(false);
        }
        
    }

    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        branchList = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        textField = new javax.swing.JTextArea();
        editButton = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        createButton = new javax.swing.JButton();
        backButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("SELECT A BRANCH FROM THE LIST BELOW");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 240, 350, -1));

        branchList.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        branchList.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        branchList.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                branchListItemStateChanged(evt);
            }
        });
        getContentPane().add(branchList, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 310, 203, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("DETAILED INFO");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 360, 253, 21));

        textField.setBackground(new java.awt.Color(255, 255, 204));
        textField.setColumns(20);
        textField.setLineWrap(true);
        textField.setRows(5);
        jScrollPane1.setViewportView(textField);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 420, 441, 152));

        editButton.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        editButton.setText("Edit Branch");
        editButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editButtonActionPerformed(evt);
            }
        });
        getContentPane().add(editButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 610, 110, -1));

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jButton2.setText("View Products");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 310, -1, 20));

        createButton.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        createButton.setText("Create Branch");
        createButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createButtonActionPerformed(evt);
            }
        });
        getContentPane().add(createButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 610, -1, -1));

        backButton.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
        getContentPane().add(backButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 610, -1, -1));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Branches");
        jLabel3.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabel3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 160, 221, 80));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/loc_icon.png"))); // NOI18N
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 40, 110, 100));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/purple_zero.png"))); // NOI18N
        jLabel4.setText("jLabel4");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1100, 1020));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void branchListItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_branchListItemStateChanged
       if (evt.getStateChange() == ItemEvent.SELECTED) {
          Object item = evt.getItem();
          String branch = item.toString();
          textField.setText(db.getBranchInfo(branch));
       }
    }//GEN-LAST:event_branchListItemStateChanged

    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButtonActionPerformed
        this.setVisible(false);this.dispose();
        EditBranch eb = new EditBranch(status);
        eb.setVisible(true);
    }//GEN-LAST:event_editButtonActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.setVisible(false);
        String selection= branchList.getSelectedItem().toString();  
        try{
        ViewProducts vp=new ViewProducts(selection);vp.setVisible(true);
        }catch(Exception e){
            
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void createButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createButtonActionPerformed
        this.setVisible(false);this.dispose();
        CreateBranch c = new CreateBranch(status);
        c.setVisible(true);
    }//GEN-LAST:event_createButtonActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        try {
            this.setVisible(false);this.dispose();
            new Menu(status).setVisible(true);
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }//GEN-LAST:event_backButtonActionPerformed

     
    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Branch(0).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JComboBox branchList;
    private javax.swing.JButton createButton;
    private javax.swing.JButton editButton;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea textField;
    // End of variables declaration//GEN-END:variables
}
