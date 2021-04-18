package mx.itesm.TheChamberWebRebuild.model;

import java.io.Serializable;
import java.util.List;

public class Test implements Serializable {
    private List<Checkpoint> checkpoints;
    private int idpruebas;
    private int accountId;
    private String timeStamp;


    public Test() {
    }

    public Test(int idpruebas, int accountId, String timeStamp) {
        this.idpruebas = idpruebas;
        this.accountId = accountId;
        this.timeStamp = timeStamp;
    }

    public Test(List<Checkpoint> checkpoints, int idpruebas, int accountId, String timeStamp) {
        this.checkpoints = checkpoints;
        this.idpruebas = idpruebas;
        this.accountId = accountId;
        this.timeStamp = timeStamp;
    }

    public List<Checkpoint> getCheckpoints() {
        return checkpoints;
    }

    public void setCheckpoints(List<Checkpoint> checkpoints) {
        this.checkpoints = checkpoints;
    }

    public int getIdpruebas() {
        return idpruebas;
    }

    public void setIdpruebas(int idpruebas) {
        this.idpruebas = idpruebas;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    @Override
    public String toString() {
        return "Test{" +
                "checkpoints=" + checkpoints +
                ", idpruebas=" + idpruebas +
                ", accountId=" + accountId +
                ", timeStamp='" + timeStamp + '\'' +
                '}';
    }
}
