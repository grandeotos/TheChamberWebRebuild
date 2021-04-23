package mx.itesm.TheChamberWebRebuild.util;

import com.mysql.cj.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;

public class MySQLConnection {
    public static Connection getConnection(){
        String cadena = "jdbc:mysql://the-chamber-web.ckqbx0wdqtxo.us-east-1.rds.amazonaws.com:3306/thechamber";
        String username = "TheChamber_Web";
        String password = "ShLzhVuVn5uTL4v2";
        try{
            DriverManager.registerDriver(new Driver());
            return DriverManager.getConnection(cadena,username,password);
        }catch(Exception ex){
            //sout
            System.out.println(ex.getClass().getCanonicalName());
        }
        return null;
    }

    public static void main(String[] args) {
        Connection conexion = MySQLConnection.getConnection();
        if(conexion != null)
            System.out.println("Se conectó");
        else
            System.out.println("No se conectó");
    }
}
