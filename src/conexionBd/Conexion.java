package conexionBd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    Connection conn;
    private String host = "localhost";
    private String port = "3306";
    private String dbName = "prueba";
    private String userName = "root";
    private String passWord = "123";

    public Conexion (){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://" + this.host + ":" + this.port + "/" + this.dbName;
            conn = DriverManager.getConnection(url, this.userName, this.passWord);
            System.out.println("Conexion establecida con la base de datos");

        }catch (ClassNotFoundException | SQLException e){
            System.out.println("Error al conectar con la base de datos" +e);
        }
    }
    public static void main(String[] args){

        Conexion c = new Conexion();

    }

}
