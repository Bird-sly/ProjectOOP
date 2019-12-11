package view;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import java.awt.Dimension;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import sample.*;

import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.plaf.FontUIResource;

public class Main extends Application {

    public static final String PATH = "res/ProductionLog.txt";
    ;
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("view/sample.fxml"));
        primaryStage.setTitle("Login");
        primaryStage.setScene(new Scene(root,348, 115));
        primaryStage.setResizable(true);
        primaryStage.show();
    }

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

    public static void errorMessage(String message) {
        UIManager.put("OptionPane.minimumSize", new Dimension(600, 200));
        UIManager.put("OptionPane.messageFont", new FontUIResource(new Font(
                "Arial", Font.BOLD, 40)));

        JOptionPane.showMessageDialog(null,
                message, "Error", JOptionPane.ERROR_MESSAGE);

    }


    public static void infoMessage(String message) {
        UIManager.put("OptionPane.minimumSize", new Dimension(600, 200));
        UIManager.put("OptionPane.messageFont", new FontUIResource(new Font(
                "Arial", Font.BOLD, 40)));

        JOptionPane.showMessageDialog(null, message, "Message",
                JOptionPane.INFORMATION_MESSAGE);
    }


    public static void loadScene(Button pressedButton, String nameOfFxml, String titleOftheScene) {

        try {
            Stage stage;
// retrieves and closes current stage
            stage = (Stage) pressedButton.getScene().getWindow();
            stage.close();
// loads main screen stage
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(nameOfFxml));
            Parent profile = fxmlLoader.load();

// creates a new stage
            Stage newStage = new Stage();
            newStage.setTitle(titleOftheScene);
            newStage.setScene(new Scene(profile));

// set new stage to current stage and display stage
            stage = newStage;
            stage.show();

        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }


    public static void main(String[] args) throws SQLException {
        DatabaseManager db = new DatabaseManager();
        Screen screen = new Screen("1080p", 144, 3);
        System.out.println(screen.toString());
        MoviePlayer moviePlayer = new MoviePlayer("name" ,"manufacturer", new Screen("1920*2000", 200, 300), MonitorType.LED);
        System.out.println(moviePlayer.toString());
        ObservableList<LogView> productionData =
                FXCollections.observableArrayList(logToFile1());
        for (LogView s : productionData) {
            System.out.println(s);
        }
        launch(args);
        db.closeCon();
    }
}