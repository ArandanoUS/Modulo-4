import Registro.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;
        System.out.println("Bienvenido al registro de visitas");
        do {
            System.out.print("Ingrese el nombre del visitante: ");
            String nombre = scanner.nextLine();

            System.out.print("Ingrese la edad del visitante: ");
            int edad = scanner.nextInt();
            scanner.nextLine();

            Visitante visitante = new Visitante(nombre, edad);

            RegistroVisitas registro = new RegistroVisitas(visitante);
            registro.registrarVisitas();

            registro.mostrarResultados();

            System.out.println("¿Desea registrar otro visitante?");
            System.out.println("1. Si \n2. No");
            opcion = scanner.nextInt();
        } while (opcion != 2);

        System.out.println("Gracias por usar el sistema de registro de visitas.");
        scanner.close();
    }
}
