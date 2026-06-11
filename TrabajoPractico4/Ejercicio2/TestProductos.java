package Ejercicio2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class TestProductos {

    public static void main(String[] args) {
        List<Producto> productos = new ArrayList<>();
        productos.add(new Producto("Laptop", 1000.0, Categoria.electronica));
        productos.add(new Producto("Camisa", 50.0, Categoria.ropa));
        productos.add(new Producto("Manzana", 1.0, Categoria.alimentos));
        productos.add(new Producto("Televisor", 500.0, Categoria.electronica));
        productos.add(new Producto("Pantalones", 80.0, Categoria.ropa));
        productos.add(new Producto("Pan", 2.0, Categoria.alimentos));

        //se muestra el producto por orden natural
        Collections.sort(productos);
        System.out.println("Productos ordenados por precio final (orden natural):");
        productos.forEach(System.out::println);

        //orden de productos usando lambda
        productos.sort((p1, p2) -> p1.getNombre().compareTo(p2.getNombre()));

        System.out.println("\nProductos ordenados por nombre (usando lambda):");
        productos.forEach(System.out::println);

        //orden por categoria y precio ascendente
        Comparator<Producto> categoriaPrecioComparator = Comparator.comparing(Producto::getCategoria).thenComparing(Producto::calcularPrecioFinal);
    
        //imprimir los productos despues de todos los ordenamientos
        productos.sort(categoriaPrecioComparator);
        System.out.println("\nProductos ordenados por categoria y precio final (ascendente):");
        productos.forEach(System.out::println);

        //obtener el producto mas barato
        Optional<Producto> productoMasBarato = productos.stream()
            .min(Comparator.comparing(Producto::calcularPrecioFinal));
    
        System.out.println("\nProducto más barato:");
        productoMasBarato.ifPresent(System.out::println);

    }

    
    
    }
