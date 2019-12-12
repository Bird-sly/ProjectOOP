package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Main Class to run the ProductionLog
 */
public class Main extends Application {
    /***
     *  Production log list text file
     */
    public static final String PATH = "res/productionLog.txt";
    /**
     * Method for starting a scene
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Login Screen");
        primaryStage.setScene(new Scene(root, 800,800));
        primaryStage.show();
    }
    /**
     * Method for adding the log to the text file
     *
     * @param message info which need to be save in the text file
     * @param objects which saves the time of the production as object
     */
    public static void logToFile(String message, Object... objects) {

        try (FileReader fr = new FileReader(PATH);
             BufferedReader bfr = new BufferedReader(fr);
             FileWriter fw = new FileWriter(PATH, true)
        ) {
            fw.append(String.format(message, objects));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * Nethod for saving the text to text file
     *
     * @return newlist arraylist
     */
    public static List<LogView> logToFile1() {
        ArrayList<LogView> newListRecord = new ArrayList<>();
        int lines = 1;
        try (FileReader fr = new FileReader(PATH);
             BufferedReader bfrc = new BufferedReader(fr);

             BufferedReader bfr = new BufferedReader(fr);
             FileWriter fw = new FileWriter(PATH, true)
        ) {
            String an;
            while ((an = bfr.readLine()) != null) {

                LogView log = new LogView(an, lines);
                lines++;

                newListRecord.add(log);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return newListRecord;
    }

    /**
     * @param message display the error message
     */
    public static void errorMessage(String message) {
        UIManager.put("OptionPane.minimumSize", new Dimension(600, 200));
        UIManager.put("OptionPane.messageFont", new FontUIResource(new Font(
                "Arial", Font.BOLD, 40)));

        JOptionPane.showMessageDialog(null,
                message, "Error", JOptionPane.ERROR_MESSAGE);

    }

    /**
     * @param message for printing information
     */
    public static void infoMessage(String message) {
        UIManager.put("OptionPane.minimumSize", new Dimension(600, 200));
        UIManager.put("OptionPane.messageFont", new FontUIResource(new Font(
                "Arial", Font.BOLD, 40)));

        JOptionPane.showMessageDialog(null, message, "Message",
                JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * @param pressedButton   name of the button pressed
     * @param nameOfFxml      name of the fxml file
     * @param titleOftheScene title of the scene
     */
    public static void loadScene(Button pressedButton, String nameOfFxml, String titleOftheScene) {
        try {
            Stage stage;
            stage = (Stage) pressedButton.getScene().getWindow();
            stage.close();
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(nameOfFxml));
            Parent profile = fxmlLoader.load();
            Stage newStage = new Stage();
            newStage.setTitle(titleOftheScene);
            newStage.setScene(new Scene(profile));
            stage = newStage;
            stage.show();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    public static void main(String[] args) {
        launch(args);
    }
}
