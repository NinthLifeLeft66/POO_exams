package bici.stats;

import static org.junit.Assert.assertFalse;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import bici.sim.Coordinate;
import bici.sim.Percorso;
import bici.sim.Zona;
import bici.tipo.Bianca;
import bici.tipo.Bici;

public class StatisticheTest {

	@SuppressWarnings("unused")
	private Statistiche stats;

	@Before
	public void setUp() {
		this.stats = new Statistiche();
	}
	
	@Test
	public void testPercorsoPerBici() {
		Zona z = new Zona();
		Bici b1 = new Bianca(z);
		Percorso p1 = new Percorso(b1, new Coordinate (1,2), new Coordinate (3,8));
		Set<Percorso> pset = new HashSet<Percorso>();
		pset.add(p1);
		
		assertFalse(this.stats.percorsiPerBici(pset).isEmpty());
		
	}

}
