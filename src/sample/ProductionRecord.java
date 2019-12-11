package sample;

import java.util.Date;

/**
 * Method for Production Record.
 * @author Brendan Beardsley
 * @version 1.0
 */
public class ProductionRecord {

    private int productNumber;
    private Date dateProduced;
    private int productID;
    private int numMade;
    private int totalMade;
    private String prodName;
    private String manufacturer;
    private String type;




    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public Date getDateProduced() {
        return dateProduced;
    }

    public void setDateProduced(Date dateProduced) {
        this.dateProduced = dateProduced;
    }

    public int getNumMade() {
        return numMade;
    }

    public void setNumMade(int numMade) {
        this.numMade = numMade;
    }

    public int getTotalMade() {
        return totalMade;
    }

    public void setTotalMade(int totalMade) {
        this.totalMade = totalMade;
    }

    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ProductionRecord(int productNumber,
                            java.sql.Date dateProduced,
                            int totalMade,
                            int productID,
                            String prodName,
                            String manufacturer,
                            String type) {

        this.productID = productID;
        this.productNumber = productNumber;
        this.totalMade = totalMade;
        this.dateProduced = dateProduced;
        this.prodName = prodName;
        this.type = type;
        this.manufacturer = manufacturer;
    }

    /**
     * This allows me to print the results, making sure it works
     *
     * @return A String with all fields in space separated strings
     */
    @Override
    public String toString() {
        return (productID
                + " "
                + dateProduced
                + " "
                + productNumber
                + " "
                + totalMade
                + " "
                + prodName
                + " "
                + manufacturer
                + " "
                + type);
    }
}

