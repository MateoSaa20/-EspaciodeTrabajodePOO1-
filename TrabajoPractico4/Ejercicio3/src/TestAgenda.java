package Ejercicio3.src;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class TestAgenda {

    public static void main(String[] args) {

        Agenda agenda = new Agenda();

        Evento e1 = new Evento(
                "Parcial POO1",
                LocalDateTime.now().plusDays(10),
                "Laboratorio");

        Evento e2 = new Evento(
                "Concierto",
                LocalDateTime.now().plusMonths(2),
                "Teatro Colon");

        Evento e3 = new Evento(
                "Cumpleaños",
                LocalDateTime.now().plusDays(30),
                "Casa");

        Evento e4 = new Evento(
                "Examen Final",
                LocalDateTime.now().minusDays(15),
                "Universidad");

        agenda.agregarEvento(e1);
        agenda.agregarEvento(e2);
        agenda.agregarEvento(e3);
        agenda.agregarEvento(e4);

        System.out.println("Busqueda Existente");

        agenda.buscarPorNombre("Parcial POO1")
                .ifPresent(System.out::println);

        System.out.println();

        System.out.println("Busqueda Inexistente");

        Evento inexistente = agenda
                .buscarPorNombre("Hackathon")
                .orElse(null);

        System.out.println(inexistente);

        System.out.println();

        System.out.println("Eventos Proximos");

        List<Evento> proximos =
                agenda.eventosProximos(LocalDate.now());

        proximos.forEach(System.out::println);

        System.out.println();

        System.out.println("Tiempo Hasta Evento Futuro");

        agenda.tiempoHastaEvento("Parcial POO1")
                .ifPresent(System.out::println);

        System.out.println();

        System.out.println("Tiempo Hasta Evento Pasado");

        agenda.tiempoHastaEvento("Examen Final")
                .ifPresent(System.out::println);

        System.out.println();

        System.out.println("To String y Fecha Formateada");

        System.out.println(e1);
        System.out.println("Fecha formateada: "+ e1.formatearFecha());

        /*
         * ERROR DE COMPILACION:
         *
         * e1.fecha = LocalDateTime.now();
         *
         * Los records son inmutables.
         * Sus componentes son finales y no pueden modificarse.
         */
    }
}