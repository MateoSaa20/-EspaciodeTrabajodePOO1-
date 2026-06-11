/**
 * Rectangulo: subclase concreta de Figura.
 * Implementa SOLO Dibujable (no Coloreable).
 */
public class Rectangulo extends Figura implements Dibujable {

    private double base;
    private double altura;

    public Rectangulo(String nombre, double base, double altura) {
        super(nombre);
        this.base = base;
        this.altura = altura;
    }

    @Override
    public double calcularArea() {
        return base * altura;
    }

    @Override
    public void dibujar() {
        System.out.println("Dibujando rectángulo: " + nombre);
    }

    public double getBase() { return base; }
    public double getAltura() { return altura; }

    @Override
    public String toString() {
        return super.toString().replace("]", "")
                + ", base=" + base
                + ", altura=" + altura
                + ", area=" + String.format("%.2f", calcularArea()) + "]";
    }
}
