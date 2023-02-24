package modelo;

public class Persona {
    private int idPersona;
    private String Nombre;
    private String Apellido;
    private int Municipio_idMunicipio;
    private String CUI;

    public Persona(int idPersona) {
        this.idPersona = idPersona;
    }

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String apellido) {
        Apellido = apellido;
    }

    public int getMunicipio_idMunicipio() {
        return Municipio_idMunicipio;
    }

    public void setMunicipio_idMunicipio(int municipio_idMunicipio) {
        Municipio_idMunicipio = municipio_idMunicipio;
    }

    public String getCUI() {
        return CUI;
    }

    public void setCUI(String CUI) {
        this.CUI = CUI;
    }
}
