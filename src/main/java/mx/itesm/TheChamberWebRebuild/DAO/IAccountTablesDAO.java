package mx.itesm.TheChamberWebRebuild.DAO;

import mx.itesm.TheChamberWebRebuild.model.Account;
import mx.itesm.TheChamberWebRebuild.model.Applicant;

import java.util.List;

public interface IAccountTablesDAO {
    public List<Applicant> ApplicantList();
    public List<Account> list();
    public List<Account> listAll();
    public Account getAccountByUsername(String Username);
    public Account getRecentTestByUsername(String Username);
    public Account getRecentScoresByUsername(String Username);
    public Applicant getApplicantById(int appId);

}

