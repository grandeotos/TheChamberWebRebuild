package mx.itesm.TheChamberWebRebuild.DAO;

import mx.itesm.TheChamberWebRebuild.model.Account;

import java.util.List;

public interface IAccountDAO {
    public Account auth(String email, String password);
    public int registerGamer(String firstName, String lastName, String username, String email, String password, String curp);
    public int registerAplicant(String firstName,  String lastName,  String email,  String telp,  int exper,  int profix);
    public int registerGamer(String username, String email);
}
