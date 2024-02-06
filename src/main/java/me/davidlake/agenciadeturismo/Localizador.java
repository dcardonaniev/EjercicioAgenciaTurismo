package me.davidlake.agenciadeturismo;

import java.util.ArrayList;

public class Localizador {
    private ArrayList<Reserva> reservas;
    private Cliente cliente;
    private double precioTotal;

    public Localizador(Cliente cliente, ArrayList<Reserva> reservas) {
        this.cliente = cliente;
        this.reservas = reservas;
        precioTotal = calcularPrecioTotal();
    }

    private double calcularPrecioTotal() {
        double total = 0;
        for (Reserva reserva : reservas) {
            total += reserva.getPrecio();
        }

        // Verificación segundo descuento
        boolean descuentoTodosLosTipos = true;
        outerLoop:
        for (TipoReserva tipo : TipoReserva.values()) {
            for(Reserva reserva : reservas) {
                if (reserva.getTipo() == tipo) {
                    continue outerLoop;
                }
            }

            descuentoTodosLosTipos = false;
        }

        // Verificación tercer descuento
        boolean descuentoHotelViaje = false;
        int contadorViaje = 0;
        int contadorHotel = 0;
        for (Reserva reserva : reservas) {
            switch(reserva.getTipo()) {
                case RESERVA_BOLETOS_VIAJE -> {
                    contadorViaje++;
                }
                case RESERVA_HOTEL -> {
                    contadorHotel++;
                }
                default -> {}
            }
        }

        if(contadorViaje == 2 && contadorHotel == 2) {
            descuentoHotelViaje = true;
        }

        if(descuentoHotelViaje) { precioTotal -= (precioTotal * 0.05); }
        else if(descuentoTodosLosTipos) { precioTotal -= (precioTotal * 0.1); }

        return precioTotal;
    }

    public double getPrecioTotal() {
        return precioTotal;
    }
}
