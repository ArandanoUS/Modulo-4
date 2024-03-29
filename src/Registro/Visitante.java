package Registro;

public class Visitante{
    private String Nombre;
    private String Apellido;
    private String Cedula;
    private int Edad;

    public Visitante(String nombre, String apellido, String cedula, int edad) {
        Nombre = nombre;
        Apellido = apellido;
        Cedula = cedula;
        Edad = edad;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String apellido) {
        Apellido = apellido;
    }

    public String getCedula() {
        return Cedula;
    }

    public void setCedula(String cedula) {
        Cedula = cedula;
    }

    public int getEdad() {
        return Edad;
    }

    public void setEdad(int edad) {
        Edad = edad;
    }
}
