package dao;

import conexionBd.Conexion;
import modelo.Persona;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

public class EditorTablaPersona {

    Conexion conectado;

    public EditorTablaPersona(Conexion conectado){
        this.conectado = conectado;
    }
    public boolean Insert(Persona persona){//Objetos de tipo persona PARA INSERTAR EN LA TABLA
        String sql = "insert into persona values (?,?,?,?,?);";//SENTENCIA PREPARAD

        try {
            PreparedStatement ps = conectado.Conectar().prepareCall(sql);

            ps.setInt(1,persona.getIdPersona());
            ps.setString(2, persona.getNombre());
            ps.setString(3, persona.getApellido());
            ps.setInt(4, persona.getMunicipio_idMunicipio());
            ps.setString(5, persona.getCUI());

            ps.executeUpdate();
            return true;//Si todo eso se cumple me lo ejecuta y me retorna un true
        }
        catch (Exception e){
            System.out.println(e);
            return false;//Si falla me retorna falso
        }
    }
    public List<Persona> selectAll(){
        String sql = "select * from Persona";

        try{
            PreparedStatement ps = conectado.Conectar().prepareCall(sql);
            ResultSet rs = ps.executeQuery();

            List<Persona> list = new LinkedList<>();
            Persona persona;

            while (rs.next()){
                persona = new Persona(rs.getInt("idPersona"));

                persona.setNombre(rs.getString("Nombre"));
                persona.setApellido(rs.getString("Apellido"));
                persona.setMunicipio_idMunicipio(rs.getInt("Municipio_idMunicipio"));
                persona.setCUI(rs.getString("CUI"));
                list.add(persona);
            }
            return list;
        }catch (Exception e){
            System.out.println(e);
            return null;
        }
    }
}
