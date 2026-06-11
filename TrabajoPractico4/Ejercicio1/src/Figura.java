/**
 * Clase abstracta Figura: centraliza el atributo nombre y obliga a las subclases
 * a implementar calcularArea() mediante el modificador abstract.
 */
public abstract class Figura {

    protected String nombre;

    public Figura(String nombre) {
        this.nombre = nombre;
    }

    public abstract double calcularArea();

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return "Figura[nombre=" + nombre + "]";
    }
}
