package mx.itesm.TheChamberWebRebuild.model;

import java.io.Serializable;

public class Checkpoint implements Serializable {
    private int idprueba;
    private int score;
    private int maxScore;
    private int timeElapsed;
    private String levelName;
    private String softSkillName;
    private String puzzleName;
    private String timeStamp;

    public Checkpoint() {
    }

    public Checkpoint(int idprueba, int score, int maxScore, int timeElapsed, String levelName, String softSkillName, String puzzleName, String timeStamp) {
        this.idprueba = idprueba;
        this.score = score;
        this.maxScore = maxScore;
        this.timeElapsed = timeElapsed;
        this.levelName = levelName;
        this.softSkillName = softSkillName;
        this.puzzleName = puzzleName;
        this.timeStamp = timeStamp;
    }

    public int getIdprueba() {
        return idprueba;
    }

    public void setIdprueba(int idprueba) {
        this.idprueba = idprueba;
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
                "idprueba=" + idprueba +
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
