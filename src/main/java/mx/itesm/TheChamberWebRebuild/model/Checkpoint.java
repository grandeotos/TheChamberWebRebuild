package mx.itesm.TheChamberWebRebuild.model;

import java.io.Serializable;

public class Checkpoint implements Serializable {
    private int checkpointid;
    private int idprueba;
    private int score;
    private int maxScore;
    private int idsoftSkill;
    private int idlevel;
    private int idPuzzle;
    private int timeElapsed;
    private String timeStamp;

    public Checkpoint() {
    }

    public Checkpoint(int checkpointid, int idprueba, int score, int maxScore, int idsoftSkill, int idlevel, int idPuzzle, int timeElapsed, String timeStamp) {
        this.checkpointid = checkpointid;
        this.idprueba = idprueba;
        this.score = score;
        this.maxScore = maxScore;
        this.idsoftSkill = idsoftSkill;
        this.idlevel = idlevel;
        this.idPuzzle = idPuzzle;
        this.timeElapsed = timeElapsed;
        this.timeStamp = timeStamp;
    }

    public int getCheckpointid() {
        return checkpointid;
    }

    public void setCheckpointid(int checkpointid) {
        this.checkpointid = checkpointid;
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

    public int getIdsoftSkill() {
        return idsoftSkill;
    }

    public void setIdsoftSkill(int idsoftSkill) {
        this.idsoftSkill = idsoftSkill;
    }

    public int getIdlevel() {
        return idlevel;
    }

    public void setIdlevel(int idlevel) {
        this.idlevel = idlevel;
    }

    public int getIdPuzzle() {
        return idPuzzle;
    }

    public void setIdPuzzle(int idPuzzle) {
        this.idPuzzle = idPuzzle;
    }

    public int getTimeElapsed() {
        return timeElapsed;
    }

    public void setTimeElapsed(int timeElapsed) {
        this.timeElapsed = timeElapsed;
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
                "checkpointid=" + checkpointid +
                ", idprueba=" + idprueba +
                ", score=" + score +
                ", maxScore=" + maxScore +
                ", idsoftSkill=" + idsoftSkill +
                ", idlevel=" + idlevel +
                ", idPuzzle=" + idPuzzle +
                ", timeElapsed=" + timeElapsed +
                ", timeStamp='" + timeStamp + '\'' +
                '}';
    }
}
