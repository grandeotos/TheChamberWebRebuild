package mx.itesm.TheChamberWebRebuild.DAO;

import mx.itesm.TheChamberWebRebuild.model.Account;
import mx.itesm.TheChamberWebRebuild.util.MySQLConnection;
import org.apache.commons.lang3.RandomStringUtils;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLOutput;


public class AccountDAO implements IAccountDAO {


    @Override
    public Account auth(String username, String password) {
        String sql = "SELECT account.accountId, account.firstName, account.lastName, account.username, account.email, account.curp, account.password, account.rolId, roles.rolName  FROM account INNER JOIN roles ON account.rolid = roles.rolid WHERE username = ? AND password = SHA2(?,224)";
        try{
            Connection conexion = MySQLConnection.getConnection();
            PreparedStatement preparedStatement = conexion.prepareStatement(sql);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            System.out.println(preparedStatement);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                Account account = new Account();
                account.setAccountId(resultSet.getInt("accountId"));
                account.setRolId(resultSet.getInt("rolId"));
                account.setFirstName(resultSet.getString("firstName"));
                account.setLastName(resultSet.getString("lastName"));
                account.setUsername(resultSet.getString("username"));
                account.setEmail(resultSet.getString("email"));
                account.setCurp(resultSet.getString("curp"));
                account.setPassword(resultSet.getString("password"));
                account.setRoleName(resultSet.getString("rolName"));
                System.out.println(account);
                conexion.close();
                return account;
            }else{
                conexion.close();
                return null;
            }
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return null;
    }

    @Override
    public int registerGamer(String firstName, String lastName, String username, String email, String password, String curp) {
        String sql = "UPDATE  `account` SET `rolid` = 1, `firstName`= ?, `lastName`= ?, `email`= ?, `password`= sha2(?,224), `curp`= ?, `create_time` = current_timestamp() WHERE username = ? AND password = sha2(?,224)";
        String sql2 = "SELECT COUNT(username) AS cuentas FROM account WHERE username = ?";
        try{
            Connection conexion = MySQLConnection.getConnection();
            PreparedStatement preparedStatement = conexion.prepareStatement(sql);
            PreparedStatement userdet = conexion.prepareStatement(sql2);
            userdet.setString(1, username);
            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, lastName);
            preparedStatement.setString(3, email);
            preparedStatement.setString(4, password);
            preparedStatement.setString(5, curp);
            preparedStatement.setString(6, username);
            preparedStatement.setString(7, email);
            System.out.println("Preparados: ");
            System.out.println(userdet);
            System.out.println(preparedStatement);
            int sameAccount = 0;
            try{
                System.out.println("Se ejecuta cuentas");
                ResultSet cuentas =  userdet.executeQuery();
                if(cuentas.next()){
                    sameAccount = cuentas.getInt("cuentas");
                    System.out.println(sameAccount);
                }
                if(sameAccount > 1){
                    System.out.println("Duplicado");
                    conexion.close();
                    return 2;
                } else {
                    int isRegistered  =  preparedStatement.executeUpdate();
                    System.out.println("isRegistered: " + isRegistered);
                    if(isRegistered > 0){
                        System.out.println("registrado");
                        conexion.close();
                        return 1;
                    }
                    else{
                        System.out.println("No registrado");
                        conexion.close();
                        return 0;
                    }
                }
            }catch(Exception ex){
                System.out.println(ex.getMessage());
            }
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return 0;
    }

    @Override
    public int registerAplicant(String firstName, String lastName, String email, String telp, int exper, int profix) {
        String sql = "INSERT INTO `applicant` (`idapplicant`, `firstName`, `lastName`, `email`, `phoneNumber`, `experienceId`, `profileId`, `reviewStatusId`) VALUES (NULL, ?, ?, ?, ?, ?, ?, '0')";
        String sql2 = "SELECT COUNT(email) AS cuentas FROM applicant WHERE email = ?";

        try{
            Connection conexion = MySQLConnection.getConnection();
            PreparedStatement preparedStatement = conexion.prepareStatement(sql);
            PreparedStatement userdet = conexion.prepareStatement(sql2);
            userdet.setString(1, email);
            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, lastName);
            preparedStatement.setString(3, email);
            preparedStatement.setString(4, telp);
            preparedStatement.setInt(5, exper);
            preparedStatement.setInt(6, profix);
            System.out.println(preparedStatement);
            int sameAccount = 0;

            int isRegistered  =  preparedStatement.executeUpdate();
            try{
                System.out.println("Se ejecuta cuentas");
                ResultSet cuentas =  userdet.executeQuery();
                if(cuentas.next()){
                    sameAccount = cuentas.getInt("cuentas");
                }
                if(sameAccount > 1){
                    System.out.println("Duplicado");
                    conexion.close();
                    return 2;
                } else {
                    if(isRegistered == 1){
                        System.out.println("registrado");
                        conexion.close();
                        return 1;
                    }
                    else{
                        System.out.println("No registrado");
                        conexion.close();
                        return 0;
                    }
                }
            }catch(Exception ex){
                System.out.println(ex.getMessage());
            }
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return 0;
    }

    @Override
    public int registerGamer(String username, String email) {
        System.out.println("ROMAAAAA");
        //String sql3 = "INSERT INTO `account (`accountId`, `rolid`, `username`, `email`, `password`, `create_time`) VALUES (NULL , '0', ?, ?, sha2(?,224), current_timestamp())";
        String sql = "INSERT INTO `account` (`accountId`, `rolid`, `firstName`, `lastName`, `username`, `email`, `password`, `curp`, `create_time`) VALUES (NULL, '0', NULL, NULL, ?, ?, sha2(?,224), NULL, current_timestamp())";
        String sql2 = "SELECT COUNT(username) AS cuentas FROM account WHERE username = ?";
        try{
            Connection conexion = MySQLConnection.getConnection();
            PreparedStatement preparedStatement = conexion.prepareStatement(sql);
            PreparedStatement userdet = conexion.prepareStatement(sql2);
            userdet.setString(1, username);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, email);
            preparedStatement.setString(3, email);
            System.out.println("Preparados: ");
            System.out.println(userdet);
            System.out.println(preparedStatement);
            int sameAccount = 0;
            try{
                System.out.println("Se ejecuta cuentas");
                ResultSet cuentas =  userdet.executeQuery();
                if(cuentas.next()){
                    sameAccount = cuentas.getInt("cuentas");
                }
                if(sameAccount > 0){
                    conexion.close();
                    System.out.println("Duplicado");
                    return 2;
                } else {
                    int isRegistered  =  preparedStatement.executeUpdate();
                    if(isRegistered == 1){
                        System.out.println("registrado");
                        conexion.close();
                        return 1;
                    }
                    else{
                        conexion.close();
                        System.out.println("No registrado");
                        return 0;
                    }
                }

            }catch(Exception ex){
                System.out.println(ex.getMessage());
            }
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return 0;
    }

    @Override
    public String getNewGamerID() {
        String generatedString = null;
        String sql = "SELECT COUNT(username) AS cuentaUsuario FROM account WHERE username = ?";
        try{
            int sameAccount = 1;
            while (sameAccount > 0){
                int length = 3;
                generatedString = (RandomStringUtils.random(length, true, false) + RandomStringUtils.random(length, false, true)).toUpperCase();
                System.out.println(generatedString);
                try {
                    Connection conexion = MySQLConnection.getConnection();
                    PreparedStatement preparedStatement = conexion.prepareStatement(sql);
                    preparedStatement.setString(1,generatedString);
                    ResultSet usernameRS =  preparedStatement.executeQuery();
                    System.out.println(preparedStatement);
                    if(usernameRS.next()){
                        sameAccount = usernameRS.getInt("cuentaUsuario");
                    }
                    conexion.close();
                } catch(Exception ex){
                    System.out.println(ex.getMessage());
                }

            }
            return generatedString;
        }  catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return null;
    }

}
