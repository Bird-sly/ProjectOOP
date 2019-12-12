package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * Sign Up Controller where sign up information are filled out.
 *
 * @author Brendan Beardsleey
 * @version 1.0
 */
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
    @FXML
    /**
     * Create account method when preesed create account
     *Information saves in the database
     */
    void createAccount(ActionEvent event) {
        String fullNameText = fullName.getText();
        String password = TF_password.getText();
        String cpassword = TF_cpassword.getText();
        String depId = deptId.getText();
        boolean fieldsCompleted = !password.equals("") && !cpassword.equals("")
                && !fullNameText.equals("");
        if (fieldsCompleted) {
            if (password.equals(cpassword)) {
                try {

                    StringBuilder sb = new StringBuilder();
                    Employee employee = new Employee(sb.append(fullNameText), password, depId);
                    String email = employee.getEmail();
                    String pass = employee.getPassword();
                    String userId = employee.getUsername();
                    StringBuilder name = employee.getName();
                    String idDept = employee.getDeptId();
                    DatabaseManager db = new DatabaseManager();
                    db.insertEmployee(name, userId, pass, email, idDept);
                    Main.loadScene(button_create, "signUp.fxml", "signUp");
                } catch (IllegalArgumentException ex) {
                    Main.errorMessage(ex.getMessage());
                    TF_password.clear();
                    TF_cpassword.clear();
                }
            } else {
                Main.errorMessage("Password and confirm Password doesnt match");
            }
        } else {
            Main.errorMessage("Fields are not filled Up");
        }

    }

    /**
     * This method is a back button to login screen
     *
     * @param event back button action
     */
    @FXML
    void backMethod(ActionEvent event) {
        Main.loadScene(back, "loginScreen.fxml", "Login Screen");
    }
}
