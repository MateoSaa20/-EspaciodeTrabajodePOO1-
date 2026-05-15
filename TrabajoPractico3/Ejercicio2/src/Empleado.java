

import java.util.Objects;

public class Empleado {
    private String nombre;
    private String dni;
    private double sueldoBase;

    // Constructor
    public Empleado(String nombre, String dni, double sueldoBase) {
        this.nombre = nombre;
        this.dni = dni;
        this.sueldoBase = sueldoBase;
    }

    // Método final: impide la sobreescritura en las subclases
    public final String getDni() {
        return dni;
    }

    // Método base para el cálculo de salario
    public double calcularSalario() {
        return sueldoBase;
    }

    @Override
    public String toString() {
        return "Empleado[nombre=" + nombre + ", dni=" + dni + ", salario=" + calcularSalario() + "]";
    }

    // Sobreescritura estricta de equals usando getClass() para asegurar simetría
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Empleado empleado = (Empleado) obj;
        return Objects.equals(dni, empleado.dni);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dni);
    }
}
