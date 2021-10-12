package car.sim;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class ZonaTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void getPossibiliDirezioniTestNessunaPossibile() {
		Zona zona = new Zona();
		zona.addOstacolo(5, 4);
		zona.addOstacolo(4, 5);
		zona.addOstacolo(6, 5);
		zona.addOstacolo(5, 6);
		
		assertEquals ( 0 ,zona.getPossibiliDirezioni(new Coordinate(5,5)).size());
	}
	
	@Test
	public void getPossibiliDirezioniTestUnaPossibile() {
		Zona zona = new Zona();
		zona.addOstacolo(5, 4);
		zona.addOstacolo(4, 5);
		zona.addOstacolo(6, 5);
	
		
		assertEquals ( 1 ,zona.getPossibiliDirezioni(new Coordinate(5,5)).size());
	}


	@Test
	public void getPossibiliDirezioniTestTuttePossibili() {
		Zona zona = new Zona();

		
		assertEquals ( 4 ,zona.getPossibiliDirezioni(new Coordinate(5,5)).size());
	}

}
