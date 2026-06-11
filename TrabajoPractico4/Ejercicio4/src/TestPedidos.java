import java.time.LocalDate;
import java.util.*;
import java.util.stream.*;

/**
 * TestPedidos: demuestra el uso de Streams API para consultas declarativas.
 * No se usan bucles for/while — todo se resuelve con stream(), filter, map, collect, etc.
 */
public class TestPedidos {

    public static void main(String[] args) {

        LocalDate hoy = LocalDate.now();

        // Lista con 8 pedidos variados: distintos clientes, fechas, estados y montos
        List<Pedido> pedidos = List.of(
            new Pedido("Ana",     hoy.minusDays(5),  1500.00, EstadoPedido.PENDIENTE),
            new Pedido("Carlos",  hoy.minusDays(40), 3200.00, EstadoPedido.ENTREGADO),
            new Pedido("Ana",     hoy.minusDays(10), 800.00,  EstadoPedido.PENDIENTE),
            new Pedido("Lucía",   hoy.minusDays(2),  4500.00, EstadoPedido.ENVIADO),
            new Pedido("Marcos",  hoy.minusDays(60), 200.00,  EstadoPedido.CANCELADO),
            new Pedido("Carlos",  hoy.minusDays(15), 1100.00, EstadoPedido.CANCELADO),
            new Pedido("Sofía",   hoy.minusDays(20), 9800.00, EstadoPedido.ENTREGADO),
            new Pedido("Lucía",   hoy.minusDays(8),  650.00,  EstadoPedido.PENDIENTE)
        );

        // ---------------------------------------------------------------
        // CONSULTA 1: Pedidos PENDIENTES de los últimos 30 días
        // filter: conserva solo los que cumplen ambas condiciones
        // ---------------------------------------------------------------
        System.out.println("=== 1. PEDIDOS PENDIENTES RECIENTES ===");
        List<Pedido> pendientesRecientes = pedidos.stream()
                .filter(p -> p.getEstado() == EstadoPedido.PENDIENTE)
                .filter(p -> p.getFecha().isAfter(hoy.minusDays(30)))
                .collect(Collectors.toList());

        pendientesRecientes.forEach(System.out::println);

        // ---------------------------------------------------------------
        // CONSULTA 2: Clientes únicos ordenados alfabéticamente
        // map: extrae el nombre; distinct: elimina duplicados; sorted: ordena
        // ---------------------------------------------------------------
        System.out.println("\n=== 2. CLIENTES ÚNICOS ORDENADOS ===");
        List<String> clientesUnicos = pedidos.stream()
                .map(Pedido::getCliente)       // method reference
                .distinct()
                .sorted()
                .collect(Collectors.toList());

        clientesUnicos.forEach(System.out::println);

        // ---------------------------------------------------------------
        // CONSULTA 3: Monto total y promedio agrupado por estado
        // groupingBy agrupa; summarizingDouble calcula stats en un solo paso
        // ---------------------------------------------------------------
        System.out.println("\n=== 3. ESTADÍSTICAS POR ESTADO ===");
        Map<EstadoPedido, DoubleSummaryStatistics> statsPorEstado = pedidos.stream()
                .collect(Collectors.groupingBy(
                        Pedido::getEstado,
                        Collectors.summarizingDouble(Pedido::getTotal)
                ));

        statsPorEstado.forEach((estado, stats) ->
                System.out.printf("%-10s → Total: %.2f | Promedio: %.2f%n",
                        estado, stats.getSum(), stats.getAverage()));

        // ---------------------------------------------------------------
        // CONSULTA 4: Pedido con mayor monto usando max() y Optional
        // Optional evita NullPointerException cuando el resultado puede no existir
        // ---------------------------------------------------------------
        System.out.println("\n=== 4. PEDIDO DE MAYOR MONTO ===");
        Optional<Pedido> mayorPedido = pedidos.stream()
                .max(Comparator.comparingDouble(Pedido::getTotal));

        // ifPresentOrElse: rama "existe" y rama "vacío" en una sola llamada
        mayorPedido.ifPresentOrElse(
                p -> System.out.println("Mayor pedido: " + p),
                () -> System.out.println("No hay pedidos registrados")
        );

        // Verificación con lista vacía: max() retorna Optional.empty()
        System.out.println("\n--- Verificación con lista vacía ---");
        try {
            Optional<Pedido> vacio = List.<Pedido>of().stream()
                    .max(Comparator.comparingDouble(Pedido::getTotal));

            // orElseThrow lanza excepción si el Optional está vacío
            vacio.orElseThrow(() -> new NoSuchElementException("No hay pedidos registrados"));

        } catch (NoSuchElementException e) {
            System.out.println("Excepción capturada: " + e.getMessage());
        }

        // ---------------------------------------------------------------
        // CONSULTA 5: Nombres de clientes con pedidos CANCELADOS, unidos por coma
        // Collectors.joining concatena Strings con un separador
        // ---------------------------------------------------------------
        System.out.println("\n=== 5. CLIENTES CON PEDIDOS CANCELADOS ===");
        String clientesCancelados = pedidos.stream()
                .filter(p -> p.getEstado() == EstadoPedido.CANCELADO)
                .map(Pedido::getCliente)       // method reference
                .distinct()
                .collect(Collectors.joining(", "));

        System.out.println("Clientes: " + clientesCancelados);
    }
}