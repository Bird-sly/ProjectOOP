package sample;

/**
 * Method for Table to generate.
 * @version 1.0
 */
public class tableProduct {
    int id;
    ItemType type;
    String manufacturer;
    String name;
    ItemType itemTypeCode;
    /**
     * Table constructor
     *
     * @param name         name of the product
     * @param manufacturer manufacturer of the product
     * @param type         type of the product from the enum
     * @param itemTypeCode item code for the item
     */
    tableProduct(String name, String manufacturer, ItemType type, ItemType itemTypeCode) {
        this.name = name;
        this.manufacturer = manufacturer;
        this.type = type;
        this.itemTypeCode = itemTypeCode;
    }
    /**
     * Getter for property 'ID'.
     *
     * @return Value for property 'ID'.
     */
    public int getID() {
        return id;
    }
    /**
     * Getter for property 'type'.
     *
     * @return Value for property 'type'.
     */
    public ItemType getType() {
        return type;
    }

    /**
     * Setter for property 'ID'.
     *
     * @param id Value to set for property 'ID'.
     */
    public void setID(int id) {
        this.id = id;
    }

    /**
     * Setter for property 'type'.
     *
     * @param type Value to set for property 'type'.
     */
    public void setType(ItemType type) {
        this.type = type;
    }
     /**
     * Getter for property 'manufacturer'.
     *
     * @return Value for property 'manufacturer'.
     */
    public String getManufacturer() {
        return manufacturer;
    }
    /**
     * Setter for property 'manufacturer'.
     *
     * @param manufacturer Value to set for property 'manufacturer'.
     */
    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }
    /**
     * Getter for property 'name'.
     *
     * @return Value for property 'name'.
     */
    public String getName() {
        return name;
    }
    /**
     * Setter for property 'name'.
     *
     * @param name Value to set for property 'name'.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * To string method
     */
    @Override
    public String toString() {
        return ("Name: " + name + " \nManufacturer: " + manufacturer + " \nType: " + type);
    }
}

