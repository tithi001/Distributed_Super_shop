/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package distributedsupershop;


import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Int;
import java.awt.Image;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import static java.lang.Integer.parseInt;
import java.sql.Connection;
import javax.swing.ImageIcon;
import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import java.util.logging.Level;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import net.proteanit.sql.DbUtils;


/**
 *
 * @author DAFFODIL
 */
public class ProfileAdmin extends javax.swing.JFrame {
static int status;
Menu menu;
String sql;
    Connection con;
    ResultSet rs;
    DataBaseConnection Dbase;
    PreparedStatement st;
    public ProfileAdmin(Menu m){

        menu=m;
        
        
    }
    public ProfileAdmin(int status) {
        
        initComponents();
          
              setContentPane(new javax.swing.JLabel(new ImageIcon(
                    "nosh2.png"))); 
       
     
       
       
        ProfileAdmin.status=status;
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            Dbase= new DataBaseConnection();
          
       
              
              try { 
            jLabel10.setIcon(new ImageIcon(ImageIO.read(new java.io.File("Cart.png")
            ).getScaledInstance(jLabel10.getWidth(), jLabel10.getHeight(),
                    Image.SCALE_SMOOTH)));
            
                   
            jLabel8.setIcon(new ImageIcon(ImageIO.read(new java.io.File("search.png")
            ).getScaledInstance(jLabel8.getWidth(), jLabel8.getHeight(),
                    Image.SCALE_SMOOTH)));
           /* jLabel4.setIcon(new ImageIcon(ImageIO.read(new java.io.File("login.png")
            ).getScaledInstance(jLabel4.getWidth(), jLabel4.getHeight(),
                    Image.SCALE_SMOOTH)));
            jLabel5.setIcon(new ImageIcon(ImageIO.read(new java.io.File("exit.png")
            ).getScaledInstance(jLabel5.getWidth(), jLabel5.getHeight(),
                    Image.SCALE_SMOOTH)));*/
        } catch (IOException ex) {
            System.out.println(ex);}
              
             add(jLabel1);add(jLabel2);add(jLabel3);add(jLabel6);     add(jLabel7);add(jLabel8);
                 add(jButton2);   add(jButton3);    add(jButton4);   add(jButton5);   add(jButton6);   add(jButton7);   add(jButton8); 
              add(jTextField1);add(jTextField2);add(jTextField3);add(jTextField5);
              add(jScrollPane1);add(jTable1);add(backbutton);
              add(jLabel10);
              
                   
     
            Update();
            Update_table();
            fetch();
            fetch1();
            Update_table2();
            show_user();
           
        
    }
 
          
             
            
    
     public ArrayList<User> userList(){
    ArrayList<User> userList = new ArrayList<> ();
    try{
        DataBaseConnection db = new DataBaseConnection();
        String query1="Select * from Admin";
        ResultSet rs=db.stmt.executeQuery(query1);
        User user;
        while(rs.next()){
        user=new User(rs.getInt("Admin_id"),rs.getString("Admin_name"),rs.getString("Admin_address"));
                userList.add(user);
        }
        
    }catch(Exception e){
    JOptionPane.showMessageDialog(null, e);
    }
    return userList;
    }
      public void show_user(){
    ArrayList<User> list = userList();
    DefaultTableModel model =(DefaultTableModel)jTable1.getModel();
    Object[] row = new Object[3];
    for(int i=0;i<list.size();i++){
        row[0]=list.get(i).getadmin_username();
          row[1]=list.get(i).getadmin_password();
            row[2]=list.get(i).getadmin_id();}}
             
     
    /**
     *
     * @return
     */
    public ArrayList<User>userList2(){
    ArrayList<User> userList2 = new ArrayList<> ();
    try{
        DataBaseConnection db = new DataBaseConnection();
        String query1="Select * from AdminLogin";
        ResultSet rs=db.stmt.executeQuery(query1);
        User user;
        while(rs.next()){
        user=new User(rs.getString("Username"),rs.getString("Password"),rs.getInt("Admin_id"));
                userList2.add(user);
        }
        
    }catch(Exception e){
    JOptionPane.showMessageDialog(null, e);
    }
    return userList2;
    }
    public void Update(){
        try{
        String sql="select Admin_id,Admin_name,Admin_address from Admin";
        st=con.prepareStatement(sql);
        rs=st.executeQuery();
        DefaultTableModel model=(DefaultTableModel)display_admin.getModel();
        
        }catch(Exception e){
             JOptionPane.showMessageDialog(null,e);
        }finally{
        try{
        rs.close();
        st.close();
        }
        catch(Exception e){
        }
        }
    }
    public void fetch(){
        sql="select * from Admin";
    try {
       con=Dbase.con;
       st = con.prepareStatement(sql);
       rs=st.executeQuery();
       display_admin.setModel(DbUtils.resultSetToTableModel(rs));
    } catch (Exception e) {
      e.printStackTrace();
    }
      }
    public void fetch1(){
    sql="select * from AdminLogin";
    try{
         con=Dbase.con;
       st = con.prepareStatement(sql);
       rs=st.executeQuery();
       jTable1.setModel(DbUtils.resultSetToTableModel(rs));
    }catch(Exception e){
          e.printStackTrace();
    }
    }
    
  
   

   
    private void Update_table(){
    try{
    String sql="select * from Admin";
    st=con.prepareStatement(sql);
    rs=st.executeQuery();
    DefaultTableModel model =(DefaultTableModel) display_admin.getModel();
    display_admin.setModel(DbUtils.resultSetToTableModel(rs));
    }
    catch(Exception e){
        JOptionPane.showMessageDialog(null,e);
    }
    
    }
    private void Update_table2(){
    try{
    String sql="select * from AdminLogin";
    st=con.prepareStatement(sql);
    rs=st.executeQuery();
    DefaultTableModel model =(DefaultTableModel) jTable1.getModel();
    jTable1.setModel(DbUtils.resultSetToTableModel(rs));
    }
    catch(Exception e){
        JOptionPane.showMessageDialog(null,e);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        display_admin = new javax.swing.JTable();
        backbutton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jTextField5 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1080, 1021));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        display_admin.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3"
            }
        ));
        display_admin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                display_adminMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                display_adminMouseEntered(evt);
            }
        });
        jScrollPane1.setViewportView(display_admin);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 520, 479, 200));

        backbutton.setText("Back");
        backbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backbuttonActionPerformed(evt);
            }
        });
        getContentPane().add(backbutton, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 770, 80, 20));

        jLabel1.setFont(new java.awt.Font("Calibri Light", 0, 18)); // NOI18N
        jLabel1.setText("Admin_id");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 320, 129, -1));

        jLabel2.setFont(new java.awt.Font("Calibri Light", 0, 18)); // NOI18N
        jLabel2.setText("Admin_name");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 360, 129, 28));

        jLabel3.setFont(new java.awt.Font("Calibri Light", 0, 18)); // NOI18N
        jLabel3.setText("Admin_address");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 400, 139, 33));

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 320, 94, -1));

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 360, 94, -1));

        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 410, 94, -1));

        jButton2.setText("Delete");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 410, 99, -1));

        jButton3.setText("Update");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 460, 99, -1));

        jButton4.setText("Clear");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 530, 99, -1));

        jLabel5.setText("jLabel5");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 280, 209, 119));

        jLabel6.setFont(new java.awt.Font("Calibri Light", 0, 36)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("DistriButed SuperShop System");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 200, 540, -1));
        jLabel6.getAccessibleContext().setAccessibleName("Distributed Supershop System");

        jLabel7.setFont(new java.awt.Font("Calibri Light", 0, 36)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Admin Profile\n");
        jLabel7.setMaximumSize(new java.awt.Dimension(307, 36));
        jLabel7.setMinimumSize(new java.awt.Dimension(307, 36));
        jLabel7.setPreferredSize(new java.awt.Dimension(307, 36));
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 300, 223, -1));
        jLabel7.getAccessibleContext().setAccessibleName("   Admin Profile");

        jButton5.setText("View Employee");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 570, 165, -1));

        jButton6.setText("View Admin");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 610, 165, 20));

        jButton7.setText("Customer Registration");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 650, 165, -1));

        jButton8.setText("Customer Management");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 700, -1, -1));

        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 440, 134, 32));

        jLabel8.setText("jLabel8");
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 440, 45, 32));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable1);
        jTable1.getAccessibleContext().setAccessibleName("jTable1");

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 750, 310, 110));

        jLabel10.setText("jLabel1");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 50, 140, 120));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void display_adminMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_display_adminMouseClicked
        // TODO add your handling code here:
        try{
            int row=display_admin.getSelectedRow();
            String Table_click=(display_admin.getModel().getValueAt(row, 0).toString());
            String sql="select * from Admin where Admin_id='"+Table_click+"' ";
            st=con.prepareStatement(sql);
            rs=st.executeQuery();
            if(rs.next()){
            String add1=rs.getString("Admin_id");
            jTextField1.setText(add1);
             String add2=rs.getString("Admin_name");
            jTextField2.setText(add2);
             String add3=rs.getString("Admin_address");
            jTextField3.setText(add3);
            }
        
        
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        
    }//GEN-LAST:event_display_adminMouseClicked

    private void backbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backbuttonActionPerformed
        // TODO add your handling code here:
         try {
            this.setVisible(false);this.dispose();
            new Menu(status).setVisible(true);
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }//GEN-LAST:event_backbuttonActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        try{
            String val1=jTextField1.getText();
            String val2=jTextField2.getText();
            String val3=jTextField3.getText();
            
            String sql="Update Admin set Admin_name='"+val2+"',Admin_address='"+val3+"' where Admin_id='"+val1+"'";
            st=con.prepareStatement(sql);
            st.execute();
            JOptionPane.showMessageDialog(null, "Data Updated");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
                DefaultTableModel model=(DefaultTableModel)display_admin.getModel();
        int row = display_admin.getSelectedRow();

        if(row>-1){
            String id=model.getValueAt(row, 0).toString();
            int c_id=Integer.parseInt(id);
            sql="delete from Admin where Admin_id=?";
            try{
                con=Dbase.con;
                st = con.prepareStatement(sql);
                st.setInt(1, c_id);
                rs=st.executeQuery();
                JOptionPane.showMessageDialog(null, "Data Deleted");
            }
            catch(Exception e2){
                JOptionPane.showMessageDialog(null, "please select the row at first");
            }
            fetch();
        }
        else{
            JOptionPane.showMessageDialog(null, "select the row at first");
        }
     
                                          

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
             
    try {
         String sql="select Admin_address from Admin";
        con=Dbase.con;
        st=con.prepareStatement(sql);
        st.setInt(1,parseInt(jTextField3.getText()));
    }catch(Exception e){
    JOptionPane.showMessageDialog(null, e);}
     
            
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
                 jTextField1.setText(null);
        jTextField2.setText(null);
        jTextField3.setText(null);
       
  
        
       
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
       
        ViewAdmin vv =new ViewAdmin(status);
        vv.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
         this.setVisible(false);this.dispose();
        new CustomerRegistration(status).setVisible(true);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        ViewEmployee v=new ViewEmployee(status);
        v.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);this.dispose();
        new CustomerManagement(status).setVisible(true);
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        // TODO add your handling code here:
        jTextField5.getText();
        sql = "select *  from Admin where Admin_id=?";
        try {
            con=Dbase.con;
            st = con.prepareStatement(sql);
            st.setInt(1,parseInt(jTextField5.getText()));
           
            rs=st.executeQuery();
            display_admin.setModel(DbUtils.resultSetToTableModel(rs));
            st.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jLabel8MouseClicked

    private void display_adminMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_display_adminMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_display_adminMouseEntered

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
               
          String add1=null; 
   try {
         String sql="select Admin_id from Admin";
        con=Dbase.con;
        st=con.prepareStatement(sql);
        st.setInt(1,parseInt(jTextField2.getText()));
        add1 = rs.getString("Admin_id");
    } catch (SQLException ex) {
        Logger.getLogger(ProfileAdmin.class.getName()).log(Level.SEVERE, null, ex);
    }
            jTextField2.setText(add1);
            
            
         
            
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
              String add2=null;
    try {
         String sql="select Admin_name from Admin";
        con=Dbase.con;
        st=con.prepareStatement(sql);
        st.setInt(1,parseInt(jTextField2.getText()));
        add2 = rs.getString("Admin_name");
    } catch (SQLException ex) {
        Logger.getLogger(ProfileAdmin.class.getName()).log(Level.SEVERE, null, ex);
    }
            jTextField2.setText(add2);
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        try{
            int row=jTable1.getSelectedRow();
            String Table_click=(jTable1.getModel().getValueAt(row, 0).toString());
            String sql="select * from AdminLogin";
            st=con.prepareStatement(sql);
            rs=st.executeQuery();
            if(rs.next()){
            String add4=rs.getString("Username");
             String add5=rs.getString("Password");
             String add1=rs.getString("Admin_id");
            jTextField1.setText(add1);
            }
      
        
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        fetch1();
        show_user();
    }//GEN-LAST:event_jTable1MouseClicked
    
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
            java.util.logging.Logger.getLogger(ProfileAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProfileAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProfileAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProfileAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ProfileAdmin(status).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backbutton;
    private javax.swing.JTable display_admin;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField5;
    // End of variables declaration//GEN-END:variables
private ImageIcon format=null;
String filename=null;
int s=0;

private String name;

    private void setText(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
