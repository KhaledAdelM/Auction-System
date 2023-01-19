package model;

import databaseAS.AuctionSystemDatabase;
import javax.swing.JTable;


public class ClientModel {
    private int id;
    private String name;
    private String email;
    private String birthday;
    private String username;
    private  String password;
    
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public boolean loginClient (String username , String password) {
        boolean chUser =  AuctionSystemDatabase.loginClient( username ,  password , ClientModel.this);
        return chUser;
    }
     public boolean signUpClient(String name, String email, String username, String password) {
        boolean chUser =  AuctionSystemDatabase.signUpClient(  name,  email,  username,  password , ClientModel.this);
        return chUser;
    }

    public void viewMyProducts(JTable tableMyProducts) {
        AuctionSystemDatabase.setTableMyProducts(id,tableMyProducts);
    }
    public void deleteProduct(int idProduct) {
        AuctionSystemDatabase.deleteProduct(idProduct);
    }

    public void SetData(int id, String name, String email, String username, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.username = username;
        this.password = password;
    }

    public boolean addProduct(String product, String details) {
       return  AuctionSystemDatabase.addProduct( id, product, details);
    }

    public void setTableUsersBid(int id, JTable tableUsersBid) {
        AuctionSystemDatabase.setTableUsersBid( id,  tableUsersBid);
    }

    public void addNewPrice(int IdProduct ,int intPrice) {
        AuctionSystemDatabase.addNewPrice(IdProduct,id, intPrice);
    }

    public void addStaticPrice(String[] prices, String[] ids, int idProduct) {
        String[] price = mixPrice(prices);
        int intPrice = Integer.parseInt(price[0]);
        int intId = Integer.parseInt(ids[(Integer.parseInt(price[1]))]);
        AuctionSystemDatabase.addStaticPrice(idProduct,intPrice,intId);
    }

    public String[] mixPrice (String[] prices) {
        int i=0,intIndex=0;
        int intPrices = Integer.parseInt(prices[0]);
        for(String p :prices ){
            int Price = Integer.parseInt(p);
            if (intPrices<Price){
                intPrices = Price;
                intIndex=i;
            }
            i++;
        }
        String strPrices = intPrices + "";
        String strIndex = intIndex +"";
        String [] r = {strPrices,strIndex}; 
        return r;
    }

    public void viewPayee(JTable tableMyProducts) {
        AuctionSystemDatabase.setTablePayee(id,tableMyProducts);
    }
   
    
}
