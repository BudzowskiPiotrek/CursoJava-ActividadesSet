import java.util.HashSet;
import java.util.Scanner;

public class Main {
    // CONJUNTO PARA ALMACENAR LOS AGENTES SIN DUPLICADOS
    private static HashSet<String> agentes = new HashSet<>();
    private static Scanner sn = new Scanner(System.in);
    private static Scanner st = new Scanner(System.in);

    public static void main(String[] args) {
        menu();
    }

    // MÉTODO QUE MUESTRA EL MENÚ PRINCIPAL Y PERMITE LA INTERACCIÓN DEL USUARIO
    private static void menu() {
        while (true) {
            System.out.println("\nSISTEMA DE REGISTRO DE AGENTES SECRETOS");
            System.out.println("1. Añadir nuevo agente");
            System.out.println("2. Eliminar agente");
            System.out.println("3. Mostrar todos los agentes");
            int opcion = sn.nextInt();
            menuSwitch(opcion);
        }
    }

    // MÉTODO QUE EJECUTA LA ACCIÓN SEGÚN LA OPCIÓN DEL USUARIO
    private static void menuSwitch(int opcion) {
        switch (opcion) {
            case 1:
                anadirAgente();
                break;
            case 2:
                eliminarAgente();
                break;
            case 3:
                mostrarAgentes();
                break;
            default:
                System.err.println("Numero no valido, intente otra vez");
        }
    }

    // MÉTODO PARA AÑADIR UN NUEVO AGENTE A LA BASE DE DATOS
    private static void anadirAgente() {
        System.out.print("INGRESE EL NOMBRE DEL AGENTE: ");
        String nombre = st.nextLine().toLowerCase(); // CONVIERTE EL NOMBRE A MINÚSCULAS PARA EVITAR DUPLICADOS 

        if (agentes.contains(nombre)) { // VERIFICA SI EL AGENTE YA ESTÁ REGISTRADO
            System.err.println("EL AGENTE YA ESTA REGISTRADO");
        } else {
            agentes.add(nombre); // AGREGA EL AGENTE AL CONJUNTO
            System.out.println("AGENTE REGISTRADO CON EXITO");
        }
    }

    // MÉTODO PARA ELIMINAR UN AGENTE DE LA BASE DE DATOS
    private static void eliminarAgente() {
        System.out.print("INGRESE EL NOMBRE DEL AGENTE A ELIMINAR: ");
        String nombre = st.nextLine().toLowerCase(); // CONVIERTE EL NOMBRE A MINÚSCULAS PARA UNA COMPARACIÓN
                                                     
        if (agentes.remove(nombre)) { // INTENTA ELIMINAR EL AGENTE, SI EXISTE
            System.out.println("AGENTE ELIMINADO CON EXITO");
        } else {
            System.err.println("NO EXISTE AGENTE CON ESE NOMBRE");
        }
    }

    // MÉTODO PARA MOSTRAR TODOS LOS AGENTES REGISTRADOS
    private static void mostrarAgentes() {
        if (agentes.isEmpty()) { // VERIFICA SI LA LISTA DE AGENTES ESTÁ VACÍA
            System.err.println("NO HAY AGENTES REGISTRADOS.");
        } else {
            System.out.println("\nLISTA DE AGENTES:");
            for (String agente : agentes) {
                System.out.println("- " + agente); // IMPRIME CADA AGENTE REGISTRADO
            }
        }
    }
}
