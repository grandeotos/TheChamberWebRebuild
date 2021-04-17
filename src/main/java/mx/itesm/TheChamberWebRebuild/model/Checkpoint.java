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
}
