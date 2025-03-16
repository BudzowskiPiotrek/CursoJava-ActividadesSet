import java.util.Scanner;
import java.util.TreeSet;

public class Main {
    private static TreeSet<Mision> misiones = new TreeSet<>(); // TREESET PARA ORDENAR MISIONES
    private static Scanner sn = new Scanner(System.in);
    private static Scanner st = new Scanner(System.in);

    public static void main(String[] args) {
        menu();
    }

    // MÉTODO QUE MUESTRA EL MENÚ PRINCIPAL Y PERMITE LA INTERACCIÓN DEL USUARIO
    private static void menu() {
        while (true) {
            System.out.println("1. Añadir nueva mision");
            System.out.println("2. Eliminar mision");
            System.out.println("3. Mostrar todas las misiones");
            int opcion = sn.nextInt();
            menuSwitch(opcion);

        }
    }

    // MÉTODO QUE EJECUTA LA ACCIÓN SEGÚN LA OPCIÓN DEL USUARIO
    private static void menuSwitch(int opcion) {
        switch (opcion) {
            case 1:
                anadirMision();
                break;
            case 2:
                eliminarMision();
                break;
            case 3:
                mostrarMisiones();
                break;
            default:
                System.err.println("Opcion no valida, intente de nuevo.");
        }
    }

    // MÉTODO PARA AÑADIR UNA NUEVA MISIÓN AL SISTEMA
    private static void anadirMision() {
        System.out.print("Ingrese el nombre: ");
        String nombre = st.nextLine();

        System.out.println("Seleccione el nivel de prioridad: 1. ALTA, 2. MEDIA, 3. BAJA");
        int opcion = sn.nextInt();

        // DETERMINAR LA PRIORIDAD SEGÚN LA OPCIÓN SELECCIONADA
        Prioridad prioridad;
        switch (opcion) {
            case 1:
                prioridad = Prioridad.ALTA;
                break;
            case 2:
                prioridad = Prioridad.MEDIA;
                break;
            case 3:
                prioridad = Prioridad.BAJA;
                break;
            default:
                System.err.println("Opcion no valida. Asignando prioridad MEDIA por defecto.");
                prioridad = Prioridad.MEDIA;
        }

        if (misiones.add(new Mision(nombre, prioridad))) { // AÑADIR LA MISIÓN AL TREESET SI NO EXISTE
            System.out.println("Añadida con exito.");
        } else {
            System.err.println("La mision ya existe");
        }
    }

    // MÉTODO PARA ELIMINAR UNA MISIÓN DEL SISTEMA
    private static void eliminarMision() {
        System.out.print("El nombre de la misión a eliminar: ");
        String nombre = sn.nextLine();

        Mision encontrada = null; // INICIALIZAR UNA VARIABLE PARA LA MISIÓN ENCONTRADA
        for (Mision m : misiones) {
            if (m.getNombre().equalsIgnoreCase(nombre)) {
                encontrada = m;
                break;
            }
        }
        // SI SE ENCONTRÓ LA MISIÓN, ELIMINARLA DEL TREESET
        if (encontrada != null) {
            misiones.remove(encontrada);
            System.out.println("Eliminada con exito");
        } else {
            System.err.println("Mision no encontrada");
        }
    }

    // MÉTODO PARA MOSTRAR TODAS LAS MISIONES REGISTRADAS
    private static void mostrarMisiones() {
        if (misiones.isEmpty()) {
            System.err.println("No hay misiones registradas");
        } else {
            System.out.println("\nListado de misiones ordenadas:");
            for (Mision m : misiones) {
                System.out.println(m);
            }
        }
    }
}
