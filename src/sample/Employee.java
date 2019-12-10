package sample;


import java.util.regex.Pattern;

public class Employee {

    private String name;
    private String username;
    private String password;
    private String email;

    /***************************************************
     * providing a default employee object if info is invalid.
     * @author Brendan Beardsley
     * @param name name of employee is used to make username and email.
     * @param password password of employee is tested if it is valid.
     */

    Employee(String name, String password) {
        this.name = name;
        if (checkName(name)) {

            setUsername(name);
            setEmail(name);
        } else {

            this.username = "default";
            this.email = "user@oracleacademy.Test";
        }

        if (isValidPassword(password)) {
            this.password = password;
        } else {
            this.password = "pw";
        }
    }

    /***************************************************
     * Constructor for Employee object.
     * @author Brendan Beardsley
     * @param name name of employee.
     * @param username username of employee.
     * @param email email of employee.
     * @param password password of employee.
     */

    Employee(String name, String username, String email, String password) {
        this.name = name;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public Employee(StringBuilder append, String password, String depId) {
    }

    /***************************************************
     * Provides a console output that displays an Employee object.
     * @author Brendan Beardsley
     * @return returns the output string to console.
     */
    public String toString() {
        return "Employee Details" + "\n" + "Name : " + name + "\n" + "Username : "
                + username + "\n" + "Email : " + email + "\n" + "Initial Password : " + password;
    }
    /***************************************************
     * Splitting name into first and last to make the username.
     * @author Brendan Beardsley
     * @param name takes the full name of the Employee and splits it
     *             into the first and last to create the username.
     */
    private void setUsername(String name) {
        String[] newName = name.split(" ");
        String first = newName[0];
        String last = newName[1];
        this.username = first.substring(0, 1).toLowerCase() + last.toLowerCase();
    }
    /***************************************************
     * Making sure that there is a space in the full name.
     * @author Brendan Beardsley
     * @param name checks if there is a space in between the first and
     *             last name of the Employee.
     */
    //
    private boolean checkName(String name) {
        final String RegexNameCheck = "([a-zA-Z]+\\s[a-zA-Z]+)";

        Pattern pattern = Pattern.compile(RegexNameCheck);

        return pattern.matcher(name).matches();
    }
    /***************************************************
     * Splitting the name into first and last to make the email.
     * @author Brendan Beardsley
     * @param name Employee's gets split into first and last name
     *             to create the email.
     */
    private void setEmail(String name) {
        String[] newName = name.split(" ");
        String first = newName[0];
        String last = newName[1];

        this.email = first.toLowerCase() + "." + last.toLowerCase() + "@oracleacademy.Test";
    }
    /***************************************************
     * Making sure password is containing at least a
     * lowercase letter, uppercase letter, and a special character.
     * @author Brendan Beardsley
     * @param password Employee's password gets verified.
     * @return if the password is valid or not.
     */
    private boolean isValidPassword(String password) {
        final String regexPassCheck = "(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%&])[a-zA-Z!@#$%&]+";

        Pattern pattern = Pattern.compile(regexPassCheck);

        return pattern.matcher(password).matches();
    }
    /***************************************************
     * Getter of Employee name.
     * @author Brendan Beardsley
     * @return the Employee's name.
     */

    public String getName() {
        return name;
    }
    /***************************************************
     * Setter of Employee name.
     * @author Brendan Beardsley
     * @param name sets the name.
     */

    public void setName(String name) {
        this.name = name;
    }
    /***************************************************
     * Getter of Employee username.
     * WARNING says can be package-private but then it breaks the Employee tableView.
     * @author Brendan Beardsley
     * @return the Employee username.
     */

    public String getUsername() {
        return username;
    }

    /***************************************************
     * Getter of Employee password.
     * WARNING says can be package-private but then it breaks the Employee tableView.
     * @author Brendan Beardsley
     * @return the Employee password.
     */

    //
    public String getPassword() {
        return password;
    }
    /***************************************************
     * Setter of Employee password.
     * @author Brendan Beardsley
     * @param password sets the password.
     */

    public void setPassword(String password) {
        this.password = password;
    }

    /***************************************************
     * Getter of Employee email.
     * WARNING says can be package-private but then it breaks the Employee tableView.
     * @author brendan
     * @return the Employee email
     */

    public String getEmail() {
        return email;
    }

    public String getDeptId() {
        return null;
    }
}