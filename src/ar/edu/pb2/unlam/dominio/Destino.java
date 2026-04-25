package ar.edu.pb2.unlam.dominio;

import java.util.Objects;

public class Destino {
	
	private String nombre;
	
	public Destino( String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	@Override
	public int hashCode() {
		return Objects.hash(nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Destino other = (Destino) obj;
		return Objects.equals(nombre, other.nombre);
	}
}
