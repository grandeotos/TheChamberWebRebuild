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

public class AccountTablesDAO {

    public List<Account> list() {
        System.out.println("Account list enabled");
        List<Account> accounts = new ArrayList<>();
        List<Test> testList = new ArrayList<>();
        String accountQuery = "SELECT *  FROM account INNER JOIN roles ON account.rolid = roles.rolid/* WHERE account.rolId <= 1*/";
        String testQuery = "SELECT tests.testId, tests.accountId, teststatus.testStatusName, tests.beganAtTimeStamp, tests.duration, tests.finishedAtTimeStamp, tests.overallScore FROM tests INNER JOIN teststatus ON tests.testStatus_statusId = teststatus.statusId WHERE accountId = ?";
        String scoresQuery = "SELECT  scores.scoreId, scores.test_testId, softskills.softSkillName, scores.softSkillScore FROM scores INNER JOIN softskills ON scores.softSkill_idsoftSkill = softskills.softskillId WHERE scores.test_testId = ?";
        String checkpointQuery = "SELECT checkpoints.checkpointId, checkpoints.test_testId, checkpoints.checkpointScore, checkpoints.checkpointMaxScore, softskills.softSkillName, levelnames.levelName, puzzlenames.puzzleName, checkpoints.timeElapsed, checkpoints.timeStamp FROM checkpoints INNER JOIN levelnames ON checkpoints.levelId INNER JOIN puzzlenames ON checkpoints.puzzleId = puzzlenames.puzzleId INNER JOIN softskills ON checkpoints.softSkillId = softskills.softskillId WHERE checkpoints.test_testId = ?";

        try{
            Connection connection = MySQLConnection.getConnection();
            PreparedStatement accPS = connection.prepareStatement(accountQuery);
            ResultSet accRSet = accPS.executeQuery();
            while (accRSet.next()){
                List<Checkpoint> checkpointList = new ArrayList<>();
                List<Score> scoreList = new ArrayList<>();
                try {
                    PreparedStatement testPS = connection.prepareStatement(testQuery);
                    testPS.setInt(1,accRSet.getInt("accountId"));
                    ResultSet testRS = testPS.executeQuery();
                    while (testRS.next()){
                        try {

                            PreparedStatement chkPS = connection.prepareStatement(checkpointQuery);
                            PreparedStatement scorePS = connection.prepareStatement(scoresQuery);
                            chkPS.setInt(1,testRS.getInt("testId"));
                            scorePS.setInt(1,testRS.getInt("testId"));
                            scoreList = new ArrayList<>();
                            checkpointList = new ArrayList<>();
                            ResultSet chkRS = chkPS.executeQuery();
                            while (chkRS.next()){
                                Checkpoint checkpoint = new Checkpoint(
                                chkRS.getInt("test_testId"),
                                chkRS.getInt("checkpointScore"),
                                chkRS.getInt("checkpointMaxScore"),
                                chkRS.getInt("timeElapsed"),
                                chkRS.getString("levelName"),
                                chkRS.getString("softSkillName"),
                                chkRS.getString("puzzleName"),
                                (chkRS.getTimestamp("timeStamp")).toString());
                                checkpointList.add(checkpoint);
                            }
                            ResultSet scoreRS = scorePS.executeQuery();
                            while (scoreRS.next()){
                                Score score = new Score(
                                        scoreRS.getInt("scoreId"),
                                        scoreRS.getInt("test_testId"),
                                        scoreRS.getString("softSkillName"),
                                        scoreRS.getInt("softSkillScore")
                                );
                                scoreList.add(score);
                            }
                        } catch(Exception ex){
                            System.out.println(ex.getMessage());
                        }
                        Test test = new Test(
                                checkpointList,
                                scoreList,
                                testRS.getInt("testId"),
                                testRS.getInt("accountId"),
                                testRS.getString("testStatusName"),
                                (testRS.getTimestamp("beganAtTimeStamp")).toString(),
                                testRS.getInt("duration"),
                                testRS.getString("finishedAtTimeStamp"),
                                testRS.getInt("overallScore")
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
