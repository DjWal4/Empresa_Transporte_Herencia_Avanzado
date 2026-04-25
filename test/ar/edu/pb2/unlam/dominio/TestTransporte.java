package ar.edu.pb2.unlam.dominio;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class TestTransporte {
	
	private Destino destino1;
	private Destino destino2;
	private Destino destino3;
	private Destino destino4;
	private Destino destinoRepetido;
	private Paquete paqueteChico;
	private Paquete paqueteMediano;
	private Paquete paqueteGrande;
	private Paquete paqueteExcedido;
	
	@Before
	public void init() {

		this.destino1 = new Destino("Ramos Mejia");
		this.destino2 = new Destino ("Moron");
		this.destino3 = new Destino ("San justo");
		this.destino4 = new Destino ("Luzuiaga");
		this.destinoRepetido = new Destino ("Ramos Mejia");
		this.paqueteChico = new Paquete (0.5, 0.5, 0.5, 15.0);
		this.paqueteMediano = new Paquete (1.5, 0.5, 2.0, 500.0);
		this.paqueteGrande = new Paquete (2.5, 2.5, 3.0, 16000.0);
		this.paqueteExcedido = new Paquete (2.5, 2.5, 3.0 , 16000.1);
	}
	
	@Test
	public void dadoQueTengoUnaEmpresaDeTransporteQueEstanEviandoUnPaqueteEnUnaBicicletaDeboVerificarQueLoPuedaLLevar() 
			throws NoCumpleLasCondicionesDeCargaException {
		
		Transporte bicicleta = new Bicicleta( this.paqueteChico );
		bicicleta.agregarDestino(destino1);
	//	bicicleta.agregarDestino(destino2);
		assertTrue( bicicleta.sePuedeLLevar(destino1));
	}
	
	@Test (expected = NoCumpleLasCondicionesDeCargaException.class)
	public void dadoQueTengoUnaEmpresaDeTransporteQueEstanEviandoUnPaqueteConDiferentesVehiculosDeboPermitirQueSoloLLevePesoExcedido() 
			throws NoCumpleLasCondicionesDeCargaException {
		
		Transporte bicicleta = new Bicicleta( this.paqueteMediano );
		bicicleta.agregarDestino(destino1);
		assertTrue( bicicleta.sePuedeLLevar(destino1));
	}
	
	@Test
	public void dadoQueTengoUnaEmpresaDeTransporteQueEstanEviandoUnPaqueteEnUnAutomovilDeboVerificarQueLoPuedaLLevar() 
			throws NoCumpleLasCondicionesDeCargaException {
		
		Transporte automovil = new Automovil( this.paqueteMediano );
		automovil.agregarDestino(destino1);
		automovil.agregarDestino(destino2);
		automovil.agregarDestino(destino3);
    //	automovil.agregarDestino(destino4);
	//	automovil.agregarDestino(destinoRepetido);
		
		assertTrue( automovil.sePuedeLLevar(destino1));
		assertTrue( automovil.sePuedeLLevar(destino2));
		assertTrue( automovil.sePuedeLLevar(destino3));
	//	assertTrue( automovil.sePuedeLLevar(destino4));
	}
	
	@Test (expected = NoCumpleLasCondicionesDeCargaException.class)
	public void dadoQueTengoUnaEmpresaDeTransporteQueEstanEviandoUnPaqueteConUnAutomivilDeboPermitirQueSoloLLevePesoExcedido() 
			throws NoCumpleLasCondicionesDeCargaException {
		
		Transporte automovil = new Automovil( this.paqueteMediano );
		automovil.agregarDestino(destino1);
		automovil.agregarDestino(destino2);
		automovil.agregarDestino(destino3);
		automovil.agregarDestino(destino4);
		automovil.agregarDestino(destinoRepetido);
		
		assertTrue( automovil.sePuedeLLevar(destino1));
		assertTrue( automovil.sePuedeLLevar(destino2));
		assertTrue( automovil.sePuedeLLevar(destino3));
		assertTrue( automovil.sePuedeLLevar(destino4));
		assertTrue( automovil.sePuedeLLevar(destinoRepetido));
	}
	
	@Test
	public void dadoQueTengoUnaEmpresaDeTransporteQueEstanEviandoUnPaqueteEnUnCamionDeboVerificarQueLoPuedaLLevar() 
			throws NoCumpleLasCondicionesDeCargaException {
		
		Transporte camion = new Camion( this.paqueteGrande);	
		camion.agregarDestino(destino1);
		camion.agregarDestino(destino2);
		camion.agregarDestino(destino3);
		camion.agregarDestino(destino4);
		
		assertTrue( camion.sePuedeLLevar(destino1));
		assertTrue( camion.sePuedeLLevar(destino2));
		assertTrue( camion.sePuedeLLevar(destino3));
		assertTrue( camion.sePuedeLLevar(destino4));
	}
	
	@Test (expected = NoCumpleLasCondicionesDeCargaException.class)
	public void dadoQueTengoUnaEmpresaDeTransporteQueEstanEviandoUnPaqueteConUnCamionDeboPermitirQueSoloLLevePesoExcedido() 
			throws NoCumpleLasCondicionesDeCargaException {
		
		Transporte camion = new Camion( this.paqueteExcedido);
		camion.agregarDestino(destino1);
			
		assertTrue( camion.sePuedeLLevar(destino1));
	}
	
	@Test
	public void dadoQueTengoUnaEmpresaDeTransporteDeboObtenerUnaListaDeDestinoOrdenadasDeFormaDescendenteDeLosEnviosDeUnCamion() {
		
		Transporte camion = new Camion(this.paqueteGrande);
		camion.agregarDestino(destino1);
		camion.agregarDestino(destino2);
		camion.agregarDestino(destino3);
		camion.agregarDestino(destino4);
		
		Integer cantidadDeDestinoDeseado = 4;
		Integer cantidadDeDestinoObtenido = camion.obtenerDestinosOrdenadosDesc().size();
		
		Destino primerDestinoDeLaListaDeseado = this.destino3;
		Destino primerDestinoDeLaListaObtenido = camion.obtenerDestinosOrdenadosDesc().getFirst();
		
		Destino ultimoDestinoDeLaListaDeseado = this.destino4;
		Destino ultimoDestinoDeLaListaObtenido = camion.obtenerDestinosOrdenadosDesc().getLast();
		
		assertEquals(cantidadDeDestinoDeseado, cantidadDeDestinoObtenido);
		assertEquals(primerDestinoDeLaListaDeseado, primerDestinoDeLaListaObtenido);
		assertEquals(ultimoDestinoDeLaListaDeseado, ultimoDestinoDeLaListaObtenido);
	}
	
}
