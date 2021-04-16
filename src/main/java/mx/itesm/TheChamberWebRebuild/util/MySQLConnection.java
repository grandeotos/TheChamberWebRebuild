package mx.itesm.TheChamberWebRebuild.util;

import com.mysql.cj.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;

public class MySQLConnection {
    public static Connection getConnection(){
        String cadena = "jdbc:mysql://localhost:3306/thechamber?user=root";

        try{
            DriverManager.registerDriver(new Driver());
            return DriverManager.getConnection(cadena);
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
