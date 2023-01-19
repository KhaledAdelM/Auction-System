
package view;

import java.awt.CardLayout;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Khaled-HP
 */
public class ClientView extends javax.swing.JFrame {

    private CardLayout cardLayoutPage;
    private DefaultTableModel dtmMyProducts = new DefaultTableModel();
    private DefaultTableModel dtmUsersBid = new DefaultTableModel();

    public ClientView() {
        initComponents();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        cardLayoutPage = (CardLayout) (jPanelRight.getLayout());
        // Create students Table
        String [] myProductsColumns = {"Id","Product","Sold","Price","Details","Payee"};
        setColumn(dtmMyProducts, jTableMyProducts ,myProductsColumns);
        String [] usersBidColumns = {"Id_Client","Price"};
        setColumn(dtmUsersBid, jTableUsersBid ,usersBidColumns);
    }
    
    // set style and Column of Tables
    private void setColumn(DefaultTableModel tableModel, JTable jTable,String [] columns){
        jTable.setModel(tableModel);
        jTable.getTableHeader().setReorderingAllowed(false); // not allow re-ordering of columns
        for (String column :columns){
            tableModel.addColumn(column);
        }
    }
    //------------
    public void goToMyProducts (){
        cardLayoutPage.show(jPanelRight, "MyProducts");
    }
    public void goToAddProducts (){
        cardLayoutPage.show(jPanelRight, "addProduct");
    }
    public void goToBid (){
        cardLayoutPage.show(jPanelRight, "Bid");       
    }
    
    //-----------
    // Message Box
    public static void msgBox(String message) {
        JOptionPane.showMessageDialog(null, message);
    }
    // Error Message Box
    public static void errmsgBox(String message) {
        JOptionPane.showMessageDialog(null, message,"Error",JOptionPane.ERROR_MESSAGE);
    }
    //-----------
    public JTable getTableMyProducts (){
        return jTableMyProducts;
    }
    public void viewMyProducts (ActionListener viewMyProductsListenerButton) {
        myProductsButton.addActionListener(viewMyProductsListenerButton);            
    }
    public void viewPayee (ActionListener viewPayeeListenerButton) {
        buttonPayee.addActionListener(viewPayeeListenerButton);            
    }
    public int getIdMyProduct() {
        try{
        int numOfRow = jTableMyProducts.getSelectedRow();
        int idMyProduct = Integer.parseInt((String) jTableMyProducts.getModel().getValueAt(numOfRow, 0));
        return idMyProduct;
        }catch(ArrayIndexOutOfBoundsException ex){
            msgBox("Select Product ^-^");
        }
        return 0;
    }
    public void deleteMyProduct (ActionListener deleteMyProductListenerButton) {
        buttonDeleteMyProduct.addActionListener(deleteMyProductListenerButton);            
    }
    public int getIdProduct (){
        return Integer.parseInt(idBid.getText());
    }
    // --------  ------- ----- ------- --------
    public int idProductInTable (){
        try{
        int numOfRow = jTableMyProducts.getSelectedRow();
        int idProduct = Integer.parseInt((String) jTableMyProducts.getModel().getValueAt(numOfRow, 0));
        return idProduct;
        }catch(ArrayIndexOutOfBoundsException ex){}
        return 0;
    }
    public String nameProductInTable (){
        try{
        int numOfRow = jTableMyProducts.getSelectedRow();
        String nameProduct = (String) jTableMyProducts.getModel().getValueAt(numOfRow, 1);
        return nameProduct;
        }catch(ArrayIndexOutOfBoundsException ex){}
        return "";
    }
    public int soldProductInTable (){
        try{
        int numOfRow = jTableMyProducts.getSelectedRow();
        int soldProduct = Integer.parseInt((String) jTableMyProducts.getModel().getValueAt(numOfRow, 2));
        return soldProduct;
        }catch(ArrayIndexOutOfBoundsException ex){}
        return -1;
    }
    public String detailsProductInTable (){
        try{
        int numOfRow = jTableMyProducts.getSelectedRow();
        String details = (String) jTableMyProducts.getModel().getValueAt(numOfRow, 3);
        return details;
        }catch(ArrayIndexOutOfBoundsException ex){}
        return "";
    }
    public void makeBid (ActionListener makeBidListenerButton) {
        buttonMakeBid.addActionListener(makeBidListenerButton);            
    }
    public void viewBid (ActionListener viewBidListenerButton) {
        bidButton.addActionListener(viewBidListenerButton);            
    }
    public JTable getTableUsersBid (){
        return jTableUsersBid;
    }
    public String getNewPrice (){
        return addNewPrice.getText();
    }
    public void addNewPrice (ActionListener addNewPriceListenerButton) {
        buttonAddPriceBid.addActionListener(addNewPriceListenerButton);            
    }
    public void setTimer (int t){
        Timer.setText(t+"");
    }
    public String[] getPrices ( ){
        int rowCount = jTableUsersBid.getRowCount();
        String[] prices = new String[rowCount];
        int i = 0;
        while(i<rowCount){    
           prices[i] = (String) jTableUsersBid.getModel().getValueAt(i, 1);
           i++;
        }
        return prices;
    }
    public String[] getIds ( ){
        int rowCount = jTableUsersBid.getRowCount();
        String[] ids = new String[rowCount];
        int i = 0;
        while(i<rowCount){    
           ids[i] = (String) jTableUsersBid.getModel().getValueAt(i, 0);
           i++;
        }
        return ids;
    }
    // --------  ------- ----- ------- --------
    public void vAddProduct (ActionListener vAddProductListenerButton) {
        addProductButton.addActionListener(vAddProductListenerButton);            
    }
    public void addProduct (ActionListener addProductListenerButton) {
        buttonAddProduct.addActionListener(addProductListenerButton);            
    }
    public void SetMyIdAddProduct (String id){
        myIdAddProduct.setText(id);
    }
    public String getProduct (){
        return productAddProduct.getText();
    }
    public String getDetails (){
        return detailsAddProduct.getText();
    }
    public void emptyTextAddProduct (){
        productAddProduct.setText("");
        detailsAddProduct.setText("");
    }
    
    public void setIdBid (String id){
        idBid.setText(id);
    }
    public void setProductBid (String name){
        productBid.setText(name);
    }
    public void setDetailsBid(String details){
        detailsBid.setText(details);
    }
    public void addNewPriceEnableInput (boolean enableInput){
        addNewPrice.setEnabled(enableInput);
    }
    public void setFullName (String name){
        fullNameJLabel.setText("Hi .. " + name);
    }    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSplitPane1 = new javax.swing.JSplitPane();
        jPanelLeft = new javax.swing.JPanel();
        LogoImg = new javax.swing.JLabel();
        fullNameJLabel = new javax.swing.JLabel();
        homeButton = new javax.swing.JButton();
        addProductButton = new javax.swing.JButton();
        myProductsButton = new javax.swing.JButton();
        bidButton = new javax.swing.JButton();
        LogOutButton = new javax.swing.JButton();
        jPanelRight = new javax.swing.JPanel();
        HomejPanelRight = new javax.swing.JPanel();
        LogoImg1 = new javax.swing.JLabel();
        MyProductsjPanelRight = new javax.swing.JPanel();
        viewMyProduct = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        buttonMakeBid = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableMyProducts = new javax.swing.JTable();
        buttonDeleteMyProduct = new javax.swing.JButton();
        buttonPayee = new javax.swing.JButton();
        addProductJPanelRight = new javax.swing.JPanel();
        Img4 = new javax.swing.JLabel();
        Username4 = new javax.swing.JLabel();
        myIdAddProduct = new javax.swing.JTextField();
        productAddProduct = new javax.swing.JTextField();
        Productee = new javax.swing.JLabel();
        buttonAddProduct = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        detailsAddProduct = new javax.swing.JTextField();
        Username7 = new javax.swing.JLabel();
        bidJPanelRight = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        buttonAddPriceBid = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableUsersBid = new javax.swing.JTable();
        addNewPrice = new javax.swing.JTextField();
        Username5 = new javax.swing.JLabel();
        idBid = new javax.swing.JTextField();
        Productee1 = new javax.swing.JLabel();
        productBid = new javax.swing.JTextField();
        detailsBid = new javax.swing.JTextField();
        Username8 = new javax.swing.JLabel();
        Timer = new javax.swing.JLabel();
        Timer1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jSplitPane1.setDividerLocation(275);
        jSplitPane1.setDividerSize(0);
        jSplitPane1.setEnabled(false);

        jPanelLeft.setBackground(new java.awt.Color(15, 25, 38));
        jPanelLeft.setPreferredSize(new java.awt.Dimension(275, 750));

        LogoImg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/Logo.png"))); // NOI18N

        fullNameJLabel.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        fullNameJLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        fullNameJLabel.setText("Hi, Full Name");
        fullNameJLabel.setToolTipText("");

        homeButton.setBackground(new java.awt.Color(34, 100, 115));
        homeButton.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        homeButton.setForeground(new java.awt.Color(255, 255, 255));
        homeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/icons8_home_16px.png"))); // NOI18N
        homeButton.setText("Home");
        homeButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        addProductButton.setBackground(new java.awt.Color(15, 25, 38));
        addProductButton.setFont(new java.awt.Font("Roboto Slab", 0, 12)); // NOI18N
        addProductButton.setForeground(new java.awt.Color(255, 255, 255));
        addProductButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/icons8_product_documents_16px.png"))); // NOI18N
        addProductButton.setText("Add Product");
        addProductButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        myProductsButton.setBackground(new java.awt.Color(15, 25, 38));
        myProductsButton.setFont(new java.awt.Font("Roboto Slab", 0, 12)); // NOI18N
        myProductsButton.setForeground(new java.awt.Color(255, 255, 255));
        myProductsButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/icons8_product_16px.png"))); // NOI18N
        myProductsButton.setText("My Products");
        myProductsButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        bidButton.setBackground(new java.awt.Color(15, 25, 38));
        bidButton.setFont(new java.awt.Font("Roboto Slab", 1, 18)); // NOI18N
        bidButton.setForeground(new java.awt.Color(255, 255, 255));
        bidButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/icons8_product_loading_20px.png"))); // NOI18N
        bidButton.setText("Bid");
        bidButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        LogOutButton.setBackground(new java.awt.Color(15, 25, 38));
        LogOutButton.setFont(new java.awt.Font("Roboto Slab", 0, 12)); // NOI18N
        LogOutButton.setForeground(new java.awt.Color(255, 255, 255));
        LogOutButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/icons8_logout_rounded_left_16px.png"))); // NOI18N
        LogOutButton.setText("LogOut");
        LogOutButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        LogOutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogOutButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelLeftLayout = new javax.swing.GroupLayout(jPanelLeft);
        jPanelLeft.setLayout(jPanelLeftLayout);
        jPanelLeftLayout.setHorizontalGroup(
            jPanelLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(LogoImg, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(homeButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(bidButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(myProductsButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanelLeftLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(fullNameJLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(addProductButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(LogOutButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanelLeftLayout.setVerticalGroup(
            jPanelLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLeftLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(fullNameJLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LogoImg)
                .addGap(29, 29, 29)
                .addComponent(homeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bidButton, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(myProductsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(addProductButton, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 330, Short.MAX_VALUE)
                .addComponent(LogOutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jSplitPane1.setLeftComponent(jPanelLeft);

        jPanelRight.setPreferredSize(new java.awt.Dimension(1005, 750));
        jPanelRight.setLayout(new java.awt.CardLayout());

        HomejPanelRight.setPreferredSize(new java.awt.Dimension(1005, 720));

        LogoImg1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LogoImg1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/Logo2.png"))); // NOI18N

        javax.swing.GroupLayout HomejPanelRightLayout = new javax.swing.GroupLayout(HomejPanelRight);
        HomejPanelRight.setLayout(HomejPanelRightLayout);
        HomejPanelRightLayout.setHorizontalGroup(
            HomejPanelRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(LogoImg1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        HomejPanelRightLayout.setVerticalGroup(
            HomejPanelRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HomejPanelRightLayout.createSequentialGroup()
                .addGap(98, 98, 98)
                .addComponent(LogoImg1, javax.swing.GroupLayout.DEFAULT_SIZE, 646, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanelRight.add(HomejPanelRight, "home");

        MyProductsjPanelRight.setPreferredSize(new java.awt.Dimension(1005, 720));

        viewMyProduct.setPreferredSize(new java.awt.Dimension(1005, 720));

        jLabel3.setFont(new java.awt.Font("Roboto Slab Medium", 1, 24)); // NOI18N
        jLabel3.setText("My Products:");

        buttonMakeBid.setFont(new java.awt.Font("Roboto Slab Medium", 0, 14)); // NOI18N
        buttonMakeBid.setForeground(new java.awt.Color(255, 255, 255));
        buttonMakeBid.setText("MakeBid");

        jTableMyProducts.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTableMyProducts);

        buttonDeleteMyProduct.setFont(new java.awt.Font("Roboto Slab Medium", 0, 14)); // NOI18N
        buttonDeleteMyProduct.setForeground(new java.awt.Color(255, 255, 255));
        buttonDeleteMyProduct.setText("Delete");

        buttonPayee.setFont(new java.awt.Font("Roboto Slab Medium", 0, 14)); // NOI18N
        buttonPayee.setForeground(new java.awt.Color(255, 255, 255));
        buttonPayee.setText("Payee");

        javax.swing.GroupLayout viewMyProductLayout = new javax.swing.GroupLayout(viewMyProduct);
        viewMyProduct.setLayout(viewMyProductLayout);
        viewMyProductLayout.setHorizontalGroup(
            viewMyProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(viewMyProductLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(viewMyProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(viewMyProductLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 993, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, viewMyProductLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(buttonMakeBid, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttonDeleteMyProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttonPayee, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(245, 245, 245))
        );
        viewMyProductLayout.setVerticalGroup(
            viewMyProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(viewMyProductLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 605, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(viewMyProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonMakeBid, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonDeleteMyProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonPayee, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35))
        );

        javax.swing.GroupLayout MyProductsjPanelRightLayout = new javax.swing.GroupLayout(MyProductsjPanelRight);
        MyProductsjPanelRight.setLayout(MyProductsjPanelRightLayout);
        MyProductsjPanelRightLayout.setHorizontalGroup(
            MyProductsjPanelRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(viewMyProduct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        MyProductsjPanelRightLayout.setVerticalGroup(
            MyProductsjPanelRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(viewMyProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 750, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanelRight.add(MyProductsjPanelRight, "MyProducts");

        addProductJPanelRight.setPreferredSize(new java.awt.Dimension(1005, 720));

        Img4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Img4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/AddProducts.png"))); // NOI18N

        Username4.setFont(new java.awt.Font("Roboto Medium", 0, 12)); // NOI18N
        Username4.setText("My_ID");

        Productee.setFont(new java.awt.Font("Roboto Medium", 0, 12)); // NOI18N
        Productee.setText("Product:");

        buttonAddProduct.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        buttonAddProduct.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/icons8_add_32px.png"))); // NOI18N
        buttonAddProduct.setText("Add");

        jLabel2.setFont(new java.awt.Font("Roboto Slab Medium", 1, 24)); // NOI18N
        jLabel2.setText("Add Product:");

        Username7.setFont(new java.awt.Font("Roboto Medium", 0, 12)); // NOI18N
        Username7.setText("Details:");

        javax.swing.GroupLayout addProductJPanelRightLayout = new javax.swing.GroupLayout(addProductJPanelRight);
        addProductJPanelRight.setLayout(addProductJPanelRightLayout);
        addProductJPanelRightLayout.setHorizontalGroup(
            addProductJPanelRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addProductJPanelRightLayout.createSequentialGroup()
                .addGroup(addProductJPanelRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Img4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(addProductJPanelRightLayout.createSequentialGroup()
                        .addGroup(addProductJPanelRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(addProductJPanelRightLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel2))
                            .addGroup(addProductJPanelRightLayout.createSequentialGroup()
                                .addGap(433, 433, 433)
                                .addComponent(buttonAddProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(addProductJPanelRightLayout.createSequentialGroup()
                                .addGap(344, 344, 344)
                                .addComponent(Username7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(detailsAddProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addProductJPanelRightLayout.createSequentialGroup()
                .addGap(0, 190, Short.MAX_VALUE)
                .addComponent(Username4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(myIdAddProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addComponent(Productee)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(productAddProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(187, 187, 187))
        );
        addProductJPanelRightLayout.setVerticalGroup(
            addProductJPanelRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addProductJPanelRightLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(1, 1, 1)
                .addComponent(Img4)
                .addGap(30, 30, 30)
                .addGroup(addProductJPanelRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Username4)
                    .addComponent(myIdAddProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Productee)
                    .addComponent(productAddProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(addProductJPanelRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Username7)
                    .addComponent(detailsAddProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttonAddProduct)
                .addContainerGap(58, Short.MAX_VALUE))
        );

        jPanelRight.add(addProductJPanelRight, "addProduct");

        bidJPanelRight.setPreferredSize(new java.awt.Dimension(1005, 720));

        jLabel4.setFont(new java.awt.Font("Roboto Slab Medium", 1, 24)); // NOI18N
        jLabel4.setText("Product:");

        buttonAddPriceBid.setFont(new java.awt.Font("Roboto Slab Medium", 0, 14)); // NOI18N
        buttonAddPriceBid.setForeground(new java.awt.Color(255, 255, 255));
        buttonAddPriceBid.setText("Add");

        jTableUsersBid.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTableUsersBid);

        Username5.setFont(new java.awt.Font("Roboto Medium", 0, 12)); // NOI18N
        Username5.setText("Id");

        idBid.setEditable(false);

        Productee1.setFont(new java.awt.Font("Roboto Medium", 0, 12)); // NOI18N
        Productee1.setText("Product:");

        productBid.setEditable(false);

        detailsBid.setEditable(false);

        Username8.setFont(new java.awt.Font("Roboto Medium", 0, 12)); // NOI18N
        Username8.setText("Details:");

        Timer.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        Timer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Timer.setText("Timer");

        Timer1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        Timer1.setText("Finish:");

        javax.swing.GroupLayout bidJPanelRightLayout = new javax.swing.GroupLayout(bidJPanelRight);
        bidJPanelRight.setLayout(bidJPanelRightLayout);
        bidJPanelRightLayout.setHorizontalGroup(
            bidJPanelRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bidJPanelRightLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(bidJPanelRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bidJPanelRightLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 993, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bidJPanelRightLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(bidJPanelRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(bidJPanelRightLayout.createSequentialGroup()
                        .addGroup(bidJPanelRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Username8)
                            .addComponent(Username5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(bidJPanelRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(bidJPanelRightLayout.createSequentialGroup()
                                .addComponent(idBid, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Productee1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(productBid, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(detailsBid))
                        .addGap(146, 146, 146))
                    .addGroup(bidJPanelRightLayout.createSequentialGroup()
                        .addComponent(Timer1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Timer, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(650, 650, 650))))
            .addGroup(bidJPanelRightLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(bidJPanelRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(addNewPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(bidJPanelRightLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(buttonAddPriceBid, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        bidJPanelRightLayout.setVerticalGroup(
            bidJPanelRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bidJPanelRightLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addGap(1, 1, 1)
                .addGroup(bidJPanelRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Timer)
                    .addComponent(Timer1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 87, Short.MAX_VALUE)
                .addGroup(bidJPanelRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Username5)
                    .addComponent(idBid, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Productee1)
                    .addComponent(productBid, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(bidJPanelRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Username8)
                    .addComponent(detailsBid, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(addNewPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonAddPriceBid, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanelRight.add(bidJPanelRight, "Bid");

        jSplitPane1.setRightComponent(jPanelRight);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jSplitPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jSplitPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void LogOutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogOutButtonActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_LogOutButtonActionPerformed

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
            java.util.logging.Logger.getLogger(ClientView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClientView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClientView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClientView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ClientView().setVisible(true);
                

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel HomejPanelRight;
    private javax.swing.JLabel Img4;
    private javax.swing.JButton LogOutButton;
    private javax.swing.JLabel LogoImg;
    private javax.swing.JLabel LogoImg1;
    private javax.swing.JPanel MyProductsjPanelRight;
    private javax.swing.JLabel Productee;
    private javax.swing.JLabel Productee1;
    private javax.swing.JLabel Timer;
    private javax.swing.JLabel Timer1;
    private javax.swing.JLabel Username4;
    private javax.swing.JLabel Username5;
    private javax.swing.JLabel Username7;
    private javax.swing.JLabel Username8;
    private javax.swing.JTextField addNewPrice;
    private javax.swing.JButton addProductButton;
    private javax.swing.JPanel addProductJPanelRight;
    private javax.swing.JButton bidButton;
    private javax.swing.JPanel bidJPanelRight;
    private javax.swing.JButton buttonAddPriceBid;
    private javax.swing.JButton buttonAddProduct;
    private javax.swing.JButton buttonDeleteMyProduct;
    private javax.swing.JButton buttonMakeBid;
    private javax.swing.JButton buttonPayee;
    private javax.swing.JTextField detailsAddProduct;
    private javax.swing.JTextField detailsBid;
    private javax.swing.JLabel fullNameJLabel;
    private javax.swing.JButton homeButton;
    private javax.swing.JTextField idBid;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanelLeft;
    private javax.swing.JPanel jPanelRight;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JTable jTableMyProducts;
    private javax.swing.JTable jTableUsersBid;
    private javax.swing.JTextField myIdAddProduct;
    private javax.swing.JButton myProductsButton;
    private javax.swing.JTextField productAddProduct;
    private javax.swing.JTextField productBid;
    private javax.swing.JPanel viewMyProduct;
    // End of variables declaration//GEN-END:variables
}
