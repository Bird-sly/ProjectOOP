package sample;

/**
 * Abstract Class Product that implement item.
 */
public abstract class Product implements Item {

    int id;
    ItemType type;
    String manufacturer;
    String name;
    ItemType itemTypeCode;


    Product(String name, String manufacturer, ItemType type) {
        this.name = name;
        this.manufacturer = manufacturer;
        this.type = type;
    }

    public int getID() {
        return id;
    }

    public ItemType getType() {
        return type;
    }

    public void setID(int id) {
        this.id = id;
    }

    public void setType(ItemType type) {
        this.type = type;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return ("Name: " + name + " \nManufacturer: " + manufacturer + " \nType: " + type);
    }

}