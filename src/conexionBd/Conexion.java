package conexionBd;

import java.security.PublicKey;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    Connection conectado;
    private String host = "localhost";
    private String port = "3306";
    private String dbName = "sat";
    private String userName = "root";
    private String passWord = "sisepuede";

    public Conexion (){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://" + this.host + ":" + this.port + "/" + this.dbName;
            conectado = DriverManager.getConnection(url, this.userName, this.passWord);
            System.out.println("Conexion establecida con la base de datos");

        }catch (ClassNotFoundException | SQLException e){
            System.out.println("Error al conectar con la base de datos" +e);
        }
    }
    public Connection Conectar(){
        return conectado;
    }
    public void Desconectar() throws Exception{
        conectado.close();
    }

}
