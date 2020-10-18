/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package distributedsupershop;


import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import java.sql.Blob;
import java.sql.Timestamp;
import java.util.Date;

/**
 *
 * @author DAFFODIL
 * 
 */

class User {
    private int receipt_id,customer_id,product_id;
    private String unit;
    private float amount;
    private Timestamp time;
    private int Employee_id,Salary;
    private String Employee_name,Employee_address,Employee_post;
    private Date Joining_date;
    private int Admin_id;
    private String Admin_name;
    private String Admin_address;
    private String Username;
    private String Password;
    
   
    public User(int receipt_id,int customer_id,int product_id,String unit,float amount,Timestamp time){
    this.receipt_id=receipt_id;
    this.customer_id=customer_id;
    this.product_id=product_id;
    this.unit=unit;
    this.amount=amount;
    this.time=time;
  
    
    
    
    }

    public User(int Employee_id,String Employee_name,String Employee_address,String Employee_post,int Salary,Date Joining_date){
        this.Employee_id=Employee_id;
        this.Employee_name=Employee_name;
        this.Employee_address=Employee_address;
        this.Employee_post=Employee_post;
        this.Salary=Salary;
        this.Joining_date=Joining_date;
        
    }
    public User(String Username,String Password,int Admin_id){
    this.Username=Username;
    this.Password=Password;
    this.Admin_id=Admin_id;
    
    }
     public String getadmin_username(){
      return Username;}
      public String getadmin_password(){
      return Password;}
      
     
     
      public User(int Admin_id,String Admin_name,String Admin_address){
        this.Admin_id=Admin_id;
        this.Admin_name=Admin_name;
        this.Admin_address=Admin_address;
        }
      public int getemployee_id(){
      return Employee_id;}
       public String getemployee_name(){
      return Employee_name;}
        public String getemployee_address(){
      return Employee_address;}
         public String getemployee_post(){
      return Employee_post;}
          public int getemployee_salary(){
      return Salary;}
           public Date getemployee_date(){
      return Joining_date;}
         
   
   public int getadmin_id(){
       return Admin_id;
   }
    public String getadmin_name(){
       return Admin_name;
   }
     public String getadmin_address(){
       return Admin_address;
   }
    
    public int getreceipt_id(){
    return receipt_id;
    }
    public int getcustomer_id(){
    return customer_id;
    }
    public int getproduct_id(){
    return product_id;
    }
    public String get_unit(){
    return unit;
    }
    public float get_amount(){
    return amount;
    }
    public Timestamp get_time(){
    return time;
    }

    

   
    
    
    
}
