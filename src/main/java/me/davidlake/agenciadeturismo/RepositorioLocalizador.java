package me.davidlake.agenciadeturismo;

import java.util.ArrayList;
import java.util.HashMap;

public class RepositorioLocalizador {
    private HashMap<String, ArrayList<Localizador>> repositorio;

    public void crearLocalizador(String identificacionCliente, Localizador localizador) {
        if (!this.repositorio.containsKey(identificacionCliente)) {
            this.repositorio.put(identificacionCliente, new ArrayList<>());
        }

        this.repositorio.get(identificacionCliente).add(localizador);
    }

    public ArrayList<Localizador> obtenerReservasCliente(String identificacionCliente) {
        return this.repositorio.getOrDefault(identificacionCliente, null);
    }
}
