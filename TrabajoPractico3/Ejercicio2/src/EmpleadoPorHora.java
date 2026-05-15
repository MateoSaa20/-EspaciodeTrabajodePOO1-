package TrabajoPractico3.Ejercicio2.src;

import java.util.Objects;

public class EmpleadoPorHora extends Empleado {
    private int horasTrabajadas;
    private double valorHora;

    // Constructor que invoca a la superclase
    public EmpleadoPorHora(String nombre, String dni, double sueldoBase, int horasTrabajadas, double valorHora) {
        super(nombre, dni, sueldoBase);
        this.horasTrabajadas = horasTrabajadas;
        this.valorHora = valorHora;
    }

    // Extiende el comportamiento agregando el pago por horas
    @Override
    public double calcularSalario() {
        return super.calcularSalario() + (horasTrabajadas * valorHora);
    }

    // Reutiliza el toString() base y concatena sus atributos específicos
    @Override
    public String toString() {
        return super.toString() + ", horas=" + horasTrabajadas + ", valorHora=" + valorHora;
    }
}