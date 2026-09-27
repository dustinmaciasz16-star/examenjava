package com.krakedev.parqueadero.servicio;

import java.util.ArrayList;

import com.krakedev.parqueadero.modelo.Vehiculo;
import com.krakedev.parqueadero.modelo.tiketCobro;

public class ServicioCobro {
	private ArrayList<tiketCobro> historicoTickets = new ArrayList<>();

    private final ServicioVehiculos servicioVehiculos;

    public ServicioCobro(ServicioVehiculos servicioVehiculos) {
        this.servicioVehiculos = servicioVehiculos;
    }

    public tiketCobro procesarSalida(String placa, int horas) {

        Vehiculo vehiculo = servicioVehiculos.retirarVehiculo(placa);

        if (vehiculo == null) {
            return null;
        }

        double total = vehiculo.calcularTarifa(horas);

        String codigo = "TCK-" + (int)(Math.random() * 900 + 100);

        tiketCobro ticket = new tiketCobro(codigo, vehiculo, horas, total, null);

        historicoTickets.add(ticket);

        return ticket;
    }

    public double calcularTotalRecaudado() {

        double total = 0;

        for (tiketCobro ticket : historicoTickets) {
            total += ticket.getTotalPagar();
        }

        return total;
    }

    public ArrayList<tiketCobro> listarTickets() {
        return historicoTickets;
    }

}
