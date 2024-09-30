package SOFTVETClinic;

import java.util.ArrayList;
import java.util.List;

public class Cliente extends Persona {
    protected List<Animal> animales;
    protected List<Factura> facturas;

    public Cliente(int id, String nombre, String fecha_nac, String direcion, int tlf) {
        super(id, nombre, fecha_nac, direcion, tlf);
        animales = new ArrayList<>();
        facturas = new ArrayList<>();
    }

    @Override
    public void mostrarDatos() {
        System.out.println("ID: " + this.getid());
        System.out.println("Nombre: " + this.getnombre());
        System.out.println("Fecha de nacimiento: " + this.getfecha_nac());
        System.out.println("Dirección: " + this.getdireccion());
        System.out.println("Telefono: " + this.gettlf());
        if (!animales.isEmpty()) {
            System.out.println("Animales:");
            for (Animal animal : animales) {
                System.out.println("Nombre: " + animal.getNombre());
                System.out.println("Especie: " + animal.getEspecie());
                System.out.println("Raza: " + animal.getRaza());
                System.out.println("Fecha de Nacimiento: " + animal.getFechaNacimiento());
                System.out.println("Sexo: " + animal.getSexo());
                System.out.println("-------------------------");
            }
        } else {
            System.out.println("No tiene animales asociados.");
        }
        if (!facturas.isEmpty()) {
            System.out.println("Facturas:");
            for (Factura facturas : facturas) {
                System.out.println("ID Factura: " + facturas.getIdFactura());
                System.out.println("Importe: " + facturas.getImporte());
                System.out.println("Pagada: " + (facturas.isPagada() ? "Sí" : "No"));
                System.out.println("Fecha de Factura: " + facturas.getFechaFactura());
                System.out.println("-------------------------");
            }
        } else {
            System.out.println("No tiene facturas asociadas.");
        }
    }

    public List<Animal> getAnimales() {
        return animales;
    }

    public void setAnimales(List<Animal> animales) {
        this.animales = animales;
    }

    public List<Factura> getFacturas() {
        return facturas;
    }

    public void setFacturas(List<Factura> facturas) {
        this.facturas = facturas;
    }

    // Método para agregar un animal
    public void addAnimal(Animal animal) {
        animales.add(animal);
    }

    // Método para eliminar un animal
    public void removeAnimal(Animal animal) {
        animales.remove(animal);
    }

    // Método para agregar una factura
    public void addFactura(Factura factura) {
        facturas.add(factura);
    }

    // Método para eliminar una factura
    public void removeFactura(Factura factura) {
        facturas.remove(factura);
    }
}
