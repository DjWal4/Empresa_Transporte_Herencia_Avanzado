package ar.edu.pb2.unlam.dominio;

public class Automovil extends Transporte {

	private static Double limiteCarga = 500.0;

	public Automovil( Paquete paquete) {
		super( paquete);
		volumenMax = 2.0;
	}

	@Override
	public Boolean sePuedeLLevar(Destino destino) throws NoCumpleLasCondicionesDeCargaException {
		
		if (super.getPaquete().getVolumen() <= this.volumenMax && super.getPaquete().getPeso() <= limiteCarga 
			 && listaDeDestinos.size() <= 3 && listaDeDestinos.contains(destino)) {
			 return true;
			}else {
				throw new NoCumpleLasCondicionesDeCargaException(" Has superado el volumen o la carga permitida en Automovil");
			}
		}

	


}
