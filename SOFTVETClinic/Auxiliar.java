package SOFTVETClinic;

public class Auxiliar extends Empleados {
    private String cargo;

    public Auxiliar(int id, String nombre, String fecha_nac, String direcion, int tlf, String fechaContrato,
            float salarioBrutoMes, String cargo) {
        super(id, nombre, fecha_nac, direcion, tlf, fechaContrato, salarioBrutoMes);
        this.cargo = cargo;
    }

    // getters y setters

    public String getcargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
}
