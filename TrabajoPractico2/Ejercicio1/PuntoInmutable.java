package TrabajoPractico2.Ejercicio1;
public final class PuntoInmutable{
    private final double x;
    private final double y;

    public  PuntoInmutable (double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public String toString() {
        return "PuntoInmutable(x = " + x + ", y = " + y + ")";
    }

    PuntoInmutable transladar(double dx, double dy) {
        return new PuntoInmutable(x + dx, y + dy);
    }
    PuntoInmutable escalar(double factor) {
        return new PuntoInmutable(x * factor, y * factor);
    }
    PuntoInmutable reflejarEjeX() {
        return new PuntoInmutable(x, -y);
    }
    PuntoInmutable reflejarEjeY() {
        return new PuntoInmutable(-x, y);
    }
    double distanciaAlOrigen() {
        return Math.sqrt(x * x + y * y);
    }
    double distanciaA(PuntoInmutable otro) {
        double dx = x - otro.x;
        double dy = y - otro.y;
        return Math.sqrt(dx * dx + dy * dy);
    }

    
public class Main {

    public static void main(String[] args) {

        PuntoInmutable punto1 = new PuntoInmutable(3.0, 4.0);

        System.out.println(punto1);

        PuntoInmutable punto2 =
                punto1.reflejarEjeX().escalar(2.0).transladar(1.0, 1.0);
                 System.out.println(punto2);

        System.out.println("Distancia al origen: "+ punto1.distanciaAlOrigen());

        System.out.println("Distancia a (0,0): "+ punto1.distanciaA(new PuntoInmutable(0.0, 0.0)));
    }
}
}