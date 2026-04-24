package ar.edu.pb2.unlam.dominio;

public class Camion extends Transporte {

	private static Double limiteCarga = 16000.0;
	
	public Camion( Paquete paquete) {
		super( paquete);
		volumenMax = 20.0;
	}

	@Override
	public Boolean sePuedeLLevar(Destino destino) throws NoCumpleLasCondicionesDeCargaException {
		
		if (super.getPaquete().getVolumen() <= this.volumenMax && super.getPaquete().getPeso() <= limiteCarga 
				&& listaDeDestinos.contains(destino)) {
			 return true;
			}else {
				throw new NoCumpleLasCondicionesDeCargaException(" Has superado el volumen o la carga permitida en Camion");
			}
		}

	
}
