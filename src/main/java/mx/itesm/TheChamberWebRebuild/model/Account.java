package mx.itesm.TheChamberWebRebuild.model;

import java.io.Serializable;
import java.util.List;

public class Account implements Serializable {
    private List<Test> testList;
    private int accountId;
    private int rolId;
    private String firstName;
    private String lastName;
    private String username;
    private String email;
    private String password;
    private String curp;
    private String roleName;

    public Account() {

    }

    public Account(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public Account(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public Account(int accountId, int rolId, String firstName, String lastName, String username, String email, String password, String curp) {
        this.accountId = accountId;
        this.rolId = rolId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.email = email;
        this.password = password;
        this.curp = curp;
    }

    public Account(List<Test> testList, int accountId, int rolId, String firstName, String lastName, String username, String email, String password, String curp, String roleName) {
        this.testList = testList;
        this.accountId = accountId;
        this.rolId = rolId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.email = email;
        this.password = password;
        this.curp = curp;
        this.roleName = roleName;
    }

    public Account(int accountId, int rolId, String firstName, String lastName, String username, String email, String password, String curp, String roleName) {
        this.accountId = accountId;
        this.rolId = rolId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.email = email;
        this.password = password;
        this.curp = curp;
        this.roleName = roleName;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public int getRolId() {
        return rolId;
    }

    public void setRolId(int rolId) {
        this.rolId = rolId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public List<Test> getTestList() {
        return testList;
    }

    public void setTestList(List<Test> testList) {
        this.testList = testList;
    }

    @Override
    public String toString() {
        return "Account{" +
                "testList=" + testList +
                ", accountId=" + accountId +
                ", rolId=" + rolId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", curp='" + curp + '\'' +
                ", roleName='" + roleName + '\'' +
                '}';
    }
}
