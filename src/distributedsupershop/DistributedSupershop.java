/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package distributedsupershop;

import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ASUS
 */

class Temp implements Runnable{

    @Override
    public void run() {
        try {
            sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Temp.class.getName()).log(Level.SEVERE, null, ex);
        }
        Server server = new Server();
    }
    
}

public class DistributedSupershop {
    
    public static void main(String[] args) throws InterruptedException {
        Thread t=new Thread(new Temp());
        t.start();
        System.out.println("main");    
        Welcome w=new Welcome();
        w.setVisible(true);
//        Discount d = new Discount(0);
//        d.setVisible(true);
//        Discount d1 = new Discount(1);
//        d1.setVisible(true);
    }
    
}
