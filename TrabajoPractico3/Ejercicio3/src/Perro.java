public class Perro extends Mamifero {
    private String raza;

    public Perro(String nombre, int mesesGestacion, String raza) {
        super(nombre, mesesGestacion);
        this.raza = raza;
    }

    @Override
    public String hacerSonido() {
        return "Guau guau!";
    }

    @Override
    public String toString() {
        return super.toString() + ", raza=" + raza;
    }
}
