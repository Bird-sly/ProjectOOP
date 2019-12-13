package sample;

import javafx.collections.ObservableList;

/**
 * ProductView Class for the Product
 */
public class ProductView {

    private String product;
    private String manufacture;
    private String type;

    public ProductView(String product, String manufacture, String type) {
        this.product = product;
        this.manufacture = manufacture;
        this.type = type;
    }

    public static void setItems(ObservableList<ProductView> data) {
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getManufacture() {
        return manufacture;
    }

    public void setManufacture(String manufacture) {
        this.manufacture = manufacture;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
