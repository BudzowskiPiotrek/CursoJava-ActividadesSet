import java.util.LinkedHashSet;
import java.util.Scanner;

public class Main {
    // CONJUNTOS PARA ALMACENAR LOS DISFRACES DE CADA AGENTE
    private static LinkedHashSet<String> mortadeloDisfraces = new LinkedHashSet<>();
    private static LinkedHashSet<String> filemonDisfraces = new LinkedHashSet<>();
    private static Scanner sn = new Scanner(System.in);
    private static Scanner st = new Scanner(System.in);

    public static void main(String[] args) {
        menu();
    }

    // MÉTODO QUE MUESTRA EL MENÚ PRINCIPAL Y GESTIONA LAS OPCIONES
    private static void menu() {
        while (true) {
            System.out.println("1. Añadir un disfraz de Mortadelo");
            System.out.println("2. Añadir un disfraz de Filemon");
            System.out.println("3. Eliminar un disfraz a Mortadelo");
            System.out.println("4. Eliminar un disfraz a Filemón");
            System.out.println("5. Mostrar todos los disfraces de Mortadelo");
            System.out.println("6. Mostrar todos los disfraces de Filemon");
            System.out.println("7. Mostrar disfraces en comun");
            int opcion = sn.nextInt();
            menuSwitch(opcion);
        }
    }

    // MÉTODO QUE EJECUTA LA ACCIÓN SEGÚN LA OPCIÓN DEL USUARIO
    private static void menuSwitch(int opcion) {
        switch (opcion) {
            case 1:
                anadirDisfrazMortadelo();
                break;
            case 2:
                anadirDisfrazFilemon();
                break;
            case 3:
                eliminarDisfrazMortadelo();
                break;
            case 4:
                eliminarDisfrazFilemon();
                break;
            case 5:
                mostrarDisfracesMortadelo();
                break;
            case 6:
                mostrarDisfracesFilemon();
                break;
            case 7:
                mostrarDisfracesComunes();
                break;
            default:
                System.err.println("Numero no valido, intente otra vez");
        }
    }

    // MÉTODOS PARA AÑADIR DISFRACES
    private static void anadirDisfrazMortadelo() {
        System.out.print("Ingrese el nombre del disfraz para Mortadelo: ");
        String disfraz = st.nextLine().toLowerCase(); // CONVIERTE A MINÚSCULAS PARA EVITAR DUPLICADOS POR MAYÚSCULAS
        if (mortadeloDisfraces.add(disfraz)) { // AGREGA EL DISFRAZ AL CONJUNTO
            System.out.println("Disfraz agregado");
        } else {
            System.err.println("Disfraz no agregado");
        }
    }

    private static void anadirDisfrazFilemon() {
        System.out.print("Ingrese el nombre del disfraz para Filemon: ");
        String disfraz = st.nextLine().toLowerCase();
        if (filemonDisfraces.add(disfraz)) { // AGREGA EL DISFRAZ AL CONJUNTO
            System.out.println("Disfraz agregado");
        } else {
            System.err.println("Disfraz no agregado");
        }
    }

    // MÉTODOS PARA ELIMINAR DISFRACES
    private static void eliminarDisfrazMortadelo() {
        System.out.print("Ingrese el nombre del disfraz a eliminar de Mortadelo: ");
        String disfraz = st.nextLine().toLowerCase();
        if (mortadeloDisfraces.remove(disfraz)) { // INTENTA ELIMINAR EL DISFRAZ, SI EXISTE
            System.out.println("Disfraz eliminado");
        } else {
            System.err.println("Disfraz no eliminado");
        }
    }

    private static void eliminarDisfrazFilemon() {
        System.out.print("Ingrese el nombre del disfraz a eliminar de Filemón: ");
        String disfraz = st.nextLine().toLowerCase();
        if (filemonDisfraces.remove(disfraz)) { // INTENTA ELIMINAR EL DISFRAZ, SI EXISTE
            System.out.println("Disfraz eliminado");
        } else {
            System.err.println("Disfraz no eliminado");
        }
    }

    // MÉTODOS PARA MOSTRAR DISFRACES
    private static void mostrarDisfracesMortadelo() {
        System.out.println("\nDisfraces de Mortadelo:");
        if (mortadeloDisfraces.isEmpty()) { // COMPRUEBA SI ESTA VACIO
            System.err.println("No hay disfraces");
        } else {
            for (String disfraz : mortadeloDisfraces) {
                System.out.println("- " + disfraz);
            }
        }
    }

    private static void mostrarDisfracesFilemon() {
        System.out.println("\nDisfraces de Filemon:");
        if (filemonDisfraces.isEmpty()) { // COMPRUEBA SI ESTA VACIO
            System.err.println("No hay disfraces");
        } else {
            for (String disfraz : filemonDisfraces) {
                System.out.println("- " + disfraz);
            }
        }
    }

    // MÉTODO PARA MOSTRAR LOS DISFRACES EN COMÚN ENTRE MORTADELO Y FILEMÓN
    private static void mostrarDisfracesComunes() {
        LinkedHashSet<String> comunes = new LinkedHashSet<>(mortadeloDisfraces);
        comunes.retainAll(filemonDisfraces); // CONSERVA SOLO LOS DISFRACES QUE ESTÁN EN AMBOS CONJUNTOS

        System.out.println("\nDisfraces en comun:");
        if (comunes.isEmpty()) {
            System.err.println("No hay disfraces en comun.");
        } else {
            for (String disfraz : comunes) {
                System.out.println("- " + disfraz);
            }
        }
    }
}