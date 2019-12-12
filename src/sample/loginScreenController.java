package sample;

import java.io.IOException;
import java.sql.SQLException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 * Login Screen Controller class to validate the login.
 *
 * @author Brendan Beardsley
 * @version 1.0
 */

public class loginScreenController {
    @FXML
    private TextField userId;
    @FXML
    private PasswordField password;
    @FXML
    private Button loginButton;
    @FXML
    private Button signUp;
    @FXML
    void signUpScene(ActionEvent event) {
        Main.loadScene(signUp, "loginScreen.fxml", "Signup Screen");

    }

    /**
     * Method for login action when login button pressed to validate the login
     *
     * @param event login action
     * @throws SQLException N/A.
     * @throws IOException  N/A.
     */
   @FXML
    void loginFunction(ActionEvent event) throws SQLException, IOException {

        DatabaseManager db = new DatabaseManager();
        String username = userId.getText();
        String pass = password.getText();
        if (db.login(username, pass)) {
            Main.loadScene(loginButton, "sample.fxml", "Product Line");
        } else {
            Main.errorMessage("Password doesnt match");
        }

    }

    /**
     * Initialize the screen
     */
/*    @FXML
    public void initialize() {
        userId.setText("brendan");
        password.setText("As!");
    }*/

}
