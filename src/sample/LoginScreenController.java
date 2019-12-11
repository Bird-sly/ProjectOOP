package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;

public class LoginScreenController {


        private Employee userStore;

        @FXML
        private Button btnRegister;
        @FXML private Button btnLogin;
        @FXML private TextField fullName;
        @FXML private TextField TF_password;

        /** Method called when the scene loads. */
        @FXML
        void initialize() {
            TF_password.setOnKeyPressed(
                    event -> {
                        if (event.getCode() == KeyCode.ENTER) {
                            actionLogin();
                            TF_password.clear();
                        }
                    });
        }

        /**
         * * Method when login button is pressed.
         *
         */
        public void actionLogin() {
            Alert alert;

            String username = fullName.getText();
            String pass = TF_password.getText();

            userStore = new Employee();

           // boolean exists = userStore.checkUserExists(username);
            boolean passMatches = userStore.comparePassword(username, pass);

            if (passMatches) {
                //Session.getInstance("").cleanUserSession();
                //Session session = Session.getInstance(username);
                Utilities.nextScene(btnLogin, "home", "Home - " + username);
            } else {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Invalid login!");
                alert.show();
            }
        }

        /** * Method to transition to the register view. */
        public void actionRegister() {
            Utilities.nextScene(btnRegister, "signUp", "Register");
        }
    }
