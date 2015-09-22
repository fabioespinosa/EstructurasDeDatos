package uniandes.cupi2.estructuras.entidades;

import uniandes.cupi2.estructuras.IInfoArco;

public class ArcoPrueba implements IInfoArco
{
	
	private double costo;
	
	public ArcoPrueba(double nCosto)
	{
		costo=nCosto;
	}
	
	public double darCosto() {
		// TODO Auto-generated method stub
		return costo;
	}
	
}
