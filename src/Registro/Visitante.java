package Registro;
public class Visitante {
    private String nombre;
    private int edad;

    public Visitante(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public boolean esMayorEdad() {
        return edad >= 18;
    }
}