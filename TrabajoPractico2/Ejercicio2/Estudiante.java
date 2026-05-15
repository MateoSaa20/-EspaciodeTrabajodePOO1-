package TrabajoPractico2.Ejercicio2;

public class Estudiante {

    private String nombre;
    private int legajo;
    private double promedio;

    public Estudiante(String nombre, int legajo, double promedio) {
        this.nombre = nombre;
        this.legajo = legajo;
        this.promedio = promedio;
    }

    public String getNombre() {
        return nombre;
    }

    public int getLegajo() {
        return legajo;
    }

    public double getPromedio() {
        return promedio;
    }

    public boolean estaAprobado() {
        return promedio >= 6.0;
    }

    @Override
    public String toString() {
        return "Estudiante(nombre = " + nombre +
                ", legajo = " + legajo +
                ", promedio = " + promedio + ")";
    }
}