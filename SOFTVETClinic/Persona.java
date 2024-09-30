package SOFTVETClinic;

public abstract class Persona {
    protected int id;
    protected String nombre;
    protected String fecha_nac;
    protected String direccion;
    protected int tlf;

    public Persona(int id, String nombre, String fecha_nac, String direccion, int tlf) {
        this.id = id;
        this.nombre = nombre;
        this.fecha_nac = fecha_nac;
        this.direccion = direccion;
        this.tlf = tlf;
    }

    public abstract void mostrarDatos();

    // getter y setters
    public int getid() {
        return id;
    }

    public void setid(int id) {
        this.id = id;
    }

    public String getnombre() {
        return nombre;
    }

    public void setnombre(String nombre) {
        this.nombre = nombre;
    }

    public String getfecha_nac() {
        return fecha_nac;
    }

    public void setfecha_nac(String fecha_nac) {
        this.fecha_nac = fecha_nac;
    }

    public String getdireccion() {
        return direccion;
    }

    public void setdireccion(String direccion) {
        this.direccion = direccion;
    }

    public int gettlf() {
        return tlf;
    }

    public void settlf(int tlf) {
        this.tlf = tlf;
    }
}
