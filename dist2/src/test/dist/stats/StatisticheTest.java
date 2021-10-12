package dist.stats;

import static org.junit.Assert.assertFalse;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import dist.pers.Attenta;
import dist.pers.Persona;
import dist.sim.Ambiente;
import dist.sim.Contatto;
import dist.sim.Coordinate;

public class StatisticheTest {

	@SuppressWarnings("unused")
	private Statistiche stats;

	@Before
	public void setUp() {
		this.stats = new Statistiche();
	}
	
	@Test
	public void testProduciStatistica() {
		Ambiente amb = new Ambiente();
		Set<Contatto> setContatto = new HashSet<Contatto>();
		Set<Persona> setPersona = new HashSet<Persona>();
		setPersona.add(new Attenta(amb));
		setPersona.add(new Attenta(amb));
		
		Contatto c1 = new Contatto(3,setPersona, new Coordinate(13,13)  );
		setContatto.add(c1);
		
		assertFalse(this.stats.produciStatistiche(setContatto).isEmpty());
	}

}
