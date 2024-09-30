package SOFTVETClinic;

public class Factura {
    private int idFactura;
    private float importe;
    private boolean pagada;
    private String fechaFactura;
    private Actuación actuacion;
    private Cliente cliente;

    public Factura(int idFactura, float importe, Actuación actuacion, Cliente cliente) {
        this.idFactura = idFactura;
        this.importe = importe;
        this.pagada = false;
        this.fechaFactura = obtenerFechaActual();
        this.actuacion = actuacion;
        this.cliente = cliente;
    }

    public int getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(int idFactura) {
        this.idFactura = idFactura;
    }

    public float getImporte() {
        return importe;
    }

    public void setImporte(float importe) {
        this.importe = importe;
    }

    public boolean isPagada() {
        return pagada;
    }

    public void setPagada(boolean pagada) {
        this.pagada = pagada;
    }

    public String getFechaFactura() {
        return fechaFactura;
    }

    public void setFechaFactura(String fechaFactura) {
        this.fechaFactura = fechaFactura;
    }

    public Actuación getActuacion() {
        return actuacion;
    }

    public void setActuacion(Actuación actuacion) {
        this.actuacion = actuacion;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    private String obtenerFechaActual() {
        // Implementación para obtener la fecha actual en formato dd/mm/aaaa
        return "18/02/2024"; // Ejemplo
    }
}
