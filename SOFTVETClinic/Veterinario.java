package SOFTVETClinic;

public class Veterinario extends Empleados {
    private int numColegiado;
    private String especialidad;

    public Veterinario(int id, String nombre, String fecha_nac, String direcion, int tlf, String fechaContrato,
            float salarioBrutoMes, int numColegiado, String especialidad) {
        super(id, nombre, fecha_nac, direcion, tlf, fechaContrato, salarioBrutoMes);
        this.numColegiado = numColegiado;
        this.especialidad = especialidad;
    }

    // getters y setters

    public int getnumColegiado() {
        return numColegiado;
    }

    public void setnumColegiado(int numColegiado) {
        this.numColegiado = numColegiado;
    }

    public String getespecialidad() {
        return especialidad;
    }

    public void setespecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
}
