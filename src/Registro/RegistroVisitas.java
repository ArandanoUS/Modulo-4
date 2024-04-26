package Registro;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RegistroVisitas {
    private Visitante visitante;
    private int totalVisitas;
    private double tiempoTotalEstadia;
    private int contadorVisitas;

    public RegistroVisitas(Visitante visitante) {
        this.visitante = visitante;
    }

    public void registrarVisitas() {
        Scanner scanner = new Scanner(System.in);

        for (int i = 1; i <= 7; i++) {
            System.out.println("\n--- Día " + i + " ---");

            System.out.print("Ingrese la cantidad de visitas para el día " + i + ": ");
            int visitasDia = scanner.nextInt();
            totalVisitas += visitasDia;

            for (int j = 1; j <= visitasDia; j++) {
                System.out.print("Ingrese la duración de la visita " + j + " en minutos: ");
                double duracion = scanner.nextDouble();
                tiempoTotalEstadia += duracion;
                contadorVisitas++;
            }
            scanner.nextLine(); // Limpiar el buffer del scanner
        }

    }

    public void mostrarResultados() {
        double promedioEstadia = tiempoTotalEstadia / contadorVisitas;

        System.out.println("\n--- Resultados ---");
        System.out.println("Total de visitas durante la semana: " + totalVisitas);
        System.out.println("Tiempo promedio de estadía: " + promedioEstadia + " minutos");

        if (visitante.esMayorEdad()) {
            System.out.println("El visitante es mayor de edad.");
        } else {
            System.out.println("El visitante es menor de edad.");
        }
    }
}