
package controller;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import view.NewClientView;


public class NewClientController {

    private NewClientView newClientView = new NewClientView();
    private int index = 0;
    private final ArrayList <Boolean> cheBid = new ArrayList<>();
    private int idBid;
    private String nameBid;
    private String detailsbid;
    private static java.util.List<ClientController> Clients = new ArrayList<>();


    
     public NewClientController () {
         System.out.println("Start Server");
        oppForme(newClientView , "Server");
        cheBid.add(false);
        
        
        //Login Button
        this.newClientView.newClient (new newClient());       
    }

    public void startBid(int id, String nameProduct, String detailsProduct) {
        idBid = id;
        nameBid = nameProduct;
        detailsbid = detailsProduct;
        for (ClientController client : Clients){
            client.setBidProduct(id, nameProduct, detailsProduct);
        }
        Timer timer = new Timer();
        TimerTask task = new TimerSandE(timer);     
        timer.schedule(task, 3000, 3000);  
    }
    public void startBid(){
        for (ClientController client : Clients){
            client.setBidProduct(idBid, nameBid, detailsbid);
        }
    }
    

    public void reSetTableUsersBid(int id) {
        for (ClientController client : Clients){
            client.setTableUsersBid(id);
        }
    }
    
    class TimerSandE extends TimerTask
    {
        private int i = 5;
        private Timer timer;

        private TimerSandE(Timer timer) {
            this.timer = timer;
        }
        public void run()
        {
            for (ClientController client : Clients){
                client.setTimer(i);
            }
            i--;
            if(i==0){
                for (ClientController client : Clients){
                    client.goToMyProducts();
                }
                setCheBid(false);
                for (ClientController client : Clients){
                    client.setPriceOfProduct();
                    
                }               
                timer.cancel();
            }
        }      
    }
    private  class newClient implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            ClientController newClient = new ClientController(NewClientController.this);
            Clients.add(newClient);
            Thread runClient = new Thread(newClient);
            runClient.start();      
        }
    }
    public boolean getCheBid (){
        synchronized(cheBid){
            return cheBid.get(index);
        }       
    }
    public void setCheBid (boolean newCheBid){        
        synchronized(cheBid){
            cheBid.add(newCheBid);
            index ++;
        }
        
    }
      
    // open Frame
    private static void oppForme (JFrame jFrame , String title){
        try {
            jFrame.setLocationRelativeTo(null);
            Image img = ImageIO.read(ClientController.class.getResource("Logo.png"));
            jFrame.setIconImage(img);
            jFrame.setTitle(title);
            //JFrame.setDefaultLookAndFeelDecorated(true);
            jFrame.setVisible(true);
        } catch (IOException ex) {       }
    }
    
    
}
