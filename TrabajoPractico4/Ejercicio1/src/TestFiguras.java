public class TestFiguras {

    public static void main(String[] args) {

        Figura[] figuras = {
            new Circulo("Círculo A", 5.0),
            new Rectangulo("Rectángulo B", 4.0, 6.0),
            new Circulo("Círculo C", 3.0),
            new Rectangulo("Rectángulo D", 7.0, 2.0),
            new Circulo("Círculo E", 1.5)
        };

        System.out.println("=== FIGURAS Y SUS ÁREAS ===");
        double areaTotal = 0;

        for (Figura f : figuras) {
            System.out.println(f.toString());
            System.out.println("  Área: " + String.format("%.2f", f.calcularArea()));

            // instanceof verifica en tiempo de ejecución si cumple el contrato
            if (f instanceof Dibujable dibujable) {
                dibujable.dibujar();
            }

            if (f instanceof Coloreable coloreable) {
                coloreable.colorear("rojo");
            }

            System.out.println();
            areaTotal += f.calcularArea();
        }

        System.out.println("=== ÁREA TOTAL ===");
        System.out.printf("Área total: %.2f%n", areaTotal);

        // ERROR INTENCIONAL
        // new Figura("Generica");
        // → "Figura is abstract; cannot be instantiated"
    }
}