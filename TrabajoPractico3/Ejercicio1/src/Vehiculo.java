

public class Vehiculo {
    protected String marca;
    protected String modelo;
    protected int anio;
    public Vehiculo(String marca, String modelo, int anio) {
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
    }

    public String toString(){
        return "Vehiculo [marca=" + marca + ", modelo=" + modelo + ", anio=" + anio + "]";
    }


    public final String obtenerDescripcionCorta(){
        return marca + " " + modelo;
    }

    public static class Auto extends Vehiculo{
        private int cantidadPuertas;

        public Auto(String marca, String modelo, int anio, int cantidadPuertas) {
            super(marca, modelo, anio);
            this.cantidadPuertas = cantidadPuertas;
        }

        @Override
        public String toString() {
            return super.toString() + " Auto [cantidadPuertas=" + cantidadPuertas + "]";
        }
         /*
    ERROR DE COMPILACIÓN:
    No se puede sobrescribir un método declarado como final
    en la clase Vehiculo.

    @Override
    public String obtenerDescripcionCorta() {
        return "Auto: " + marca + " " + modelo;
    }
    */
    }

    public static class Moto extends Vehiculo{
        private int cilindrada;
        public Moto(String marca, String modelo, int anio, int cilindrada) {
            super(marca, modelo, anio);
            this.cilindrada = cilindrada;
        }

        @Override
        public String toString() {
            return super.toString() + " Moto [cilindrada=" + cilindrada + "cc]";
        }
    }

    public static class TestVehiculo{

        public static void main(String[] args) {
            Auto auto = new Auto("Toyota", "Corolla", 2020, 4);
            Moto moto = new Moto("Honda", "CBR500R", 2019, 500);

            System.out.println(auto.toString());
            System.out.println(moto.toString());

            System.out.println("Descripción corta del auto: " + auto.obtenerDescripcionCorta());
            System.out.println("Descripción corta de la moto: " + moto.obtenerDescripcionCorta());
        }
    }
}
