package ant;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class AmbienteTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void DirezioneNessunaPossibiletest() {
		Ambiente amb = new Ambiente();
		
		Coordinate coo = new Coordinate(5,5);
		
		amb.aggiungiOstacolo(6,4);
		amb.aggiungiOstacolo(6,5);
		amb.aggiungiOstacolo(6,6);
		amb.aggiungiOstacolo(5,6);
		amb.aggiungiOstacolo(4,6);
		amb.aggiungiOstacolo(4,5);
		amb.aggiungiOstacolo(4,4);
		amb.aggiungiOstacolo(5,4);
	
		assertTrue( amb.getPossibiliDirezioni(coo).size() == 0);
	}

	@Test
	public void DirezioneUnaPossibiletest() {
		Ambiente amb = new Ambiente();
		
		Coordinate coo = new Coordinate(5,5);
		
		amb.aggiungiOstacolo(6,4);
	
		amb.aggiungiOstacolo(6,6);
		amb.aggiungiOstacolo(5,6);
		amb.aggiungiOstacolo(4,6);
		amb.aggiungiOstacolo(4,5);
		amb.aggiungiOstacolo(4,4);
		amb.aggiungiOstacolo(5,4);
	
		assertTrue( amb.getPossibiliDirezioni(coo).size() == 1);
	}
	
	@Test
	public void DirezioneTutteOttoPossibiletest() {
		Ambiente amb = new Ambiente();
		
		Coordinate coo = new Coordinate(5,5);
		
		
		assertTrue( amb.getPossibiliDirezioni(coo).size() == 8);
	}
}
