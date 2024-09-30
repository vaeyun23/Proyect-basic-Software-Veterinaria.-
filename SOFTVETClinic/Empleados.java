package SOFTVETClinic;

public abstract class Empleados extends Persona {
    protected String fechaContrato;
    protected float salarioBrutoMes;

    public Empleados(int id, String nombre, String fecha_nac, String direcion, int tlf, String fechaContrato,
            float salarioBrutoMes) {
        super(id, nombre, fecha_nac, direcion, tlf);
        this.fechaContrato = fechaContrato;
        this.salarioBrutoMes = salarioBrutoMes;
    }

    @Override
    public void mostrarDatos() {
        System.out.println("ID: " + this.getid());
        System.out.println("Nombre: " + this.getnombre());
        System.out.println("Fecha de nacimiento: " + this.getfecha_nac());
        System.out.println("Dirección: " + this.getdireccion());
        System.out.println("Telefono: " + this.gettlf());
        System.out.println("Fecha de contratación: " + this.getfechaContrato());
        System.out.println("Salario bruto al mes: " + this.getsalarioBrutoMes());
    }

    // Método para asignar un empleado como veterinario
    public Veterinario asignarComoVeterinario() {
        Veterinario veterinario = new Veterinario(id, nombre, fecha_nac, direccion, tlf, fechaContrato, salarioBrutoMes,
                id, direccion);
        return veterinario;
    }

    public Auxiliar asignarComoAuxiliar() {
        Auxiliar auxiliar = new Auxiliar(id, nombre, fecha_nac, direccion, tlf, fechaContrato, salarioBrutoMes,
                direccion);
        return auxiliar;
    }

    // getter setter

    public float getsalarioBrutoMes() {
        return salarioBrutoMes;
    }

    public void setsalarioBrutoMes(float salarioBrutoMes) {
        this.salarioBrutoMes = salarioBrutoMes;
    }

    public String getfechaContrato() {
        return fechaContrato;
    }

    public void setfechaContrato(String fechaContrato) {
        this.fechaContrato = fechaContrato;
    }
}
