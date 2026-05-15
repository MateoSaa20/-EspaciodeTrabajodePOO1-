package TrabajoPractico3.Ejercicio2.src;

import java.util.Objects;

public class EmpleadoTiempoCompleto extends Empleado {
    private double bonoAnual;

    // Constructor que invoca a la superclase
    public EmpleadoTiempoCompleto(String nombre, String dni, double sueldoBase, double bonoAnual) {
        super(nombre, dni, sueldoBase);
        this.bonoAnual = bonoAnual;
    }

    // Extiende el comportamiento del cálculo base
    @Override
    public double calcularSalario() {
        return super.calcularSalario() + (bonoAnual / 12);
    }

    // Reutiliza el toString() base y concatena su atributo específico
    @Override
    public String toString() {
        return super.toString() + ", bonoAnual=" + bonoAnual;
    }
}