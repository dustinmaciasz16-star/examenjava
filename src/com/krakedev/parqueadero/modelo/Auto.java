package com.krakedev.parqueadero.modelo;

public class Auto extends Vehiculo{

	private int numerosPuertas;

	public Auto(String placa, String propietario, int numerosPuertas) {
		super(placa, propietario);
		this.numerosPuertas = numerosPuertas;
	}
	
	

	public int getNumerosPuertas() {
		return numerosPuertas;
	}



	public void setNumerosPuertas(int numerosPuertas) {
		this.numerosPuertas = numerosPuertas;
	}



	@Override
	public double calcularTarifa(int horasPermanencia) {
		
		double total = horasPermanencia * 1.50;
		
		if(horasPermanencia > 4) {
			total += 2;
		}
		
		return total;
	}
	
	
	
}
