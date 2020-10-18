/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package distributedsupershop;
import java.sql.*;
import javax.swing.JOptionPane;
/**
 *
 * @author ASUS
 */
public class DataBaseConnection {

    Connection con;
    Statement stmt,stmt2;
    PreparedStatement pstmt;
    ResultSet rs,rs2;
    //PartialStatement parStmt;
    
    public DataBaseConnection() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");

            con = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:orcl", "ds", "Oracle_1"); //change "oracle" to "orcl" depening on sid

            stmt = con.createStatement();
            stmt2 = con.createStatement();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
}
