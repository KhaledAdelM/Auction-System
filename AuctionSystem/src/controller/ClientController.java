package controller;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import model.*;
import view.*;


public class ClientController implements Runnable{
    private ClientModel clientModel = new ClientModel();
    private ClientView clientView = new ClientView();
    private LoginView loginView = new LoginView();
    private SignUpView signUpView = new SignUpView();
    private NewClientController server;
    private boolean masterBid = false;
    
    ClientController(NewClientController server) {
        this.server = server;
    }
    
     @Override
    public void run() {
        oppForme(loginView , "Login :)");
        //loginView        
            //Login Button
        loginView.loginListener(new LloginListenerButton());
            //Sign UP Button
        loginView.signUpButton(new LsignUpListenerButton());
        
        //SignUpView       
            //Login Button
        signUpView.loginListener(new SloginListenerButton());
            //Sign UP Button
        signUpView.signUpButton(new SsignUpListenerButton());
        
        
        //clientView
        // Set Table My Products
        clientView.viewMyProducts(new viewMyProductsListenerButton());
        // Set Table Payee
        clientView.viewPayee (new viewPayeeListenerButton());
        // Delete My Product
        clientView.deleteMyProduct(new deleteMyProductListenerButton());
        // go To Add Products
        clientView.vAddProduct(new vAddProductListenerButton());
        //Add Products
        clientView.addProduct(new addProductListenerButton());
        //make Bid
        clientView.makeBid(new makeBidListenerButton());
        //view Bid
        clientView.viewBid(new viewBidListenerButton());
        //Add new New Price 
        clientView.addNewPrice(new addNewPriceListenerButton());
    }
    private void setFullName (){
       clientView.setFullName (clientModel.getName());
       
       
    }
    
    //public ClientController () {}
    public void setBidProduct(int id, String name, String details){
        clientView.setIdBid (id+"");
        clientView.setProductBid (name);
        clientView.setDetailsBid(details);
        clientView.addNewPriceEnableInput(true);
        setTableUsersBid ( id);
    }
    public void setTableUsersBid (int id){
        clientModel.setTableUsersBid(id,clientView.getTableUsersBid());
    }
    public void goToMyProducts (){
        clientModel.viewMyProducts(clientView.getTableMyProducts());
        clientView.goToMyProducts();
    }
    
    public void setPriceOfProduct (){
        if(masterBid){
            String [] prices = clientView.getPrices ( );
            String [] ids = clientView.getIds ( );
            clientModel.addStaticPrice(prices,ids,clientView.getIdProduct());
            masterBid = false;
        }
    }
    // open Frame
     public static void oppForme (JFrame jFrame , String title){
        try {
            jFrame.setLocationRelativeTo(null);
            Image img = ImageIO.read(ClientController.class.getResource("Logo.png"));
            jFrame.setIconImage(img);
            jFrame.setTitle(title);
            //JFrame.setDefaultLookAndFeelDecorated(true);
            jFrame.setVisible(true);
        } catch (IOException ex) {       }
    }

    void setTimer(int i) {
        clientView.setTimer(i);
    }

   
    
    private class LloginListenerButton implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent e) {
                String username = loginView.getUsername();
                String password = loginView.getPassword ();              
                boolean loginClient = clientModel.loginClient(username, password);
                if (loginClient){
                    setFullName ();
                    oppForme(clientView , "Auction System :)");
                    loginView.setVisible(!loginClient);
                }
            }
    }
    private class LsignUpListenerButton implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent e) {
                loginView.setVisible(false);
                oppForme(signUpView , "Hi .. SignUp :)");               
            }
    }
    private class SsignUpListenerButton implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent e) {
                String username = signUpView.getUsername();
                String password = signUpView.getPassword ();
                String email = signUpView.getEmail();
                String name = signUpView.getFullName ();
                boolean signUpClient = clientModel.signUpClient(name,email,username, password);
                if (signUpClient){
                    setFullName ();
                    oppForme(clientView , "Auction System :)");
                    signUpView.setVisible(!signUpClient);
                }              
            }
            
    }
    private class SloginListenerButton implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent e) {
                signUpView.setVisible(false);
                oppForme(loginView , "Login :)");               
            }
            
    }
    private class viewMyProductsListenerButton implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            clientModel.viewMyProducts(clientView.getTableMyProducts());
            clientView.goToMyProducts ();
        }
    }
    private class viewPayeeListenerButton implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            clientModel.viewPayee(clientView.getTableMyProducts());
            clientView.goToMyProducts ();
        }
    }
    private class deleteMyProductListenerButton implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            int idProduct = clientView.getIdMyProduct() ;
            if(idProduct!=0) clientModel.deleteProduct(idProduct);
            clientModel.viewMyProducts(clientView.getTableMyProducts());          
        }
    }
    private class vAddProductListenerButton implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            clientView.SetMyIdAddProduct(clientModel.getId()+"");
            clientView.goToAddProducts();         
        }
    }
    private class addProductListenerButton implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String p = clientView.getProduct();
            String d = clientView.getDetails();
            boolean che = clientModel.addProduct(p,d);
            if(che) clientView.emptyTextAddProduct();
        }
    }
    private class makeBidListenerButton implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if(!server.getCheBid()&& clientView.soldProductInTable() == 0){
                server.setCheBid(true);
                int id = clientView.idProductInTable();
                    if(id !=0){
                        String nameProduct = clientView.nameProductInTable();
                        String detailsProduct = clientView.detailsProductInTable();
                        server.startBid(id, nameProduct, detailsProduct);
                        clientView.goToBid();
                        clientView.addNewPriceEnableInput(false);
                        masterBid = true;                              
                }
            }else{
                System.out.println("Anther User");
            }
        }
    }
    private class viewBidListenerButton implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (server.getCheBid()){
                 server.startBid();
                clientView.goToBid();
            }else {
                System.out.println("not Start yet");
            }
        }
    }
    private class addNewPriceListenerButton implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String strPrice = clientView.getNewPrice();
            int intPrice = Integer.parseInt(strPrice);
            clientModel.addNewPrice(clientView.getIdProduct(),intPrice);
            server.reSetTableUsersBid(clientView.getIdProduct());
        }
    }
    
    
}
