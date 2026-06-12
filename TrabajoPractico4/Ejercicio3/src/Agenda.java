package Ejercicio3.src;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Agenda {

    private List<Evento> eventos;

    public Agenda() {
        eventos = new ArrayList<>();
    }

    public void agregarEvento(Evento e) {
        eventos.add(e);
    }

    public Optional<Evento> buscarPorNombre(String nombre) {
        return eventos.stream()
                .filter(e -> e.nombre().equalsIgnoreCase(nombre))
                .findFirst();
    }

    public List<Evento> eventosProximos(LocalDate hoy) {
        return eventos.stream()
                .filter(e ->
                        !e.fecha().toLocalDate().isBefore(hoy))
                .collect(Collectors.toList());
    }

    public Optional<String> tiempoHastaEvento(String nombre) {

        return buscarPorNombre(nombre).map(evento -> {

                    LocalDate fechaEvento =
                            evento.fecha().toLocalDate();

                    LocalDate hoy = LocalDate.now();

                    Period periodo =
                            Period.between(hoy, fechaEvento);

                    String tiempo =
                            Math.abs(periodo.getYears()) + " años, "
                            + Math.abs(periodo.getMonths()) + " meses, "
                            + Math.abs(periodo.getDays()) + " días";

                    if (fechaEvento.isAfter(hoy)) {
                        return "Falta " + tiempo;
                    } else if (fechaEvento.isBefore(hoy)) {
                        return "Evento pasado hace " + tiempo;
                    } else {
                        return "El evento es hoy";
                    }
                });
    }
}