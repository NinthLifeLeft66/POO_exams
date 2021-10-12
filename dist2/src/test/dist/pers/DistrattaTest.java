package dist.pers;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import dist.sim.Ambiente;
import dist.sim.Coordinate;

public class DistrattaTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testAmbienteVuoto() {
		Ambiente amb = new Ambiente();
		Persona distrattaTestata = new Distratta (amb);
		distrattaTestata.setPosizione(new Coordinate(3,3));
		Coordinate c1 =distrattaTestata.getPosizione();

		distrattaTestata.mossa();
		assertFalse (distrattaTestata.getPosizione().equals(c1) );
	}

	@Test
	public void testTrePosizioniLibere() {
		Ambiente amb = new Ambiente();
		Persona distrattaTestata = new Distratta (amb);
		distrattaTestata.setPosizione(new Coordinate(3,3));
		Coordinate c1 =distrattaTestata.getPosizione();

		Persona distratta = new Distratta (amb);
		distratta.setPosizione (new Coordinate(4,3));
		
		distrattaTestata.mossa();
		assertFalse (distrattaTestata.getPosizione().equals(c1) );
	}
	
	@Test
	public void testTrePosizioniOccupate() {
		Ambiente amb = new Ambiente();
		Persona distrattaTestata = new Distratta (amb);
		distrattaTestata.setPosizione(new Coordinate(3,3));
		Coordinate c1 =distrattaTestata.getPosizione();

		Persona distratta = new Distratta (amb);
		distratta.setPosizione (new Coordinate(4,3));
		
		Persona distratta2 = new Distratta (amb);
		distratta2.setPosizione (new Coordinate(2,3));
		
		Persona distratta3 = new Distratta (amb);
		distratta3.setPosizione (new Coordinate(3,2));
		
		distrattaTestata.mossa();
		assertFalse (distrattaTestata.getPosizione().equals(c1) );

	}

}
