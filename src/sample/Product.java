package sample;

public abstract class Product implements Item{
    private int id;
    private String type;
    private String manufacturer;
    private String name;

    /***
     * @param name
     * @param manufacturer
     * @param mediaType
     */
    public Product(String name, String manufacturer, ItemType mediaType) {
    }

    public Product() {

    }

    public void setId(int id){
        this.id = id;
    }
    @Override
    public int getId(){
        return id;
    }
    public void setType(String type){
        this.type = type;
    }
    public String getType(){
        return type;
    }
    public void setManufacturer(String manufacturer){
        this.manufacturer = manufacturer;
    }
    @Override
    public String getManufacturer(){
        return manufacturer;
    }
    public void setName(String name){
        this.name = name;
    }
    @Override
    public String getName(){
        return name;
    }
    public Product (int id, String type, String manufacturer, String name) {
        this.id = id;
        this.type = type;
        this.manufacturer = manufacturer;
        this.name = name;

    }

}
