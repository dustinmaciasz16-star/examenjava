package com.krakedev.parqueadero.servicio;

import java.util.ArrayList;

import com.krakedev.parqueadero.modelo.Vehiculo;

public class ServicioVehiculos {
	
	private ArrayList<Vehiculo> parqueadero = new ArrayList<>();
	
	private final int CAPACIDAD_MAXIMA = 10;
	
	public Vehiculo buscarPorPlaca(String placa) {
		Vehiculo encontrado = null;
		for(Vehiculo v: parqueadero) {
			if(v.getPlaca().equals(placa)) {
				encontrado = v;
				break;
			}
		}
		return encontrado;
	}
	
	public boolean ingresarVehiculo(Vehiculo vehiculo) {
		
		if(parqueadero.size() >= CAPACIDAD_MAXIMA) {
			System.out.println("La capacidad del parqueo ya esta llena");
			return false;
		}
		
		if (buscarPorPlaca(vehiculo.getPlaca()) != null) { 
			System.out.println("La placa ya está registrada"); 
			return false; 
		}
		
		System.out.println("La capacidad actual: " + CAPACIDAD_MAXIMA);
		parqueadero.add(vehiculo);
		return true;
	}
	
	public Vehiculo retirarVehiculo(String placa) {

	    Vehiculo encontrado = buscarPorPlaca(placa);

	    if (encontrado == null) {
	        System.out.println("Placa no encontrada en el Sistema");
	        return null;
	    } else {
	        System.out.println("Vehiculo con la placa " + placa + " se retira");
	        parqueadero.remove(encontrado);
	        return encontrado;
	    }
	}
	
	public ArrayList<Vehiculo> listarVehiculos() {
	    return parqueadero;
	}
}
