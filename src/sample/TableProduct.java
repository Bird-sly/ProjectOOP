package sample;

public class TableProduct {
    int id;
    ItemType type;
    String manufacturer;
    String name;
    ItemType itemTypeCode;

    TableProduct(String name, String manufacturer, ItemType type, ItemType itemTypeCode) {
        this.name = name;
        this.manufacturer = manufacturer;
        this.type = type;
        this.itemTypeCode = itemTypeCode;
    }

    public int getID() {
        return this.id;
    }

    public ItemType getType() {
        return this.type;
    }

    public void setID(int id) {
        this.id = id;
    }

    public void setType(ItemType type) {
        this.type = type;
    }

    public String getManufacturer() {
        return this.manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString() {
        return "Name: " + this.name + " \nManufacturer: " + this.manufacturer + " \nType: " + this.type;
    }
}
