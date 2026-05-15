package TrabajoPractico2.Ejercicio3;
import java.util.*;

public class Biblioteca {


    public static class Libro {
        private String isbn;
        private String titulo;
        private String autor;
        private Set<String> categorias;

        public Libro(String isbn, String titulo, String autor) {
            this.isbn = isbn;
            this.titulo = titulo;
            this.autor = autor;
            this.categorias = new HashSet<>();
        }

        public String getIsbn() { return isbn; }
        public String getTitulo() { return titulo; }
        public String getAutor() { return autor; }

       
        public Set<String> getCategorias() {
            return Collections.unmodifiableSet(categorias);
        }

        public void agregarCategoria(String categoria) {
            categorias.add(categoria);
        }

        public boolean perteneceACategoria(String categoria) {
            return categorias.contains(categoria);
        }

        @Override
        public String toString() {
            return String.format("[%s] %s - %s | Categorías: %s", 
                    isbn, titulo, autor, categorias);
        }
    }

   
    private Map<String, Libro> librosPorIsbn;
    private Map<String, Set<String>> librosPorCategoria;
    private Set<String> isbnPrestados;

    public Biblioteca() {
        this.librosPorIsbn = new HashMap<>();
        this.librosPorCategoria = new HashMap<>();
        this.isbnPrestados = new HashSet<>();
    }



    public void registrarLibro(Libro libro) {
        if (!librosPorIsbn.containsKey(libro.getIsbn())) {
            librosPorIsbn.put(libro.getIsbn(), libro);
           
            for (String cat : libro.getCategorias()) {
                librosPorCategoria.putIfAbsent(cat, new HashSet<>());
                librosPorCategoria.get(cat).add(libro.getIsbn());
            }
        }
    }

    public Libro buscarPorIsbn(String isbn) {
        return librosPorIsbn.get(isbn);
    }

    public Set<String> obtenerCategorias() {
        return librosPorCategoria.keySet();
    }

    public Set<Libro> buscarPorCategoria(String categoria) {
        Set<Libro> resultados = new HashSet<>();
        Set<String> isbns = librosPorCategoria.get(categoria);
        
        if (isbns != null) {
            for (String isbn : isbns) {
                resultados.add(librosPorIsbn.get(isbn));
            }
        }
        return resultados;
    }

    public boolean prestarLibro(String isbn) {
        if (!librosPorIsbn.containsKey(isbn) || isbnPrestados.contains(isbn)) {
            return false;
        }
        return isbnPrestados.add(isbn);
    }

    public boolean devolverLibro(String isbn) {
        return isbnPrestados.remove(isbn);
    }

    public Set<Libro> obtenerLibrosDisponibles() {
        Set<Libro> disponibles = new HashSet<>();
        for (String isbn : librosPorIsbn.keySet()) {
            if (!isbnPrestados.contains(isbn)) {
                disponibles.add(librosPorIsbn.get(isbn));
            }
        }
        return disponibles;
    }

    public void listarTodos() {
        System.out.println("\n--- Listado de Biblioteca ---");
        for (Libro l : librosPorIsbn.values()) {
            String estado = isbnPrestados.contains(l.getIsbn()) ? "[PRESTADO]" : "[DISPONIBLE]";
            System.out.println(estado + " " + l);
        }
    }


    public static void main(String[] args) {
        Biblioteca miBiblioteca = new Biblioteca();

      
        Libro l1 = new Libro("111", "Don Quijote", "Cervantes");
        l1.agregarCategoria("Clásicos");
        l1.agregarCategoria("Aventura");

        Libro l2 = new Libro("222", "El Hobbit", "Tolkien");
        l2.agregarCategoria("Fantasía");
        l2.agregarCategoria("Aventura");

        Libro l3 = new Libro("333", "Cien Años de Soledad", "García Márquez");
        l3.agregarCategoria("Clásicos");
        l3.agregarCategoria("Realismo Mágico");

        Libro l4 = new Libro("444", "Java 17", "Oracle Press");
        l4.agregarCategoria("Tecnología");

      
        miBiblioteca.registrarLibro(l1);
        miBiblioteca.registrarLibro(l2);
        miBiblioteca.registrarLibro(l3);
        miBiblioteca.registrarLibro(l4);

        
        System.out.println("Categorías en la biblioteca: " + miBiblioteca.obtenerCategorias());

       
        System.out.println("Libros de Aventura': " + miBiblioteca.buscarPorCategoria("Aventura"));
        System.out.println("Libros de 'Cocina': " + miBiblioteca.buscarPorCategoria("Cocina"));

      
        System.out.println("Prestando el libro '111' (Quijote): " + miBiblioteca.prestarLibro("111"));
        System.out.println("Intentando prestar '111' de nuevo: " + miBiblioteca.prestarLibro("111"));
        miBiblioteca.prestarLibro("222");

        
        miBiblioteca.listarTodos();

  
        System.out.println("Devolvemos el libro '111'");
        miBiblioteca.devolverLibro("111");
        System.out.println("Los libros disponibles ahora son: " + miBiblioteca.obtenerLibrosDisponibles().size());
        miBiblioteca.listarTodos();
    }
}



