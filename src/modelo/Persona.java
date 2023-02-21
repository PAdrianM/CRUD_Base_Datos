package modelo;

public class Persona {
    private int id;
    private String nombre;
    private String apellido;
    private int municipioIdMuni;
    private String cui;

    public Persona(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getMunicipioIdMuni() {
        return municipioIdMuni;
    }

    public void setMunicipioIdMuni(int municipioIdMuni) {
        this.municipioIdMuni = municipioIdMuni;
    }

    public String getCui() {
        return cui;
    }

    public void setCui(String cui) {
        this.cui = cui;
    }
}
