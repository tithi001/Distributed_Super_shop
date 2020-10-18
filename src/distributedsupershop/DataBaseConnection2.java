/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package distributedsupershop;
import java.sql.*;
import java.util.ArrayList;
/**
 *
 * @author ASUS
 */
public class DataBaseConnection2 {

    Connection con;
    Statement stmt;
    PreparedStatement pst;
    ResultSet rs;
    String url = "jdbc:oracle:thin:@localhost:1521:orcl";  //change "oracle" to "orcl" depending on sid

    String id = "ds";
    String password = "Oracle_1";
    String sql;
    
    public DataBaseConnection2() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");

            con = DriverManager.getConnection(url, id, password);

            stmt = con.createStatement();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
    

    
    public Connection getConnection() {
           try {
               Class.forName("oracle.jdbc.driver.OracleDriver");
               con = DriverManager.getConnection(url, id, password);
           } catch (ClassNotFoundException | SQLException e) {
               e.printStackTrace();
           }
           if (con != null) {
               //System.out.println("Connection established, database uplink is online.");
           } else {
               System.out.println("Connection failed, please check database status.");
           }
           return con;
       }

       public ArrayList getBranchList() {
           ArrayList<String> list = new ArrayList<>();
           sql = "SELECT * FROM branches";

           Connection conn = getConnection();
           try {
               pst = conn.prepareStatement(sql);
               rs = pst.executeQuery(sql);

               while (rs.next()){
                   list.add(rs.getString(2));
               }

           } catch (Exception e) {
               System.out.println(e);
           }

           return list;
       }
       
        public ResultSet getDiscountList() {
           ArrayList<String> list = new ArrayList<>();
           sql = "SELECT * FROM DISCOUNT";
           rs = null;
           Connection conn = getConnection();
           try {
               pst = conn.prepareStatement(sql);
               rs = pst.executeQuery(sql);

           } catch (Exception e) {
               System.out.println(e);
           }

           return rs;
       }
       
       public String getBranchInfo(String branch_name) {
           ArrayList<String> list = new ArrayList<>();
           branch_name = "'"+branch_name+"'";
           sql = "SELECT * FROM branches where branch_name = " + branch_name;
           String result = "";
           
           Connection conn = getConnection();
           try {
               pst = conn.prepareStatement(sql);
               rs = pst.executeQuery(sql);

               while (rs.next()){
                   result += "BranchID: "+rs.getInt(1)+"\nBranch Name: "+rs.getString(2)+"\nLocation: "+rs.getString(3)+"\nIP: "+rs.getString(4)+"\nPort: "+rs.getInt(5)+"\n";
               }

           } catch (Exception e) {
               System.out.println(e);
           }

           return result;
       }
       
        public String updateBranchIP(String ip, int port, int branch_id) {
           
           sql = "UPDATE Branches\n" + "SET BRANCH_IPADDRESS = '" + ip + "', BRANCH_PORT=" + port + "\n  WHERE BRANCH_ID =" + branch_id;

           Connection conn = getConnection();
           try {
               pst = conn.prepareStatement(sql);
               rs = pst.executeQuery(sql);

               return "success";

           } catch (Exception e) {
               return e.toString();
           }

       }
        
        
       public String getBranchIp(String branch_name) {
           ArrayList<String> list = new ArrayList<>();
           branch_name = "'"+branch_name+"'";
           sql = "SELECT * FROM branches where branch_name = " + branch_name;
           String result = "null";
           
           Connection conn = getConnection();
           try {
               pst = conn.prepareStatement(sql);
               rs = pst.executeQuery(sql);

               while (rs.next()){
                   result = rs.getString(4);
               }

           } catch (Exception e) {
               System.out.println(e);
           }

           return result;
       }
       
        public int getBranchPort(String branch_name) {
           ArrayList<String> list = new ArrayList<>();
           branch_name = "'"+branch_name+"'";
           sql = "SELECT * FROM branches where branch_name = " + branch_name;
           int result = 0;
           
           Connection conn = getConnection();
           try {
               pst = conn.prepareStatement(sql);
               rs = pst.executeQuery(sql);

               while (rs.next()){
                   result += rs.getInt(5);
               }

           } catch (Exception e) {
               System.out.println(e);
           }

           return result;
       }

        public String updateBranch(String ip, int port, String branch_name, String new_branch_name) {
           ArrayList<String> list = new ArrayList<>();
           branch_name = "'"+branch_name+"'";
           new_branch_name = "'"+new_branch_name+"'";
           ip = "'"+ip+"'";
           sql = "update branches set branch_ipaddress = " + ip + ", branch_port = " + port + ", branch_name = " + new_branch_name + "where branch_name = " + branch_name;
           String result = "failure";
           
           Connection conn = getConnection();
           try {
               pst = conn.prepareStatement(sql);
               rs = pst.executeQuery(sql);

               result = "Success";

           } catch (Exception e) {
               System.out.println(e);
           }

           return result;
       }
        
       public String createBranch(int id, String name, String location, String ip, int port) {
           name = "'" + name + "'";
           ip = "'" + ip + "'";
           location = "'" + location + "'";
           sql = "insert into Branches(Branch_id,Branch_name,Branch_location, branch_ipaddress, branch_port) values("+id+" ,"+name+" ,"+location+" ,"+ip+", "+port+")";
           String result = "failure";
           
           Connection conn = getConnection();
           try {
               pst = conn.prepareStatement(sql);
               rs = pst.executeQuery(sql);

               result = "Success";
                System.out.println(id+","+name+","+location+","+ip+","+port);

           } catch (Exception e) {
               System.out.println(e);
           }

           return result;
       }
        
        
        public String deleteBranch(String branch_name) {
           ArrayList<String> list = new ArrayList<>();
           branch_name = "'"+branch_name+"'";
           sql = "delete from branches where branch_name = " + branch_name;
           String result = "failure";
           
           Connection conn = getConnection();
           try {
               pst = conn.prepareStatement(sql);
               rs = pst.executeQuery(sql);

               result = "Success!\n" + branch_name + "branch deleted...";

           } catch (Exception e) {
               System.out.println(e);
           }

           return result;
       }

    
}
