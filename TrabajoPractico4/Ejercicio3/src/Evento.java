package Ejercicio3.src;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public record Evento(
        String nombre,
        LocalDateTime fecha,
        String ubicacion) {

    public String formatearFecha() {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        return fecha.format(formato);
    }
}
