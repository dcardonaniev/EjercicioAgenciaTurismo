package me.davidlake.agenciadeturismo;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        Reserva reserva1 = new Reserva(
                TipoReserva.RESERVA_BOLETOS_VIAJE,
                20
        ), reserva2 = new Reserva(
                TipoReserva.RESERVA_COMIDA,
                20
        ), reserva3 = new Reserva(
                TipoReserva.RESERVA_HOTEL,
                20
        ), reserva4 = new Reserva(
                TipoReserva.RESERVA_TRANSPORTE,
                20
        );

        Cliente cliente1 = new Cliente("4122411", "David", 18);
        ArrayList<Reserva> reservas = new ArrayList<>(List.of(reserva1, reserva2, reserva3, reserva4));
        Localizador localizador = new Localizador(cliente1, reservas);

        System.out.println(localizador.getPrecioTotal());
    }
}