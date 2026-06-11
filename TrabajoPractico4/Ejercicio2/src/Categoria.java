package Ejercicio2.src;

public enum Categoria {
    electronica (10.0),
    ropa (20.0),
    alimentos (5.0);




    private double descuento;
    Categoria(double descuento) {
        this.descuento = descuento;
    }

    double getDescuento(){
        return descuento;
    }

}
