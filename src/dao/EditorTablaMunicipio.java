package dao;

import conexionBd.Conexion;
import modelo.Municipios;
import modelo.Persona;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

public class EditorTablaMunicipio {
    Conexion conectado;
    public EditorTablaMunicipio(Conexion conectado){
        this.conectado = conectado;
    }

    //metodo consultar tabla Municipio
    public List<Municipios> selectAllMunicipio(){
        String sql = "select * from Municipio";

        try{
            PreparedStatement ps = conectado.Conectar().prepareCall(sql);
            ResultSet rs = ps.executeQuery();

            List<Municipios> list = new LinkedList<>();
            Municipios municipios;

            while (rs.next()){
                municipios = new Municipios(rs.getInt("idMunicipio"));

                municipios.setNombre(rs.getString("Nombre"));
                municipios.setDepartamento_idDepartamento(rs.getInt("Departamento_idDepartamento"));
                list.add(municipios);
            }
            return list;
        }catch (Exception e){
            System.out.println(e);
            return null;
        }
    }
}
