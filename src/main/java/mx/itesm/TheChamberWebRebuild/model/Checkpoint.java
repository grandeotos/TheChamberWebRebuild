package mx.itesm.TheChamberWebRebuild.model;

import java.io.Serializable;

public class Checkpoint implements Serializable {
    private int checkpointId;
    private int testId;
    private int score;
    private int maxScore;
    private int timeElapsed;
    private String levelName;
    private String softSkillName;
    private String puzzleName;
    private String timeStamp;

    public Checkpoint() {
    }

    public Checkpoint(int checkpointId, int testId, int score, int maxScore, int timeElapsed, String levelName, String softSkillName, String puzzleName, String timeStamp) {
        this.checkpointId = checkpointId;
        this.testId = testId;
        this.score = score;
        this.maxScore = maxScore;
        this.timeElapsed = timeElapsed;
        this.levelName = levelName;
        this.softSkillName = softSkillName;
        this.puzzleName = puzzleName;
        this.timeStamp = timeStamp;
    }

    public int getCheckpointId() {
        return checkpointId;
    }

    public void setCheckpointId(int checkpointId) {
        this.checkpointId = checkpointId;
    }

    public int getTestId() {
        return testId;
    }

    public void setTestId(int testId) {
        this.testId = testId;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getMaxScore() {
        return maxScore;
    }

    public void setMaxScore(int maxScore) {
        this.maxScore = maxScore;
    }

    public int getTimeElapsed() {
        return timeElapsed;
    }

    public void setTimeElapsed(int timeElapsed) {
        this.timeElapsed = timeElapsed;
    }

    public String getLevelName() {
        return levelName;
    }

    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }

    public String getSoftSkillName() {
        return softSkillName;
    }

    public void setSoftSkillName(String softSkillName) {
        this.softSkillName = softSkillName;
    }

    public String getPuzzleName() {
        return puzzleName;
    }

    public void setPuzzleName(String puzzleName) {
        this.puzzleName = puzzleName;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    @Override
    public String toString() {
        return "Checkpoint{" +
                "checkpointId=" + checkpointId +
                ", testId=" + testId +
                ", score=" + score +
                ", maxScore=" + maxScore +
                ", timeElapsed=" + timeElapsed +
                ", levelName='" + levelName + '\'' +
                ", softSkillName='" + softSkillName + '\'' +
                ", puzzleName='" + puzzleName + '\'' +
                ", timeStamp='" + timeStamp + '\'' +
                '}';
    }
}
