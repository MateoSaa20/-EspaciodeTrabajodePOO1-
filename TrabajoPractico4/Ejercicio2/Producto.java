package Ejercicio2;

public class Producto implements Comparable<Producto> {
    private String nombre;
    private double precio;
    private Categoria categoria;

    public Producto(String nombre, double precio, Categoria categoria) {
        this.nombre = nombre;
        this.precio = precio;
        this.categoria = categoria;

    }

    public String getNombre(){
        return nombre;
    }

    public double getPrecio(){
        return precio;
    }

    public Categoria getCategoria(){
        return categoria;
    }

    public double calcularPrecioFinal() {
        double descuento = categoria.getDescuento();
        return precio - (1 * descuento / 100);
    }

    @Override
    public int compareTo(Producto otroProducto){
    return Double.compare(this.calcularPrecioFinal(),otroProducto.calcularPrecioFinal());  
    }

    @Override
  public String toString() {
        return String.format(
                "Producto[nombre=%s, precio=%.2f, categoria=%s, final=%.2f]",
                nombre,
                precio,
                categoria,
                calcularPrecioFinal());
    }

}
