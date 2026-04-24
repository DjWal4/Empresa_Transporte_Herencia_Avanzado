package ar.edu.pb2.unlam.dominio;

import java.util.ArrayList;
import java.util.List;

public abstract class Transporte {
	
	private Integer id,proximoId = 0;
	private Paquete paquete;
	protected List<Destino> listaDeDestinos = new ArrayList<>();
	protected Double volumenMax;
	
	public Transporte( Paquete paquete) {
		this.id = ++proximoId;
		this.paquete = paquete;
		
	}
	
	public Boolean agregarDestino(Destino destino){
		return this.listaDeDestinos.add(destino);
	}

	public Integer getId() {
		return id;
	}

	public List<Destino> getListaDeDestino() {
		return listaDeDestinos;
	}

	public Paquete getPaquete() {
		return paquete;
	}

	public Double getVolumenMax() {
		return volumenMax;
	}
	
	public abstract Boolean sePuedeLLevar(Destino destino) throws NoCumpleLasCondicionesDeCargaException ;
	
}
