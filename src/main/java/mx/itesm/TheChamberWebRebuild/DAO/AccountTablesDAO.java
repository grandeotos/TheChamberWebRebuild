package mx.itesm.TheChamberWebRebuild.DAO;

import com.google.gson.Gson;
import mx.itesm.TheChamberWebRebuild.model.*;
import mx.itesm.TheChamberWebRebuild.util.MySQLConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AccountTablesDAO implements IAccountTablesDAO{

    @Override
    public Account getAccountByUsername(String Username) {
        String accountQuery = "SELECT *  FROM account INNER JOIN roles ON account.rolid = roles.rolid WHERE account.username = ?";
        String testQuery = "SELECT tests.testId, tests.accountId, testStatus.testStatusName, tests.beganAtTimeStamp, tests.duration, tests.finishedAtTimeStamp, tests.overallScore FROM tests INNER JOIN testStatus ON tests.testStatus_statusId = testStatus.statusId WHERE accountId = ?";
        String scoreQuery = "SELECT  scores.scoreId, scores.test_testId, softSkills.softSkillName, scores.softSkillScore FROM scores INNER JOIN softSkills ON scores.softSkill_idsoftSkill = softSkills.softskillId WHERE scores.test_testId = ? ORDER BY scores.scoreId ASC";
        String checkpointQuery = "SELECT checkpoints.checkpointId, checkpoints.test_testId,  checkpoints.test_testId AS testIdd ,checkpoints.checkpointScore, checkpoints.checkpointMaxScore, softSkills.softSkillName, levelNames.levelName, puzzleNames.puzzleName, checkpoints.timeElapsed, checkpoints.timeStamp FROM checkpoints INNER JOIN levelNames ON checkpoints.levelId = levelNames.levelId INNER JOIN puzzleNames ON checkpoints.puzzleId = puzzleNames.puzzleId INNER JOIN softSkills ON checkpoints.softSkillId = softSkills.softskillId WHERE checkpoints.test_testId = ? ORDER BY testIdd DESC, checkpoints.checkpointId ASC";
        Connection connection = MySQLConnection.getConnection();
        System.out.println("Lista de cuentas iniciada");
        Account TempAccount = new Account();
        try{
            PreparedStatement accountPS = connection.prepareStatement(accountQuery);
            accountPS.setString(1,Username);
            ResultSet accountRS = accountPS.executeQuery();
            if(accountRS.next()){
                try{
                    List<Test> testList = new ArrayList<Test>();
                    try{
                        PreparedStatement testPS = connection.prepareStatement(testQuery);
                        testPS.setInt(1,accountRS.getInt("accountId"));
                        ResultSet testRS = testPS.executeQuery();
                        while (testRS.next()){
                            List<Score> scoreList = new ArrayList<Score>();
                            try{
                                PreparedStatement scorePS = connection.prepareStatement(scoreQuery);
                                scorePS.setInt(1,testRS.getInt("testId"));
                                ResultSet scoreRS = scorePS.executeQuery();
                                while (scoreRS.next()){
                                    Score TempScore = new Score(
                                            scoreRS.getInt("scoreId"),
                                            scoreRS.getInt("test_testId"),
                                            scoreRS.getString("softSkillName"),
                                            scoreRS.getInt("softSkillScore")
                                    );
                                    System.out.println("GSON Score");
                                    Gson gson = new Gson();
                                    System.out.println(gson.toJson(TempScore));
                                    scoreList.add(TempScore);
                                }
                            } catch (SQLException e1) {
                                System.out.println("Could not retrieve database metadata " + e1.getMessage());

                            } catch(Exception ex){
                                System.out.println("Linea a");
                                System.out.println(ex.getClass().getCanonicalName() + " " + ex.getMessage());
                            }
                            List<Checkpoint> checkpointList = new ArrayList<Checkpoint>();
                            try {
                                PreparedStatement checkpointPS = connection.prepareStatement(checkpointQuery);
                                checkpointPS.setInt(1,testRS.getInt("testId"));
                                ResultSet checkpointRS = checkpointPS.executeQuery();
                                while (checkpointRS.next()){
                                    Checkpoint TempCheckpoint = new Checkpoint(
                                            checkpointRS.getInt("checkpointId"),
                                            checkpointRS.getInt("test_testId"),
                                            checkpointRS.getInt("checkpointScore"),
                                            checkpointRS.getInt("checkpointMaxScore"),
                                            checkpointRS.getInt("timeElapsed"),
                                            checkpointRS.getString("levelName"),
                                            checkpointRS.getString("softSkillName"),
                                            checkpointRS.getString("puzzleName"),
                                            checkpointRS.getString("timeStamp")
                                            );
                                    System.out.println("GSON Checkpoint");
                                    Gson gson = new Gson();
                                    System.out.println(gson.toJson(TempCheckpoint));
                                    checkpointList.add(TempCheckpoint);
                                }
                            } catch (SQLException e1) {
                                System.out.println("Could not retrieve database metadata " + e1.getMessage());
                            } catch(Exception ex){
                                System.out.println("Linea b");
                                System.out.println(ex.getClass().getCanonicalName() + " " + ex.getMessage());
                            }
                            Test TempTest = new Test(
                                    checkpointList,
                                    scoreList,
                                    testRS.getInt("testId"),
                                    testRS.getInt("accountId"),
                                    testRS.getString("testStatusName"),
                                    testRS.getString("beganAtTimeStamp"),
                                    testRS.getInt("duration"),
                                    testRS.getString("finishedAtTimeStamp"),
                                    testRS.getInt("overallScore")
                            );
                            System.out.println("GSON Test");
                            Gson gson = new Gson();
                            System.out.println(gson.toJson(TempTest));
                            testList.add(TempTest);
                        }
                    } catch (SQLException e1) {
                        System.out.println("Could not retrieve database metadata " + e1.getMessage());
                    } catch(Exception ex){
                        System.out.println("Linea c");
                        System.out.println(ex.getClass().getCanonicalName() + " " + ex.getMessage());
                    }
                     TempAccount = new Account(
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
                } catch (SQLException e1) {
                    System.out.println("Could not retrieve database metadata " + e1.getMessage());
                } catch(Exception ex){
                    System.out.println("Linea d");
                    System.out.println(ex.getClass().getCanonicalName() + " " + ex.getMessage());
                }
            }
        } catch (SQLException e1) {
            System.out.println("Could not retrieve database metadata " + e1.getMessage());
        } catch(Exception ex){
            System.out.println("Linea e");
            System.out.println(ex.getClass().getCanonicalName() + " " + ex.getMessage());
        }
        System.out.println("GSON Account");
        Gson gson = new Gson();
        System.out.println(gson.toJson(TempAccount));
        return TempAccount;
    }

    @Override
    public Account getRecentTestByUsername(String Username) {
        return null;
    }

    @Override
    public Account getRecentScoresByUsername(String Username) {
        return null;
    }

    @Override
    public Applicant getApplicantById(int appId) {
        String applicantQuery = "SELECT  applicant.applicantId, applicant.firstName, applicant.lastName, applicant.email, applicant.phoneNumber, applicant.reviewStatusId, experience.experienceName, profile.profileName, reviewStatus.reviewStatusName from applicant INNER JOIN experience ON experience.experienceId = applicant.experienceId INNER JOIN profile ON profile.profileId  = applicant.profileId INNER JOIN reviewStatus on applicant.reviewStatusId = reviewStatus.reviewStatusId WHERE applicant.applicantId = ?";
        Connection connection = MySQLConnection.getConnection();
        System.out.println("Lista de cuentas iniciada");
        Applicant TempApplicant;
        try{
            PreparedStatement applicantsPS = connection.prepareStatement(applicantQuery);
            applicantsPS.setInt(1, appId);
            ResultSet applicantsRS = applicantsPS.executeQuery();
            if (applicantsRS.next()){
                TempApplicant = new Applicant(
                        applicantsRS.getInt("applicantId"),
                        applicantsRS.getString("firstName"),
                        applicantsRS.getString("lastName"),
                        applicantsRS.getString("email"),
                        applicantsRS.getString("phoneNumber"),
                        applicantsRS.getString("experienceName"),
                        applicantsRS.getString("profileName"),
                        applicantsRS.getString("reviewStatusName"),
                        applicantsRS.getInt("reviewStatusId")
                );
            } else {
                return null;
            }
            Gson gson = new Gson();
            System.out.println(gson.toJson(TempApplicant));
            return TempApplicant;
        } catch (SQLException e1) {
            System.out.println("Could not retrieve database metadata " + e1.getMessage());
        } catch(Exception ex){
            System.out.println("Linea f");
            System.out.println(ex.getClass().getCanonicalName() + " " + ex.getMessage());
        }
        return null;
    }

    @Override
    public List<Applicant> ApplicantList(){
        String applicantQuery = "SELECT  applicant.applicantId, applicant.firstName, applicant.lastName, applicant.email, applicant.phoneNumber, applicant.reviewStatusId, experience.experienceName, profile.profileName, reviewStatus.reviewStatusName from applicant INNER JOIN experience ON experience.experienceId = applicant.experienceId INNER JOIN profile ON profile.profileId  = applicant.profileId INNER JOIN reviewStatus on applicant.reviewStatusId = reviewStatus.reviewStatusId";
        Connection connection = MySQLConnection.getConnection();
        System.out.println("Lista de cuentas iniciada");
        List<Applicant> applicantList = new ArrayList<Applicant>(); // Lista Main de cuentas
        try{
            PreparedStatement applicantsPS = connection.prepareStatement(applicantQuery);
            ResultSet applicantsRS = applicantsPS.executeQuery();
            while (applicantsRS.next()){
                Applicant TempApplicant = new Applicant(
                        applicantsRS.getInt("applicantId"),
                        applicantsRS.getString("firstName"),
                        applicantsRS.getString("lastName"),
                        applicantsRS.getString("email"),
                        applicantsRS.getString("phoneNumber"),
                        applicantsRS.getString("experienceName"),
                        applicantsRS.getString("profileName"),
                        applicantsRS.getString("reviewStatusName"),
                        applicantsRS.getInt("reviewStatusId")
                );
                applicantList.add(TempApplicant);

            }

        } catch (SQLException e1) {
            System.out.println("Could not retrieve database metadata " + e1.getMessage());
        } catch(Exception ex){
            System.out.println("Linea f");
            System.out.println(ex.getClass().getCanonicalName() + " " + ex.getMessage());
        }
        Gson gson = new Gson();
        System.out.println(gson.toJson(applicantList));
        return applicantList;
    }

    @Override
    public List<Account> listAll() {
        String accountQuery = "SELECT *  FROM account INNER JOIN roles ON account.rolid = roles.rolid";
        String testQuery = "SELECT tests.testId, tests.accountId, testStatus.testStatusName, tests.beganAtTimeStamp, tests.duration, tests.finishedAtTimeStamp, tests.overallScore FROM tests INNER JOIN testStatus ON tests.testStatus_statusId = testStatus.statusId WHERE accountId = ?";
        String scoreQuery = "SELECT  scores.scoreId, scores.test_testId, softSkills.softSkillName, scores.softSkillScore FROM scores INNER JOIN softSkills ON scores.softSkill_idsoftSkill = softSkills.softskillId WHERE scores.test_testId = ? ORDER BY scores.scoreId ASC";
        String checkpointQuery = "SELECT checkpoints.checkpointId, checkpoints.test_testId,  checkpoints.test_testId AS testIdd ,checkpoints.checkpointScore, checkpoints.checkpointMaxScore, softSkills.softSkillName, levelNames.levelName, puzzleNames.puzzleName, checkpoints.timeElapsed, checkpoints.timeStamp FROM checkpoints INNER JOIN levelNames ON checkpoints.levelId = levelNames.levelId INNER JOIN puzzleNames ON checkpoints.puzzleId = puzzleNames.puzzleId INNER JOIN softSkills ON checkpoints.softSkillId = softSkills.softskillId WHERE checkpoints.test_testId = ? ORDER BY testIdd DESC, checkpoints.checkpointId ASC";
        Connection connection = MySQLConnection.getConnection();
        System.out.println("Lista de cuentas iniciada");
        List<Account> accountList = new ArrayList<Account>(); // Lista Main de cuentas
        try{
            PreparedStatement accountPS = connection.prepareStatement(accountQuery);
            ResultSet accountRS = accountPS.executeQuery();
            while (accountRS.next()){
                List<Test> testList = new ArrayList<Test>();
                try{
                    PreparedStatement testPS = connection.prepareStatement(testQuery);
                    testPS.setInt(1,accountRS.getInt("accountId"));
                    ResultSet testRS = testPS.executeQuery();
                    while (testRS.next()){
                        List<Score> scoreList = new ArrayList<Score>();
                        try{
                            PreparedStatement scorePS = connection.prepareStatement(scoreQuery);
                            scorePS.setInt(1,testRS.getInt("testId"));
                            ResultSet scoreRS = scorePS.executeQuery();
                            while (scoreRS.next()){
                                Score TempScore = new Score(
                                        scoreRS.getInt("scoreId"),
                                        scoreRS.getInt("test_testId"),
                                        scoreRS.getString("softSkillName"),
                                        scoreRS.getInt("softSkillScore")
                                );
                                scoreList.add(TempScore);
                            }
                        } catch (SQLException e1) {
                            System.out.println("Could not retrieve database metadata " + e1.getMessage());
                        } catch(Exception ex){
                            System.out.println("Linea g");
                            System.out.println(ex.getClass().getCanonicalName() + " " + ex.getMessage());
                        }
                        List<Checkpoint> checkpointList = new ArrayList<Checkpoint>();
                        try {
                            PreparedStatement checkpointPS = connection.prepareStatement(checkpointQuery);
                            checkpointPS.setInt(1,testRS.getInt("testId"));
                            ResultSet checkpointRS = checkpointPS.executeQuery();
                            while (checkpointRS.next()){
                                Checkpoint TempCheckpoint = new Checkpoint(
                                        checkpointRS.getInt("checkpointId"),
                                        checkpointRS.getInt("test_testId"),
                                        checkpointRS.getInt("checkpointScore"),
                                        checkpointRS.getInt("checkpointMaxScore"),
                                        checkpointRS.getInt("timeElapsed"),
                                        checkpointRS.getString("levelName"),
                                        checkpointRS.getString("softSkillName"),
                                        checkpointRS.getString("puzzleName"),
                                        checkpointRS.getString("timeStamp")
                                );
                                checkpointList.add(TempCheckpoint);
                            }
                        } catch (SQLException e1) {
                            System.out.println("Could not retrieve database metadata " + e1.getMessage());
                        } catch(Exception ex){
                            System.out.println("Linea h");
                            System.out.println(ex.getClass().getCanonicalName() + " " + ex.getMessage());
                        }
                        Test TempTest = new Test(
                                checkpointList,
                                scoreList,
                                testRS.getInt("testId"),
                                testRS.getInt("accountId"),
                                testRS.getString("testStatusName"),
                                testRS.getString("beganAtTimeStamp"),
                                testRS.getInt("duration"),
                                testRS.getString("finishedAtTimeStamp"),
                                testRS.getInt("overallScore")
                        );
                        testList.add(TempTest);
                    }
                } catch (SQLException e1) {
                    System.out.println("Could not retrieve database metadata " + e1.getMessage());
                } catch(Exception ex){
                    System.out.println("Linea i");
                    System.out.println(ex.getClass().getCanonicalName() + " " + ex.getMessage());
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

            }
            Gson gson = new Gson();
            System.out.println(gson.toJson(accountList));
            return accountList;

        } catch (SQLException e1) {
            System.out.println("Could not retrieve database metadata " + e1.getMessage());
        } catch(Exception ex){
            System.out.println("Linea j");
            System.out.println(ex.getClass().getCanonicalName() + " " + ex.getMessage());
        }
        return null;
    }

    @Override
    public List<Account> list() {
        String accountQuery = "SELECT *  FROM account INNER JOIN roles ON account.rolid = roles.rolid WHERE account.rolId <= 2";
        String testQuery = "SELECT tests.testId, tests.accountId, testStatus.testStatusName, tests.beganAtTimeStamp, tests.duration, tests.finishedAtTimeStamp, tests.overallScore FROM tests INNER JOIN testStatus ON tests.testStatus_statusId = testStatus.statusId WHERE accountId = ?";
        String scoreQuery = "SELECT  scores.scoreId, scores.test_testId, softSkills.softSkillName, scores.softSkillScore FROM scores INNER JOIN softSkills ON scores.softSkill_idsoftSkill = softSkills.softskillId WHERE scores.test_testId = ? ORDER BY scores.scoreId ASC";
        String checkpointQuery = "SELECT checkpoints.checkpointId, checkpoints.test_testId,  checkpoints.test_testId AS testIdd ,checkpoints.checkpointScore, checkpoints.checkpointMaxScore, softSkills.softSkillName, levelNames.levelName, puzzleNames.puzzleName, checkpoints.timeElapsed, checkpoints.timeStamp FROM checkpoints INNER JOIN levelNames ON checkpoints.levelId = levelNames.levelId INNER JOIN puzzleNames ON checkpoints.puzzleId = puzzleNames.puzzleId INNER JOIN softSkills ON checkpoints.softSkillId = softSkills.softskillId WHERE checkpoints.test_testId = ? ORDER BY testIdd DESC, checkpoints.checkpointId ASC";
        Connection connection = MySQLConnection.getConnection();
        System.out.println("Lista de cuentas iniciada");
        List<Account> accountList = new ArrayList<Account>(); // Lista Main de cuentas
        try{
            PreparedStatement accountPS = connection.prepareStatement(accountQuery);
            ResultSet accountRS = accountPS.executeQuery();
            while (accountRS.next()){
                List<Test> testList = new ArrayList<Test>();
                try{
                    PreparedStatement testPS = connection.prepareStatement(testQuery);
                    testPS.setInt(1,accountRS.getInt("accountId"));
                    ResultSet testRS = testPS.executeQuery();
                    while (testRS.next()){
                        List<Score> scoreList = new ArrayList<Score>();
                        try{
                            PreparedStatement scorePS = connection.prepareStatement(scoreQuery);
                            scorePS.setInt(1,testRS.getInt("testId"));
                            ResultSet scoreRS = scorePS.executeQuery();
                            while (scoreRS.next()){
                                Score TempScore = new Score(
                                        scoreRS.getInt("scoreId"),
                                        scoreRS.getInt("test_testId"),
                                        scoreRS.getString("softSkillName"),
                                        scoreRS.getInt("softSkillScore")
                                );
                                scoreList.add(TempScore);
                            }
                        } catch (SQLException e1) {
                            System.out.println("Could not retrieve database metadata " + e1.getMessage());
                        } catch(Exception ex){
                            System.out.println("Linea g");
                            System.out.println(ex.getClass().getCanonicalName() + " " + ex.getMessage());
                        }
                        List<Checkpoint> checkpointList = new ArrayList<Checkpoint>();
                        try {
                            PreparedStatement checkpointPS = connection.prepareStatement(checkpointQuery);
                            checkpointPS.setInt(1,testRS.getInt("testId"));
                            ResultSet checkpointRS = checkpointPS.executeQuery();
                            while (checkpointRS.next()){
                                Checkpoint TempCheckpoint = new Checkpoint(
                                        checkpointRS.getInt("checkpointId"),
                                        checkpointRS.getInt("test_testId"),
                                        checkpointRS.getInt("checkpointScore"),
                                        checkpointRS.getInt("checkpointMaxScore"),
                                        checkpointRS.getInt("timeElapsed"),
                                        checkpointRS.getString("levelName"),
                                        checkpointRS.getString("softSkillName"),
                                        checkpointRS.getString("puzzleName"),
                                        checkpointRS.getString("timeStamp")
                                );
                                checkpointList.add(TempCheckpoint);
                            }
                        } catch (SQLException e1) {
                            System.out.println("Could not retrieve database metadata " + e1.getMessage());
                        } catch(Exception ex){
                            System.out.println("Linea h");
                            System.out.println(ex.getClass().getCanonicalName() + " " + ex.getMessage());
                        }
                        Test TempTest = new Test(
                                checkpointList,
                                scoreList,
                                testRS.getInt("testId"),
                                testRS.getInt("accountId"),
                                testRS.getString("testStatusName"),
                                testRS.getString("beganAtTimeStamp"),
                                testRS.getInt("duration"),
                                testRS.getString("finishedAtTimeStamp"),
                                testRS.getInt("overallScore")
                        );
                        testList.add(TempTest);
                    }
                } catch (SQLException e1) {
                    System.out.println("Could not retrieve database metadata " + e1.getMessage());
                } catch(Exception ex){
                    System.out.println("Linea i");
                    System.out.println(ex.getClass().getCanonicalName() + " " + ex.getMessage());
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

            }
            Gson gson = new Gson();
            System.out.println(gson.toJson(accountList));
            return accountList;

        } catch (SQLException e1) {
            System.out.println("Could not retrieve database metadata " + e1.getMessage());
        } catch(Exception ex){
            System.out.println("Linea j");
            System.out.println(ex.getClass().getCanonicalName() + " " + ex.getMessage());
        }
        return null;
    }
}
