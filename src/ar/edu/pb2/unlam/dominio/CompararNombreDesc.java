package ar.edu.pb2.unlam.dominio;

import java.util.Comparator;

public class CompararNombreDesc implements Comparator<Destino>{

	@Override
	public int compare(Destino o1, Destino o2) {
		return o2.getNombre().compareTo(o1.getNombre());
	}

}
