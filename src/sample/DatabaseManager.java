package sample;


import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;

/**
 * Database Manager to control & facilitate all the database operation.
 * @author Brendan Beardsley
 * @version 1.0
 */
public class DatabaseManager extends Main {

    private Connection con = null;
    public int idOftheProduct;
    private ResultSet rs = null;

    /**
     * Constructs a new DatabaseManager.
     */
    public DatabaseManager() {
        try {

            Properties openFile = new Properties();
            openFile.load(new FileInputStream("res/pass"));
            String user = openFile.getProperty("user");
          //  String pass = Employee.reverseString(openFile.getProperty("pass"));
            this.con = DriverManager
                    .getConnection("jdbc:h2:C:\\Users\\Brendan\\IdeaProjects\\project\\res\\ProductLine"
                            );

        } catch (SQLException | IOException exception) {
            exception.printStackTrace();

        }
    }
    public Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("org.h2.Driver");
        return DriverManager.getConnection("jdbc:h2:./res/ProductLine", "", "");
    }
    /**
     * Made for adding employees to the Employee table
     *
     * @param fullName Full Name for the employee.
     * @param userId   userId for the for the employee auto generated.
     * @param password password for the employee.
     * @param email    email auto generated for the employee.
     * @param deptId   dept id for the employee.
     */
    public void insertEmployee(StringBuilder fullName, String userId, String password, String email,
                               String deptId) {
        String userIdTemp;
        int count = 0;

        try {
            String querySearch = "Select * from employee";
            PreparedStatement stmt1 = con.prepareStatement(querySearch);
            ResultSet rs = stmt1.executeQuery();
            int lengthOfUserId = userId.length();

            String[] emailParts = email.split("@");
            String emailPart1 = emailParts[0];
            String emailPart2 = "@" + emailParts[1];
            int lengthOfEmail = emailPart1.length();

            while (rs.next()) {
                String nameExist = rs.getString("userid");
                if (userId.equals(nameExist)) {
                    count++;

                    userId = userId.substring(0, lengthOfUserId) + count;
                    email = emailPart1.substring(0, lengthOfEmail) + count + emailPart2;
                } else {
                    System.out.println(" ");
                }

            }
            String query = "Insert into Employee (name, userid, password, email, DEPTID) Values(?,?,?,?,?)";
            PreparedStatement stmt2 = con.prepareStatement(query);
            stmt2.setString(1, String.valueOf(fullName));
            stmt2.setString(2, userId);
            stmt2.setString(3, password);
            stmt2.setString(4, email);
            stmt2.setString(5, deptId);
            stmt2.executeUpdate();
            Main.infoMessage("USERID:- " + userId + "\nEmail:- " + email + "\nDepartment Id:- "+ deptId);
        } catch (Exception e) {
            Main.errorMessage("This Name is already taken");
            e.printStackTrace();
        }

    }

    /**
     * @param iQuery       query for the product.
     * @param insertValues insert value for the item count.
     * @throws SQLException SQL Exception.
     */
    public void insertProd(String iQuery, String[] insertValues) throws SQLException {

        PreparedStatement pstmt = this.con.prepareStatement(iQuery);
        pstmt.setInt(1, Integer.parseInt(insertValues[0]));
        pstmt.setString(2, insertValues[1]);
        pstmt.executeUpdate();
    }
    /**
     * Method of getting the Product Id.
     *
     * @param nameSelected name of the selected produtct.
     * @return id of the product selected.
     */
    public int getTheIdFromSelected(Product nameSelected) {
        try {
            String name = nameSelected.getName();
            String query = "SELECT * FROM PRODUCT WHERE NAME = ?";
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setString(1, name);
            ResultSet rs = null;
            rs = stmt.executeQuery();
            while (rs.next()) {
                String getId = rs.getString("ID");
                idOftheProduct = Integer.parseInt(getId);
                return idOftheProduct;
            }

        } catch (SQLException var6) {
            this.sqlExceptionHandler(var6);
        }
        return 0;
    }

    /***
     * @param idProduct  id of the product
     * @param dateofProduction date of the product adding to the database.
     */
    public void RecordProduction(int idProduct, Date dateofProduction) {
        try {
            PreparedStatement stmt = con
                    .prepareStatement("INSERT INTO PRODUCTIONRECORD (product_id, date_produced) "
                            + "VALUES (?,?)");

            stmt.setInt(1, idProduct);
            stmt.setString(2, String.valueOf(dateofProduction));
            stmt.execute();

        } catch (SQLException var6) {
            this.sqlExceptionHandler(var6);
        }
    }


    /**
     * Method for record the quantity of the product.
     * @param quantity quantity of the product from the combo box.
     * @param name     name of the product to adding to the database.
     * @return the quantity.
     */
    public int recordQauntity(int quantity, String name) {

        try {
            int fQuantity = 0;
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM PRODUCT WHERE NAME = ?");
            stmt.setString(1, name);
            ResultSet rs = null;
            rs = stmt.executeQuery();
            while (rs.next()) {
                fQuantity = rs.getInt("QUANTITY");
                String query = "UPDATE PRODUCT SET QUANTITY = ? WHERE NAME = ? ";
                PreparedStatement stmt2 = con.prepareStatement(query);
                stmt2.setInt(1, quantity);
                stmt2.setString(2, name);
                stmt2.executeUpdate();

                return fQuantity;
            }

        } catch (SQLException var6) {
            this.sqlExceptionHandler(var6);
        }

        return quantity;
    }






    /**
     * Method for adding  a new product to the DB
     * @param itemType item type of the product.
     * @param itemName name of the item.
     * @param itemManufacturer name of the manufacture of the item.
     */
    public void TableProduct(String itemType, String itemName, String itemManufacturer) {
        try {
            PreparedStatement stmt = this.con
                    .prepareStatement("INSERT INTO PRODUCT (type, name, manufacturer)"
                            + " VALUES (? ,? ,?,0)");
            stmt.setString(1, itemType);
            stmt.setString(2, itemName);
            stmt.setString(3, itemManufacturer);
            stmt.execute();
        } catch (SQLException var6) {
            this.sqlExceptionHandler(var6);
        }
    }
    public String[] getProductInfo(int productID) throws SQLException {
        String query = "SELECT * FROM PRODUCT WHERE ID = ?";
        PreparedStatement stmt = con.prepareStatement(query);
        stmt.setInt(1, productID);
        ResultSet results;
        results = stmt.executeQuery();
        String prodName;
        String type;
        String manufacturer;
        results.next();
        prodName = results.getString("NAME");
        manufacturer = results.getString("MANUFACTURER");
        type = results.getString("TYPE");
        return new String[] {prodName, manufacturer, type};
    }
    public List<ProductionRecord> getProductionInfo() {
        List<ProductionRecord> prodList = new ArrayList<>();
        try {
            String query = "SELECT * FROM PRODUCTION";
            PreparedStatement stmt = con.prepareStatement(query);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int productNumber = rs.getInt("PRODUCTNUMBER");
                java.sql.Date dateProduced = rs.getDate("DATEPRODUCED");
                int numMade = rs.getInt("AMOUNTMADE");
                int totalMade = rs.getInt("TOTALMADE");
                int productID = rs.getInt("PRODUCTID");
                String[] productInfo = getProductInfo(productID);
                prodList.add(
                        new ProductionRecord(
                                productNumber,
                                dateProduced,
                                totalMade,
                                productID,
                                productInfo[0],
                                productInfo[1],
                                productInfo[2]));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return prodList;
    }

    /**
     * Method for generating the list view for the product display from database
     * @param typeSort type of sorting.
     * @return Listview.
     * @throws SQLException SQL Exception.
     */
    public List<Product> listViewProduct(String typeSort) throws SQLException {
        try {
            String sortedProduct;
            String nameProduct;
            String idOftheProducts;
            String manufacturer;
            String typeName;
            ResultSet rs = null;
            ResultSet rs2 = null;
            Statement stmt = this.con.createStatement();
            rs = stmt.executeQuery(String.format("Select * from Product "));
            ArrayList<Product> newListRecord = new ArrayList<>();
            ArrayList<String> sortedListUnfiltered = new ArrayList<>();
            while (rs.next()) {
                sortedProduct = rs.getString(typeSort);
                sortedListUnfiltered.add(sortedProduct);
            }
            List<String> sortedList = sortedListUnfiltered.stream().distinct()
                    .collect(Collectors.toList());
            Collections.sort(sortedList);
            for (int i = 0; i < sortedList.size(); i++) {
                String temp = sortedList.get(i);

                String query = "Select * from Product where ";
                query += typeSort + " = ?";
                PreparedStatement stmt2 = con.prepareStatement(query);
                stmt2.setString(1, temp);
                rs2 = stmt2.executeQuery();
                while (rs2.next()) {

                    nameProduct = rs2.getString("Name");
                    idOftheProducts = rs2.getString("ID");
                    manufacturer = rs2.getString("Manufacturer");
                    typeName = rs2.getString("Type");
                    Product prod = new Widget(
                            nameProduct, manufacturer,
                            ItemType.valueOf(typeName)
                    );


                    newListRecord.add(prod);
                }
            }
            return newListRecord;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    /**
     * makes the SQL exception
     * @param error SQL ERROR.
     */
    public void sqlExceptionHandler(SQLException error) {

        Main.errorMessage("Standard Failure: " + error.getMessage());
    }
    public void closeCon() {
        try {
            con.close();
        } catch (SQLException e) {
            sqlExceptionHandler(e);
        }
    }
    public int fetchQauntity(String name) {

        try {
            int fQuantity = 0;
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM PRODUCT WHERE NAME = ?");
            stmt.setString(1, name);
            ResultSet rs = null;
            rs = stmt.executeQuery();
            while (rs.next()) {
                fQuantity = rs.getInt("QUANTITY");
                return fQuantity;
            }
        } catch (SQLException var6) {
            this.sqlExceptionHandler(var6);
        }
        return 0;
    }


    /***
     *
     * @param userName
     * @param passwordTyped
     * @return
     * @throws SQLException
     */
    public boolean login(String userName, String passwordTyped) throws SQLException {
        String query = "Select * from Employee where userid = ?";

        PreparedStatement stmt = con.prepareStatement(query);
        stmt.setString(1, userName);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            String password = rs.getString("password");
            String name = rs.getString("Name");
            Controller.employee = name;
            String userId = rs.getString("USERID");
            Controller.employeeId = userId;
            String email = rs.getString("email");
            Controller.email = email;
            String deptId = rs.getString("deptid");

            return password.equals(passwordTyped);
        }
        return false;
    }
}
