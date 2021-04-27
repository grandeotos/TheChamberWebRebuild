package mx.itesm.TheChamberWebRebuild.DAO;

import mx.itesm.TheChamberWebRebuild.model.Account;

import java.util.List;

public interface IAccountDAO {
    public Account auth(String email, String password);
    public int registerGamer(String firstName, String lastName, String username, String email, String password, String curp);
    public int registerApplicant(String firstName,  String lastName,  String email,  String telp,  int exper,  int profix);
    public int registerGamer(String username, String email);
    public int registerGamer(String username, String firstName, String lastName, String email);
    public int registerAdmin(String username, String email, String role);
    public int registerAdmin(String firstName, String lastName, String username, String email, String password, String curp, String roleName);
    public String getNewGamerID();
    public int updateApplicant(int appId, int action);
}
