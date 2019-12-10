package sample;

import java.util.Date;

/**
 * Method for Production Record.
 *
 * @author Mushfique Shafi
 * @version 1.0
 */
public class ProductionRecord {

    private int productionNumber;
    private int productID;
    private String serialNumber;
    private Date dateProduced;

    /**
     * Constructor for the ProductionRecord
     *
     * @param productID id of the product.
     */
    public ProductionRecord(int productID) {
        this.productID = productID;
        this.productionNumber = 0;
        this.serialNumber = "0";
        this.dateProduced = new Date();

    }

    /**
     * Constructor for the Production Record
     *
     * @param productionNumber production number of the product
     * @param productID        id of the of the product
     * @param serialNumber     serial number of the product
     * @param dateProduced     date of the product produced
     */
    ProductionRecord(int productionNumber, int productID, String serialNumber,
                     Date dateProduced) {
        this.productionNumber = productionNumber;
        this.productID = productID;
        this.serialNumber = serialNumber;
        this.dateProduced = dateProduced;

    }

    /**
     * Production record method for generating the serial number of the product
     *
     * @param product   name of the product
     * @param itemCount item count of the product
     */
    ProductionRecord(Product product, int itemCount) {
        serialNumber = generateSerial(product, itemCount);
    }

    /**
     * Getter for property 'productID'.
     *
     * @return Value for property 'productID'.
     */
    public int getProductID() {

        return productID;
    }

    /**
     * Getter for property 'productionNumber'.
     *
     * @return Value for property 'productionNumber'.
     */
    public int getProductionNumber() {
        return productionNumber;
    }

    /**
     * Setter for property 'productionNumber'.
     *
     * @param productionNumber Value to set for property 'productionNumber'.
     */
    public void setProductionNumber(int productionNumber) {
        this.productionNumber = productionNumber;
    }

    /**
     * Setter for property 'productID'.
     *
     * @param productID Value to set for property 'productID'.
     */
    public void setProductID(int productID) {

        this.productID = productID;
    }

    /**
     * Getter for property 'serialNumber'.
     *
     * @return Value for property 'serialNumber'.
     */
    public String getSerialNumber() {

        return serialNumber;
    }

    /**
     * Setter for property 'serialNumber'.
     *
     * @param serialNumber Value to set for property 'serialNumber'.
     */
    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    /**
     * Getter for property 'dateProduced'.
     *
     * @return Value for property 'dateProduced'.
     */
    public Date getDateProduced() {

        return dateProduced;
    }

    /**
     * Setter for property 'dateProduced'.
     *
     * @param dateProduced Value to set for property 'dateProduced'.
     */
    public void setDateProduced(Date dateProduced) {

        this.dateProduced = dateProduced;
    }

    /**
     * Generate Serial for a product while record the production
     *
     * @param product   name of the product
     * @param itemCount count of the product produced
     * @return the serial string
     */
    public static String generateSerial(Product product, int itemCount) {
        return product.getManufacturer().substring(0, 3) + product.getType() + String
                .format("%05d", itemCount);

    }
}