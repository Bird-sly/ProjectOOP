
package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.sql.SQLException;

public class SignUpController {
    @FXML
    private TextField fullName;
    @FXML
    private TextField deptId;
    @FXML
    private TextField TF_password;
    @FXML
    private TextField TF_cpassword;
    @FXML
    private Button back;
    @FXML
    private Button button_create;

    public SignUpController() {
    }

    @FXML
    void createAccount(ActionEvent event) {
        String fullNameText = this.fullName.getText();
        String password = this.TF_password.getText();
        String cpassword = this.TF_cpassword.getText();
        String depId = this.deptId.getText();
        boolean fieldsCompleted = !password.equals("") && !cpassword.equals("") && !fullNameText.equals("");
        if (fieldsCompleted) {
            if (password.equals(cpassword)) {
                try {
                    StringBuilder sb = new StringBuilder();
                    Employee employee = new Employee(sb.append(fullNameText), password, depId);
                    String email = employee.getEmail();
                    String pass = employee.getPassword();
                    String userId = employee.getUsername();
                    String name = employee.getName();
                    String idDept = employee.getDeptId();
                    DatabaseManager db = new DatabaseManager();
                    db.insertEmployee(name, userId, pass, email, idDept);
                    Main.loadScene(this.button_create, "loginScreen.fxml", "Login Screen");
                } catch (IllegalArgumentException | SQLException var15) {
                    Main.errorMessage(var15.getMessage());
                    this.TF_password.clear();
                    this.TF_cpassword.clear();
                }
            } else {
                Main.errorMessage("Passwords Do not match");
            }
        } else {
            Main.errorMessage("Please fill up the Fields");
        }

    }

    @FXML
    void backMethod(ActionEvent event) {
        Main.loadScene(this.back, "loginScreen.fxml", "Login Screen");
    }
}
