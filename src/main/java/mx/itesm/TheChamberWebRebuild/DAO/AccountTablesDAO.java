package mx.itesm.TheChamberWebRebuild.DAO;

import mx.itesm.TheChamberWebRebuild.model.*;
import mx.itesm.TheChamberWebRebuild.util.MySQLConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AccountTablesDAO implements IAccountTablesDAO{

    @Override
    public Account getAccountByUsername(String Username) {
        String accountQuery = "SELECT *  FROM account INNER JOIN roles ON account.rolid = roles.rolid WHERE account.username = ?";
        String testQuery = "SELECT tests.testId, tests.accountId, testStatus.testStatusName, tests.beganAtTimeStamp, tests.duration, tests.finishedAtTimeStamp, tests.overallScore FROM tests INNER JOIN testStatus ON tests.testStatus_statusId = testStatus.statusId WHERE accountId = ?";
        String scoreQuery = "SELECT  scores.scoreId, scores.test_testId, softSkills.softSkillName, scores.softSkillScore FROM scores INNER JOIN softSkills ON scores.softSkill_idsoftSkill = softSkills.softskillId WHERE scores.test_testId = ? ORDER BY scores.scoreId ASC";
        String checkpointQuery = "SELECT checkpoints.checkpointId, checkpoints.test_testId,  checkpoints.test_testId AS testIdd ,checkpoints.checkpointScore, checkpoints.checkpointMaxScore, softSkills.softSkillName, levelNames.levelName, puzzleNames.puzzleName, checkpoints.timeElapsed, checkpoints.timeStamp FROM checkpoints INNER JOIN levelNames ON checkpoints.levelId INNER JOIN puzzleNames ON checkpoints.puzzleId = puzzleNames.puzzleId INNER JOIN softSkills ON checkpoints.softSkillId = softSkills.softskillId WHERE checkpoints.test_testId = ? ORDER BY testIdd DESC, checkpoints.checkpointId ASC";
        Connection connection = MySQLConnection.getConnection();
        System.out.println("Lista de cuentas iniciada");
        Account TempAccount = new Account();
        try{
            System.out.println("Lista de cuentas creada");
            PreparedStatement accountPS = connection.prepareStatement(accountQuery);
            accountPS.setString(1, Username);
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
                System.out.println("TempAccount de "+ accountRS.getString("username") + " anadido a lista de Account");

            }
            //System.out.println("Retornando lista de Account para " + accountRS.getString("username"));
            //System.out.println(TempAccount);

        } catch (Exception ex) {
            System.out.println("On no, una excepción en la seccion lista de Account");
            System.out.println("La excepción es: " + ex.getCause() + " " + ex.getMessage());
        }
        System.out.println(TempAccount);
        return TempAccount;

    }

    @Override
    public List<Applicant> ApplicantList(){
        String applicantQuery = "SELECT  applicant.applicantId, applicant.firstName, applicant.lastName, applicant.email, applicant.phoneNumber, experience.experienceName, profile.profileName, reviewStatus.reviewStatusName from applicant INNER JOIN experience ON experience.experienceId = applicant.experienceId INNER JOIN profile ON profile.profileId  = applicant.profileId INNER JOIN reviewStatus on applicant.reviewStatusId = reviewStatus.reviewStatusId";
        Connection connection = MySQLConnection.getConnection();
        System.out.println("Lista de cuentas iniciada");
        List<Applicant> applicantList = new ArrayList<>(); // Lista Main de cuentas
        try{
            System.out.println("Lista de aplicantes creada");
            PreparedStatement applicantsPS = connection.prepareStatement(applicantQuery);
            System.out.println("PreparedStatement de Applicants creado");
            ResultSet applicantsRS = applicantsPS.executeQuery();
            System.out.println("ResultSet de cuentas creado");
            while (applicantsRS.next()){
                Applicant TempApplicant = new Applicant(
                        applicantsRS.getInt("applicantId"),
                        applicantsRS.getString("firstName"),
                        applicantsRS.getString("lastName"),
                        applicantsRS.getString("email"),
                        applicantsRS.getString("phoneNumber"),
                        applicantsRS.getString("experienceName"),
                        applicantsRS.getString("profileName"),
                        applicantsRS.getString("reviewStatusName")
                );
                applicantList.add(TempApplicant);
                System.out.println("TempAccount de "+ applicantsRS.getInt("applicantId") + " anadido a lista de Account");

            }
            System.out.println("Retornando lista de Account para " + applicantsRS.getInt("applicantId"));
            System.out.println(applicantList);

        } catch (Exception ex) {
            System.out.println("On no, una excepción en la seccion lista de Account");
            System.out.println("La excepción es: " + ex.getCause() + " " + ex.getMessage());
        }
        System.out.println(applicantList);
        return applicantList;

    }

    @Override
    public List<Account> list() {
        String accountQuery = "SELECT *  FROM account INNER JOIN roles ON account.rolid = roles.rolid/* WHERE account.rolId <= 1*/";
        String testQuery = "SELECT tests.testId, tests.accountId, testStatus.testStatusName, tests.beganAtTimeStamp, tests.duration, tests.finishedAtTimeStamp, tests.overallScore FROM tests INNER JOIN testStatus ON tests.testStatus_statusId = testStatus.statusId WHERE accountId = ?";
        String scoreQuery = "SELECT  scores.scoreId, scores.test_testId, softSkills.softSkillName, scores.softSkillScore FROM scores INNER JOIN softSkills ON scores.softSkill_idsoftSkill = softSkills.softskillId WHERE scores.test_testId = ? ORDER BY scores.scoreId ASC";
        String checkpointQuery = "SELECT checkpoints.checkpointId, checkpoints.test_testId,  checkpoints.test_testId AS testIdd ,checkpoints.checkpointScore, checkpoints.checkpointMaxScore, softSkills.softSkillName, levelNames.levelName, puzzleNames.puzzleName, checkpoints.timeElapsed, checkpoints.timeStamp FROM checkpoints INNER JOIN levelNames ON checkpoints.levelId INNER JOIN puzzleNames ON checkpoints.puzzleId = puzzleNames.puzzleId INNER JOIN softSkills ON checkpoints.softSkillId = softSkills.softskillId WHERE checkpoints.test_testId = ? ORDER BY testIdd DESC, checkpoints.checkpointId ASC";
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
