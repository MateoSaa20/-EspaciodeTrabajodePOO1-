/**
 * Circulo: subclase concreta de Figura.
 */
public class Circulo extends Figura implements Dibujable, Coloreable {

    private double radio;

    public Circulo(String nombre, double radio) {
        super(nombre);
        this.radio = radio;
    }

    // @Override implementa el método abstracto de Figura
    @Override
    public double calcularArea() {
        return Math.PI * radio * radio;
    }

    // Implementación del contrato Dibujable
    @Override
    public void dibujar() {
        System.out.println("Dibujando círculo: " + nombre);
    }

    // Implementación del contrato Coloreable
    @Override
    public void colorear(String color) {
        System.out.println("Coloreando círculo de color " + color);
    }

    public double getRadio() {
        return radio;
    }

    @Override
    public String toString() {
        return super.toString().replace("]", "")
                + ", radio=" + radio
                + ", area=" + String.format("%.2f", calcularArea()) + "]";
    }
}
