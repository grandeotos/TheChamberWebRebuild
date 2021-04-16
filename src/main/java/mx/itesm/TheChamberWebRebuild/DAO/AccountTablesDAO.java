package mx.itesm.TheChamberWebRebuild.DAO;

import mx.itesm.TheChamberWebRebuild.model.Account;
import mx.itesm.TheChamberWebRebuild.util.MySQLConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AccountTablesDAO {

    public List<Account> list() {
        System.out.println("Account list enabled");
        List<Account> accounts = new ArrayList<>();
        String sql = "SELECT account.accountId, account.firstName, account.lastName, account.username, account.email, account.curp, account.password, account.rolId, roles.rolName  FROM account INNER JOIN roles ON account.rolid = roles.rolid WHERE account.rolId <= 1";

        try{
            Connection connection = MySQLConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Account cuenta = new Account();
                cuenta.setAccountId(resultSet.getInt("accountId"));
                cuenta.setRolId(resultSet.getInt("rolId"));
                cuenta.setFirstName(resultSet.getString("firstName"));
                cuenta.setLastName(resultSet.getString("lastName"));
                cuenta.setUsername(resultSet.getString("username"));
                cuenta.setEmail(resultSet.getString("email"));
                cuenta.setCurp(resultSet.getString("curp"));
                cuenta.setPassword(resultSet.getString("password"));
                cuenta.setRoleName(resultSet.getString("rolName"));
                accounts.add(cuenta);
                //System.out.println("SOUT ACTDAO:" + cuenta);
            }
            connection.close();
            return accounts;
        } catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return null;
    }
}
