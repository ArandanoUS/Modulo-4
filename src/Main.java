import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import Registro.Visitante;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Visitante> listaVisitantes = new ArrayList<>();
        int opcion;

        do {
            System.out.println("\nMenú:");
            System.out.println("1. Registrar visitante");
            System.out.println("2. Ver lista de visitantes");
            System.out.println("3. Salir");
            System.out.println("Ingrese una opción:");

            try {
                opcion = scanner.nextInt();
                scanner.nextLine(); // Limpiar el buffer de entrada

                switch (opcion) {
                    case 1:
                        registrarVisitante(scanner, listaVisitantes);
                        break;
                    case 2:
                        menuBuscarVisitantes(scanner, listaVisitantes);
                        break;
                    case 3:
                        System.out.println("Saliendo del programa...");
                        break;
                    default:
                        System.out.println("Opción no válida. Por favor, ingrese una opción válida.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Por favor, ingrese un número válido.");
                scanner.next(); // Limpiar el buffer de entrada
                opcion = 0; // Reiniciar la opción para evitar un bucle infinito
            }
        } while (opcion != 3);

        // Cerrar el scanner
        scanner.close();
    }

    private static void registrarVisitante(Scanner scanner, ArrayList<Visitante> listaVisitantes) {
        try {
            // Pedir información del visitante
            System.out.println("\nIngrese el nombre del visitante:");
            String nombre = scanner.nextLine();

            System.out.println("Ingrese el apellido del visitante:");
            String apellido = scanner.nextLine();

            System.out.println("Ingrese la cédula del visitante:");
            String cedula = scanner.nextLine();

            int edad;
            do {
                System.out.println("Ingrese la edad del visitante:");
                edad = scanner.nextInt();
                if (edad < 0) {
                    System.out.println("Error: La edad no puede ser un valor negativo. Inténtelo de nuevo.");
                }
            } while (edad < 0);
            scanner.nextLine(); // Limpiar el buffer de entrada

            // Crear un objeto Visitante con la información proporcionada y agregarlo a la lista de visitantes
            Visitante visitante = new Visitante(nombre, apellido, cedula, edad);
            listaVisitantes.add(visitante);

            System.out.println("Visitante registrado exitosamente.");
        } catch (InputMismatchException e) {
            System.out.println("Error: La edad debe ser un número entero.");
            scanner.next(); // Limpiar el buffer de entrada
        }
    }

    private static void menuBuscarVisitantes(Scanner scanner, ArrayList<Visitante> listaVisitantes) {
        int opcion;
        do {
            System.out.println("\nMenú de búsqueda de visitantes:");
            System.out.println("1. Mostrar lista completa de visitantes");
            System.out.println("2. Buscar visitante por nombre");
            System.out.println("3. Buscar visitante por cédula");
            System.out.println("4. Regresar al menú principal");
            System.out.println("Ingrese una opción:");

            try {
                opcion = scanner.nextInt();
                scanner.nextLine(); // Limpiar el buffer de entrada

                switch (opcion) {
                    case 1:
                        mostrarListaVisitantes(listaVisitantes);
                        break;
                    case 2:
                        buscarPorNombre(scanner, listaVisitantes);
                        break;
                    case 3:
                        buscarPorCedula(scanner, listaVisitantes);
                        break;
                    case 4:
                        System.out.println("Regresando al menú principal...");
                        break;
                    default:
                        System.out.println("Opción no válida. Por favor, ingrese una opción válida.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Por favor, ingrese un número válido.");
                scanner.next(); // Limpiar el buffer de entrada
                opcion = 0; // Reiniciar la opción para evitar un bucle infinito
            }
        } while (opcion != 4);
    }

    private static void mostrarListaVisitantes(ArrayList<Visitante> listaVisitantes) {
        System.out.println("\nLista de visitantes:");
        for (Visitante visitante : listaVisitantes) {
            System.out.println("Nombre: " + visitante.getNombre());
            System.out.println("Apellido: " + visitante.getApellido());
            System.out.println("Cédula: " + visitante.getCedula());
            System.out.println("Edad: " + visitante.getEdad());
            System.out.println("-----------------------");
        }
    }

    private static void buscarPorNombre(Scanner scanner, ArrayList<Visitante> listaVisitantes) {
        System.out.println("\nIngrese el nombre del visitante a buscar:");
        String nombre = scanner.nextLine();
        boolean encontrado = false;
        for (Visitante visitante : listaVisitantes) {
            if (visitante.getNombre().equalsIgnoreCase(nombre)) {
                System.out.println("\nInformación del visitante encontrado:");
                System.out.println("Nombre: " + visitante.getNombre());
                System.out.println("Apellido: " + visitante.getApellido());
                System.out.println("Cédula: " + visitante.getCedula());
                System.out.println("Edad: " + visitante.getEdad());
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            System.out.println("No se encontró ningún visitante con ese nombre.");
        }
    }

    private static void buscarPorCedula(Scanner scanner, ArrayList<Visitante> listaVisitantes) {
        System.out.println("\nIngrese la cédula del visitante a buscar:");
        String cedula = scanner.nextLine();
        boolean encontrado = false;
        for (Visitante visitante : listaVisitantes) {
            if (visitante.getCedula().equalsIgnoreCase(cedula)) {
                System.out.println("\nInformación del visitante encontrado:");
                System.out.println("Nombre: " + visitante.getNombre());
                System.out.println("Apellido: " + visitante.getApellido());
                System.out.println("Cédula: " + visitante.getCedula());
                System.out.println("Edad: " + visitante.getEdad());
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            System.out.println("No se encontró ningún visitante con esa cédula.");
        }
    }
}
