package ar.edu.pb2.unlam.dominio;

public class Bicicleta extends Transporte {
	
	private static Double limiteCarga = 15.0;

	public Bicicleta( Paquete paquete) {
		super( paquete);
		volumenMax = 0.125;
		// listaDeDestinos = new ArrayList<Destino>();
	}
	
	@Override
	public Boolean sePuedeLLevar(Destino destino ) throws NoCumpleLasCondicionesDeCargaException {
		
		if (super.getPaquete().getVolumen() <= volumenMax && super.getPaquete().getPeso() <= limiteCarga 
				&& listaDeDestinos.size() < 2 && listaDeDestinos.contains(destino)) {
		 return true;
		}else {
			throw new NoCumpleLasCondicionesDeCargaException(" Has superado el volumen o la carga permitida en Bicicleta");
		}
	}
}
