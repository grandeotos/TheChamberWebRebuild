package mx.itesm.TheChamberWebRebuild.model;

import java.io.Serializable;

public class Score implements Serializable {
    private int scoreId;
    private int test_testId;
    private String softSkillName;
    private int softSkillScore;

    public Score() {
    }

    public Score(int scoreId, int test_testId, String softSkillName, int softSkillScore) {
        this.scoreId = scoreId;
        this.test_testId = test_testId;
        this.softSkillName = softSkillName;
        this.softSkillScore = softSkillScore;
    }

    public int getScoreId() {
        return scoreId;
    }

    public void setScoreId(int scoreId) {
        this.scoreId = scoreId;
    }

    public int getTest_testId() {
        return test_testId;
    }

    public void setTest_testId(int test_testId) {
        this.test_testId = test_testId;
    }

    public String getSoftSkillName() {
        return softSkillName;
    }

    public void setSoftSkillName(String softSkillName) {
        this.softSkillName = softSkillName;
    }

    public int getSoftSkillScore() {
        return softSkillScore;
    }

    public void setSoftSkillScore(int softSkillScore) {
        this.softSkillScore = softSkillScore;
    }

    @Override
    public String toString() {
        return "Score{" +
                "scoreId=" + scoreId +
                ", test_testId=" + test_testId +
                ", softSkillName='" + softSkillName + '\'' +
                ", softSkillScore=" + softSkillScore +
                '}';
    }
}
