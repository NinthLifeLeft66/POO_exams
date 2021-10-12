package bici.tipo;

import static org.junit.Assert.assertFalse;

import org.junit.Before;
import org.junit.Test;

import bici.sim.Coordinate;
import bici.sim.Zona;

public class GiallaTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		Zona z = new Zona();
		Bici b1 = new Gialla(z);
		Coordinate c1 = b1.getPosizione();

		b1.simula(2);
		
		assertFalse(b1.getPosizione().equals(c1));
	}
	
	@Test
	public void test2() {
		Zona z = new Zona();
		Gialla b1 = new Gialla(z);
		b1.simula(2);
		
		assertFalse(b1.getOrigine().equals(b1.getDestinazioneAttuale() ));
	}
}
