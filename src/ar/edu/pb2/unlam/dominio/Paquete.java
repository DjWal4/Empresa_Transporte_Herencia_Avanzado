package ar.edu.pb2.unlam.dominio;

public class Paquete {
	
	private Integer id,proximoId = 0;
	private Double alto;
    private Double ancho;
    private Double profundo;
    private Double peso;

    public Paquete(Double alto, Double ancho, Double profundo, Double peso) {
    	this.id = ++proximoId;
        this.alto = alto;
        this.ancho = ancho;
        this.profundo = profundo;
        this.peso = peso;
    }
    
    public Integer getId() {
    	return this.id;
    }

    public Double getVolumen() {
        return alto * ancho * profundo;
    }

    public Double getPeso() {
        return peso;
    }
}


