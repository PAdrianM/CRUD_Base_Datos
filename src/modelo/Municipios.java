package modelo;

public class Municipios {
    private int idMunicipio;
    private String Nombre;
    private int Departamento_idDepartamento;

    public Municipios(int idMunicipio) {
        this.idMunicipio = idMunicipio;
    }

    public int getIdMunicipio() {
        return idMunicipio;
    }

    public void setIdMunicipio(int idMunicipio) {
        this.idMunicipio = idMunicipio;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public int getDepartamento_idDepartamento() {
        return Departamento_idDepartamento;
    }

    public void setDepartamento_idDepartamento(int departamento_idDepartamento) {
        Departamento_idDepartamento = departamento_idDepartamento;
    }
}
