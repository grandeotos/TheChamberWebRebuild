package mx.itesm.TheChamberWebRebuild.DAO;

import mx.itesm.TheChamberWebRebuild.model.Account;
import mx.itesm.TheChamberWebRebuild.model.Checkpoint;
import mx.itesm.TheChamberWebRebuild.model.Test;
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
        List<Test> testList = new ArrayList<>();
        String accountQuery = "SELECT *  FROM account INNER JOIN roles ON account.rolid = roles.rolid WHERE account.rolId <= 1";
        String testQuery = "SELECT * FROM test where accountId = ?";
        String checkpointId = "SELECT * FROM checkpoints where idprueba = ?";

        try{
            Connection connection = MySQLConnection.getConnection();
            PreparedStatement accPS = connection.prepareStatement(accountQuery);
            ResultSet accRSet = accPS.executeQuery();
            while (accRSet.next()){
                List<Checkpoint> checkpointList = new ArrayList<>();
                try {
                    PreparedStatement testPS = connection.prepareStatement(testQuery);
                    testPS.setInt(1,accRSet.getInt("accountId"));
                    ResultSet testRS = testPS.executeQuery();
                    while (testRS.next()){
                        try {
                            PreparedStatement chkPS = connection.prepareStatement(checkpointId);
                            chkPS.setInt(1,testRS.getInt("idpruebas"));
                            checkpointList = new ArrayList<>();
                            System.out.println(chkPS);
                            ResultSet chkRS = chkPS.executeQuery();
                            while (chkRS.next()){
                                Checkpoint checkpoint = new Checkpoint(
                                chkRS.getInt("checkpointid"),
                                chkRS.getInt("idprueba"),
                                chkRS.getInt("score"),
                                chkRS.getInt("maxScore"),
                                chkRS.getInt("idsoftSkill"),
                                chkRS.getInt("idlevel"),
                                chkRS.getInt("idPuzzle"),
                                chkRS.getInt("timeElapsed"),
                                (chkRS.getTimestamp("timeStamp")).toString());
                                checkpointList.add(checkpoint);
                            }

                        } catch(Exception ex){
                            System.out.println(ex.getMessage());
                        }
                        Test test = new Test(
                                checkpointList,
                                testRS.getInt("idpruebas"),
                                testRS.getInt("accountId"),
                                (testRS.getTimestamp("timeStamp")).toString()
                        );
                        testList.add(test);
                    }
                } catch(Exception ex){
                    System.out.println(ex.getMessage());
                }
                Account cuenta = new Account(
                        testList,
                        accRSet.getInt("accountId"),
                        accRSet.getInt("rolId"),
                        accRSet.getString("firstName"),
                        accRSet.getString("lastName"),
                        accRSet.getString("username"),
                        accRSet.getString("email"),
                        accRSet.getString("password"),
                        accRSet.getString("curp"),
                        accRSet.getString("rolName")
                        );
                //System.out.println(cuenta);
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
