package sample;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;


/**
 * The controller class where the main page scene is executed.
 *
 * @author Brendan Beardsley
 * @version 1.0
 */
public class Controller {


    Statement statement;
    @FXML
    private Button logout;
    @FXML
    private Label userIdShow;

    @FXML
    private TextField ProductNameField;
    @FXML
    private Tab tab4;
    @FXML
    private Tab tab2;
    @FXML
    private Tab tab3;
    @FXML
    private Tab tab1;


    @FXML
    private TextField ManufactureField;

    @FXML
    private ComboBox<String> ItemTypeCombobox;

    @FXML
    private Button btnaddproduct;

    @FXML
    private ComboBox<String> ChooseQuantity;
    @FXML
    private TextField deptId;

    @FXML
    private Button RecordProduction;

    @FXML
    private TextField serialRec;
    @FXML
    private TableView<Product> tableProduct;
    @FXML
    private TableColumn<?, ?> nameProduct;

    @FXML
    private TableColumn<?, ?> Manufacture;

    @FXML
    private TableColumn<?, ?> itemType;

    @FXML
    private TableColumn<?, ?> itemTypeCode;
    @FXML
    private ListView<Product> productList;

    @FXML
    private ComboBox<String> comboSort;
    private ObservableList<Product> observableList;
    private ObservableList<LogView> logList;
    @FXML
    private TableView<LogView> logTable;
    @FXML
    private TextField EmployeeTab_Name;
    @FXML
    private TextField EmployeeTab_UserId;
    @FXML
    private TextField EmployeeTab_Email;
    @FXML
    private TextField EmployeeTab_Dept;
    @FXML
    private TableColumn<?, ?> LogId;
    @FXML
    private TableColumn<?, ?> logData;
    int finalQuantity;
    public static String employee;
    public static String email;
    public static String employeeId;


    @FXML
    void recordProductionAction(ActionEvent event) throws SQLException {
        Product tempString1 = productList.getSelectionModel().getSelectedItem();
        String nameOfSelected = tempString1.getName();
        String manufacturerName = tempString1.getManufacturer();
        ItemType itemTypeSelected = tempString1.getType();
        String deptIdForEmp = deptId.getText();

        String quantityTemp = ChooseQuantity.getValue();
        int quantity = Integer.parseInt(quantityTemp);
        Date date = new Date(System.currentTimeMillis());
        long time = date.getTime();
        Timestamp timeStamp = new Timestamp(time);

        DatabaseManager db = new DatabaseManager();
        int intitalLoop = db.fetchQauntity(nameOfSelected);

        int quantityTotal = intitalLoop + quantity;
        db.recordQauntity(quantityTotal, nameOfSelected);
        int idOftheSelected = db.getTheIdFromSelected(tempString1);
        for (int i = intitalLoop; i < quantityTotal; i++) {

            db.RecordProduction(idOftheSelected, timeStamp);
            Timestamp timeOfProduction = new Timestamp(System.currentTimeMillis());
            Main.logToFile("Type: %s (%s) || Name: %s || Made: %s || "
                            + "by an employee from departmentid of : %s at %s "
                            + "\n", itemTypeSelected, itemTypeSelected.getCode(), nameOfSelected, manufacturerName,
                   Employee.reverseString(deptIdForEmp), timeOfProduction);
            logList = FXCollections.observableArrayList(Main.logToFile1());

            logTable.setItems(logList);
        }
    }
    @FXML
    public void initialize() {



        ObservableList<String> logData = FXCollections.observableArrayList();
        try (FileReader fr = new FileReader(Main.PATH);
             BufferedReader bfr = new BufferedReader(fr)) {
            logList = FXCollections.observableArrayList(Main.logToFile1());
            logTable.setItems(logList);
        } catch (IOException e) {
            e.printStackTrace();
        }
        setComboBoxText();
        for (int i = 0; i < 10; i++) {
            ChooseQuantity.getItems().add(String.valueOf(i + 1));
        }
        for (int i = 0; i < ItemType.values().length; i++) {
            ItemTypeCombobox.getItems().add(ItemType.values()[i].name());
        }
        try {
            DatabaseManager db = new DatabaseManager();
            List<Product> listOfitem = db.listViewProduct("NAME");
            observableList = FXCollections.observableArrayList(db.listViewProduct("NAME"));
            for (int i = 0; i < listOfitem.size(); i++) {
                productList.getItems().add(listOfitem.get(i));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ItemTypeCombobox.getSelectionModel().selectFirst();
        ChooseQuantity.setEditable(true);
        tableProduct.setItems(observableList);
    }
    @FXML
    void onaddproduct(ActionEvent event) throws SQLException {
        String productName = ProductNameField.getText();
        String manufacturerName = ManufactureField.getText();
        String itemType = ItemTypeCombobox.getValue();
        DatabaseManager db = new DatabaseManager();
        db.TableProduct(itemType, productName, manufacturerName);
        populateList(productName, manufacturerName, itemType);
        observableList.add(new Widget(productName, manufacturerName, ItemType.valueOf(itemType)));
        productList.setItems(observableList);
        ProductNameField.clear();
        ManufactureField.clear();
        setComboBoxText();
    }
    public static ObservableList<ProductView> populateList(String name, String Company, String type) {
        return FXCollections.observableArrayList(
                new ProductView(name, Company, type));
    }

    private void setComboBoxText() {
        comboSort.setPromptText("Select a type of sort.");
        comboSort.getItems().addAll("Name", "Type", "Quantity", "Manufacturer");
    }

    @FXML
    void sortCombo(ActionEvent event) {
        String sortSelected = comboSort.getValue();

        try {
            DatabaseManager db = new DatabaseManager();
            productList.getItems().clear();
            List<Product> listOfitem = db.listViewProduct(sortSelected);

            for (int i = 0; i < listOfitem.size(); i++) {
                productList.getItems().add(listOfitem.get(i));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    @FXML
    void logoutAction(ActionEvent event) {
        Main.loadScene(logout, "loginScreen.fxml", "Login Screen");
    }

}