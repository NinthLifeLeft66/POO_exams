package car.stats;

import static org.junit.Assert.assertFalse;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import car.auto.Bianca;
import car.auto.Gialla;
import car.sim.Coordinate;
import car.sim.Tragitto;
import car.sim.Zona;

public class StatisticheTest {

	private Statistiche stats;

	@Before
	public void setUp() {
		this.stats = new Statistiche();
	}
	
	@Test
	public void testTragittoPerAuto() {
		List<Tragitto> tragitti = new ArrayList<>();
		
		Tragitto percorso1b = new Tragitto(new Bianca( new Zona()), new Coordinate(0,0), new Coordinate(15,12)); 
		Tragitto percorso1g = new Tragitto(new Gialla( new Zona()), new Coordinate(0,1), new Coordinate(15,11)); 
		Tragitto percorso2b = new Tragitto(new Bianca( new Zona()), new Coordinate(1,0), new Coordinate(11,12)); 
		Tragitto percorso2g = new Tragitto(new Gialla( new Zona()), new Coordinate(0,3), new Coordinate(15,14)); 

		tragitti.add(percorso1b);
		tragitti.add(percorso2b);
		tragitti.add(percorso1g);
		tragitti.add(percorso2g);
		
		assertFalse (this.stats.tragittoPerAuto(tragitti).isEmpty());
	}

}
