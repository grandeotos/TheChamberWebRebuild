package mx.itesm.TheChamberWebRebuild.model;

import java.io.Serializable;
import java.util.List;

public class Test implements Serializable {
    private List<Checkpoint> checkpoints;
    private List<Score> scores;
    private int testId;
    private int accountId;
    private String testStatus;
    private String beganAtTimeStamp;
    private int duration;
    private String finishedAtTimeStamp;
    private int overallScore;


    public Test() {
    }

    public Test(List<Checkpoint> checkpoints, List<Score> scores, int testId, int accountId, String testStatus, String beganAtTimeStamp, int duration, String finishedAtTimeStamp, int overallScore) {
        this.checkpoints = checkpoints;
        this.scores = scores;
        this.testId = testId;
        this.accountId = accountId;
        this.testStatus = testStatus;
        this.beganAtTimeStamp = beganAtTimeStamp;
        this.duration = duration;
        this.finishedAtTimeStamp = finishedAtTimeStamp;
        this.overallScore = overallScore;
    }

    public List<Checkpoint> getCheckpoints() {
        return checkpoints;
    }

    public void setCheckpoints(List<Checkpoint> checkpoints) {
        this.checkpoints = checkpoints;
    }

    public List<Score> getScores() {
        return scores;
    }

    public void setScores(List<Score> scores) {
        this.scores = scores;
    }

    public int getTestId() {
        return testId;
    }

    public void setTestId(int testId) {
        this.testId = testId;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getTestStatus() {
        return testStatus;
    }

    public void setTestStatus(String testStatus) {
        this.testStatus = testStatus;
    }

    public String getBeganAtTimeStamp() {
        return beganAtTimeStamp;
    }

    public void setBeganAtTimeStamp(String beganAtTimeStamp) {
        this.beganAtTimeStamp = beganAtTimeStamp;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getFinishedAtTimeStamp() {
        return finishedAtTimeStamp;
    }

    public void setFinishedAtTimeStamp(String finishedAtTimeStamp) {
        this.finishedAtTimeStamp = finishedAtTimeStamp;
    }

    public int getOverallScore() {
        return overallScore;
    }

    public void setOverallScore(int overallScore) {
        this.overallScore = overallScore;
    }

    @Override
    public String toString() {
        return "Test{" +
                "checkpoints=" + checkpoints +
                ", scores=" + scores +
                ", testId=" + testId +
                ", accountId=" + accountId +
                ", testStatus='" + testStatus + '\'' +
                ", beganAtTimeStamp='" + beganAtTimeStamp + '\'' +
                ", duration=" + duration +
                ", finishedAtTimeStamp='" + finishedAtTimeStamp + '\'' +
                ", overallScore=" + overallScore +
                '}';
    }
}
