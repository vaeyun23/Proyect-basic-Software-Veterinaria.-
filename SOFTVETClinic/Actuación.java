package SOFTVETClinic;

public class Actuación {
    private int idActuacion;
    private String diagnostico;
    private String tratamiento;
    private String estado;
    private Animal animal;
    private Empleados empleado;

    public Actuación(int idActuacion, String diagnostico, String tratamiento, Animal animal, Empleados empleado) {
        this.idActuacion = idActuacion;
        this.diagnostico = diagnostico;
        this.tratamiento = tratamiento;
        this.estado = "Iniciada";
        this.animal = animal;
        this.empleado = empleado;
    }

    public int getIdActuacion() {
        return idActuacion;
    }

    public void setIdActuacion(int idActuacion) {
        this.idActuacion = idActuacion;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getTratamiento() {
        return tratamiento;
    }

    public void setTratamiento(String tratamiento) {
        this.tratamiento = tratamiento;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public Empleados getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleados empleado) {
        this.empleado = empleado;
    }
}
