package databaseAS;

import java.sql.*;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.ClientModel;


public class AuctionSystemDatabase {

    private static String dbUrl = "jdbc:sqlserver://HP-PC:1433;databaseName=AuctionSystem ";
    private static  String dbUsername = "PC-HP";
    private static  String dbPassword = "123321";
    private static Connection dbConnection;

    //Connection to Database
    private static void setConnection(){
        try {
            //System.out.println("Start");
            dbConnection = DriverManager.getConnection(dbUrl,dbUsername,dbPassword);
        }
        catch (SQLException ex) {
            System.out.println("ErrorSQL - Connection to Database.");
        }
    }
    // Message Box
    public static void msgBox(String message) {
        JOptionPane.showMessageDialog(null, message);
    }
    // Error Message Box
    public static void errmsgBox(String message) {
        JOptionPane.showMessageDialog(null, message,"Error",JOptionPane.ERROR_MESSAGE);
    }
    // Set Any Table 
    private static void fillToJTable(String tableNameOrSelectStatement, JTable table){
        try{
            setConnection();
            Statement stmt = dbConnection.createStatement();
            ResultSet records;
            String SPart = tableNameOrSelectStatement.substring(0, 7).toLowerCase();
            String strSelect;
            if( "select ".equals( SPart ) ){
                strSelect = tableNameOrSelectStatement;
            }
            else{
                strSelect = "select * from " + tableNameOrSelectStatement;
            }
            records = stmt.executeQuery(strSelect);
            
            int col = records.getMetaData().getColumnCount();
            
            DefaultTableModel model = (DefaultTableModel)table.getModel();
            
            Vector row = new Vector();
            model.setRowCount(0);
           
            while(records.next()){
                row = new Vector(col);
                for(int i = 1 ; i <= col ; i++){
                    row.add(records.getString(i));
                }
                model.addRow(row);
            }
            if(table.getColumnCount() != col){
                System.out.println("JTable Columns Count Not Equal To Query Columns Count \n JTable Columns Count Is: " 
                        + table.getColumnCount() 
                        + "\n Query Columns Count Is: " + col);
            }
        }
        catch(SQLException ex){
            System.out.println(ex.getMessage());
            //Tools.msgBox(ex.getMessage());
        }
      }

    public static void setTableMyProducts(int id, JTable tableMyProducts) {
        String strSelect =  "SELECT Id , Product,Sold , Price , Details,payee\n" +
                    "FROM Products\n" +
                    "WHERE Id_Client = " + id;       
        fillToJTable (strSelect , tableMyProducts);
    }

    public static void deleteProduct(int idProduct) {
            try{setConnection();
            // Open SQL Server
            Statement stmt = dbConnection.createStatement();
            // Delete Product id = ....
            String strdelt = "DELETE FROM Products WHERE Id = " + idProduct ;
            // Delete Product
            stmt.execute(strdelt);
            // close SQL Server.
            dbConnection.close();
            msgBox("Delete successfully");
        }
        catch(SQLException ex ){
            errmsgBox("Delete failed");
        }
    }

    public static boolean loginClient(String username, String password, ClientModel aThis) {
        try {
            setConnection();
            // Open SQL Server
            Statement stmt = dbConnection.createStatement();
            // Check User Validity form this Username & Password ( in SQL Server ).
            String strCheck = "select * from Clients where "
                    + "Username ='" + username + "' and "
                    + "Password ='" + password + "'";
            ResultSet resultSet = stmt.executeQuery(strCheck);
            while (resultSet.next()) {
                //get and set userInfo  
                int id = resultSet.getInt("Id");
                String name = (String) resultSet.getString("Name");
                String email = (String) resultSet.getString("Email");               
                aThis.SetData(id,name,email,username,password);             
                // close SQL Server.
                dbConnection.close();
                // check successfully.
                return true;
            }
            errmsgBox("Not Found");
            dbConnection.close();
        } catch (SQLException ex) {
            errmsgBox("Not Found");
        }
        // check failed.
        return false;
        
    }
    public static boolean signUpClient(String name, String email, String username, String password, ClientModel aThis) {
       try{
            setConnection();
            // Open SQL Server
            Statement stmt = dbConnection.createStatement();
            // Add User ( in SQL Server ).
            String strAdd = "INSERT INTO Clients (Name,Username,Email,Password) OUTPUT Inserted.Id "
                    + "VALUES ('"+ name + "','" + username + "','" + email + "','" + password + "')";
            // Return ID from this user
            ResultSet resultSetID = stmt.executeQuery(strAdd);
            while( resultSetID.next() ){
                // Get Id from Database.
                int dbId = (int) resultSetID.getInt("Id");
                // set data in User Object.
                aThis.SetData(dbId,name,email,username,password); 
                // close SQL Server.
                dbConnection.close();
                // Add successfully.
                return true;
            }
            dbConnection.close();
        }
        catch(SQLException ex ){
          msgBox("Wrong Username");
        }
        // check failed.
        return false; 
    }

    public static boolean addProduct(int id, String product, String details) {
        try{
            setConnection();
            // Open SQL Server
            Statement stmt = dbConnection.createStatement();
            // Add Product ( in SQL Server ).
            String strAdd = "INSERT INTO Products (Id_Client,product,Details,Price) "
                    + "VALUES ("+ id +",'"+ product + "','" + details +"'," + 0 +")";
            // Add this Product
            stmt.execute(strAdd);
            // close SQL Server.
            dbConnection.close();
            msgBox("Added successfully");
            return true;
        }
        catch(SQLException ex ){
            errmsgBox("Wrong!!");
        }
        // check failed.
        return false;
    }

    public static void setTableUsersBid(int id, JTable tableUsersBid) {
        String strSelect =  "SELECT Id_Client , Price \n" +
                    "FROM Bid\n" +
                    "WHERE Id_Product = " + id;       
        fillToJTable (strSelect , tableUsersBid);
    }

    public static void addNewPrice(int IdProduct, int id, int intPrice) {
        try{
            setConnection();
            // Open SQL Server
            Statement stmt = dbConnection.createStatement();
            // Add NewPrice ( in SQL Server ).
            String strAdd = "INSERT INTO Bid (Id_Product,Id_Client,Price)"
                    + "VALUES (" + IdProduct +","+ id + "," + intPrice+ ")";
            // Add NewPrice
            stmt.execute(strAdd);
            // close SQL Server.
            dbConnection.close();
            msgBox("Added successfully");
        }
        catch(SQLException ex ){
            errmsgBox(ex.getMessage());
        }
        // check failed.
    }

    public static void addStaticPrice (int idProduct, int intPrice, int intId) {
        try {
            setConnection();
            // Open SQL Server
            Statement stmt = dbConnection.createStatement();
            // Update User ( in SQL Server ).
            String strUp = "UPDATE Products SET " +
                    "payee = " + intId + " , " +
                    "Sold = " + 1 + " , " +
                    "Price =" + intPrice + " "+
                    "WHERE Id= " + idProduct ;
            stmt.execute(strUp);
            // close SQL Server.
            dbConnection.close();
            // update successfully.
            msgBox("update successfully");
        }catch (SQLException ex){
            errmsgBox("Update failed");
        }
        // update Profile failed.
    }

    public static void setTablePayee(int id, JTable tableMyProducts) {
        String strSelect =  "SELECT Id , Product,Sold , Price , Details,payee\n" +
                    "FROM Products\n" +
                    "WHERE payee = " + id;       
        fillToJTable (strSelect , tableMyProducts);
    }

    
    
    
}

