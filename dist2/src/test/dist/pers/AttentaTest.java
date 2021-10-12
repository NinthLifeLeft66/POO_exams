package dist.pers;

import static org.junit.Assert.assertFalse;

import org.junit.Before;
import org.junit.Test;

import dist.sim.Ambiente;
import dist.sim.Coordinate;

public class AttentaTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testAmbienteVuoto() {
		Ambiente amb = new Ambiente();
		Persona attenta = new Attenta (amb);
		attenta.setPosizione(new Coordinate(3,3));
		Coordinate p1 = attenta.getPosizione();
		attenta.mossa();
		assertFalse (attenta.getPosizione().equals(p1) );
	}

	@Test
	public void testTrePosizioniLibere() {
		Ambiente amb = new Ambiente();
		Persona attenta = new Attenta (amb);
		attenta.setPosizione(new Coordinate(3,3));
		
		Persona distratta = new Distratta (amb);
		distratta.setPosizione (new Coordinate(4,3));
		Coordinate p2 = distratta.getPosizione();
		
		attenta.mossa();
		assertFalse (attenta.getPosizione().equals(p2) );
	}
	
	@Test
	public void testTrePosizioniOccupate() {
		Ambiente amb = new Ambiente();
		Persona attenta = new Attenta (amb);
		attenta.setPosizione(new Coordinate(3,3));
		
		Persona distratta = new Distratta (amb);
		distratta.setPosizione (new Coordinate(4,3));
		Coordinate p2 = distratta.getPosizione();
		
		Persona distratta2 = new Distratta (amb);
		distratta2.setPosizione (new Coordinate(2,3));
		Coordinate p3 = distratta2.getPosizione();
		
		Persona distratta3 = new Distratta (amb);
		distratta3.setPosizione (new Coordinate(3,2));
		Coordinate p4 = distratta3.getPosizione();
		
		attenta.mossa();
		assertFalse (attenta.getPosizione().equals(p2) );
		assertFalse (attenta.getPosizione().equals(p3) );
		assertFalse (attenta.getPosizione().equals(p4) );

		
		
	}
	
}
