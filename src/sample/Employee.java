package sample;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Employee class to create an employee.
 * @author Brendan Beardsley
 * @version 1.0
 */
public final class Employee{

    StringBuilder name;
    String username;
    String password;
    String email;
    String deptId;
    Pattern depPattern = Pattern.compile("[A-Z][a-z]{3}[0-9]{2}");
    private DatabaseManager dao = new DatabaseManager();
    private Connection conn = null;
    private PreparedStatement ps = null;

    /** Constructor that sets the username. */
    public Employee(StringBuilder name, String password, String deptId) {
        this.username = "test";
        setDeptId(deptId);
        setUsername();
        setEmail();
    }

    public Employee() {

    }

    public void setUsername() {
        if (checkName()) {
            String[] tokens = name.toString().toLowerCase().split(" ");
            username = tokens[0].substring(0, 1) + "." + tokens[1];
        }
    }
    private void setDeptId(String deptId) {
        if (validId(deptId)) {
            this.deptId = deptId;
        } else {
            this.deptId = "None01";
        }

    }
    private boolean checkName() {
        return name.toString().contains(" ");}

    public Employee(String username, String password) {
        this.username = username;
        this.password = password;
    }
    private void setEmail() {
        if (checkName()) {
            String[] tokens = name.toString().toLowerCase().split(" ");

            email = tokens[0] + "." + tokens[1] + "@fgcu.edu";
        }

    }
    private boolean validId(String id) {
        Matcher deptIdValidation = depPattern.matcher(id);
        return deptIdValidation.find();
    }
    /** Method to create a new user and insert it into the database. */
    public void createUser() {
        try {
            conn = dao.getConnection();

            ps = conn.prepareStatement("INSERT INTO Users(username, password) VALUES(?, ?)");
            ps.setString(1, this.username);
            ps.setString(2, this.password);

            ps.execute();

            ps.close();
            conn.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Method to check the database to see if a specified user already exists.
     */
    public boolean checkUserExists(String username) {
        boolean exists = false;
        try {
            conn = dao.getConnection();
            ps = conn.prepareStatement("SELECT * FROM USERS WHERE USERNAME=?");
            ps.setString(1, username);

            ResultSet rs = ps.executeQuery();

            // rs.next() is false if the set is empty
            exists = rs.next();

            // close stuff
            ps.close();
            conn.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return exists;
    }
    /**
     * Getter for property 'name'.
     *
     * @return the name.
     */
    public StringBuilder getName() {
        return name;
    }

    /**
     * Getter for property 'username'.
     *
     * @return name.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Getter for property 'password'
     *
     * @return password.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Getter for property 'email'.
     *
     * @return email.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Getter for property 'deptId'
     *
     * @return deptId
     */
    public String getDeptId() {
        return deptId;

    }
    /**
     * Method to compare the entered password on the login screen with the password in the database.
     *
     * @param username The username to check.
     * @param password The password to compare.
     * @return A boolean if the password matches or not.
     */
    public boolean comparePassword(String username, String password) {
        boolean matchedPass = false;
        try {
            conn = dao.getConnection();
            ps = conn.prepareStatement("SELECT * FROM USERS WHERE USERNAME=? AND PASSWORD=?");
            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            // rs.next() is not empty if both user and pass are in the same row
            matchedPass = rs.next();

            // close stuff
            ps.close();
            conn.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return matchedPass;
    }

}