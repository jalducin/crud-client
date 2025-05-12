import java.util.*;
import java.util.logging.Logger;

record Cliente(String id, String nombre, String email, int edad, TipoCliente tipoCliente) {}

enum TipoCliente { REGULAR, VIP }

public class ClienteApp {
    private static final Logger logger = Logger.getLogger(ClienteApp.class.getName());
    private static final List<Cliente> clientes = new ArrayList<>();

    public static void crearCliente(Cliente cliente) {
        clientes.add(cliente);
        logger.info("Cliente creado: " + cliente);
    }

    public static List<Cliente> obtenerClientes() {
        return clientes;
    }

    public static void actualizarCliente(String id, String nuevoEmail, TipoCliente nuevoTipo) {
        for (int i = 0; i < clientes.size(); i++) {
            Cliente c = clientes.get(i);
            if (c.id().equals(id)) {
                clientes.set(i, new Cliente(c.id(), c.nombre(), nuevoEmail, c.edad(), nuevoTipo));
                logger.info("Cliente actualizado: " + clientes.get(i));
                return;
            }
        }
    }

    public static void eliminarCliente(String id) {
        clientes.removeIf(c -> c.id().equals(id));
        logger.info("Cliente con ID " + id + " eliminado.");
    }

    public static void aplicarBeneficioPorTipo() {
        for (Cliente c : clientes) {
            switch (c.tipoCliente()) {
                case VIP -> System.out.println("Cliente VIP " + c.nombre() + " tiene descuento.");
                case REGULAR -> System.out.println("Cliente REGULAR " + c.nombre() + " sin descuento.");
            }
        }
    }

    public static void main(String[] args) {
        crearCliente(new Cliente("1", "Juan", "juan@email.com", 30, TipoCliente.REGULAR));
        crearCliente(new Cliente("2", "Ana", "ana@email.com", 40, TipoCliente.VIP));
        aplicarBeneficioPorTipo();
        actualizarCliente("1", "juan.nuevo@email.com", TipoCliente.VIP);
        eliminarCliente("2");
    }
}
