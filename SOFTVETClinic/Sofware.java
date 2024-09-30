package SOFTVETClinic;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Sofware {
    public static void main(String[] args) {
        Scanner key = new Scanner(System.in);
        List<Cliente> clientes = new ArrayList<>();
        List<Animal> animales = new ArrayList<>();
        List<Veterinario> veterinarios = new ArrayList<>();
        List<Auxiliar> auxiliares = new ArrayList<>();
        List<Actuación> actuaciones = new ArrayList<>();
        List<Factura> facturas = new ArrayList<>();

        System.out.println("*** Menú de opciones ***");
        System.out.println("1. Alta de cliente");
        System.out.println("2. Baja de cliente");
        System.out.println("3. Alta de animal");
        System.out.println("4. Baja de animal");
        System.out.println("5. Crear actuación");
        System.out.println("6. Actualizar actuación");
        System.out.println("7. Generar factura");
        System.out.println("8. Obtener facturación mensual");
        System.out.println("9. Mostrar información de clientes");
        System.out.println("10. Mostrar información de animales");
        System.out.println("11. Añadir auxiliar");
        System.out.println("12. Mostrar información de auxiliares");
        System.out.println("13. Mostrar Actuaciones");
        System.out.println("14. Mostrar Facturas");
        System.out.println("15. Añadir veterinario");
        System.out.println("16. Mostrar información de veterinarios");
        System.out.println("17. Pagar factura");
        System.out.println("18. Finalizar actuación");
        System.out.println("19. Salir");

        System.out.print("Seleccione una opción: ");
        int opcion = key.nextInt();

        // Aquí va el menú y el switch-case con las opciones
        switch (opcion) {
            case 1:
                altaCliente(key, clientes);
                break;
            case 2:
                bajaCliente(key, clientes, animales);
                break;
            case 3:
                // altaAnimal(key, animales, clientes);
                break;
            case 4:
                bajaAnimal(key, animales);
                break;
            case 5:
                nuevaActuacion(key, actuaciones, null, animales);
                break;
            case 6:
                actualizarActuacion(key, actuaciones);
                break;
            case 7:
                generarFactura(key, facturas, actuaciones);
                break;
            case 8:
                obtenerFacturacionMensual(key, facturas);
                break;
            case 9:
                mostrarCliente(key, clientes);
                break;
            case 10:
                mostrarAnimales(animales);
                break;
            case 11:
                agregarAuxiliar(key, null);
                break;
            case 12:
                mostrarAuxiliares(null);
                break;
            case 13:
                mostrarActualizaciones(actuaciones);
                break;
            case 14:
                mostrarFacturas(facturas);
                ;
                break;
            case 15:
                agregarVeterinario(key, null);
                break;
            case 16:
                mostrarVeterinarios(null);
                break;
            case 17:
                pagarFactura(key, facturas);
                break;
            case 18:
                finalizarActuacion(key, actuaciones);
                break;
            case 19:
                System.out.println("Saliendo del programa...");
                key.close();
                return;
            default:
                System.out.println("Opción no válida. Intente nuevamente.");
        }
    }

    // Aquí van los métodos para cada opción del menú

    // Añadir cliente
    public static void altaCliente(Scanner key, List<Cliente> clientes) {
        System.out.println("Ingrese nombre del cliente:");
        String nombre = key.next();

        // Verificar si ya existe un cliente con el mismo nombre
        for (Cliente cliente : clientes) {
            if (cliente.getnombre().equalsIgnoreCase(nombre)) {
                System.out.println("Error: Ya existe un cliente con ese nombre.");
                return;
            }
        }

        System.out.println("Ingrese fecha de nacimiento del cliente (dd/mm/aaaa):");
        String fechaNacimiento = key.next();
        System.out.println("Ingrese dirección del cliente:");
        String direccion = key.next();
        System.out.println("Ingrese número de teléfono del cliente:");
        int telefono = key.nextInt();

        // Crear nuevo cliente y agregarlo a la lista de clientes
        Cliente nuevoCliente = new Cliente(telefono, nombre, fechaNacimiento, direccion, telefono);
        clientes.add(nuevoCliente);
        System.out.println("Cliente agregado exitosamente.");
    }

    // eliminar cliente
    public static void bajaCliente(Scanner key, List<Cliente> clientes, List<Animal> animales) {
        System.out.println("Ingrese nombre del cliente a dar de baja:");
        String nombre = key.next();

        boolean clienteEncontrado = false;
        for (Iterator<Cliente> iterator = clientes.iterator(); iterator.hasNext();) {
            Cliente cliente = iterator.next();
            if (cliente.getnombre().equalsIgnoreCase(nombre)) {
                clienteEncontrado = true;

                // Verificar si el cliente tiene animales asociados
                if (!cliente.getAnimales().isEmpty()) {
                    System.out.println("Error: No se puede dar de baja al cliente porque tiene animales asociados.");
                    return;
                }

                // Remover el cliente de la lista
                iterator.remove();
                System.out.println("Cliente eliminado exitosamente.");
                break;
            }
        }

        if (!clienteEncontrado) {
            System.out.println("Cliente no encontrado.");
        }
    }

    // añadir animal, no llego a solucionar el problema
    /*
     * public static void altaAnimal(Scanner key, List<Animal> animales,
     * List<Cliente> clientes) {
     * System.out.println("Ingrese nombre del animal:");
     * String nombre = key.next();
     * 
     * // Verificar si ya existe un animal con el mismo nombre
     * for (Animal animal : animales) {
     * if (animal.getNombre().equalsIgnoreCase(nombre)) {
     * System.out.println("Error: Ya existe un animal con ese nombre.");
     * return;
     * }
     * }
     * 
     * System.out.println("Ingrese especie:");
     * String especie = key.next();
     * System.out.println("Ingrese raza:");
     * String raza = key.next();
     * System.out.println("Ingrese fecha de nacimiento (dd/mm/aaaa):");
     * String fechaNacimiento = key.next();
     * System.out.println("Ingrese sexo:");
     * char sexo = key.next().charAt(0);
     * System.out.println("Ingrese nombre del cliente propietario:");
     * String nombrePropietario = key.next();
     * 
     * // Buscar al propietario por nombre
     * private static Cliente buscarClientePorNombre(List<Cliente> clientes, String
     * nombre) {
     * for (Cliente cliente : clientes) {
     * if (cliente.getnombre().equalsIgnoreCase(nombre)) {
     * return cliente;
     * }
     * }
     * return null; // Retorna null si no se encuentra el cliente
     * }
     * 
     * // Crear nuevo animal y agregarlo a la lista de animales del propietario
     * Animal nuevoAnimal = new Animal(especie, raza, nombrePropietario,
     * fechaNacimiento, sexo, null);
     * clientes.add;
     * animales.add(nuevoAnimal);
     * System.out.println("Animal agregado exitosamente.");
     * }
     */

    // eliminar animal
    public static void bajaAnimal(Scanner key, List<Animal> animales) {
        System.out.println("Ingrese nombre del animal a dar de baja:");
        String nombre = key.next();

        boolean animalEncontrado = false;
        for (Iterator<Animal> iterator = animales.iterator(); iterator.hasNext();) {
            Animal animal = iterator.next();
            if (animal.getNombre().equalsIgnoreCase(nombre)) {
                animalEncontrado = true;

                // Remover el animal de la lista
                iterator.remove();
                System.out.println("Animal eliminado exitosamente.");
                break;
            }
        }

        if (!animalEncontrado) {
            System.out.println("Animal no encontrado.");
        }
    }

    // Creacion de una actuación
    public static void nuevaActuacion(Scanner key, List<Actuación> actuaciones, List<Empleados> empleados,
            List<Animal> animales) {
        // Verificar si hay empleados para asignar a la actuación
        if (empleados.isEmpty()) {
            System.out.println("No hay empleados registrados para asignar a la actuación.");
            return;
        }

        // Verificar si hay animales para asociar a la actuación
        if (animales.isEmpty()) {
            System.out.println("No hay animales registrados para asociar a la actuación.");
            return;
        }

        System.out.println("Ingrese el diagnóstico de la actuación:");
        String diagnostico = key.next();
        System.out.println("Ingrese el tratamiento de la actuación:");
        String tratamiento = key.next();

        // Mostrar empleados disponibles para asignar a la actuación
        System.out.println("Empleados disponibles:");
        for (int i = 0; i < empleados.size(); i++) {
            System.out.println((i + 1) + ". " + empleados.get(i).getnombre());
        }
        System.out.println("Seleccione el número del empleado para asignar a la actuación:");
        int indiceEmpleado = key.nextInt();
        if (indiceEmpleado < 1 || indiceEmpleado > empleados.size()) {
            System.out.println("Selección de empleado no válida.");
            return;
        }
        Empleados empleado = empleados.get(indiceEmpleado - 1);

        // Mostrar animales disponibles para asociar a la actuación
        System.out.println("Animales disponibles:");
        for (int i = 0; i < animales.size(); i++) {
            System.out.println((i + 1) + ". " + animales.get(i).getNombre());
        }
        System.out.println("Seleccione el número del animal para asociar a la actuación:");
        int indiceAnimal = key.nextInt();
        if (indiceAnimal < 1 || indiceAnimal > animales.size()) {
            System.out.println("Selección de animal no válida.");
            return;
        }
        Animal animal = animales.get(indiceAnimal - 1);

        // Crear la nueva actuación y agregarla a la lista de actuaciones
        Actuación nuevaActuacion = new Actuación(indiceAnimal, diagnostico, tratamiento, animal, empleado);
        actuaciones.add(nuevaActuacion);
        System.out.println("Actuación creada exitosamente.");
    }

    // Actualizar la actualizacion
    public static void actualizarActuacion(Scanner key, List<Actuación> actuaciones) {
        // Verificar si hay actuaciones para actualizar
        if (actuaciones.isEmpty()) {
            System.out.println("No hay actuaciones registradas para actualizar.");
            return;
        }

        // Mostrar actuaciones disponibles para actualizar
        System.out.println("Actuaciones disponibles:");
        for (int i = 0; i < actuaciones.size(); i++) {
            System.out.println((i + 1) + ". " + actuaciones.get(i).getIdActuacion());
        }
        System.out.println("Seleccione el número de la actuación a actualizar:");
        int indiceActuacion = key.nextInt();
        if (indiceActuacion < 1 || indiceActuacion > actuaciones.size()) {
            System.out.println("Selección de actuación no válida.");
            return;
        }
        Actuación actuacion = actuaciones.get(indiceActuacion - 1);

        // Mostrar opciones para actualizar la actuación
        System.out.println("Seleccione el campo a actualizar:");
        System.out.println("1. Diagnóstico");
        System.out.println("2. Tratamiento");
        int opcion = key.nextInt();

        switch (opcion) {
            case 1:
                System.out.println("Ingrese el nuevo diagnóstico:");
                String nuevoDiagnostico = key.next();
                actuacion.setDiagnostico(nuevoDiagnostico);
                System.out.println("Diagnóstico actualizado exitosamente.");
                break;
            case 2:
                System.out.println("Ingrese el nuevo tratamiento:");
                String nuevoTratamiento = key.next();
                actuacion.setTratamiento(nuevoTratamiento);
                System.out.println("Tratamiento actualizado exitosamente.");
                break;
            default:
                System.out.println("Opción no válida.");
                break;
        }
    }

    // Genera una Factura
    // Método para generar una factura
    public static void generarFactura(Scanner key, List<Factura> facturas, List<Actuación> actuaciones) {
        // Verificar si hay actuaciones para facturar
        if (actuaciones.isEmpty()) {
            System.out.println("No hay actuaciones registradas para generar factura.");
            return;
        }

        // Mostrar actuaciones disponibles para facturar
        System.out.println("Actuaciones disponibles para facturar:");
        for (int i = 0; i < actuaciones.size(); i++) {
            Actuación actuacion = actuaciones.get(i);
            if (actuacion.getEstado().equals("Finalizada")) {
                System.out.println((i + 1) + ". ID de actuación: " + actuacion.getIdActuacion());
                System.out.println("   Diagnóstico: " + actuacion.getDiagnostico());
                System.out.println("   Tratamiento: " + actuacion.getTratamiento());
                System.out.println("   Empleado: " + actuacion.getEmpleado().getnombre());
                System.out.println("   Animal: " + actuacion.getAnimal().getNombre());
                System.out.println("---------------------------------------");
            }
        }

        // Solicitar al usuario que seleccione una actuación para facturar
        System.out.println("Seleccione el número de la actuación a facturar:");
        int indiceActuacion = key.nextInt();
        if (indiceActuacion < 1 || indiceActuacion > actuaciones.size()) {
            System.out.println("Selección de actuación no válida.");
            return;
        }
        Actuación actuacionSeleccionada = actuaciones.get(indiceActuacion - 1);

        // Verificar si ya se ha generado una factura para esta actuación
        for (Factura factura : facturas) {
            if (factura.getActuacion().equals(actuacionSeleccionada)) {
                System.out.println("Ya se ha generado una factura para esta actuación.");
                return;
            }
        }

        // Crear la nueva factura y agregarla a la lista de facturas
        Factura nuevaFactura = new Factura(indiceActuacion, indiceActuacion, actuacionSeleccionada, null);
        facturas.add(nuevaFactura);
        System.out.println("Factura generada exitosamente.");
    }

    // Obtener facturacion mensual
    public static void obtenerFacturacionMensual(Scanner key, List<Factura> facturas) {
        // Solicitar al usuario que ingrese el número del mes
        System.out.println("Ingrese el número del mes (1 al 12) para obtener la facturación mensual:");
        int mes = key.nextInt();

        // Verificar que el mes ingresado sea válido
        if (mes < 1 || mes > 12) {
            System.out.println("Mes ingresado no válido.");
            return;
        }

        // Calcular la facturación total del mes especificado
        float facturacionMensual = 0;
        for (Factura factura : facturas) {
            // Obtener el mes de la factura
            int mesFactura = Integer.parseInt(factura.getFechaFactura().split("/")[1]);

            // Si el mes de la factura coincide con el mes especificado, sumar su importe a
            // la facturación mensual
            if (mesFactura == mes) {
                facturacionMensual += factura.getImporte();
            }
        }

        // Mostrar la facturación mensual al usuario
        System.out.println("La facturación total del mes " + mes + " es: $" + facturacionMensual);
    }

    // Mostrar clientes
    public static boolean mostrarCliente(Scanner key, List<Cliente> clientes) {
        // Solicitar al usuario que ingrese el nombre del cliente a buscar
        System.out.println("Ingrese el nombre del cliente que desea ver:");
        String nombreCliente = key.next();

        // Buscar el cliente por su nombre
        for (Cliente cliente : clientes) {
            if (cliente.getnombre().equalsIgnoreCase(nombreCliente)) {
                // Mostrar la información del cliente y sus animales asociados
                System.out.println("Información del cliente:");
                System.out.println("Nombre: " + cliente.getnombre());
                System.out.println("Dirección: " + cliente.getdireccion());
                System.out.println("Teléfono: " + cliente.gettlf());

                List<Animal> animalesCliente = cliente.getAnimales();
                if (!animalesCliente.isEmpty()) {
                    System.out.println("Animales asociados:");
                    for (Animal animal : animalesCliente) {
                        System.out.println("Nombre: " + animal.getNombre());
                        System.out.println("Especie: " + animal.getEspecie());
                        System.out.println("Raza: " + animal.getRaza());
                        System.out.println("Fecha de Nacimiento: " + animal.getFechaNacimiento());
                        System.out.println("Sexo: " + animal.getSexo());
                        System.out.println("-------------------------");
                    }
                } else {
                    System.out.println("Este cliente no tiene animales asociados.");
                }
                return true; // Indicar que se encontró al cliente
            }
        }

        // Si no se encuentra al cliente, mostrar mensaje y retornar false
        System.out.println("Cliente no encontrado.");
        return false;
    }

    // mostrar los animales
    public static void mostrarAnimales(List<Animal> animales) {
        // Verificar si hay animales registrados
        if (animales.isEmpty()) {
            System.out.println("No hay animales registrados.");
            return;
        }

        // Mostrar la información de cada animal
        System.out.println("Información de los animales:");
        for (Animal animal : animales) {
            System.out.println("Nombre: " + animal.getNombre());
            System.out.println("Especie: " + animal.getEspecie());
            System.out.println("Raza: " + animal.getRaza());
            System.out.println("Fecha de Nacimiento: " + animal.getFechaNacimiento());
            System.out.println("Sexo: " + animal.getSexo());
            System.out.println("Propietario: " + animal.getPropietario().getnombre());
            System.out.println("-------------------------");
        }
    }

    // Añadir auxiliar
    // Método para añadir un nuevo auxiliar a la lista de empleados
    public static void agregarAuxiliar(Scanner key, List<Empleados> empleados) {
        System.out.println("Ingrese el nombre del auxiliar:");
        String nombre = key.next();
        System.out.println("Ingrese la fecha de contrato (dd/mm/aaaa):");
        String fechaContrato = key.next();
        System.out.println("Ingrese el salario bruto mensual:");
        float salarioBrutoMes = key.nextFloat();
        System.out.println("Ingrese el cargo:");
        String cargo = key.next();

        // Crear una instancia de Auxiliar y agregarla a la lista de empleados
        Auxiliar nuevoAuxiliar = new Auxiliar(0, nombre, cargo, nombre, 0, fechaContrato, salarioBrutoMes, cargo);
        empleados.add(nuevoAuxiliar);

        System.out.println("Auxiliar agregado exitosamente.");
    }

    // mostrar auxiliar
    // Método para mostrar la información de todos los auxiliares
    public static void mostrarAuxiliares(List<Empleados> empleados) {
        // Verificar si hay auxiliares registrados
        if (empleados.isEmpty()) {
            System.out.println("No hay auxiliares registrados.");
            return;
        }

        // Mostrar la información de cada auxiliar
        System.out.println("Información de los auxiliares:");
        for (Empleados empleado : empleados) {
            if (empleado instanceof Auxiliar) {
                Auxiliar auxiliar = (Auxiliar) empleado;
                System.out.println("Nombre: " + auxiliar.getnombre());
                System.out.println("Fecha de Contrato: " + auxiliar.getfechaContrato());
                System.out.println("Salario Bruto Mensual: " + auxiliar.getsalarioBrutoMes());
                System.out.println("Cargo: " + auxiliar.getcargo());
                System.out.println("-------------------------");
            }
        }
    }

    // mostrar actuaciones
    public static void mostrarActualizaciones(List<Actuación> actuaciones) {
        // Verificar si hay actualizaciones registradas
        if (actuaciones.isEmpty()) {
            System.out.println("No hay actuaciones registradas.");
            return;
        }

        // Mostrar la información de cada actuación
        System.out.println("Información de las actualizaciones:");
        for (Actuación actuacion : actuaciones) {
            System.out.println("ID de Actuación: " + actuacion.getIdActuacion());
            System.out.println("Diagnóstico: " + actuacion.getDiagnostico());
            System.out.println("Tratamiento: " + actuacion.getTratamiento());
            System.out.println("Estado: " + actuacion.getEstado());
            System.out.println("-------------------------");
        }
    }

    // mostrar facturas
    public static void mostrarFacturas(List<Factura> facturas) {
        // Verificar si hay facturas registradas
        if (facturas.isEmpty()) {
            System.out.println("No hay facturas registradas.");
            return;
        }

        // Mostrar la información de cada factura
        System.out.println("Información de las facturas:");
        for (Factura factura : facturas) {
            System.out.println("ID de Factura: " + factura.getIdFactura());
            System.out.println("Importe: " + factura.getImporte());
            System.out.println("Pagada: " + (factura.isPagada() ? "Sí" : "No"));
            System.out.println("Fecha de Factura: " + factura.getFechaFactura());
            System.out.println("Actuación asociada: " + factura.getActuacion().getIdActuacion());
            System.out.println("-------------------------");
        }
    }

    // Método para agregar un nuevo veterinario a la lista de empleados
    public static void agregarVeterinario(Scanner key, List<Empleados> empleados) {
        System.out.println("Ingrese el nombre del veterinario:");
        String nombre = key.next();
        System.out.println("Ingrese la fecha de contrato (dd/mm/aaaa):");
        String fechaContrato = key.next();
        System.out.println("Ingrese el salario bruto mensual:");
        float salarioBrutoMes = key.nextFloat();
        System.out.println("Ingrese el número de colegiatura:");
        int numColegiatura = key.nextInt();
        System.out.println("Ingrese la especialidad:");
        String especialidad = key.next();

        // Crear una instancia de Veterinario y agregarla a la lista de empleados
        Veterinario nuevoVeterinario = new Veterinario(numColegiatura, nombre, especialidad, nombre, numColegiatura,
                fechaContrato, salarioBrutoMes, numColegiatura, especialidad);
        empleados.add(nuevoVeterinario);

        System.out.println("Veterinario agregado exitosamente.");
    }

    // mostrar veterinario
    public static void mostrarVeterinarios(List<Empleados> empleados) {
        // Verificar si hay veterinarios registrados
        boolean hayVeterinarios = false;
        for (Empleados empleado : empleados) {
            if (empleado instanceof Veterinario) {
                hayVeterinarios = true;
                break;
            }
        }

        if (!hayVeterinarios) {
            System.out.println("No hay veterinarios registrados.");
            return;
        }

        // Mostrar la información de cada veterinario
        System.out.println("Información de los veterinarios:");
        for (Empleados empleado : empleados) {
            if (empleado instanceof Veterinario) {
                Veterinario veterinario = (Veterinario) empleado;
                System.out.println("Nombre: " + veterinario.getnombre());
                System.out.println("Fecha de Contrato: " + veterinario.getfechaContrato());
                System.out.println("Salario Bruto Mensual: " + veterinario.getsalarioBrutoMes());
                System.out.println("Número de Colegiatura: " + veterinario.getnumColegiado());
                System.out.println("Especialidad: " + veterinario.getespecialidad());
                System.out.println("-------------------------");
            }
        }
    }

    // Pagar una factura
    public static void pagarFactura(Scanner key, List<Factura> facturas) {
        System.out.println("Ingrese el ID de la factura que desea pagar:");
        int idFactura = key.nextInt();

        // Buscar la factura por su ID
        for (Factura factura : facturas) {
            if (factura.getIdFactura() == idFactura) {
                // Verificar si la factura ya está pagada
                if (factura.isPagada()) {
                    System.out.println("La factura ya está pagada.");
                } else {
                    // Marcar la factura como pagada
                    factura.setPagada(true);
                    System.out.println("La factura ha sido pagada correctamente.");
                }
                return; // Terminar la búsqueda
            }
        }

        // Si no se encontró la factura
        System.out.println("No se encontró ninguna factura con el ID proporcionado.");
    }

    // Finalizar una actuación
    public static void finalizarActuacion(Scanner scanner, List<Actuación> actuaciones) {
        // Mostrar las actuaciones disponibles
        System.out.println("Actuaciones disponibles:");
        mostrarActualizaciones(actuaciones);

        // Solicitar al usuario el ID de la actuación que desea finalizar
        System.out.println("Ingrese el ID de la actuación que desea finalizar:");
        int idActuacion = scanner.nextInt();

        // Buscar la actuación por su ID
        for (Actuación actuacion : actuaciones) {
            if (actuacion.getIdActuacion() == idActuacion) {
                // Verificar si la actuación ya está finalizada
                if (actuacion.getEstado().equals("Finalizada")) {
                    System.out.println("La actuación ya está finalizada.");
                } else {
                    // Actualizar el estado de la actuación a "Finalizada"
                    actuacion.setEstado("Finalizada");
                    System.out.println("La actuación ha sido finalizada correctamente.");
                }
                return; // Terminar la búsqueda
            }
        }

        // Si no se encontró la actuación
        System.out.println("No se encontró ninguna actuación con el ID proporcionado.");
    }

}
