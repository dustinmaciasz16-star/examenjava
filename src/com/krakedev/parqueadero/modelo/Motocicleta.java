package com.krakedev.parqueadero.modelo;

public class Motocicleta extends Vehiculo {
	
	private int cilindraje;
	

	public Motocicleta(String placa, String propietario, int cilindraje) {
		super(placa, propietario);
		this.cilindraje = cilindraje;
	}

	

	public int getCilindraje() {
		return cilindraje;
	}



	public void setCilindraje(int cilindraje) {
		this.cilindraje = cilindraje;
	}



	@Override
	public double calcularTarifa(int horasPermanencia) {
		
		double tarifaHora = 0.75;
		
		if(cilindraje > 250) {
			tarifaHora = 1.00;
		}
		
		return horasPermanencia * tarifaHora;
	}

}
