package me.davidlake.agenciadeturismo;

import java.util.ArrayList;

public class RepositorioCliente {
    private ArrayList<Cliente> clientes;

    public void crearCliente(Cliente cliente) {
        if (!this.clientes.contains(cliente)) {
            this.clientes.add(cliente);
        }
    }
}