package mx.itesm.TheChamberWebRebuild.DAO;

import mx.itesm.TheChamberWebRebuild.model.Account;
import mx.itesm.TheChamberWebRebuild.model.Checkpoint;
import mx.itesm.TheChamberWebRebuild.model.Score;
import mx.itesm.TheChamberWebRebuild.model.Test;
import mx.itesm.TheChamberWebRebuild.util.MySQLConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AccountTablesDAO implements IAccountTablesDAO{

    @Override
    public Account getAccountById() {
        return null;
    }

    @Override
    public List<Account> list() {
        String accountQuery = "SELECT *  FROM account INNER JOIN roles ON account.rolid = roles.rolid/* WHERE account.rolId <= 1*/";
        String testQuery = "SELECT tests.testId, tests.accountId, teststatus.testStatusName, tests.beganAtTimeStamp, tests.duration, tests.finishedAtTimeStamp, tests.overallScore FROM tests INNER JOIN teststatus ON tests.testStatus_statusId = teststatus.statusId WHERE accountId = ?";
        String scoreQuery = "SELECT  scores.scoreId, scores.test_testId, softskills.softSkillName, scores.softSkillScore FROM scores INNER JOIN softskills ON scores.softSkill_idsoftSkill = softskills.softskillId WHERE scores.test_testId = ?";
        String checkpointQuery = "SELECT checkpoints.checkpointId, checkpoints.test_testId, checkpoints.checkpointScore, checkpoints.checkpointMaxScore, softskills.softSkillName, levelnames.levelName, puzzlenames.puzzleName, checkpoints.timeElapsed, checkpoints.timeStamp FROM checkpoints INNER JOIN levelnames ON checkpoints.levelId INNER JOIN puzzlenames ON checkpoints.puzzleId = puzzlenames.puzzleId INNER JOIN softskills ON checkpoints.softSkillId = softskills.softskillId WHERE checkpoints.test_testId = ?  GROUP BY checkpoints.checkpointId";
        Connection connection = MySQLConnection.getConnection();
        System.out.println("Lista de cuentas iniciada");
        List<Account> accountList = new ArrayList<>(); // Lista Main de cuentas
        try{
            System.out.println("Lista de cuentas creada");
            PreparedStatement accountPS = connection.prepareStatement(accountQuery);
            System.out.println("PreparedStatement de cuentas creado");
            ResultSet accountRS = accountPS.executeQuery();
            System.out.println("ResultSet de cuentas creado");
            while (accountRS.next()){
                List<Test> testList = new ArrayList<>();
                System.out.println("Lista de Test creado para " + accountRS.getString("username"));
                try{
                    PreparedStatement testPS = connection.prepareStatement(testQuery);
                    System.out.println("PreparedStatement de Test creado para " + accountRS.getString("username"));
                    testPS.setInt(1,accountRS.getInt("accountId"));
                    ResultSet testRS = testPS.executeQuery();
                    System.out.println("ResultSet de Test creado para " + accountRS.getString("username"));
                    while (testRS.next()){

                        List<Score> scoreList = new ArrayList<>();
                        System.out.println("List de Score del Test " + testRS.getInt("testId") + " creado para " + accountRS.getString("username"));
                        try{
                            PreparedStatement scorePS = connection.prepareStatement(scoreQuery);
                            System.out.println("PreparedStatement de Score del Test " + testRS.getInt("testId") + " creado para " + accountRS.getString("username"));
                            scorePS.setInt(1,testRS.getInt("testId"));
                            ResultSet scoreRS = scorePS.executeQuery();
                            System.out.println("ResultSet de Score del Test " + testRS.getInt("testId") + " creado para " + accountRS.getString("username"));
                            while (scoreRS.next()){
                                Score TempScore = new Score(
                                        scoreRS.getInt("scoreId"),
                                        scoreRS.getInt("test_testId"),
                                        scoreRS.getString("softSkillName"),
                                        scoreRS.getInt("softSkillScore")
                                );
                                scoreList.add(TempScore);
                                System.out.println("TempScore anadido a lista de Score del Test " + testRS.getInt("testId") + " creado para " + accountRS.getString("username"));

                            }
                        } catch (Exception ex) {
                            System.out.println("On no, una excepción en la seccion TempScore");
                            System.out.println("La excepción es: " + ex.getCause() + " " + ex.getMessage());
                        }

                        List<Checkpoint> checkpointList = new ArrayList<>();
                        System.out.println("Lista de Checkpoint creado para " + accountRS.getString("username"));

                        try {
                            PreparedStatement checkpointPS = connection.prepareStatement(checkpointQuery);
                            System.out.println("PreparedStatement de Checkpoint creado para " + accountRS.getString("username"));
                            checkpointPS.setInt(1,testRS.getInt("testId"));
                            ResultSet checkpointRS = checkpointPS.executeQuery();
                            System.out.println("ResultSet de Checkpoint del Test " + testRS.getInt("testId") + " creado para " + accountRS.getString("username"));
                            while (checkpointRS.next()){
                                Checkpoint TempCheckpoint = new Checkpoint(
                                        checkpointRS.getInt("test_testId"),
                                        checkpointRS.getInt("checkpointScore"),
                                        checkpointRS.getInt("checkpointMaxScore"),
                                        checkpointRS.getInt("timeElapsed"),
                                        checkpointRS.getString("levelName"),
                                        checkpointRS.getString("softSkillName"),
                                        checkpointRS.getString("puzzleName"),
                                        (checkpointRS.getTimestamp("timeStamp")).toString()
                                );
                                checkpointList.add(TempCheckpoint);
                                System.out.println("TempCheckpoint anadido a lista de Score del Test " + testRS.getInt("testId") + " creado para " + accountRS.getString("username"));
                            }
                        } catch (Exception ex) {
                            System.out.println("On no, una excepción en la seccion TempCheckpoint");
                            System.out.println("La excepción es: " + ex.getCause() + " " + ex.getMessage());
                        }
                        Test TempTest = new Test(
                                checkpointList,
                                scoreList,
                                testRS.getInt("testId"),
                                testRS.getInt("accountId"),
                                testRS.getString("testStatusName"),
                                (testRS.getTimestamp("beganAtTimeStamp")).toString(),
                                testRS.getInt("duration"),
                                (testRS.getTimestamp("finishedAtTimeStamp")).toString(),
                                testRS.getInt("overallScore")
                        );
                        testList.add(TempTest);
                        System.out.println("TempTest anadido a lista del Test " + testRS.getInt("testId") + " creado para " + accountRS.getString("username"));
                    }

                } catch (Exception ex) {
                    System.out.println("On no, una excepción en la seccion TempTest");
                    System.out.println("La excepción es: " + ex.getCause() + " " + ex.getMessage());
                }
                Account TempAccount = new Account(
                        testList,
                        accountRS.getInt("accountId"),
                        accountRS.getInt("rolid"),
                        accountRS.getString("firstName"),
                        accountRS.getString("lastName"),
                        accountRS.getString("username"),
                        accountRS.getString("email"),
                        accountRS.getString("password"),
                        accountRS.getString("curp"),
                        accountRS.getString("rolName")
                );
                accountList.add(TempAccount);
                System.out.println("TempAccount de "+ accountRS.getString("username") + " anadido a lista de Account");

            }
            System.out.println("Retornando lista de Account para " + accountRS.getString("username"));
            System.out.println(accountList);

        } catch (Exception ex) {
            System.out.println("On no, una excepción en la seccion lista de Account");
            System.out.println("La excepción es: " + ex.getCause() + " " + ex.getMessage());
        }
        System.out.println(accountList);
        return accountList;

    }
}
