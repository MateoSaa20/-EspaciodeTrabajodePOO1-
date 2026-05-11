import java.util.ArrayList;
import java.util.List;


public class Estudiante {

    private String nombre;
    private int legajo;
    private double promedio;

    public Estudiante(String nombre, int legajo, double promedio) {
        this.nombre = nombre;
        this.legajo = legajo;
        this.promedio = promedio;
    }

    public String getNombre() {
        return nombre;
    }

    public int getLegajo() {
        return legajo;
    }

    public double getPromedio() {
        return promedio;
    }

    public boolean estaAprobado() {
        return promedio >= 6.0;
    }

 
    public String toString() {
        return "Estudiante(nombre = " + nombre +
                ", legajo = " + legajo +
                ", promedio = " + promedio + ")";
    }
}


 public class GestionEstudiantes {

    private List<Estudiante> estudiantes;

    public GestionEstudiantes() {
        estudiantes = new ArrayList<>();
    }

    public void agregarEstudiante(Estudiante e) {
        estudiantes.add(e);
    }

    public void listarEstudiantes() {

        int i = 1;

        for (Estudiante e : estudiantes) {
            System.out.println(i + " - " + e);
            i++;
        }
    }

    public Estudiante buscarPorLegajo(int legajo) {

        for (Estudiante e : estudiantes) {

            if (e.getLegajo() == legajo) {
                return e;
            }
        }

        return null;
    }

    public List<Estudiante> obtenerAprobados() {

        List<Estudiante> aprobados =
                new ArrayList<>();

        for (Estudiante e : estudiantes) {

            if (e.estaAprobado()) {
                aprobados.add(e);
            }
        }

        return aprobados;
    }

    public Estudiante obtenerMejorEstudiante() {

        if (estudiantes.isEmpty()) {
            return null;
        }

        Estudiante mejor = estudiantes.get(0);

        for (Estudiante e : estudiantes) {

            if (e.getPromedio() >
                    mejor.getPromedio()) {

                mejor = e;
            }
        }

        return mejor;
    }

    public double calcularPromedioGeneral() {

        if (estudiantes.isEmpty()) {
            return 0.0;
        }

        double suma = 0.0;

        for (Estudiante e : estudiantes) {
            suma += e.getPromedio();
        }

        return suma / estudiantes.size();
    }

}
     public static void main(String[] args) {

        GestionEstudiantes gestion = new GestionEstudiantes();

        Estudiante e1 = new Estudiante("Juan", 123, 7.5);

        Estudiante e2 = new Estudiante("Maria", 456, 5.0);

        Estudiante e3 = new Estudiante("Pedro", 789, 8.0);

        Estudiante e4 = new Estudiante("Ana", 101, 9.0);

        Estudiante e5 = new Estudiante("Luis", 202, 4.5);

        gestion.agregarEstudiante(e1);
        gestion.agregarEstudiante(e2);
        gestion.agregarEstudiante(e3);
        gestion.agregarEstudiante(e4);
        gestion.agregarEstudiante(e5);

        System.out.println("Listado de estudiantes:");
        gestion.listarEstudiantes();

        System.out.println("Buscar legajo 456:");

        Estudiante encontrado = gestion.buscarPorLegajo(456);

        if (encontrado != null) {
            System.out.println(encontrado);
        } else {
            System.out.println("No encontrado");
        }

        System.out.println("Buscar legajo inexistente:");

        Estudiante noEncontrado = gestion.buscarPorLegajo(999);

        if (noEncontrado != null) {
            System.out.println(noEncontrado);
        } else {
            System.out.println("No encontrado");
        }

        System.out.println("Aprobados:");

        List<Estudiante> aprobados =
                gestion.obtenerAprobados();

        for (Estudiante e : aprobados) {
            System.out.println(e);
        }

        System.out.println("Mejor estudiante:");

        Estudiante mejor =
                gestion.obtenerMejorEstudiante();

        if (mejor != null) {
            System.out.println(mejor);
        }

        System.out.println("Promedio general: "+ gestion.calcularPromedioGeneral()
        );
    }


